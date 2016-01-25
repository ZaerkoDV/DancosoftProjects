/**
 * 
 */
'use strict';

angular.module('socialcommunity').controller('UserController',function ($scope, $rootScope ,$state, $http) {
	
	$scope.id = $state.params.idUser;
	$scope.idForum = $state.params.idForum;
	$scope.idForumTopic = $state.params.idForumTopic;
	
	$scope.loadUserData = function(id){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/parlor/accountdata.json',id).success(function(userParlorData) {
			$scope.userParlorData=userParlorData;
					
		}).error(function() {
		});
	};	
	$scope.loadUserData($scope.id);
	
	$scope.getListAccountGroup = function(id){	
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/parlor/listaccountgroup.json',id)
		.success(function(listAccountGroup) {
			$scope.listAccountGroup=listAccountGroup;		
			$state.go('userparlor', {idUser: id});
			
		}).error(function() {
		});
	};
	
	$scope.getListForum = function(id){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/parlor/listforum.json',id).success(function(listForum) {
			$scope.listForum=listForum;		
			$state.go('userparlor', {idUser: id});
			
		}).error(function() {
		});
	};
	
														//edit common profile
		
	$scope.loadCommonUserProfile = function(id){
		//$scope.changeRoute('#/user/parlor/editcommonprofile');
		$state.go('editcommonprofile', {idUser: id});
	};
	
	$scope.loadCommonUserProfileData = function(id){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/parlor/commonuserprofile.json',id).success(function(user) {
			$scope.user=user;
		}).error(function(){
		});
	};
	$scope.loadCommonUserProfileData($scope.id);
	
	$scope.editCommonUserProfile = function(id,user){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/parlor/'+id+'/editcommonprofile.json',user).success(function(id) {
			//$scope.changeRoute('#/user/parlor');
			$state.go('userparlor', {idUser: id});
			
		}).error(function(){
		});
	};
														//edit extended profile

	
	$scope.loadExtendedUserProfile = function(id){
		//$scope.changeRoute('#/user/parlor/editextendedprofile');
		$state.go('editextendedprofile', {idUser: id});
	};
	
	$scope.loadExtendedUserProfileData = function(id){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/parlor/extendeduserprofile.json',id)
		.success(function(userExtendedData) {
			$scope.userExtendedData=userExtendedData;
		}).error(function(){
		});
	};
	$scope.loadExtendedUserProfileData($scope.id);
	
	$scope.editExtendedUserProfile = function(id,userExtendedData){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/parlor/'+id+'/editextendedprofile.json',userExtendedData)
		.success(function(id) {
			//$scope.changeRoute('#/user/parlor');
			$state.go('userparlor', {idUser: id});
			
		}).error(function(){
		});
	};
	
	
	$scope.loadUserAutobiography = function(id){
		//$scope.changeRoute('#/user/parlor/editautobiography');
		$state.go('editautobiography', {idUser: id});
	};
	
	$scope.loadUserAutobiographyData = function(id){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/parlor/userautobiographyprofile.json',id)
		.success(function(userAutobiography) {
			$scope.userAutobiography=userAutobiography;
		}).error(function(){
		});
	};
	$scope.loadUserAutobiographyData($scope.id);

	$scope.editUserAutobiography = function(id,userAutobiography){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/parlor/'+id+'/editautobiographyprofile.json',userAutobiography)
		.success(function(id) {
			//$scope.changeRoute('#/user/parlor');
			$state.go('userparlor', {idUser: id});
			
		}).error(function(){
		});
	};
					
															//support data
	
	$scope.getListLanguage = function(){
		$http.get('http://localhost:8080/socialcommunity-web/views/listlanguage.json').success(function(listLanguage) {
			$scope.listLanguage=listLanguage;		
			//$state.go('editextendedprofile', {idUser: id});
			
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
			//$state.go('editextendedprofile', {idUser: id});
		}).error(function() {
		});
	};
	
	
															//forum topics
	
	$scope.getForum = function(id,idForum){
		$state.go('editlistforumtopic', {idUser: id, idForum:idForum})
	};
	
	$scope.loadListForumTopic = function(idForum){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/forum/listforumtopic.json',idForum)
		.success(function(listForumTopic) {
			$scope.listForumTopic=listForumTopic;
		}).error(function(){
		});
	};
		
	$scope.saveNewForumTopic = function(id,newForumTopic){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+id+'/savenewforumtopic.json',newForumTopic)
		.success(function(idForum) {
			$scope.loadListForumTopic(idForum);
		}).error(function(){
		});
	};
													//forum messages
	
	$scope.getTopicMessages=function(id,idForumTopic){
		$state.go('forumtopicmessages', {idUser: id, idForumTopic:idForumTopic})
	};
	
	$scope.loadListTopicMessages = function(idForumTopic){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+idForumTopic+'/listForumMessages.json')
		.success(function(listTopicMessages) {
			$scope.listTopicMessages=listTopicMessages;
		}).error(function(){
		});
	};
	
	$scope.saveNewForumMessages=function(newForumMessage){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/forum/saveForumMessages.json',newForumMessage)
		.success(function(idForumTopic) {
			$scope.loadListTopicMessages(idForumTopic);
		}).error(function(){
		});
	};
	
	$scope.deleteForumMessages=function(idForumTopic,idForumMessage){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+idForumTopic+'/deleteForumMessages.json',idForumMessage)
		.success(function(idForumTopic) {
			$scope.loadListTopicMessages(idForumTopic);
		}).error(function(){
		});
	};
	
	
//	$scope.createAccountGroup = function(id){	
//	};
	
//	$scope.getAccountGroup = function(id,idAccountGroup){	
//	};
	
	
	
	
	
	
	
	
	
	//search account
	
	
	
	$scope.returnToParlor = function(id){
		$state.go('userparlor', {idUser: id});	
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
    
});