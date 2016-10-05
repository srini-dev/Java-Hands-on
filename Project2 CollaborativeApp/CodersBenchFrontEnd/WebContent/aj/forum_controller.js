'use strict';

angular.module('myApp').controller('ForumController', ['$scope', 'ForumService', function($scope, ForumService) {
   
	$scope.forumm={fid:'',fcmtct:'',fdy:'',flikct:'',fpostdat:null,fsec:'',ftitle:'',fusr:'',fimg:null};
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
//    	
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
    
    $scope.addRpl=function(reply,fid,forumm)
    {
    	 reply.fid=fid;
    	 console.log(forumm);
    	 console.log(reply);
    	// fetchAllRep(fid);
    	 ForumService.addRpl(reply)
        .then(
        		function(response){
        			forumm.fcmtct=forumm.fcmtct+1;
        			ForumService.addForum(forumm);
                },
        		
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
    
 
  $scope.updateLik = function(x,y,forumm){
		
	      console.log(x,"JKKJK JK JKJK KJ KJKJ")
	      forumm.flikct=x;
	      forumm.fid=y;
	      
	    ForumService.addForum(forumm);
	    };
	    
   

}]);
