/**
 * 
 */
'use strict';

angular.module('socialcommunity').service('IndexService', function($http, $q,hostName){   
    
	 this.hostName=hostName;
	
	 this.saveCommonUser= function(user){
          return $http.post(hostName+'/views/profile/signup/savecommon/user.json',user).then(
              function(response){
                   return response.data;
              }
          );
      }
   
	 this.saveExtendedUser=function(id,userExtended){
		 return $http.post(hostName+'/views/profile/signup/saveextended/'+id+'/userextended.json',userExtended).then(
	          function(response){
	                return response.data;
	          }
	     );
	 }
	 
	 this.saveLoginUser=function(id,securityPrompt){
		 return $http.post(hostName+'/views/profile/signup/savelogin/'+id+'/userlogin.json',securityPrompt).then(
	          function(response){
	                return response.data;
	          }
	     );
	 }
	 
	 this.createUserAccount = function(id){
		 return $http.post(hostName+'/views/profile/signup/createaccount/useraccount.json',id).then(
	          function(response){
	                return response.data;
	          }
	     );
	 }
   
	 this.userSignIn = function(login,password,answer){
		 return $http.get(hostName+'/views/profile/signin/'+login+'/'+password+'/'+answer+'/userdata.json').then(
	          function(response){
	                return response.data;
	          }
	     );
	 }
	 
	 this.getSecurityQuestion= function(loginOrEmail){
		 return $http.get(hostName+'/views/profile/signin/'+loginOrEmail+'/securityquestion.json').then(
	          function(response){
	                return response.data;
	          }
	     );
	 }
	 
	 this.redirectToUserPage= function(id){
		 return $http.get(hostName+'/views/profile/signin/'+id+'/userrole.json').then(
	          function(response){
	                return response.data;
	          }
	     );
	 }

});