'use strict';

var socialcommunity = {};
var App = angular.module('socialcommunity',['ui.router']);

App.config(function($stateProvider) {
		 
	$stateProvider.state('index', {
        url: 'index',
        views: {'': {
              templateUrl: '/socialcommunity/index.html',
              controller: 'IndexController'
            },
          }
    });
	
	$stateProvider.state('signupcommon', {
        url: '/signup',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/signup/commonprofile.html',
              controller: 'IndexController'
            },
          }
    });
	
	$stateProvider.state('signin', {
	  url: '/signin',
	  views: {'': {
	        templateUrl: '/socialcommunity/views/profile/signin.html',
	        controller: 'IndexController'
	      },
	    }
	});
	
	$stateProvider.state('signupextended', {
        url: '/signup/extended/:idUser',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/signup/extendedprofile.html',
              controller: 'IndexController'
            },
          },
        params: {idUser: null}
    });
	
	$stateProvider.state('signuplogin', {
        url: '/signup/login/:idUser',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/signup/loginprofile.html',
              controller: 'IndexController'
            },
          },
        params: {idUser: null}
    });
	
	$stateProvider.state('userparlor', {
        url: '/user/parlor/:idUser',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/user/parlor/userparlor.html',
              controller: 'UserController'
            },
          },
          params: {idUser: null}
    });
	
	$stateProvider.state('editcommonprofile', {
        url: '/user/parlor/editcommonprofile/:idUser',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/user/parlor/editcommonprofile.html',
              controller: 'UserController'
            },
          },
          params: {idUser: null}
    });
	
	$stateProvider.state('editextendedprofile', {
        url: '/user/parlor/editextendedprofile/:idUser',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/user/parlor/editextendedprofile.html',
              controller: 'UserController'
            },
          },
          params: {idUser: null}
    });
	
	$stateProvider.state('editautobiography', {
		  url: '/user/parlor/editautobiography/:idUser',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/parlor/editautobiography.html',
		        controller: 'UserController'
		      },
		    },
		   params: {idUser: null}
	});
	
	$stateProvider.state('editlistforumtopic', {
		  url: '/user/forum/listtopic/:idUser/:idForum',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/forum/listtopic.html',
		        controller: 'UserController'
		      },
		    },
		  params: {idUser: null, idForum:null}
	});
	
	$stateProvider.state('forumtopicmessages', {
		  url: '/user/forum/forummessages/:idUser/:idForumTopic',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/forum/forumtopicmessage.html',
		        controller: 'UserController'
		      },
		    },
		  params: {idUser: null, idForumTopic:null}
	});
	
	$stateProvider.state('addaccountgroup', {
		  url: '/user/group/addaccountgroup/:idUser',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/group/addaccountgroup.html',
		        controller: 'UserController'
		      },
		    },
		  params: {idUser: null}
	});
	
	$stateProvider.state('viewaccountgroup', {
		  url: '/user/group/viewaccountgroup/:idUser:/idAccountGroupMember/:idAccountGroup',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/group/viewaccountgroup.html',
		        controller: 'UserController'
		      },
		    },
		   params: {idUser: null,idAccountGroupMember:null,idAccountGroup:null}
	});
	
	$stateProvider.state('editaccountgroupmember', {
		  url: '/user/group/editaccountgroupmember/:idUser:/idAccountGroupMember/:idAccountGroup',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/group/editaccountgroup.html',
		        controller: 'UserController'
		      },
		    },
		   params: {idUser: null,idAccountGroupMember:null,idAccountGroup:null}
	});
	
	$stateProvider.state('searchaccount', {
		  url: '/user/account/search/listaccounts/:idUser',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/account/listaccounts.html',
		        controller: 'UserController'
		      },
		    },
		   params: {idUser: null}
	});
	
	$stateProvider.state('accountinfo', {
		  url: '/user/account/search/accountinfo/:idUser/:searchIdAccount',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/account/useraccountinfo.html',
		        controller: 'UserController'
		      },
		    },
		  params: {idUser: null,searchIdAccount:null}
	});
	
	$stateProvider.state('accountsinglemessage', {
		  url: '/user/account/search/accountsinglemessage/:idUser/:searchIdAccount',
		  views: {'': {
		        templateUrl: '/socialcommunity/views/profile/user/account/accountsinglemessage.html',
		        controller: 'UserController'
		      },
		    },
		  params: {idUser: null,searchIdAccount:null}
	});
	
												//admin states
	
	$stateProvider.state('adminparlor', {
        url: '/admin/parlor/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/parlor/adminparlor.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
    });
	
	$stateProvider.state('editadmincommonprofile', {
        url: '/admin/parlor/editadmincommonpofile/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/parlor/editcommonprofile.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
    });

	$stateProvider.state('editextendedadminprofile', {
        url: '/admin/parlor/editextendedadminprofile/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/parlor/editextendedprofile.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
    });
	
	$stateProvider.state('editeventpattern', {
        url: '/admin/event/editeventpattern/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/event/editeventpattern.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
    });
	
	$stateProvider.state('newforum', {
        url: '/admin/forum/addforum/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/forum/addforum.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
    });
	
	$stateProvider.state('editlistforum', {
        url: '/admin/forum/search/editlistforum/:idAdmin',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/forum/editlistforum.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null}
    });
	
	$stateProvider.state('editforumtopic', {
        url: '/admin/forum/search/editlisttopic/:idAdmin/:idForum',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/admin/forum/editlistforumtopic.html',
              controller: 'AdministratorController'
            },
          },
        params: {idAdmin: null, idForum:null}
    });
	
	
	
	
	
	
	
	
});


