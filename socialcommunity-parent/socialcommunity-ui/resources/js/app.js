/**
 * 
 */
'use strict';

var socialcommunity = {};
var App = angular.module('socialcommunity',['ngRoute']);

App.config(function($routeProvider) {//'$routeProvider',
	
	 $routeProvider.when('/', {
		 templateUrl: '/socialcommunity/index.html',
		 controller: IndexController
	 });
	 
	 $routeProvider.when('/signin', {
			templateUrl: '/socialcommunity/views/profile/signin.html',
			controller: IndexController
	 });
	 
	 $routeProvider.when('/signup', {
			templateUrl: '/socialcommunity/views/profile/signup/commonprofile.html',
			controller: IndexController
	});

	 
	 $routeProvider.otherwise({redirectTo: '/'});
});
