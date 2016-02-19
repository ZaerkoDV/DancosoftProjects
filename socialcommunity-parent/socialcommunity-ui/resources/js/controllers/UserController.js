/**
 * 
 */
'use strict';

angular.module('socialcommunity').controller('UserController', function ($scope, $state, UserService) {
	
	$scope.id = $state.params.idUser;
	$scope.idForum = $state.params.idForum;
	$scope.idForumTopic = $state.params.idForumTopic;
	$scope.idAccountGroup= $state.params.idAccountGroup;
	$scope.idAccountGroupMember=$state.params.idAccountGroupMember;
	$scope.searchIdAccount=$state.params.searchIdAccount;
	
												//user parlor
	$scope.loadUserData = function(id){
		UserService.loadUserData(id).then(
              function(userParlorData) {
            	  $scope.userParlorData=userParlorData;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};	
	$scope.loadUserData($scope.id);
	
	$scope.getListAccountGroup = function(id){
		UserService.getListAccountGroup(id).then(
              function(listAccountGroup) {
            	  $scope.listAccountGroup=listAccountGroup;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};	
		
	$scope.getListForum = function(id){
		UserService.getListForum(id).then(
              function(listForum) {
            	  $scope.listForum=listForum;	
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};	
	
												//return to user parlor
	$scope.returnToParlor = function(id){
		$state.go('userparlor', {idUser: id});	
	};
												//edit common profile
	
	$scope.loadCommonUserProfile = function(id){
		$state.go('editcommonprofile', {idUser: id});
	};
											//edit extended profile
	
	$scope.loadExtendedUserProfile = function(id){
		$state.go('editextendedprofile', {idUser: id});
	};
										   //editAutoboigraphy
	
	$scope.loadUserAutobiography = function(id){
		$state.go('editautobiography', {idUser: id});
	};	
	
											//forum
	$scope.getForum = function(id,idForum){
		$state.go('editlistforumtopic', {idUser: id, idForum:idForum})
	};
	
	$scope.loadListForumTopic = function(idForum){
		UserService.loadListForumTopic(idForum).then(
              function(listForumTopic) {
            	  $scope.listForumTopic=listForumTopic;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.saveNewForumTopic = function(id,newForumTopic){
		UserService.saveNewForumTopic(id,newForumTopic).then(
              function(idForum) {
            	  $scope.loadListForumTopic(idForum);
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.getTopicMessages=function(id,idForumTopic){
		$state.go('forumtopicmessages', {idUser: id, idForumTopic:idForumTopic})
	};
	
	$scope.loadListTopicMessages = function(idForumTopic){
		UserService.loadListTopicMessages(idForumTopic).then(
              function(listTopicMessages) {
            	  $scope.listTopicMessages=listTopicMessages;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.saveNewForumMessages=function(newForumMessage){
		UserService.saveNewForumMessages(newForumMessage).then(
              function(idForumTopic) {
            	  $scope.loadListTopicMessages(idForumTopic);
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.deleteForumMessages=function(idForumTopic,idForumMessage){
		UserService.deleteForumMessages(idForumTopic,idForumMessage).then(
              function(idForumTopic) {
            	  $scope.loadListTopicMessages(idForumTopic);
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
												//account group
	$scope.createAccountGroup = function(id){	
		$state.go('addaccountgroup', {idUser: id});
	};
	
	$scope.saveNewAccountGroup=function(id,accountGroup){
		UserService.saveNewAccountGroup(id,accountGroup).then(
              function(id) {
            	  $state.go('userparlor', {idUser: id});
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.getAccountGroup = function(id,idAccountGroup){
		UserService.getAccountGroup(id,idAccountGroup).then(
              function(idAccountGroupMember) {
            	  $state.go('viewaccountgroup', {idUser: id, idAccountGroupMember:idAccountGroupMember,idAccountGroup:idAccountGroup});
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.loadListAccountGroupMessages = function(idAccountGroup){
		UserService.loadListAccountGroupMessages(idAccountGroup).then(
              function(listAccountGroupMessages) {
            	  $scope.listAccountGroupMessages=listAccountGroupMessages;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.saveNewAccountGroupMessage=function(newAccountGroupMessage){
		UserService.saveNewAccountGroupMessage(newAccountGroupMessage).then(
              function(idAccountGroup) {
            	  $scope.loadListAccountGroupMessages(idAccountGroup);
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.deleteAccountGroupMessage=function(idAccountGroup,idGroupMessage){
		UserService.deleteAccountGroupMessage(idAccountGroup,idGroupMessage).then(
              function(idAccountGroup) {
            	  $scope.loadListAccountGroupMessages(idAccountGroup);
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.loadListEventPattern=function(){
		UserService.loadListEventPattern().then(
              function(listEventPattern) {
            	  $scope.listEventPattern=listEventPattern;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.loadAccountGroupToEdit=function(idAccountGroup){
		UserService.loadAccountGroupToEdit(idAccountGroup).then(
	       function(accountGroup) {
	           	  $scope.accountGroup=accountGroup;
	       },
	       function(errResponse){
	              console.error('!!!Error');
	       }
	     );
	};
	
	$scope.editAccountGroup=function(accountGroup){
		UserService.editAccountGroup(accountGroup).then(
	       function(accountGroup) {
	           $scope.accountGroup=accountGroup;
	       },
	       function(errResponse){
	           console.error('!!!Error');
	       }
	     );
	};
	
	
	
	$scope.editAccountGroupMember=function(id,idAccountGroupMember,idAccountGroup){
		$state.go('editaccountgroupmember', {
			idUser: id,
			idAccountGroupMember:idAccountGroupMember,
			idAccountGroup:idAccountGroup
		});
	};
	
	$scope.loadListAccountGroupMember=function(idAccountGroup){
		UserService.loadListAccountGroupMember(idAccountGroup).then(
              function(listAccountGroupMember) {
            	  $scope.listAccountGroupMember=listAccountGroupMember;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.deleteMemberFromAccountGroup=function(idAccountGroupMember,idAccountGroup,idDeleteGroupMember){
		UserService.deleteMemberFromAccountGroup(idAccountGroupMember,idAccountGroup,idDeleteGroupMember).then(
              function(idAccountGroupMember) {
            	  $scope.loadListAccountGroupMember(idAccountGroup);
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.getRightEditGroupMember=function(id,idAccountGroup){
		UserService.getRightEditGroupMember(id,idAccountGroup).then(
	         function(rightToEditGroupMember) {
	          	  $scope.rightToEditGroupMember=rightToEditGroupMember;	
	         },
	         function(errResponse){
	              console.error('!!!Error');
	         }
	    );
	}
	
	$scope.searchAccountForAccountGroup=function(idAccountGroup,searchPattern){
		if(searchPattern===undefined){
			searchPattern='null';
		}
		UserService.searchAccountForAccountGroup(idAccountGroup,searchPattern).then(
              function(listAccount) {
            	  $scope.friendStatus=false;
          		  $scope.listAccount=listAccount;	
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.addToAccountGroup=function(idAccountGroup,idAccountNewMember,friendStatus){
		UserService.addToAccountGroup(idAccountGroup,idAccountNewMember,friendStatus).then(
              function(idAccountGroup) {
            	  $scope.loadListAccountGroupMember(idAccountGroup);	
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
												//search account
	$scope.getPageSearchAccount=function(id){
		$state.go('searchaccount', {idUser: id});
	};
	
	$scope.getListAccountGroupForAccount=function(id){
		UserService.getListAccountGroupForAccount(id).then(
              function(listAccountGroup) {
            	  $scope.friendStatus=false;
          		  $scope.listAccountGroup=listAccountGroup;	
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.searchAccountByAccountName=function(id, searchPattern){
		if(searchPattern===undefined){
			searchPattern='null';
		}
		UserService.searchAccountByAccountName(searchPattern).then(
              function(listAccount) {
            	  $scope.listAccount=listAccount;	
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.addToAccountGroupAfterSearch=function(idAccountGroupSelected,idAccount,friendStatus){
		UserService.addToAccountGroupAfterSearch(idAccountGroupSelected,idAccount,friendStatus).then(
              function() {	
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.getAccountInfo=function(id,searchIdAccount){
		$state.go('accountinfo', {idUser: id,searchIdAccount:searchIdAccount});
	};
	
	$scope.loadAccountInfo=function(searchIdAccount){
		UserService.loadAccountInfo(searchIdAccount).then(
              function(accountDataSearchResult) {
            	  $scope.accountDataSearchResult=accountDataSearchResult;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
												//single messege
	$scope.getAccountSingleDialog=function(id,searchIdAccount){
		$state.go('accountsinglemessage', {idUser: id,searchIdAccount:searchIdAccount});
	};
	
	$scope.loadListAccountSingleMessages=function(id,searchIdAccount){
		UserService.loadListAccountSingleMessages(id,searchIdAccount).then(
              function(listAccountSingleMessage) {
            	  $scope.listAccountSingleMessage=listAccountSingleMessage;
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.saveNewAccountSingleMessage=function(id,searchIdAccount,newAccountSingleMessage){
		UserService.saveNewAccountSingleMessage(id,searchIdAccount,newAccountSingleMessage).then(
              function(id) {
            	  $scope.loadListAccountSingleMessages(id,searchIdAccount);
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.deleteAccountSingleMessage=function(id,searchIdAccount,idAccountSingleMessage){
		UserService.deleteAccountSingleMessage(id,searchIdAccount,idAccountSingleMessage).then(
              function(id) {
            	  $scope.loadListAccountSingleMessages(id,searchIdAccount);
              },
              function(errResponse){
                  console.error('!!!Error');
              }
          );
	};
	
	$scope.open1 = function() {
	    $scope.popup1.opened = true;
	};

	$scope.dateOptions = {
	    formatYear: 'yy',
	    startingDay: 1
	};

	$scope.popup1 = {
	   opened: false
	};
		
});	








//old


//angular.module('socialcommunity').controller('UserController',function ($scope,$state, $http) {
//	
//	$scope.id = $state.params.idUser;
//	$scope.idForum = $state.params.idForum;
//	$scope.idForumTopic = $state.params.idForumTopic;
//	$scope.idAccountGroup= $state.params.idAccountGroup;
//	$scope.idAccountGroupMember=$state.params.idAccountGroupMember;
//	$scope.searchIdAccount=$state.params.searchIdAccount;
//	
//													//user parlor
//	
//	$scope.loadUserData = function(id){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/parlor/accountdata.json')
//		.success(function(userParlorData) {
//			$scope.userParlorData=userParlorData;
//		}).error(function() {
//		});
//	};	
//	$scope.loadUserData($scope.id);
//	
//	$scope.getListAccountGroup = function(id){	
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/parlor/listaccountgroup.json')
//		.success(function(listAccountGroup) {
//			$scope.listAccountGroup=listAccountGroup;		
//		}).error(function() {
//		});
//	};
//	
//	$scope.getListForum = function(id){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/parlor/listforum.json')
//		.success(function(listForum) {
//			$scope.listForum=listForum;		
//		}).error(function() {
//		});
//	};
//													//return to user parlor
//	
//	$scope.returnToParlor = function(id){
//		$state.go('userparlor', {idUser: id});	
//	};
//													//edit common profile
//		
//	$scope.loadCommonUserProfile = function(id){
//		$state.go('editcommonprofile', {idUser: id});
//	};
//	
//	$scope.loadCommonUserProfileData = function(id){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/parlor/commonuserprofile.json')
//		.success(function(user) {
//			$scope.user=user;
//		}).error(function(){
//		});
//	};
//	$scope.loadCommonUserProfileData($scope.id);
//	
//	$scope.editCommonUserProfile = function(id,user){
//		$http.put('http://localhost:8080/socialcommunity-web/views/profile/user/parlor/'+id+'/editcommonprofile.json',user)
//		.success(function(id) {
//			$state.go('userparlor', {idUser: id});		
//		}).error(function(){
//		});
//	};
//												//edit extended profile
//
//	$scope.loadExtendedUserProfile = function(id){
//		$state.go('editextendedprofile', {idUser: id});
//	};
//	
//	$scope.loadExtendedUserProfileData = function(id){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/parlor/extendeduserprofile.json')
//		.success(function(userExtendedData) {
//			$scope.userExtendedData=userExtendedData;
//		}).error(function(){
//		});
//	};
//	$scope.loadExtendedUserProfileData($scope.id);
//	
//	$scope.editExtendedUserProfile = function(id,userExtendedData){
//		$http.put('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/parlor/editextendedprofile.json',userExtendedData)
//		.success(function(id) {
//			$state.go('userparlor', {idUser: id});
//		}).error(function(){
//		});
//	};
//												//editAutoboigraphy
//	
//	$scope.loadUserAutobiography = function(id){
//		$state.go('editautobiography', {idUser: id});
//	};
//	
//	$scope.loadUserAutobiographyData = function(id){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/parlor/userautobiographyprofile.json')
//		.success(function(userAutobiography) {
//			$scope.userAutobiography=userAutobiography;
//		}).error(function(){
//		});
//	};
//	$scope.loadUserAutobiographyData($scope.id);
//
//	$scope.editUserAutobiography = function(id,userAutobiography,birth){
//		//this.userAutobiography.birth = null;
//		$http.put('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/'+birth+'/parlor/editautobiographyprofile.json',userAutobiography)
//		.success(function(id) {
//			$state.go('userparlor', {idUser: id});
//		}).error(function(){
//		});
//	};
//													//support data
//	
//	$scope.getListLanguage = function(){
//		$http.get('http://localhost:8080/socialcommunity-web/views/listlanguage.json').success(function(listLanguage) {
//			$scope.listLanguage=listLanguage;		
//		}).error(function() {
//		});
//	};
//	$scope.getListLanguage();
//	
//	$scope.getListCountry=function(){
//		$http.get('http://localhost:8080/socialcommunity-web/views/listcountry.json').success(function(listCountry) {
//			$scope.listCountry=listCountry;
//		}).error(function() {
//		});
//	};
//	$scope.getListCountry();
//	
//	$scope.getListCityByIdCountry = function(idCountry){
//		$http.get('http://localhost:8080/socialcommunity-web/views/'+idCountry+'/listcity.json').success(function(listCity) {
//			$scope.listCity=listCity;		
//		}).error(function() {
//		});
//	};
//													//forum
//	
//	$scope.getForum = function(id,idForum){
//		$state.go('editlistforumtopic', {idUser: id, idForum:idForum})
//	};
//	
//	$scope.loadListForumTopic = function(idForum){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+idForum+'/listforumtopic.json')
//		.success(function(listForumTopic) {
//			$scope.listForumTopic=listForumTopic;
//		}).error(function(){
//		});
//	};
//		
//	$scope.saveNewForumTopic = function(id,newForumTopic){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+id+'/savenewforumtopic.json',newForumTopic)
//		.success(function(idForum) {
//			$scope.loadListForumTopic(idForum);
//		}).error(function(){
//		});
//	};
//	
//	$scope.getTopicMessages=function(id,idForumTopic){
//		$state.go('forumtopicmessages', {idUser: id, idForumTopic:idForumTopic})
//	};
//	
//	$scope.loadListTopicMessages = function(idForumTopic){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+idForumTopic+'/listForumMessages.json')
//		.success(function(listTopicMessages) {
//			$scope.listTopicMessages=listTopicMessages;
//		}).error(function(){
//		});
//	};
//	
//	$scope.saveNewForumMessages=function(newForumMessage){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/forum/saveForumMessages.json',newForumMessage)
//		.success(function(idForumTopic) {
//			$scope.loadListTopicMessages(idForumTopic);
//		}).error(function(){
//		});
//	};
//	
//	$scope.deleteForumMessages=function(idForumTopic,idForumMessage){
//		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+idForumTopic+'/'+idForumMessage+'/deleteForumMessages.json')
//		.success(function(idForumTopic) {
//			$scope.loadListTopicMessages(idForumTopic);
//		}).error(function(){
//		});
//	};
//												  //account group
//	$scope.createAccountGroup = function(id){	
//		$state.go('addaccountgroup', {idUser: id});
//	};
//	
//	$scope.saveNewAccountGroup=function(id,accountGroup){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+id+'/saveAccountGroup.json',accountGroup)
//		.success(function(id) {
//			$state.go('userparlor', {idUser: id});
//		}).error(function(){
//		});
//	};
//	
//	$scope.getAccountGroup = function(id,idAccountGroup){	
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+id+'/'+idAccountGroup+'/accountGroupMember.json')
//		.success(function(idAccountGroupMember){
//			$state.go('viewaccountgroup', {idUser: id, idAccountGroupMember:idAccountGroupMember,idAccountGroup:idAccountGroup});
//		}).error(function(){
//		});
//	};
//	
//	$scope.loadListAccountGroupMessages = function(idAccountGroup){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/listAccountGroupMessages.json')
//		.success(function(listAccountGroupMessages) {
//			$scope.listAccountGroupMessages=listAccountGroupMessages;
//		}).error(function(){
//		});
//	};
//	
//	$scope.saveNewAccountGroupMessage=function(newAccountGroupMessage){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/group/saveAccountGroupMessage.json',newAccountGroupMessage)
//		.success(function(idAccountGroup) {
//			$scope.loadListAccountGroupMessages(idAccountGroup);
//		}).error(function(){
//		});
//	};
//	
//	$scope.deleteAccountGroupMessage=function(idAccountGroup,idGroupMessage){
//		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/'+idGroupMessage+'/deleteAccountGroupMessage.json')
//		.success(function(idAccountGroup) {
//			$scope.loadListAccountGroupMessages(idAccountGroup);
//		}).error(function(){
//		});
//	};
//	
//	$scope.loadListEventPattern=function(){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/listEventPattern.json')
//		.success(function(listEventPattern) {
//			$scope.listEventPattern=listEventPattern;
//		}).error(function(){
//		});
//	};
//	
//	$scope.editAccountGroupMember=function(id,idAccountGroupMember,idAccountGroup){
//		$state.go('editaccountgroupmember', {
//			idUser: id,
//			idAccountGroupMember:idAccountGroupMember,
//			idAccountGroup:idAccountGroup
//		});
//	};
//	
//	$scope.loadListAccountGroupMember=function(idAccountGroup){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/listAccountGroupMembers.json')
//		.success(function(listAccountGroupMember) {
//			$scope.listAccountGroupMember=listAccountGroupMember;
//		}).error(function(){
//		});
//	};
//	
//	$scope.deleteMemberFromAccountGroup=function(idAccountGroupMember,idAccountGroup,idDeleteGroupMember){
//		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroupMember+'/'+idDeleteGroupMember+'/deleteAccountGroupMember.json')
//		.success(function(idAccountGroupMember) {
//			$scope.loadListAccountGroupMember(idAccountGroup);
//		}).error(function(){
//		});	
//	};
//	
//	$scope.searchAccountForAccountGroup=function(idAccountGroup,searchPattern){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/listaccount.json',searchPattern)
//		.success(function(listAccount) {
//			$scope.friendStatus=false;
//			$scope.listAccount=listAccount;	
//		}).error(function(){
//		});	
//	};
//	
//	$scope.addToAccountGroup=function(idAccountGroup,idAccountNewMember,friendStatus){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/group/'+idAccountGroup+'/'+idAccountNewMember+'/newmember.json',friendStatus)
//		.success(function(idAccountGroup) {
//			$scope.loadListAccountGroupMember(idAccountGroup);
//		}).error(function(){
//		});	
//	};
//													//search account
//	$scope.getPageSearchAccount=function(id){
//		$state.go('searchaccount', {idUser: id});
//	};
//	
//	$scope.getListAccountGroupForAccount=function(id){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/account/listaccountgroup.json')
//		.success(function(listAccountGroup) {
//			$scope.friendStatus=false;
//			$scope.listAccountGroup=listAccountGroup;
//		}).error(function(){
//		});	
//	};
//	
//	$scope.searchAccountByAccountName=function(id, searchPattern){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/account/searchaccount.json',searchPattern)
//		.success(function(listAccount) {
//			$scope.listAccount=listAccount;
//		}).error(function(){
//		});	
//	};
//	
//	$scope.addToAccountGroupAfterSearch=function(idAccountGroupSelected,idAccount,friendStatus){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/account/'+idAccountGroupSelected
//				+'/'+idAccount+'/newaccountgroupmember.json',friendStatus).success(function() {
//		}).error(function(){
//		});
//	};
//	
//	$scope.getAccountInfo=function(id,searchIdAccount){
//		$state.go('accountinfo', {idUser: id,searchIdAccount:searchIdAccount});
//	};
//	
//	$scope.loadAccountInfo=function(searchIdAccount){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/account/'+searchIdAccount+'/accountinfo.json')
//		.success(function(accountDataSearchResult) {
//			$scope.accountDataSearchResult=accountDataSearchResult;
//		}).error(function() {
//		});
//	};
//													//single messege
//	
//	$scope.getAccountSingleDialog=function(id,searchIdAccount){
//		$state.go('accountsinglemessage', {idUser: id,searchIdAccount:searchIdAccount});
//	};
//	
//	$scope.loadListAccountSingleMessages=function(id,searchIdAccount){
//		$http.get('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/account/'+searchIdAccount+'/listAccountSingleMessage.json')
//		.success(function(listAccountSingleMessage) {
//			$scope.listAccountSingleMessage=listAccountSingleMessage;
//		}).error(function() {
//		});
//	};
//	
//	$scope.saveNewAccountSingleMessage=function(id,searchIdAccount,newAccountSingleMessage){
//		$http.post('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/account/saveAccountSingleMessage.json',newAccountSingleMessage)
//		.success(function(id) {
//			$scope.loadListAccountSingleMessages(id,searchIdAccount);
//		}).error(function(){
//		});
//	};
//	
//	$scope.deleteAccountSingleMessage=function(id,searchIdAccount,idAccountSingleMessage){
//		$http.delete('http://localhost:8080/socialcommunity-web/views/profile/user/'+id+'/account/'
//				+idAccountSingleMessage+'/deleteAccountSingleMessage.json').success(function(id) {
//			$scope.loadListAccountSingleMessages(id,searchIdAccount);
//		}).error(function(){
//		});
//	};
//	
//	
//	
//	
//	$scope.today = function() {
//	    $scope.birth = new Date();
//	};
//	$scope.today();
//
//    $scope.open1 = function() {
//	    $scope.popup1.opened = true;
//	};
//
//	$scope.setDate = function(year, month, day) {
//	    $scope.birth = new Date(year, month, day);
//	};
//
//	$scope.dateOptions = {
//	    formatYear: 'yy',
//	    startingDay: 1
//	};
//
//	$scope.popup1 = {
//	   opened: false
//	};
//});