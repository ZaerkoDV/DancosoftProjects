/**
 * 
 */
'use strict';

var socialcommunity = {};
var App = angular.module('socialcommunity',['ngRoute']);

App.config(function($routeProvider) {//'$routeProvider',
	
	 $routeProvider.when('/', {
		 templateUrl: '/index',
		 controller: IndexController
	 });
	 
	 $routeProvider.otherwise({redirectTo: '/'});
});
