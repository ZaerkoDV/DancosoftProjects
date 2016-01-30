'use strict';

var socialcommunity = {};
var App = angular.module('socialcommunity',['ui.router','ngRoute']);

App.config(function($stateProvider,$routeProvider) {
		 
	$routeProvider.when('/signin', {
		templateUrl: '/socialcommunity/views/profile/signin.html',
		controller: 'IndexController'
	});
	
	$routeProvider.when('/signup', {
		templateUrl:'/socialcommunity/views/profile/signup/commonprofile.html',
		controller: 'IndexController'
	});
	
	$routeProvider.otherwise({
		 redirectTo: '/'
	});
	
	
														//state
	
//	$stateProvider.state('signupcommon', {
//        url: '/signup',
//        views: {'': {
//              templateUrl: '/socialcommunity/views/profile/signup/commonprofile.html',
//              controller: 'IndexController'
//            },
//          }
//    });
	
//	$stateProvider.state('signin', {
//  url: '/signin',
//  views: {'': {
//        templateUrl: '/socialcommunity/views/profile/signin.html',
//        controller: 'IndexController'
//      },
//    }
//});
	
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
	
	
	
	
});


