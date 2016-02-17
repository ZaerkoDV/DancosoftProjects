/**
 * 
 */
'use strict';

angular.module('socialcommunity').service('AdministratorService', function($http, $q,hostName){   
	
	this.hostName=hostName;
	
	this.loadAdminData = function(idAdmin){
        return $http.get(hostName+'/views/profile/admin/'+idAdmin+'/parlor/accountdata.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadCommonAdminProfileData = function(idAdmin){
        return $http.get(hostName+'/views/profile/admin/'+idAdmin+'/parlor/commonadminprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.editCommonAdminProfile = function(idAdmin,admin){
        return $http.put(hostName+'/views/profile/admin/parlor/editcommonadminprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.editCommonAdminProfile = function(idAdmin,admin){
        return $http.put(hostName+'/views/profile/admin/parlor/editcommonadminprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadExtendedAdminProfileData = function(idAdmin){
        return $http.get(hostName+'/views/profile/admin/'+idAdmin+'/parlor/extendedadminprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.editExtendedAdminProfile = function(idAdmin,adminExtendedData){
        return $http.put(hostName+'/views/profile/admin/parlor/'+idAdmin+'/editextendedadminprofile.json',adminExtendedData).then(
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
	
	this.getListCountry=function(){
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
	
	this.loadListEventPattern=function(){
        return $http.get(hostName+'/views/profile/user/group/listEventPattern.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveEventPattern=function(eventPattern){
        return $http.post(hostName+'/views/profile/admin/event/neweventpattern.json',eventPattern).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.deleteEventPattern=function(idEventPattern){
        return $http.delete(hostName+'/views/profile/admin/event/'+idEventPattern+'/deletedeventpattern.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.updateEventPattern=function(eventPattern){
        return $http.put(hostName+'/views/profile/admin/event/updatedeventpattern.json',eventPattern).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListForum = function(){
        return $http.get(hostName+'/views/profile/admin/parlor/listforum.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveNewForum=function(idAdmin,forum){
        return $http.post(hostName+'/views/profile/admin/forum/newforum.json',forum).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.deleteForum=function(idForum){
        return $http.delete(hostName+'/views/profile/admin/forum/'+idForum+'/deletedforum.json').then(
            function(response){
                 return response.data;
            }
        );
    }

	this.editForum=function(idAdmin,forum){
        return $http.put(hostName+'/views/profile/admin/forum/editforum.json',forum).then(
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
	
	this.saveNewForumTopic=function(idForum,forumTopic){
        return $http.post(hostName+'/views/profile/admin/forum/newtopic.json',forumTopic).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.deleteForumTopic=function(idForumTopic){
        return $http.delete(hostName+'/views/profile/admin/forum/deleteforumtopic/'+idForumTopic+'/forumtopic.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.updateForumTopic=function(forumTopic){
        return $http.put(hostName+'/views/profile/admin/forum/updateforumtopic.json',forumTopic).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.searchForumMessagesBetweenDate=function(idForumTopic,from,to){
        return $http.get(hostName+'/views/profile/admin/forum/'+idForumTopic+'/'+from+'/'+to+'/topicmessages.json').then(
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

	this.searchAccount=function(account){
	    return $http.post(hostName+'/views/profile/admin/account/searchaccount.json',account).then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.changeAccountBlockStatus=function(account,blockStatus){
	    return $http.put(hostName+'/views/profile/admin/account/'+blockStatus+'/newblockstatus.json',account).then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.deleteAccount=function(idAccount){
	    return $http.delete(hostName+'/views/profile/admin/account/'+idAccount+'/deleteaccount.json').then(
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
	
	this.searchSingleMessagesBetweenDate=function(searchIdAccount,fromDate,toDate){
	    return $http.get(hostName+'/views/profile/admin/account/'+searchIdAccount+'/'+fromDate+'/'+toDate+'/singlemessages.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.saveNewAccountSingleMessage=function(idAdmin,newAccountSingleMessage){
	    return $http.post(hostName+'/views/profile/user/'+idAdmin+'/account/saveAccountSingleMessage.json',newAccountSingleMessage).then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.deleteAccountSingleMessage=function(idAdmin,idAccountSingleMessage,fromDate,toDate){
	    return $http.delete(hostName+'/views/profile/user/'+idAdmin+'/account/'+idAccountSingleMessage+'/deleteAccountSingleMessage.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.searchAccountGroup=function(groupName,accountName){
	    return $http.get(hostName+'/views/profile/admin/group/'+groupName+'/'+accountName+'/searchAccountGroup.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.changeAccountGroupBlockStatus=function(accountGroup,blockStatus){
	    return $http.put(hostName+'/views/profile/admin/group/'+blockStatus+'/newblockstatus.json',accountGroup).then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.deleteAccountGroup=function(idAccountGroup){
	    return $http.delete(hostName+'/views/profile/admin/group/'+idAccountGroup+'/deleteaccountgroup.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.searchGroupMessagesBetweenDate=function(idAccountGroup,fromDate,toDate){
	    return $http.get(hostName+'/views/profile/admin/group/'+idAccountGroup+'/'+fromDate+'/'+toDate+'/groupmessages.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.saveNewAccountGroupMessage=function(idAdmin,idAccountGroup,newAccountGroupMessage){
	    return $http.post(hostName+'/views/profile/admin/'+idAdmin+'/group/'+idAccountGroup+'/saveAccountGroupMessage.json',newAccountGroupMessage).then(
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
	
	this.loadListAccountGroupMembers=function(idAccountGroup){
	    return $http.get(hostName+'/views/profile/admin/group/'+idAccountGroup+'/listgroupmembers.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}

	
});