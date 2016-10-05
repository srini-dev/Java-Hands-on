'use strict';

angular.module('myApp').controller('BlogController', ['$scope', 'BlogService', function($scope, BlogService) {
   
	$scope.blogm={bid:'',btitle:'',bdy:'',bimg:null,busr:'',bsec:'',bcmtct:'',blikct:''};
    $scope.blogs=[];
	
    $scope.coment={cid:'',bid:'',busr:'',cdt:'',cmt:''};
    $scope.coments=[];
    
    
    fetchAllBlogs();
    $scope.titl="CoderBenchBlog"
    
    function fetchAllBlogs(){
    	BlogService.fetchAllBlogs()
        .then(
        function(d) {
        	$scope.blogs = d;
        	 console.log($scope.blogs);
        	 console.log('Done');
        	 
        },
        function(errResponse){
            console.error('Error while fetching blogs');
        });
    }
    
    function fetchAllCom(bid){
    	BlogService.fetchAllCom(bid)
        .then(
        function(d) {
        	$scope.coments = d;
        	 console.log($scope.coms);
        	 console.log('Done');
        	 
        },
        function(errResponse){
            console.error('Error while fetching coms');
        });
    }
    
    $scope.addBlog=function(blogm)
    {
    	 console.log(blogm);
    	 BlogService.addBlog(blogm)
        .then(
        		
        		function(errResponse){
            console.error('Error while creating blog');
        });
    }
    $scope.addCom=function(comment,bid,blogm)
    {
    	 comment.bid=bid;
    	 console.log(comment);
    	 BlogService.addCom(comment)
        .then(
        		function(response){
        			blogm.bcmtct=blogm.bcmtct+1;
        			BlogService.addBlog(blogm);
                },
        		
        		function(errResponse){
            console.error('Error while creating comnt');
        });
    }
   
$scope.tab = 'btb';
    
$scope.selectTab = function(setTab){
	$scope.tab = setTab;
      console.log($scope.tab)
      $scope.bid=setTab;
      fetchAllCom($scope.bid);
    };
    
    $scope.isSelected = function(checkTab){
      return $scope.tab === checkTab;
    };
      
    
//   ------------------------------
//   comment starts
    
    $scope.contLik = function(x,y,blogm){
		
	      console.log(x,"JKKJK JK JKJK KJ KJKJ")
	      blogm.blikct=x;
	      blogm.bid=y;
	      
	      BlogService.addBlog(blogm);
	    };
    
   

}]);
