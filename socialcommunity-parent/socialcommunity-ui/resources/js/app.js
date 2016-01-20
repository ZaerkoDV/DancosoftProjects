'use strict';

var socialcommunity = {};
var App = angular.module('socialcommunity',['ui.router','ngRoute']);

App.config(function($stateProvider,$routeProvider) {
		 
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
		
	$routeProvider.when('/signin', {
		templateUrl: '/socialcommunity/views/profile/signin.html',
		controller: 'IndexController'
	});
	
	$routeProvider.when('/user/parlor', {
		templateUrl: '/socialcommunity/views/profile/user/parlor/userparlor.html',
		controller: 'UserController'
	});
	
//	$routeProvider.when('/admin/parlor', {
//		templateUrl: '/socialcommunity/views/profile/admin/parlor/adminparlor.html',
//		controller: 'AdminController'
//	});
	
	$routeProvider.otherwise({
		 redirectTo: '/'
	});
	
	
	
	
	
	
	
														//state
	
	$stateProvider.state('signupextended', {
        url: '/signup/extended/{idUser}',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/signup/extendedprofile.html',
              controller: 'IndexController'
            },
          },
        params: {idUser: null}
    });
	
	$stateProvider.state('signuplogin', {
        url: '/signup/login/{idUser}',
        views: {'': {
              templateUrl: '/socialcommunity/views/profile/signup/loginprofile.html',
              controller: 'IndexController'
            },
          },
        params: {idUser: null}
    });
	
	
//	$stateProvider.state('userparlor', {
//        url: '/user/parlor',
//        views: {'': {
//              templateUrl: '/socialcommunity/views/profile/user/parlor/userparlor.html',
//              controller: 'UserController'
//            },
//          },
//          params: {idUser: null}
//    });
	
	
	
	
});


