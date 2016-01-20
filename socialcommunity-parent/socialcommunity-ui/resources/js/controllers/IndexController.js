/**
 * 
 */
'use strict';

//angular.module('socialcommunity', ['ngAnimate', 'ui.bootstrap']);
angular.module('socialcommunity').controller('IndexController',function ($scope,$state, $http) {

	$scope.id = $state.params.idUser;
	
	$scope.saveCommonUser = function(user){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/savecommon/user.json',user).success(function(id) {
					
			if(id===null || id===''){
				$scope.changeRoute('#/signup');
				
			}else{
				$scope.changeRoute('#/signup/extended');
				$state.go('signupextended', {idUser: id});
			}
		}).error(function() {
		});
	};	
	
	$scope.saveExtendedUser = function(id,userExtended){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/saveextended/'+id+'/userextended.json',userExtended)
		.success(function(id) {								  
			
			if(id===null || id===''){
				$scope.changeRoute('#/signup/extended');
			
			}else{
				$scope.changeRoute('#/signup/login');
				$state.go('signuplogin', {idUser: id});
			}
		}).error(function() {
		});
	};	
	
	$scope.saveLoginUser = function(id,securityPrompt){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/savelogin/'+id+'/userlogin.json',securityPrompt)
		.success(function(id) {
			
			if(id===null || id===''){
				$scope.changeRoute('#/signup/login');
				
			}else{
				$scope.createUserAccount(id);
				$scope.changeRoute('/socialcommunity');
			}
		}).error(function() {
		});
	};	
	
	$scope.createUserAccount = function(id){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/createaccount/useraccount.json',id)
		.success(function(id) {
			
		}).error(function() {
		});
	};	
	
	
													//sign in
	$scope.userSignIn = function(securityPrompt){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signin/userdata.json',securityPrompt).success(function(id) {
			
			if(id===null && id===''){
				$scope.changeRoute('#/signin');	
				
			}else{
				$scope.redirectToUserPage(id);	
			}
		}).error(function() {
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
	
	//before use spring security 
	$scope.redirectToUserPage= function(id){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/signin/userrole.json', id).success(function(userRole) {
		
			if(userRole.userRoleName==='user'){
				//$state.go('userparlor', {idUser: id});
				$scope.changeRoute('#/user/parlor');
				
			}else if(userRole.userRoleName==='admin'){
				//$state.go('adminparlor', {idUser: id});
				$scope.changeRoute('#/admin/parlor');
				
			}else{
				$scope.changeRoute('#/signin');
			}	
		}).error(function() {		
		});
	};	
	
	
	
	
	
	
	
	
	
	
	//route change
	$scope.changeRoute = function(url, forceReload) {
        $scope = $scope || angular.element(document).scope();
        if(forceReload || $scope.$$phase) { 
            window.location = url;
        } else {
            $location.path(url);
            $scope.$apply();
        }
    };
	
    //datekeaper
    $scope.today = function() {
	      $scope.dt = new Date();
	};
	$scope.today();

    $scope.clear = function() {
        $scope.dt = null;
    };

	$scope.setDate = function(year, month, day) {
	    $scope.dt = new Date(year, month, day);
	};  
	    
	$scope.open = function() {
	    $scope.popup.opened = true;
	};
	      
	$scope.popup = {
	    opened: false
	};

});