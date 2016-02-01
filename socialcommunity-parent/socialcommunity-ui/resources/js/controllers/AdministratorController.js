/**
 * 
 */

'use strict';

angular.module('socialcommunity').controller('AdministratorController',function ($scope,$state, $http) {
	
	$scope.idAdmin = $state.params.idAdmin;
	
	$scope.loadAdminData = function(idAdmin){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/accountdata.json',idAdmin)
		.success(function(adminParlorData) {
			$scope.adminParlorData=adminParlorData;
		}).error(function() {
		});
	};	
	$scope.loadAdminData($scope.idAdmin);
	
	$scope.getListForum = function(){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/listforum.json')
		.success(function(listForum) {
			$scope.listForum=listForum;		
		}).error(function() {
		});
	};
	
	
	
	
	
	$scope.loadCommonAdminProfile = function(idAdmin){
		$state.go('editadmincommonprofile', {idAdmin: idAdmin});
	};
	
	$scope.loadCommonAdminProfileData = function(idAdmin){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/commonadminprofile.json',idAdmin)
		.success(function(admin) {
			$scope.admin=admin;
		}).error(function(){
		});
	};
	$scope.loadCommonAdminProfileData($scope.idAdmin);
	
	$scope.editCommonAdminProfile = function(idAdmin,admin){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/editcommonadminprofile.json',admin)
 	.success(function(idAdmin) {
			$state.go('adminparlor', {idAdmin: idAdmin});		
		}).error(function(){
		});
	};

	
													//edit extended profile

	$scope.loadExtendedAdminProfile = function(idAdmin){
		$state.go('editextendedadminprofile', {idAdmin: idAdmin});
	};
	
	
	$scope.loadExtendedAdminProfileData = function(idAdmin){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/extendedadminprofile.json',idAdmin)
		.success(function(adminExtendedData) {
			$scope.adminExtendedData=adminExtendedData;
			
		}).error(function(){
		});
	};
	$scope.loadExtendedAdminProfileData($scope.idAdmin);
	
	$scope.editExtendedAdminProfile = function(idAdmin,adminExtendedData){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/'+idAdmin+'/editextendedadminprofile.json',adminExtendedData)
		.success(function(idAdmin) {
			$state.go('adminparlor', {idAdmin: idAdmin});	
		}).error(function(){
		});
	};
																//data
	
	$scope.getListLanguage = function(){
		$http.get('http://localhost:8080/socialcommunity-web/views/listlanguage.json').success(function(listLanguage) {
			$scope.listLanguage=listLanguage;		
		}).error(function() {
		});
	};
	$scope.getListLanguage();
	
	$scope.getListCountry=function(){
		$http.get('http://localhost:8080/socialcommunity-web/views/listcountry.json').success(function(listCountry) {
			$scope.listCountry=listCountry;
		}).error(function() {
		});
	};
	$scope.getListCountry();
	
	$scope.getListCityByIdCountry = function(idCountry){
		$http.post('http://localhost:8080/socialcommunity-web/views/listcity.json',idCountry).success(function(listCity) {
			$scope.listCity=listCity;		
		}).error(function() {
		});
	};
	
	$scope.getEventPatternPage = function(idAdmin){
		$state.go('editeventpattern', {idAdmin: idAdmin});
	};
	
	$scope.loadListEventPattern=function(){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/listEventPattern.json')
		.success(function(listEventPattern) {
			$scope.listEventPattern=listEventPattern;
		}).error(function(){
		});
	};
	
	$scope.saveEventPattern=function(eventPattern){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/event/neweventpattern.json',eventPattern)
		.success(function() {
		}).error(function(){
		});
	};
	
	//deleteEventPattern(eventPattern.idEventPattern)
	
	//editEventPattern(eventPattern.idEventPattern)
	
	
	
	
	
	
	
	$scope.returnToParlor = function(idAdmin){
		$state.go('adminparlor', {idAdmin: idAdmin});	
	};
	
	
});