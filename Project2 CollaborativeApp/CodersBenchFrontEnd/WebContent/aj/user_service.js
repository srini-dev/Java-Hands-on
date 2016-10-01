'use strict';

angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q){

  
    var factory = {
        fetchAllUsers: fetchAllUsers,
        regiUser: regiUser,
        doLogin:doLogin
     };
    var nam="uid";
    return factory;

    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get('http://localhost:8080/CodersBench/user/?uid="uid"')
            .then(
            function (response) {
            	console.log('Got data');
            	deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Data');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    function regiUser(user) {
        var deferred = $q.defer();
//        $http.post('http://localhost:8080/CodersBench/user/insert/',{user: u})
        $http.post('http://localhost:8080/CodersBench/user/insert/',user)
            .then(
            		
            function (response) {
            	 console.log(user);
            	console.log('Saving New User A2',user);
            	deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    function doLogin(user) {
        var deferred = $q.defer();
        $http.get('http://localhost:8080/CodersBench/user/dologs/'+user.uid+'/'+user.pwd)
      
            .then(
            		
            function (response) {
            	deferred.resolve(response.data);
            	console.log('done');
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
   

}]);
