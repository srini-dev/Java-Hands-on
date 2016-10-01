'use strict';

angular.module('myApp').controller('ForumController', ['$scope', 'ForumService', function($scope, ForumService) {
   
	$scope.forumm={fid:'',ftitle:'',fdy:'',fimg:null,fpostdat:null,fusr:'',fsec:'',fcmtct:'',flikct:''};
    $scope.forumms=[];
	
    $scope.reply={rid:'',fid:'', rpl:'',fusr:'',rdt:''};
    $scope.repls=[];
    
    
    fetchAllForums();
    
    $scope.titl="CoderBenchForum"
    
    function fetchAllForums(){
    	
    	ForumService.fetchAllForums()
        .then(
        function(d) {
        	$scope.forumms = d;
        	 console.log($scope.forumms);
        	 console.log('Done');
        	 
        },
        function(errResponse){
            console.error('Error while fetching forumms');
        });
    }
    
    
    $scope.addForum=function(forumm)
    {
    	forumm.fsec='ggg';
    	forumm.fcmtct=0;
    	forumm.flikct=0;
    	 console.log(forumm);
    	 console.log('Sending alllllllllllllllllll');
    	 ForumService.addForum(forumm)
        .then(
        		
        		function(errResponse){
            console.error('Error while creating blog');
        });
    }
    
    
    
    function fetchAllRep(fid){
    	ForumService.fetchAllRep(fid)
        .then(
        function(d) {
        	$scope.repls = d;
        	 console.log($scope.repls);
        	 console.log('Done');
        	 
        },
        function(errResponse){
            console.error('Error while fetching coms');
        });
    }
    
    $scope.addRpl=function(reply,fid)
    {
    	 reply.fid=fid;
    	 console.log(reply);
    	// fetchAllRep(fid);
    	 ForumService.addRpl(reply)
        .then(
        		
        		function(errResponse){
            console.error('Error while creating comnt');
        });
    }
   
$scope.tabf = 'ftb';
    
$scope.selectTab = function(setTab){
	$scope.tabf = setTab;
      console.log($scope.tabf)
      $scope.fid = setTab;
      fetchAllRep($scope.fid);
    };
    
    $scope.isSelected = function(checkTab){
      return $scope.tabf === checkTab;
    };
      
    
//   ------------------------------
//   comment starts
    
  
    
   

}]);
