/**
 * 
 */
'use strict';

angular.module('socialcommunity').service('AdministratorService', function($http, $q){   
	
	this.loadAdminData = function(idAdmin){
        return $http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/'+idAdmin+'/parlor/accountdata.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadCommonAdminProfileData = function(idAdmin){
        return $http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/'+idAdmin+'/parlor/commonadminprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.editCommonAdminProfile = function(idAdmin,admin){
        return $http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/editcommonadminprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.editCommonAdminProfile = function(idAdmin,admin){
        return $http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/editcommonadminprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadExtendedAdminProfileData = function(idAdmin){
        return $http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/'+idAdmin+'/parlor/extendedadminprofile.json').then(
            function(response){
                 return response.data;
            }
        );
    }
//	
	this.editExtendedAdminProfile = function(idAdmin,adminExtendedData,birth){
        return $http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/'+idAdmin+'/'+birth+'/editextendedadminprofile.json',adminExtendedData).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListLanguage = function(){
        return $http.get('http://localhost:8080/socialcommunity-web/views/listlanguage.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListCountry=function(){
        return $http.get('http://localhost:8080/socialcommunity-web/views/listcountry.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListCityByIdCountry = function(idCountry){
        return $http.get('http://localhost:8080/socialcommunity-web/views/'+idCountry+'/listcity.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadListEventPattern=function(){
        return $http.get('http://localhost:8080/socialcommunity-web/views/profile/user/group/listEventPattern.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveEventPattern=function(eventPattern){
        return $http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/event/neweventpattern.json',eventPattern).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.deleteEventPattern=function(idEventPattern){
        return $http.delete('http://localhost:8080/socialcommunity-web/views/profile/admin/event/'+idEventPattern+'/deletedeventpattern.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.updateEventPattern=function(eventPattern){
        return $http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/event/updatedeventpattern.json',eventPattern).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.getListForum = function(){
        return $http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/parlor/listforum.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveNewForum=function(idAdmin,forum){
        return $http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/newforum.json',forum).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.deleteForum=function(idForum){
        return $http.delete('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/'+idForum+'/deletedforum.json').then(
            function(response){
                 return response.data;
            }
        );
    }
//not convert 	
	this.editForum=function(idAdmin,forum){
        return $http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/editforum.json',forum).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.loadListForumTopic = function(idForum){
        return $http.get('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+idForum+'/listforumtopic.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveNewForumTopic=function(idForum,forumTopic){
        return $http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/newtopic.json',forumTopic).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.deleteForumTopic=function(idForumTopic){
        return $http.delete('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/deleteforumtopic/'+idForumTopic+'/forumtopic.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.updateForumTopic=function(forumTopic){
        return $http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/updateforumtopic.json',forumTopic).then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.searchForumMessagesBetweenDate=function(idForumTopic,from,to){
        return $http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/forum/'+idForumTopic+'/'+from+'/'+to+'/topicmessages.json').then(
            function(response){
                 return response.data;
            }
        );
    }
	
	this.saveNewForumMessages=function(newForumMessage){
	    return $http.post('http://localhost:8080/socialcommunity-web/views/profile/user/forum/saveForumMessages.json',newForumMessage).then(
	        function(response){
	             return response.data;
	        }
	    );
	}

	this.deleteForumMessages=function(idForumTopic,idForumMessage){
	    return $http.delete('http://localhost:8080/socialcommunity-web/views/profile/user/forum/'+idForumTopic+'/'+idForumMessage+'/deleteForumMessages.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}

	this.searchAccount=function(account){
	    return $http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/account/searchaccount.json',account).then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.changeAccountBlockStatus=function(account,blockStatus){
	    return $http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/account/'+blockStatus+'/newblockstatus.json',account).then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.deleteAccount=function(idAccount){
	    return $http.delete('http://localhost:8080/socialcommunity-web/views/profile/admin/account/'+idAccount+'/deleteaccount.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.loadAccountInfo=function(searchIdAccount){
	    return $http.get('http://localhost:8080/socialcommunity-web/views/profile/user/account/'+searchIdAccount+'/accountinfo.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.searchSingleMessagesBetweenDate=function(searchIdAccount,fromDate,toDate){
	    return $http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/account/'+searchIdAccount+'/'+fromDate+'/'+toDate+'/singlemessages.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.saveNewAccountSingleMessage=function(idAdmin,newAccountSingleMessage){
	    return $http.post('http://localhost:8080/socialcommunity-web/views/profile/user/'+idAdmin+'/account/saveAccountSingleMessage.json',newAccountSingleMessage).then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.deleteAccountSingleMessage=function(idAdmin,idAccountSingleMessage,fromDate,toDate){
	    return $http.delete('http://localhost:8080/socialcommunity-web/views/profile/user/'+idAdmin+'/account/'
				+idAccountSingleMessage+'/deleteAccountSingleMessage.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.searchAccountGroup=function(groupName,accountName){
	    return $http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/group/'+groupName+'/'+accountName+'/searchAccountGroup.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.changeAccountGroupBlockStatus=function(accountGroup,blockStatus){
	    return $http.put('http://localhost:8080/socialcommunity-web/views/profile/admin/group/'+blockStatus+'/newblockstatus.json',accountGroup).then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.deleteAccountGroup=function(idAccountGroup){
	    return $http.delete('http://localhost:8080/socialcommunity-web/views/profile/admin/group/'+idAccountGroup+'/deleteaccountgroup.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.searchGroupMessagesBetweenDate=function(idAccountGroup,fromDate,toDate){
	    return $http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/group/'+idAccountGroup+'/'+fromDate+'/'+toDate+'/groupmessages.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.saveNewAccountGroupMessage=function(idAdmin,idAccountGroup,newAccountGroupMessage){
	    return $http.post('http://localhost:8080/socialcommunity-web/views/profile/admin/'+idAdmin+'/group/'
	    		+idAccountGroup+'/saveAccountGroupMessage.json',newAccountGroupMessage).then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.deleteAccountGroupMessage=function(idAccountGroup,idGroupMessage){
	    return $http.delete('http://localhost:8080/socialcommunity-web/views/profile/user/group/'
	    		+idAccountGroup+'/'+idGroupMessage+'/deleteAccountGroupMessage.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}
	
	this.loadListAccountGroupMembers=function(idAccountGroup){
	    return $http.get('http://localhost:8080/socialcommunity-web/views/profile/admin/group/'
	    		+idAccountGroup+'/listgroupmembers.json').then(
	        function(response){
	             return response.data;
	        }
	    );
	}

	
});