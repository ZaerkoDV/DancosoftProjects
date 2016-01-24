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
	
	$routeProvider.when('/signup/extended', {
		templateUrl:'/socialcommunity/views/profile/signup/extendedprofile.html',
		controller: 'IndexController'
	});
	
	$routeProvider.when('/signup/login', {
		templateUrl:'/socialcommunity/views/profile/signup/loginprofile.html',
		controller: 'IndexController'
	});
	
//	$routeProvider.when('/user/parlor', {
//		templateUrl: '/socialcommunity/views/profile/user/parlor/userparlor.html',
//		controller: 'UserController'
//	});
//	
//	$routeProvider.when('/user/parlor/editcommonprofile', {
//		templateUrl: '/socialcommunity/views/profile/user/parlor/editcommonprofile.html',
//		controller: 'UserController'
//	});
//	
//	$routeProvider.when('/user/parlor/editextendedprofile', {
//		templateUrl: '/socialcommunity/views/profile/user/parlor/editextendedprofile.html',
//		controller: 'UserController'
//	});
//	
//	$routeProvider.when('/user/parlor/editautobiography', {
//		templateUrl: '/socialcommunity/views/profile/user/parlor/editautobiography.html',
//		controller: 'UserController'
//	});

//	$routeProvider.when('/admin/parlor', {
//		templateUrl: '/socialcommunity/views/profile/admin/parlor/adminparlor.html',
//		controller: 'AdminController'
//	});
	
	$routeProvider.otherwise({
		 redirectTo: '/'
	});
	
	
														//state
	
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
	
	
	
	
});


