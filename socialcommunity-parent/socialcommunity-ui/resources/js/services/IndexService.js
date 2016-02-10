/**
 * 
 */
'use strict';

angular.module('socialcommunity').service('IndexService', function($http, $q){   
    
	 this.saveCommonUser= function(user){
          return $http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/savecommon/user.json',user).then(
              function(response){
                   return response.data;
              }
          );
      }
   
	 this.saveExtendedUser=function(id,userExtended,birth){
		 return $http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/saveextended/'+id+'/'+birth+'/userextended.json',userExtended).then(
	          function(response){
	                return response.data;
	          }
	     );
	 }
	 
	 this.saveLoginUser=function(id,securityPrompt){
		 return $http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/savelogin/'+id+'/userlogin.json',securityPrompt).then(
	          function(response){
	                return response.data;
	          }
	     );
	 }
	 
	 this.createUserAccount = function(id){
		 return $http.post('http://localhost:8080/socialcommunity-web/views/profile/signup/createaccount/useraccount.json',id).then(
	          function(response){
	                return response.data;
	          }
	     );
	 }
   
	 this.userSignIn = function(login,password,answer){
		 return $http.get('http://localhost:8080/socialcommunity-web/views/profile/signin/'+login+'/'+password+'/'+answer+'/userdata.json').then(
	          function(response){
	                return response.data;
	          }
	     );
	 }
	 
	 this.getSecurityQuestion= function(loginOrEmail){
		 return $http.get('http://localhost:8080/socialcommunity-web/views/profile/signin/'+loginOrEmail+'/securityquestion.json').then(
	          function(response){
	                return response.data;
	          }
	     );
	 }
	 
	 this.redirectToUserPage= function(id){
		 return $http.get('http://localhost:8080/socialcommunity-web/views/profile/signin/'+id+'/userrole.json').then(
	          function(response){
	                return response.data;
	          }
	     );
	 }

});