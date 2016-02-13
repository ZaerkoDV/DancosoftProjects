/**
 * 
 */
'use strict';

angular.module('socialcommunity').controller('UserExtendedProfileController', function ($scope, $state, $controller, UserService) {
	
	$controller('UserController', {$scope: $scope, $state:$state});
	
	$scope.id = $state.params.idUser;

	
	$scope.loadExtendedUserProfileData = function(id){
		UserService.loadExtendedUserProfileData(id).then(
              function(userExtendedData) {
            	  $scope.userExtendedData=userExtendedData;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	$scope.loadExtendedUserProfileData($scope.id);
	
	$scope.editExtendedUserProfile = function(id,userExtendedData){
		UserService.editExtendedUserProfile(id,userExtendedData).then(
              function(id) {
            	  $state.go('userparlor', {idUser: id});
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
		
												//support data
	$scope.getListLanguage = function(){
		UserService.getListLanguage().then(
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
		UserService.getListCountry().then(
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
		UserService.getListCityByIdCountry(idCountry).then(
              function(listCity) {
            	  $scope.listCity=listCity;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
												
});	
