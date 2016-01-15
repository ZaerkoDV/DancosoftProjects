/**
 * 
 */

App.factory('UserController', ['$http', '$q', function($http, $q){
 
    return {
         
	    	createCommonUser: function(user){
	            return $http.post('http://localhost:8080/socialcommunity/crateCommonUser/', user)
	                    .then(
	                            function(response){
	                                return response.data;
	                            }, 
	                            function(errResponse){
	                                console.error('Error while creating user');
	                                return $q.reject(errResponse);
	                            }
	                    );
	    	},
	    	
	    	
	    	
	    	
	    	
	    	};
}]);