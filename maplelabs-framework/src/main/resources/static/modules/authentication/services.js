'use strict';

angular.module('Authentication')

.factory('AuthenticationService',
    ['$http', '$rootScope',
    function ( $http, $rootScope) {
        var service = {};
        
        service.SetCredentials = function (username, password,userId) {
            

            $rootScope.
                currentUserID=userId;
            
        }

        service.Login = function (username, password, callback) {

            /* Dummy authentication for testing, uses $timeout to simulate api call
             ----------------------------------------------*/
           
        	$http({
        	    url: '/login', 
        	    method: "POST",
        	    params: {username: username,password:password}
        	 }).success(function (response) {
                 callback(response,false);
             }).error(function(response){
            	 callback(response,true);
            	 console.log("error true");
             });

            /* Use this for real authentication
             ----------------------------------------------*/
          /*  $http.get('/login?username=mahesh&password=kumar')
                .success(function (response) {
                    callback(response);
                });*/

        	};
        
        	return service;
     }])


