'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
   
	$scope.user={unam:'',uid:'',pwd:'',email:''};
    $scope.users=[];
	
    $scope.getAll=function(){
    	UserService.fetchAllUsers()
        .then(
        function(d) {
        	$scope.users = d;
        	 console.log($scope.users);
        	 console.log('Done');
        	 
        },
        function(errResponse){
            console.error('Error while fetching Users');
        });
    }
    $scope.regiUser=function(user)
    {
    	 console.log(user);
    	UserService.regiUser(user)
        .then(
        		
        		function(errResponse){
            console.error('Error while creating User');
        });
    }
    $scope.doLogin=function(user)
    {
    	 console.log(user.uid);
    	UserService.doLogin(user)
        .then(
        		function (response) {
                	alert("You are authorised");
        			console.log('done2');
        			
        			 window.location = "menu.html";
                },
        		function(errResponse){
                	alert("You are not authorised");
                	console.error('Error while creating User');
        });
    }

      
   

}]);
