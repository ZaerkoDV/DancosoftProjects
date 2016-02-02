/**
 * 
 */

'use strict';

angular.module('socialcommunity').controller('AdministratorController',function ($scope,$state, $http) {
	
	$scope.idAdmin = $state.params.idAdmin;
	$scope.idForum = $state.params.idForum;
	
	$scope.loadAdminData = function(idAdmin){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/accountdata.json',idAdmin)
		.success(function(adminParlorData) {
			$scope.adminParlorData=adminParlorData;
		}).error(function() {
		});
	};	
	$scope.loadAdminData($scope.idAdmin);
													//edit common profile
	
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
	
													//event pattern
	
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
			$scope.loadListEventPattern();
		}).error(function(){
		});
	};
	
	$scope.deleteEventPattern=function(idEventPattern){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/event/'+idEventPattern+'/deletedeventpattern.json')
		.success(function() {
			$scope.loadListEventPattern();
		}).error(function(){
		});
	};
	
	$scope.updateEventPattern=function(eventPattern){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/event/updatedeventpattern.json',eventPattern)
		.success(function() {
			$scope.loadListEventPattern();
		}).error(function(){
		});
	};
													//forum

	$scope.getListForum = function(){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/listforum.json')
		.success(function(listForum) {
			$scope.listForum=listForum;		
		}).error(function() {
		});
	};
	
	$scope.getListForumToEdit=function(idAdmin){
		$state.go('editlistforum', {idAdmin: idAdmin});
	};
	
	$scope.createNewForum = function(idAdmin){
		$state.go('newforum', {idAdmin: idAdmin});
	};
	
	$scope.saveNewForum=function(idAdmin,forum){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/newforum.json',forum)
		.success(function() {
			$state.go('adminparlor', {idAdmin: idAdmin});
		}).error(function(){
		});
	};
	
	$scope.editForum=function(idAdmin,forum){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/editforum.json',forum)
		.success(function() {
			$scope.getListForum();
		}).error(function(){
		});
	};
	
	$scope.deleteForum=function(idForum){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/'+idForum+'/deletedforum.json')
		.success(function() {
			$scope.getListForum();
		}).error(function(){
		});
	};
													//forum topic
	
	$scope.editForumTopic=function(idAdmin,idForum){
		$state.go('editforumtopic', {idAdmin: idAdmin, idForum:idForum});
	};
	
	$scope.loadListForumTopic = function(idForum){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/forum/listforumtopic.json',idForum)
		.success(function(listForumTopic) {
			$scope.listForumTopic=listForumTopic;
		}).error(function(){
		});
	};
	
	$scope.saveNewForumTopic=function(idForum,forumTopic){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/newtopic.json',forumTopic)
		.success(function(idForum) {
			$scope.loadListForumTopic(idForum);
		}).error(function(){
		});
	};
	
	$scope.deleteForumTopic=function(idForum,idForumTopic){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/deleteforumtopic/'+idForumTopic+'/forumtopic.json')
		.success(function() {
			$scope.loadListForumTopic(idForum);
		}).error(function(){
		});
	};
	
	
	//updateForumTopic(idForum,forumTopic)
	
	
	
	$scope.returnToParlor = function(idAdmin){
		$state.go('adminparlor', {idAdmin: idAdmin});	
	};
	
	
});