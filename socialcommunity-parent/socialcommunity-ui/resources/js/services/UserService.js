/**
 * 
 */
'use strict';

angular.module('socialcommunity').service('UserService', function($http, $q,hostName){   
	
	this.hostName=hostName;
	
	this.loadUserData= function(id){
        return $http.get(hostName+'/views/profile/user/'+id+'/parlor/accountdata.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListAccountGroup = function(id){
        return $http.get(hostName+'/views/profile/user/'+id+'/parlor/listaccountgroup.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListForum = function(id){
        return $http.get(hostName+'/views/profile/user/'+id+'/parlor/listforum.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadCommonUserProfileData = function(id){
        return $http.get(hostName+'/views/profile/user/'+id+'/parlor/commonuserprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.editCommonUserProfile = function(id,user){
        return $http.put(hostName+'/views/profile/user/parlor/'+id+'/editcommonprofile.json',user).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadExtendedUserProfileData = function(id){
        return $http.get(hostName+'/views/profile/user/'+id+'/parlor/extendeduserprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.editExtendedUserProfile = function(id,userExtendedData){
        return $http.put(hostName+'/views/profile/user/'+id+'/parlor/editextendedprofile.json',userExtendedData).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadUserAutobiographyData = function(id){
        return $http.get(hostName+'/views/profile/user/'+id+'/parlor/userautobiographyprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.editUserAutobiography = function(id,userAutobiography){
        return $http.put(hostName+'/views/profile/user/'+id+'/parlor/editautobiographyprofile.json',userAutobiography).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListLanguage = function(){
        return $http.get(hostName+'/views/listlanguage.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListCountry = function(){
        return $http.get(hostName+'/views/listcountry.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListCityByIdCountry = function(idCountry){
        return $http.get(hostName+'/views/'+idCountry+'/listcity.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadListForumTopic = function(idForum){
        return $http.get(hostName+'/views/profile/user/forum/'+idForum+'/listforumtopic.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveNewForumTopic = function(id,newForumTopic){
        return $http.post(hostName+'/views/profile/user/forum/'+id+'/savenewforumtopic.json',newForumTopic).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadListTopicMessages = function(idForumTopic){
        return $http.get(hostName+'/views/profile/user/forum/'+idForumTopic+'/listForumMessages.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveNewForumMessages=function(newForumMessage){
        return $http.post(hostName+'/views/profile/user/forum/saveForumMessages.json',newForumMessage).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.deleteForumMessages=function(idForumTopic,idForumMessage){
        return $http.delete(hostName+'/views/profile/user/forum/'+idForumTopic+'/'+idForumMessage+'/deleteForumMessages.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveNewAccountGroup=function(id,accountGroup){
        return $http.post(hostName+'/views/profile/user/group/'+id+'/saveAccountGroup.json',accountGroup).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getAccountGroup = function(id,idAccountGroup){
        return $http.get(hostName+'/views/profile/user/group/'+id+'/'+idAccountGroup+'/accountGroupMember.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadListAccountGroupMessages = function(idAccountGroup){
        return $http.get(hostName+'/views/profile/user/group/'+idAccountGroup+'/listAccountGroupMessages.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveNewAccountGroupMessage=function(newAccountGroupMessage){
        return $http.post(hostName+'/views/profile/user/group/saveAccountGroupMessage.json',newAccountGroupMessage).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.deleteAccountGroupMessage=function(idAccountGroup,idGroupMessage){
        return $http.delete(hostName+'/views/profile/user/group/'+idAccountGroup+'/'+idGroupMessage+'/deleteAccountGroupMessage.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadListEventPattern=function(){
        return $http.get(hostName+'/views/profile/user/group/listEventPattern.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadListAccountGroupMember=function(idAccountGroup){
        return $http.get(hostName+'/views/profile/user/group/'+idAccountGroup+'/listAccountGroupMembers.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.deleteMemberFromAccountGroup=function(idAccountGroupMember,idAccountGroup,idDeleteGroupMember){
        return $http.delete(hostName+'/views/profile/user/group/'+idAccountGroupMember+'/'+idDeleteGroupMember+'/deleteAccountGroupMember.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.searchAccountForAccountGroup=function(idAccountGroup,searchPattern){
        return $http.post(hostName+'/views/profile/user/group/'+idAccountGroup+'/listaccount.json',searchPattern).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.addToAccountGroup=function(idAccountGroup,idAccountNewMember,friendStatus){
        return $http.post(hostName+'/views/profile/user/group/'+idAccountGroup+'/'+idAccountNewMember+'/newmember.json',friendStatus).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListAccountGroupForAccount=function(id){
        return $http.get(hostName+'/views/profile/user/'+id+'/account/listaccountgroup.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.searchAccountByAccountName=function(id, searchPattern){
        return $http.post(hostName+'/views/profile/user/'+id+'/account/searchaccount.json',searchPattern).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.addToAccountGroupAfterSearch=function(idAccountGroupSelected,idAccount,friendStatus){
        return $http.post(hostName+'/views/profile/user/account/'+idAccountGroupSelected+'/'+idAccount+'/newaccountgroupmember.json',friendStatus).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadAccountInfo=function(searchIdAccount){
        return $http.get(hostName+'/views/profile/user/account/'+searchIdAccount+'/accountinfo.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadListAccountSingleMessages=function(id,searchIdAccount){
        return $http.get(hostName+'/views/profile/user/'+id+'/account/'+searchIdAccount+'/listAccountSingleMessage.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveNewAccountSingleMessage=function(id,searchIdAccount,newAccountSingleMessage){
        return $http.post(hostName+'/views/profile/user/'+id+'/account/saveAccountSingleMessage.json',newAccountSingleMessage).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.deleteAccountSingleMessage=function(id,searchIdAccount,idAccountSingleMessage){
        return $http.delete(hostName+'/views/profile/user/'+id+'/account/'+idAccountSingleMessage+'/deleteAccountSingleMessage.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
});