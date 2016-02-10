/**
 * 
 */
'use strict';

angular.module('socialcommunity').controller('IndexController', function ($scope, $state, IndexService) {

	$scope.id = $state.params.idUser;
	
	$scope.saveCommonUser = function(user){
		IndexService.saveCommonUser(user).then(
              function(id) {
            	  if(id===null || id===''){
	      			$state.go('signupcommon');
	      		  }else{
	      			$state.go('signupextended', {idUser: id});
	      		  }
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};	
	
	$scope.saveExtendedUser = function(id,userExtended,birth){
		IndexService.saveExtendedUser(id,userExtended,birth).then(
	         function(id) {
	             if(id===null || id===''){
	          		$state.go('signupextended', {idUser: id});
	       		 }else{
	            	$state.go('signuplogin', {idUser: id});
	             }
	          },
	         function(errResponse){
	              console.error('!!!Error');
	          }
	    );
    };	

    $scope.saveLoginUser = function(id,securityPrompt){
		IndexService.saveLoginUser(id,securityPrompt).then(
	         function(id) {
	        	 if(id===null || id===''){
	     			$state.go('signuplogin', {idUser: id});
	     		}else{
	     			$scope.createUserAccount(id);
	     			$state.go('index');
	     		}
	          },
	         function(errResponse){
	              console.error('!!!Error');
	          }
	    );
    };	
    
    $scope.createUserAccount = function(id){
		IndexService.createUserAccount(id).then(
	         function(id) {
	         },
	         function(errResponse){
	              console.error('!!!Error');
	         }
	    );
    };	
    											//sign in
    $scope.userSignIn = function(login,password,answer){
		IndexService.userSignIn(login,password,answer).then(
	         function(id) {
	        	 if(id===null && id===''){
	 				$state.go('signin');
	 			}else{
	 				$scope.redirectToUserPage(id);	
	 			}
	         },
	         function(errResponse){
	              console.error('!!!Error');
	         }
	    );
    };	
    
    $scope.getSecurityQuestion = function(loginOrEmail){
		IndexService.getSecurityQuestion(loginOrEmail).then(
	         function(question) {
	             $scope.question=question;
	         },
	         function(errResponse){
	             console.error('!!!Error');
	         }
	    );
    };
    
    //before use spring security 
    $scope.redirectToUserPage = function(id){
		IndexService.redirectToUserPage(id).then(
	         function(userRole) {
	        	 if(userRole.userRoleName==='user'){
	 				$state.go('userparlor', {idUser: id});	
	 				
	 			}else if(userRole.userRoleName==='admin'){
	 				$state.go('adminparlor', {idAdmin: id});
	 				
	 			}else{
	 				$state.go('signin');
	 			}	
	         },
	         function(errResponse){
	             console.error('!!!Error');
	         }
	    );
    };	
    
   
	$scope.today = function() {
		$scope.birth = new Date();
	};
	$scope.today();

	$scope.open1 = function() {
		$scope.popup1.opened = true;
	};

	$scope.setDate = function(year, month, day) {
		$scope.birth = new Date(year, month, day);
	};

	$scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	};

	$scope.popup1 = {
	   opened: false
	};
    
		
});	
	


														//old


//angular.module('socialcommunity').controller('IndexController',function ($scope, $state, $http) {
//
//	$scope.id = $state.params.idUser;
//
//	$scope.saveCommonUser = function(user){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/savecommon/user.json',user).success(function(id) {
//					
//			if(id===null || id===''){
//				$state.go('signupcommon');
//			}else{
//				$state.go('signupextended', {idUser: id});
//			}
//		}).error(function() {
//		});
//	};	
//	
//	$scope.saveExtendedUser = function(id,userExtended,birth){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/saveextended/'+id+'/'+birth+'/userextended.json',userExtended)
//		.success(function(id) {								  
//			
//			if(id===null || id===''){
//				$state.go('signupextended', {idUser: id});
//			}else{
//				$state.go('signuplogin', {idUser: id});
//			}
//		}).error(function() {
//		});
//	};	
//	
//	$scope.saveLoginUser = function(id,securityPrompt){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/savelogin/'+id+'/userlogin.json',securityPrompt)
//		.success(function(id) {
//			
//			if(id===null || id===''){
//				$state.go('signuplogin', {idUser: id});
//			}else{
//				$scope.createUserAccount(id);
//				$state.go('index');
//			}
//		}).error(function() {
//		});
//	};	
//	
//	$scope.createUserAccount = function(id){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/createaccount/useraccount.json',id)
//		.success(function(id) {		
//		}).error(function() {
//		});
//	};	
//													//sign in
//	$scope.userSignIn = function(login,password,answer){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/signin/'+login+'/'+password+'/'+answer+'/userdata.json')
//		.success(function(id) {
//			
//			if(id===null && id===''){
//				$state.go('signin');
//			}else{
//				$scope.redirectToUserPage(id);	
//			}
//		}).error(function() {
//		});
//	};	
//	
//	//get security prompt for user
//	$scope.getSecurityQuestion= function(loginOrEmail){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/signin/'+loginOrEmail+'/securityquestion.json')
//		.success(function(question) {
//			$scope.question=question;
//		})
//		.error(function() {
//		});
//	};
//	
//	//before use spring security 
//	$scope.redirectToUserPage= function(id){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/signin/'+id+'/userrole.json').success(function(userRole) {
//		
//			if(userRole.userRoleName==='user'){
//				$state.go('userparlor', {idUser: id});	
//				
//			}else if(userRole.userRoleName==='admin'){
//				$state.go('adminparlor', {idAdmin: id});
//				
//			}else{
//				$state.go('signin');
//			}	
//		}).error(function() {		
//		});
//	};	
//
//
//    
//	$scope.today = function() {
//	    $scope.birth = new Date();
//	};
//	$scope.today();
//
//    $scope.open1 = function() {
//	    $scope.popup1.opened = true;
//	};
//
//	$scope.setDate = function(year, month, day) {
//		$scope.birth = new Date(year, month, day);
//	};
//
//	$scope.dateOptions = {
//	    formatYear: 'yy',
//	    startingDay: 1
//	};
//
//	$scope.popup1 = {
//	   opened: false
//	};
//
//});