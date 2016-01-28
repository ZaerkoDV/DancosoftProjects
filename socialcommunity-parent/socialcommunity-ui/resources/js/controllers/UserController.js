/**
 * 
 */
'use strict';

angular.module('socialcommunity').controller('UserController',function ($scope, $rootScope ,$state, $http) {
	
	$scope.id = $state.params.idUser;
	$scope.idForum = $state.params.idForum;
	$scope.idForumTopic = $state.params.idForumTopic;
	$scope.idAccountGroup= $state.params.idAccountGroup;
	$scope.idAccountGroupMember=$state.params.idAccountGroupMember;
	
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
														//editAutoboigraphy
	
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
	
	
														  //group save
	$scope.createAccountGroup = function(id){	
		$state.go('addaccountgroup', {idUser: id});
	};
	
	$scope.saveNewAccountGroup=function(id,accountGroup){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+id+'/saveAccountGroup.json',accountGroup)
		.success(function(id) {
			$state.go('userparlor', {idUser: id});
		}).error(function(){
		});
	};
														//get id group member
	
	$scope.getAccountGroup = function(id,idAccountGroup){	
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+id+'/'+idAccountGroup+'/accountGroupMember.json')
		.success(function(idAccountGroupMember){
			$state.go('viewaccountgroup', {idUser: id, idAccountGroupMember:idAccountGroupMember,idAccountGroup:idAccountGroup});
		}).error(function(){
		});
	};
														//group messages & pattern
	
	$scope.loadListAccountGroupMessages = function(idAccountGroup){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/listAccountGroupMessages.json')
		.success(function(listAccountGroupMessages) {
			$scope.listAccountGroupMessages=listAccountGroupMessages;
		}).error(function(){
		});
	};
	
	$scope.saveNewAccountGroupMessage=function(newAccountGroupMessage){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/group/saveAccountGroupMessage.json',newAccountGroupMessage)
		.success(function(idAccountGroup) {
			$scope.loadListAccountGroupMessages(idAccountGroup);
		}).error(function(){
		});
	};
	
	$scope.deleteAccountGroupMessage=function(idAccountGroup,idGroupMessage){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/deleteAccountGroupMessage.json',idGroupMessage)
		.success(function(idAccountGroup) {
			$scope.loadListAccountGroupMessages(idAccountGroup);
		}).error(function(){
		});
	};
	
	$scope.loadListEventPattern=function(){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/listEventPattern.json')
		.success(function(listEventPattern) {
			$scope.listEventPattern=listEventPattern;
			
		}).error(function(){
		});
	};
	
	$scope.editAccountGroupMember=function(id,idAccountGroupMember,idAccountGroup){
		$state.go('editaccountgroupmember', {
			idUser: id,
			idAccountGroupMember:idAccountGroupMember,
			idAccountGroup:idAccountGroup
		});
	};
	
	$scope.loadListAccountGroupMember=function(idAccountGroup){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/listAccountGroupMembers.json')
		.success(function(listAccountGroupMember) {
			$scope.listAccountGroupMember=listAccountGroupMember;
			
		}).error(function(){
		});
	};
	
	$scope.deleteMemberFromAccountGroup=function(idAccountGroupMember,idAccountGroup,idDeleteGroupMember){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroupMember+'/'+idDeleteGroupMember+'/deleteAccountGroupMember.json')
		.success(function(idAccountGroupMember) {
			$scope.loadListAccountGroupMember(idAccountGroup);
			
		}).error(function(){
		});	
	};
	
	$scope.searchAccountForAccountGroup=function(idAccountGroup,searchPattern){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/listaccount.json',searchPattern)
		.success(function(listAccount) {
			$scope.friendStatus=false;
			$scope.listAccount=listAccount;	
		}).error(function(){
		});	
	};
	
	$scope.addToAccountGroup=function(idAccountGroup,idAccountNewMember,friendStatus){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/'+idAccountNewMember+'/newmember.json',friendStatus)
		.success(function(idAccountGroup) {
			$scope.loadListAccountGroupMember(idAccountGroup);
		}).error(function(){
		});	
	};
	
																//search account
	
	$scope.getPageSearchAccount=function(id){
		$state.go('searchaccount', {idUser: id});
	};
	
	$scope.getListAccountGroupForAccount=function(id){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/account/listaccountgroup.json')
		.success(function(listAccountGroup) {
			$scope.friendStatus=false;
			$scope.listAccountGroup=listAccountGroup;
		}).error(function(){
		});	
	};
	
	$scope.searchAccountByAccountName=function(id, searchPattern){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/account/searchaccount.json',searchPattern)
		.success(function(listAccount) {
			$scope.listAccount=listAccount;
		}).error(function(){
		});	
	};
	
	$scope.addToAccountGroupAfterSearch=function(idAccountGroupSelected,idAccount,friendStatus){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/account/'+idAccountGroupSelected
				+'/'+idAccount+'/newaccountgroupmember.json',friendStatus).success(function() {
		}).error(function(){
		});	
	};

	$scope.searchIdAccount=$state.params.searchIdAccount;
	$scope.getAccountInfo=function(id,searchIdAccount){
		$state.go('accountinfo', {idUser: id,searchIdAccount:searchIdAccount});
	};
	
	$scope.loadAccountInfo=function(searchIdAccount){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/account/'+searchIdAccount+'/accountinfo.json')
		.success(function(accountDataSearchResult) {
			$scope.accountDataSearchResult=accountDataSearchResult;
		}).error(function() {
		});
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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