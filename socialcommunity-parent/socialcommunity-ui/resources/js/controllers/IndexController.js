/**
 * 
 */
'use strict';

var IndexController = function($scope, $http) {
	
	
	
};

//App.factory('IndexController', ['$http', '$q', function($http, $q){
// 
//    return {
//         
//	    	createCommonUser: function(user){
//	            return $http.post('http://localhost:8080/socialcommunity/crateCommonUser/', user)
//	                    .then(
//	                            function(response){
//	                                return response.data;
//	                            }, 
//	                            function(errResponse){
//	                                console.error('Error while creating user');
//	                                return $q.reject(errResponse);
//	                            }
//	                    );
//	    	},
//            
//	    	createUser: function(user){
//                return $http.post('http://localhost:8080/Spring4MVCAngularJSExample/user/', user)
//                        .then(
//                                function(response){
//                                    return response.data;
//                                }, 
//                                function(errResponse){
//                                    console.error('Error while creating user');
//                                    return $q.reject(errResponse);
//                                }
//                        );
//	    	},
//            
//    	
//    	};
//}]);