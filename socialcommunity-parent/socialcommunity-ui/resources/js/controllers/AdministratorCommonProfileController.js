/**
 * 
 */

'use strict';

angular.module('socialcommunity').controller('AdministratorCommonProfileController', function ($scope, $state, $controller, AdministratorService) {
	
	$controller('AdministratorController', {$scope: $scope, $state:$state});
	
	$scope.idAdmin = $state.params.idAdmin;
	
	$scope.loadCommonAdminProfileData = function(idAdmin){
		AdministratorService.loadCommonAdminProfileData(idAdmin).then(
              function(admin) {
            	  $scope.admin=admin;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};	
	$scope.loadCommonAdminProfileData($scope.idAdmin);
	
	$scope.editCommonAdminProfile = function(idAdmin,admin){
		AdministratorService.editCommonAdminProfile(idAdmin,admin).then(
              function(idAdmin) {
            	  $state.go('adminparlor', {idAdmin: idAdmin});
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};	
												
	
});	
