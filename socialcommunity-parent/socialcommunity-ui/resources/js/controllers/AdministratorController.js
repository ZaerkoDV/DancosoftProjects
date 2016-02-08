/**
 * 
 */

'use strict';

angular.module('socialcommunity').controller('AdministratorController',function ($scope,$state, $http) {
	
	$scope.idAdmin = $state.params.idAdmin;
	$scope.idForum = $state.params.idForum;
	$scope.idForumTopic=$state.params.idForumTopic;
	$scope.searchIdAccount=$state.params.searchIdAccount;
	$scope.idAccountGroup=$state.params.idAccountGroup;
	
	$scope.returnToParlor = function(idAdmin){
		$state.go('adminparlor', {idAdmin: idAdmin});	
	};
	
	$scope.loadAdminData = function(idAdmin){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/'+idAdmin+'/parlor/accountdata.json')
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
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/'+idAdmin+'/parlor/commonadminprofile.json')
		.success(function(admin) {
			$scope.admin=admin;
		}).error(function(){
		});
	};
	$scope.loadCommonAdminProfileData($scope.idAdmin);
	
	$scope.editCommonAdminProfile = function(idAdmin,admin){
		$http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/editcommonadminprofile.json',admin)
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
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/'+idAdmin+'/parlor/extendedadminprofile.json')
		.success(function(adminExtendedData) {
			$scope.adminExtendedData=adminExtendedData;
		}).error(function(){
		});
	};
	$scope.loadExtendedAdminProfileData($scope.idAdmin);
	
	$scope.editExtendedAdminProfile = function(idAdmin,adminExtendedData){
		$http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/'+idAdmin+'/editextendedadminprofile.json',adminExtendedData)
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
		$http.get('http://localhost:8080/socialcommunity-web/views/'+idCountry+'/listcity.json').success(function(listCity) {
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
		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/admin/event/'+idEventPattern+'/deletedeventpattern.json')
		.success(function() {
			$scope.loadListEventPattern();
		}).error(function(){
		});
	};
	
	$scope.updateEventPattern=function(eventPattern){
		$http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/event/updatedeventpattern.json',eventPattern)
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
	
	$scope.deleteForum=function(idForum){
		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/'+idForum+'/deletedforum.json')
		.success(function() {
			$scope.getListForum();
		}).error(function(){
		});
	};
	
	$scope.editForum=function(idAdmin,forum){
		$http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/editforum.json',forum)
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
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+idForum+'/listforumtopic.json')
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
		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/deleteforumtopic/'+idForumTopic+'/forumtopic.json')
		.success(function() {
			$scope.loadListForumTopic(idForum);
		}).error(function(){
		});
	};
	
	$scope.updateForumTopic=function(idForum,forumTopic){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/updateforumtopic.json',forumTopic)
		.success(function(idForum) {
			$scope.loadListForumTopic(idForum);
		}).error(function(){
		});
	};
											// forum messages
	
	$scope.getForumMessagePage=function(idAdmin,idForum,idForumTopic){
		$state.go('forummessage', {idAdmin:idAdmin,idForum:idForum,idForumTopic:idForumTopic});
	};

	
	$scope.searchForumMessagesBetweenDate=function(idForumTopic,from,to){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/'+idForumTopic+'/'+from+'/'+to+'/topicmessages.json')
		.success(function(listTopicMessages) {
			$scope.listTopicMessages=listTopicMessages;
		}).error(function(){
		});
	};
	
	$scope.saveNewForumMessages=function(idForumTopic,from,to,newForumMessage){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/forum/saveForumMessages.json',newForumMessage)
		.success(function(idForumTopic) {
			$scope.searchForumMessagesBetweenDate(idForumTopic,from,to);
		}).error(function(){
		});
	};
	
	$scope.deleteForumMessages=function(idForumTopic,from,to,idForumMessage){
		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+idForumTopic+'/'+idForumMessage+'/deleteForumMessages.json')
		.success(function(idForumTopic) {
			$scope.searchForumMessagesBetweenDate(idForumTopic,from,to);
		}).error(function(){
		});
	};
													//account
	
	$scope.getPageSearchAccount=function(idAdmin){
		$state.go('editlistaccount', {idAdmin:idAdmin});
	};
	
	$scope.searchAccount=function(account){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/account/searchaccount.json',account)
		.success(function(accountList) {
			$scope.blockStatus='';
			$scope.accountList=accountList;
		}).error(function(){
		});
	};
	
	$scope.changeAccountBlockStatus=function(account,blockStatus){
		$http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/account/'+blockStatus+'/newblockstatus.json',account)
		.success(function(account) {
			$scope.searchAccount(account)
		}).error(function(){
		});
	}
	
	$scope.deleteAccount=function(idAdmin,idAccount){
		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/admin/account/'+idAccount+'/deleteaccount.json')
		.success(function() {
			$scope.accountList='';
		}).error(function(){
		});
	};
												//account info
	
	$scope.getAccountInfo=function(idAdmin,searchIdAccount){
		$state.go('useraccountinfo', {idAdmin: idAdmin,searchIdAccount:searchIdAccount});
	};
	
	$scope.loadAccountInfo=function(searchIdAccount){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/account/'+searchIdAccount+'/accountinfo.json')
		.success(function(accountDataSearchResult) {
			$scope.accountDataSearchResult=accountDataSearchResult;
		}).error(function() {
		});
	};
	
	$scope.getAccountSingleMessagesPage=function(idAdmin,searchIdAccount){
		$state.go('useraccountsinglemessage', {idAdmin: idAdmin,searchIdAccount:searchIdAccount});
	};
	
	$scope.searchSingleMessagesBetweenDate=function(searchIdAccount,fromDate,toDate){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/account/'+searchIdAccount+'/'+fromDate+'/'+toDate+'/singlemessages.json')
		.success(function(listAccountSingleMessage) {
			$scope.listAccountSingleMessage = listAccountSingleMessage;
		}).error(function(){
		});
	};
	
	$scope.saveNewAccountSingleMessage=function(idAdmin,searchIdAccount,newAccountSingleMessage,fromDate,toDate){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/'+idAdmin+'/account/saveAccountSingleMessage.json',newAccountSingleMessage)
		.success(function(idAdmin) {
			$scope.searchSingleMessagesBetweenDate(searchIdAccount,fromDate,toDate);
		}).error(function(){
		});
	};
	
	$scope.deleteAccountSingleMessage=function(idAdmin,searchIdAccount,idAccountSingleMessage,fromDate,toDate){
		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/user/'+idAdmin+'/account/'
				+idAccountSingleMessage+'/deleteAccountSingleMessage.json').success(function() {
			$scope.searchSingleMessagesBetweenDate(searchIdAccount,fromDate,toDate);
		}).error(function(){
		});
	};
													//edit user account group
	
	$scope.getSearchAccountGroupPage=function(idAdmin){
		$state.go('searchaccountgrouppage', {idAdmin:idAdmin});
	};
	
	$scope.searchAccountGroup=function(groupName,accountName){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/group/'+groupName+'/'+accountName+'/searchAccountGroup.json')
		.success(function(listAccountGroup) {
			$scope.blockStatus='';
			$scope.listAccountGroup = listAccountGroup;
		}).error(function(){
		});
	};
	
	$scope.changeAccountGroupBlockStatus=function(accountGroup,blockStatus,groupName,accountName){
		$http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/group/'+blockStatus+'/newblockstatus.json',accountGroup)
		.success(function() {		
			if(groupName==='undefined'){
				groupName=null;
			}
			if(accountName==='undefined'){
				accountName=null;
			}
			$scope.searchAccountGroup(groupName,accountName);	
		}).error(function(){
		});
	};
	
	$scope.deleteAccountGroup=function(idAccountGroup){
		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/admin/group/'+idAccountGroup+'/deleteaccountgroup.json')
		.success(function() {
			$scope.listAccountGroup='';
		}).error(function(){
		});
	};
	
	$scope.getAccountGroupMessages=function(idAdmin, idAccountGroup){
		$state.go('listusergroupmessages', {idAdmin: idAdmin, idAccountGroup:idAccountGroup});
	};
	
	$scope.searchGroupMessagesBetweenDate=function(idAccountGroup,fromDate,toDate){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/group/'+idAccountGroup+'/'+fromDate+'/'+toDate+'/groupmessages.json')
		.success(function(listAccountGroupMessage) {
			$scope.listAccountGroupMessage = listAccountGroupMessage;
		}).error(function(){
		});
	};
	
	$scope.saveNewAccountGroupMessage=function(idAdmin,idAccountGroup,newAccountGroupMessage,fromDate,toDate){
		$http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/'+
				idAdmin+'/group/'+idAccountGroup+'/saveAccountGroupMessage.json',newAccountGroupMessage)
		.success(function() {
			$scope.searchGroupMessagesBetweenDate(idAccountGroup,fromDate,toDate);
		}).error(function(){
		});
	};
	
	$scope.deleteAccountGroupMessage=function(idAccountGroup,idGroupMessage,fromDate,toDate){
		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/'+idGroupMessage+'/deleteAccountGroupMessage.json')
		.success(function(idAccountGroup) {
			$scope.searchGroupMessagesBetweenDate(idAccountGroup,fromDate,toDate);
		}).error(function(){
		});
	};
	
	$scope.getAccountGroupMembers=function(idAdmin,idAccountGroup){
		$state.go('editlistgroupmembers', {idAdmin:idAdmin, idAccountGroup:idAccountGroup});
	};
	
	$scope.loadListAccountGroupMembers=function(idAccountGroup){
		$http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/group/'+idAccountGroup+'/listgroupmembers.json')
		.success(function(listAccountGroupMembers) {
			$scope.listAccountGroupMembers = listAccountGroupMembers;
		}).error(function(){
		});
	};
	
	
	
	
	
	
	$scope.today = function() {
	    $scope.from = new Date();
	    $scope.to=new Date();
	};
	$scope.today();

    $scope.open1 = function() {
	    $scope.popup1.opened = true;
	};
	
	$scope.open2 = function() {
	    $scope.popup2.opened = true;
	};

	$scope.setDate = function(year, month, day) {
	    $scope.from = new Date(year, month, day);
	    $scope.to = new Date(year, month, day);
	};

	$scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	};

	$scope.popup1 = {
	   opened: false
	};
	
	$scope.popup2 = {
	   opened: false
	};
			
});