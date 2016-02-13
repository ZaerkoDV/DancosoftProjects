/**
 * 
 */

'use strict';

angular.module('socialcommunity').controller('AdministratorExtendedProfileController', function ($scope, $state, $controller, AdministratorService) {
	
	$controller('AdministratorController', {$scope: $scope, $state:$state});
	
	$scope.idAdmin = $state.params.idAdmin;
	
	$scope.loadExtendedAdminProfileData = function(idAdmin){
		AdministratorService.loadExtendedAdminProfileData(idAdmin).then(
              function(adminExtendedData) {
            	  $scope.adminExtendedData=adminExtendedData;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	$scope.loadExtendedAdminProfileData($scope.idAdmin);
	
	$scope.editExtendedAdminProfile = function(idAdmin,adminExtendedData){
		AdministratorService.editExtendedAdminProfile(idAdmin,adminExtendedData).then(
              function(idAdmin) {
            	  $state.go('adminparlor', {idAdmin: idAdmin});
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
															//data
	$scope.getListLanguage = function(){
		AdministratorService.getListLanguage().then(
              function(listLanguage) {
            	  $scope.listLanguage=listLanguage;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	$scope.getListLanguage();
	
	$scope.getListCountry=function(){
		AdministratorService.getListCountry().then(
              function(listCountry) {
            	  $scope.listCountry=listCountry;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	$scope.getListCountry();
	
	$scope.getListCityByIdCountry = function(idCountry){
		AdministratorService.getListCityByIdCountry(idCountry).then(
              function(listCity) {
            	  $scope.listCity=listCity;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
												
	
});	
