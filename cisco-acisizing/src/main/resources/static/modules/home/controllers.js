'use strict';

angular.module('Home')

.controller('HomeController',
    ['$scope','$rootScope', '$location','HomeService',
    function ($scope,$rootScope, $location,HomeService) {
    	
    	
    	$scope.getComments=function(){
    		 $scope.dataLoading = true;
    		 $scope.showAddComment=true;
    		 $scope.showComment="hide Comments";
    		 HomeService.getComments( function (response,iserror) {
                 if (!iserror) {
                     //AuthenticationService.SetCredentials($scope.username, $scope.password,response.token);
                     $scope.messages=response;
                 } else {
                	 $location.path('/login');
                 }
             });
    	}
    	
    	$scope.deleteComment=function(commentId){
    		HomeService.deleteComment($scope.messages[commentId].id,function(response,isError){
    			if(!isError){
    				//alert("message deleted");
    				$scope.getComments();
    			}else{
    				alert("cannot delete");
    			}
    		});
    		
    	}
    	
    	$scope.editComment=function(commentText,commentId){
    		HomeService.editComment($scope.messages[commentId].id,commentText,function(response,isError){
    			if(!isError){
    				alert("message updated");
    				$scope.getComments();
    			}else{
    				alert("cannot update");
    			}
    		});
    		
    	}
    	
    	$scope.addComment=function(){
    		HomeService.addComment($scope.commentText,function(response,isError){
    			if(!isError){
    				alert("message added");
    				$scope.getComments();
    			}else{
    				alert("cannot add message");
    			}
    			
    		})
    	}
    	
    	$scope.deleteAllComment=function(){
    		HomeService.deleteAllComment(function(response,isError){
    			if(!isError){
    				alert("All messages deleted");
    				$scope.getComments();
    			}else{
    				alert("cannot delete messages");
    			}
    			
    		})
    	}

    }]);