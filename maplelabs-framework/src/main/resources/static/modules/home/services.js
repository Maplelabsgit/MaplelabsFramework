'use strict';

angular.module('Home')

.factory('HomeService',
    ['$http', '$rootScope',
    function ( $http, $rootScope) {
        var service = {};
       
        
        

        service.getComments = function (callback) {
        	 var userIdUrl="User/"+$rootScope.currentUserID+"/Comment";
	           //var url="User/"+$rootScope.currentUserID+"/Comment";
	        	$http({
	        	    url: userIdUrl, 
	        	    method: "GET",
	        	    params: {token: 'testToken'}
	        	 }).success(function (response) {
	                 callback(response);
	             }).error(function(response){
	            	 callback(response,true);
	             });

           
         };
        
         service.deleteComment=function(commentId,callback){
        	 var url="User/"+$rootScope.currentUserID+"/Comment/"+commentId;
        	 $http({
	        	    url: url, 
	        	    method: "DELETE",
	        	    params: {token: 'testToken'}
	        	 }).success(function (response) {
	                 callback(response);
	             }).error(function(response){
	            	 callback(response,true);
	             });
        	 
         }
         
         service.editComment=function(commentId,callback){
        	 var url="User/"+$rootScope.currentUserID+"/Comment/"+commentId;
        	 $http({
	        	    url: url, 
	        	    method: "POST",
	        	    params: {token: 'testToken'}
	        	 }).success(function (response) {
	                 callback(response);
	             }).error(function(response){
	            	 callback(response,true);
	             });
        	 
         }
         
         service.addComment=function(comment,callback){
        	 var userIdUrl="User/"+$rootScope.currentUserID+"/Comment";
        	 $http({
	        	    url: userIdUrl, 
	        	    method: "POST",
	        	    params: {token: 'testToken',comment:comment}
	        	 }).success(function (response) {
	                 callback(response);
	             }).error(function(response){
	            	 callback(response,true);
	             });
        	 
         }
         
         service.deleteAllComment=function(callback){
        	 var userIdUrl="User/"+$rootScope.currentUserID+"/Comment";
        	 $http({
	        	    url: userIdUrl, 
	        	    method: "DELETE",
	        	    params: {token: 'testToken'}
	        	 }).success(function (response) {
	                 callback(response);
	             }).error(function(response){
	            	 callback(response,true);
	             });
        	 
         }
        	
        	
        
         return service;
     }])


