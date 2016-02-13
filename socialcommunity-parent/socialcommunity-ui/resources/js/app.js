'use strict';

var socialcommunity = {};
var App = angular.module('socialcommunity',['ui.router','ui.bootstrap','ui.bootstrap.tpls']);
		  
App.value('hostName', 'http://localhost:8080/socialcommunity-web');

//App.factory('middleware', function() {
//		return {
//		  request: function(config) {
//		      config.url = "http://localhost:8080/socialcommunity-web" + config.url
//		      return config;
//		  }
//		};
//});

App.config(function($stateProvider) {//$httpProvider
	//$httpProvider.interceptors.push('middleware');
	
	$stateProvider.state('index', {
        url: 'index',
        views: {'': {
              templateUrl: '/socialcommunity/index.html',
              controller: 'IndexController'
            },
          }
	
    }).state('signupcommon', {
        url: '/signup',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/signup/commonprofile.html',
              controller: 'IndexController'
            },
          }
    
    }).state('signin', {
	  url: '/signin',
	  views: {'': {
	        templateUrl: '/socialcommunity/views/profile/signin.html',
	        controller: 'IndexController'
	      },
	    }
    
	}).state('signupextended', {
        url: '/signup/extended/:idUser',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/signup/extendedprofile.html',
              controller: 'IndexController'
            },
          },
        params: {idUser: null}
          
    }).state('signuplogin', {
        url: '/signup/login/:idUser',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/signup/loginprofile.html',
              controller: 'IndexController'
            },
          },
        params: {idUser: null}
    });
    
												//user state for chaild controller
	
	$stateProvider.state('editcommonprofile', {
        url: '/user/parlor/editcommonprofile/:idUser',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/user/parlor/editcommonprofile.html',
              controller: 'UserCommonProfileController'
            },
          },
          params: {idUser: null} 
    });
	
	$stateProvider.state('editextendedprofile', {
        url: '/user/parlor/editextendedprofile/:idUser',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/user/parlor/editextendedprofile.html',
              controller: 'UserExtendedProfileController'
            },
          },
          params: {idUser: null}
    });
	
	$stateProvider.state('editautobiography', {
		  url: '/user/parlor/editautobiography/:idUser',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/parlor/editautobiography.html',
		        controller: 'UserAutobiographyProfileController'
		      },
		    },
		   params: {idUser: null}
		    
	});
										//user state for parent controller
	
	$stateProvider.state('userparlor', {
        url: '/user/parlor/:idUser',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/user/parlor/userparlor.html',
              controller: 'UserController'
            },
          },
          params: {idUser: null}
          
    }).state('editlistforumtopic', {
		  url: '/user/forum/listtopic/:idUser/:idForum',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/forum/listtopic.html',
		        controller: 'UserController'
		      },
		    },
		  params: {idUser: null, idForum:null}
		    
	}).state('forumtopicmessages', {
		  url: '/user/forum/forummessages/:idUser/:idForumTopic',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/forum/forumtopicmessage.html',
		        controller: 'UserController'
		      },
		    },
		  params: {idUser: null, idForumTopic:null}
		    
	}).state('addaccountgroup', {
		  url: '/user/group/addaccountgroup/:idUser',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/group/addaccountgroup.html',
		        controller: 'UserController'
		      },
		    },
		  params: {idUser: null}
		    
	}).state('viewaccountgroup', {
		  url: '/user/group/viewaccountgroup/:idUser/:idAccountGroupMember/:idAccountGroup',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/group/viewaccountgroup.html',
		        controller: 'UserController'
		      },
		    },
		   params: {idUser: null,idAccountGroupMember:null,idAccountGroup:null}
		    
	}).state('editaccountgroupmember', {
		  url: '/user/group/editaccountgroupmember/:idUser/:idAccountGroupMember/:idAccountGroup',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/group/editaccountgroup.html',
		        controller: 'UserController'
		      },
		    },
		   params: {idUser: null,idAccountGroupMember:null,idAccountGroup:null}
		    
	}).state('searchaccount', {
		  url: '/user/account/search/listaccounts/:idUser',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/account/listaccounts.html',
		        controller: 'UserController'
		      },
		    },
		   params: {idUser: null}
		    
	}).state('accountinfo', {
		  url: '/user/account/search/accountinfo/:idUser/:searchIdAccount',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/account/useraccountinfo.html',
		        controller: 'UserController'
		      },
		    },
		  params: {idUser: null,searchIdAccount:null}
		    
	}).state('accountsinglemessage', {
		  url: '/user/account/search/accountsinglemessage/:idUser/:searchIdAccount',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/account/accountsinglemessage.html',
		        controller: 'UserController'
		      },
		    },
		  params: {idUser: null,searchIdAccount:null}
	});

	
												//admin state for chaild controller

    $stateProvider.state('editadmincommonprofile', {
        url: '/admin/parlor/editadmincommonpofile/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/parlor/editcommonprofile.html',
              controller: 'AdministratorCommonProfileController'
            },
          },
        params: {idAdmin: null}      
    });
    
    $stateProvider.state('editextendedadminprofile', {
        url: '/admin/parlor/editextendedadminprofile/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/parlor/editextendedprofile.html',
              controller: 'AdministratorExtendedProfileController'
            },
          },
        params: {idAdmin: null}
    });
    										//admin state for parent controller
    
    $stateProvider.state('adminparlor', {
        url: '/admin/parlor/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/parlor/adminparlor.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
          
    }).state('editeventpattern', {
        url: '/admin/event/editeventpattern/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/event/editeventpattern.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
          
    }).state('newforum', {
        url: '/admin/forum/addforum/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/forum/addforum.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
          
    }).state('editlistforum', {
        url: '/admin/forum/search/editlistforum/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/forum/editlistforum.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
          
    }).state('editforumtopic', {
        url: '/admin/forum/search/editlisttopic/:idAdmin/:idForum',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/forum/editlistforumtopic.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null, idForum:null}
          
    }).state('forummessage', {
        url: '/admin/forum/search/editlistmessage/:idAdmin/:idForum/:idForumTopic',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/forum/editlistforummessage.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null, idForum:null, idForumTopic:null}
          
    }).state('editlistaccount', {
        url: '/admin/account/search/editlistaccount/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/account/editlistaccount.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
          
    }).state('useraccountinfo', {
		  url: '/admin/account/search/accountinfo/:idAdmin/:searchIdAccount',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/admin/account/useraccountinfo.html',
		        controller: 'AdministratorController'
		      },
		    },
		  params: {idAdmin: null,searchIdAccount:null}
		    
	}).state('useraccountsinglemessage', {
		  url: '/admin/account/search/showsinglemessage/:idAdmin/:searchIdAccount',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/admin/account/showsinglemessage.html',
		        controller: 'AdministratorController'
		      },
		    },
		  params: {idAdmin: null,searchIdAccount:null}
		    
	}).state('searchaccountgrouppage', {
		  url: '/admin/group/search/editlistgroup/:idAdmin',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/admin/group/editlistgroup.html',
		        controller: 'AdministratorController'
		      },
		    },
		  params: {idAdmin: null}
		    
	}).state('listusergroupmessages', {
		  url: '/admin/group/search/listgroupmessages/:idAdmin/:idAccountGroup',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/admin/group/editlistgroupmessages.html',
		        controller: 'AdministratorController'
		      },
		    },
		  params: {idAdmin: null, idAccountGroup:null}
		    
	}).state('editlistgroupmembers', {
		  url: '/admin/group/search/editlistgroupmembers/:idAdmin/:idAccountGroup',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/admin/group/editlistgroupmembers.html',
		        controller: 'AdministratorController'
		      },
		    },
		  params: {idAdmin: null, idAccountGroup:null}
	});
	
});

