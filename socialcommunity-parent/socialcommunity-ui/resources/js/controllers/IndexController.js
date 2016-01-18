/**
 * 
 */
'use strict';


angular.module('socialcommunity').controller('IndexController',function ($scope, $http) {

	$scope.saveCommonUser = function(user){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/savecommon/user.json',user).success(function(id) {
					
			if(id===null || id===''){
				$scope.changeRoute('#/signup');
				//send id
			}else{
				$scope.changeRoute('#/signup/extended');
				//send id
			}
		})
		.error(function() {
			//$scope.message('System error');
		});
	};	
	
	$scope.id=1;
	$scope.saveExtendedUser = function(id,userExtended){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/saveextended/'+id+'/userextended.json',userExtended)
		.success(function(id) {								  
			
			if(id===null || id===''){
				$scope.changeRoute('#/signup/extended');
				//send id
			}else{
				$scope.changeRoute('#/signup/login');
				//send id
			}
		})
		.error(function() {
		});
	};	
	
	//$scope.id=1;
	$scope.saveLoginUser = function(id,securityPrompt){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/savelogin/'+id+'/userlogin.json',securityPrompt)
		.success(function(id) {
			
			if(id===null || id===''){
				$scope.changeRoute('#/signup/login');
				//send id
			}else{
				$scope.changeRoute('#/');
			}
		})
		.error(function() {
		});
	};	
	

	$scope.userSignIn = function(securityPrompt){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signin/userdata.json',securityPrompt).success(function(user) {
			
			//if(user!==null && user!==''){
				//send on page user
				
			$scope.redirectToUserPage(user);	
			//}
		})
		.error(function() {
		});
	};	
	
	//get security prompt for user
	$scope.getSecurityQuestion= function(securityPrompt){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signin/securityquestion.json', securityPrompt).success(function(question) {
			$scope.question=question;
		})
		.error(function() {
		});
	};	
	
	
	//before create spring security 
	$scope.redirectToUserPage= function(user){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signin/userrole.json', user).success(function(userRole) {
		
			$scope.role=userRole.userRoleName;
			if(role==='user'){
				$scope.changeRoute('#/user/parlor');
				//send id user
				
			}else if(role==='admin'){
				$scope.changeRoute('#/admin/parlor');
				//send id user
				
			}else{
				$scope.changeRoute('#/signin');
			}	
		})
		.error(function() {		
		});
	};	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	$scope.changeRoute = function(url, forceReload) {
        $scope = $scope || angular.element(document).scope();
        if(forceReload || $scope.$$phase) { 
            window.location = url;
        } else {
            $location.path(url);
            $scope.$apply();
        }
    };
	
});


