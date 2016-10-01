'use strict';

angular.module('myApp').factory('BlogService', ['$http', '$q', function($http, $q){

  
    var factory = {
        fetchAllBlogs: fetchAllBlogs,
        addBlog: addBlog,
        addCom :addCom,
        fetchAllCom:fetchAllCom
     };
  
    return factory;

    function fetchAllBlogs() {
        var deferred = $q.defer();
        $http.get('http://localhost:8080/CodersBench/blogs')
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
    function addBlog(blogm) {
        var deferred = $q.defer();

        $http.post('http://localhost:8080/CodersBench/blog/insert/',blogm)
            .then(
            		
            function (response) {
            	 console.log(blogm);
            	console.log('Saving New User A2',blogm);
            	deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating blog');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    function addCom(comment) {
        var deferred = $q.defer();
        $http.post('http://localhost:8080/CodersBench/cmnt/insert/',comment)
      
            .then(
            		
            function (response) {
            	deferred.resolve(response.data);
            	console.log('done');
            },
            function(errResponse){
                console.error('Error while creating cmnt');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
   
    function fetchAllCom(bid) {
        var deferred = $q.defer();
        $http.get('http://localhost:8080/CodersBench/coments/'+bid)
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

}]);
