/**
 * 
 */
'use strict';

var socialcommunity = {};
var App = angular.module('socialcommunity',['ngRoute']);
App.config(function($routeProvider) {//'$routeProvider',
	
	 $routeProvider.when('/signin', {
		 templateUrl: 'profile/signin',
		 controller: IndexController
	 });
	 
	 
	 
	 $routeProvider.otherwise({redirectTo: '/'});
});
