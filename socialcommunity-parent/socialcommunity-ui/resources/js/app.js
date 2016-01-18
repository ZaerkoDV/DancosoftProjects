'use strict';

var socialcommunity = {};
var App = angular.module('socialcommunity',['ngRoute']);

App.config(function($routeProvider) {
		 
	
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
	
	
//	$routeProvider.when('/user/parlor', {
//		templateUrl: '/socialcommunity/views/profile/user/parlor/userparlor.html',
//		controller: 'UserController'
//	});
//	
//	$routeProvider.when('/admin/parlor', {
//		templateUrl: '/socialcommunity/views/profile/admin/parlor/adminparlor.html',
//		controller: 'UserController'
//	});
	
	
	$routeProvider.otherwise({
		 redirectTo: '/'
	});
});


