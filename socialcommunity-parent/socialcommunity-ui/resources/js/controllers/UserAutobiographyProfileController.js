/**
 * 
 */
'use strict';

angular.module('socialcommunity').controller('UserAutobiographyProfileController', function ($scope, $state, $controller, UserService) {
	
	$controller('UserController', {$scope: $scope, $state:$state});
	
	$scope.id = $state.params.idUser;
										
	$scope.loadUserAutobiographyData = function(id){
		UserService.loadUserAutobiographyData(id).then(
              function(userAutobiography) {
            	  $scope.userAutobiography=userAutobiography;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	$scope.loadUserAutobiographyData($scope.id);
	
	$scope.editUserAutobiography = function(id,userAutobiography){
		UserService.editUserAutobiography(id,userAutobiography).then(
              function(id) {
            	  $state.go('userparlor', {idUser: id});
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
		
});	
