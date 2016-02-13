/**
 * 
 */
'use strict';

angular.module('socialcommunity').controller('UserCommonProfileController', function ($scope, $state, $controller, UserService) {
	
	$controller('UserController', {$scope: $scope, $state:$state});
	
	$scope.id = $state.params.idUser;
										//edit common profile
	
	$scope.loadCommonUserProfileData = function(id){
		UserService.loadCommonUserProfileData(id).then(
              function(user) {
            	  $scope.user=user;	
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};	
	$scope.loadCommonUserProfileData($scope.id);
	
	$scope.editCommonUserProfile = function(id,user){
		UserService.editCommonUserProfile(id,user).then(
              function(id) {
            	  $state.go('userparlor', {idUser: id});
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
		
});	
