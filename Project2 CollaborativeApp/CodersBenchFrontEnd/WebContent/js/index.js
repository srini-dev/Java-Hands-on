/*

Simple blog front end demo in order to learn AngularJS - You can add new posts, add comments, and like posts.

*/

(function(){
  var app = angular.module('NIITYLNblogApp',[]);
  
  app.controller('NIITYLNBlogController', ['$http', function($http){
    
    var blog = this;
    blog.btitle = "NIIT YLN - BLOG";
    
    blog.posts = {};
    $http.get('http://localhost:8080/CodersBench/blogs').success(function(data){

    	//    	https://localhost:8080/CodersBench/blogs
//    	https://s3-us-west-2.amazonaws.com/s.cdpn.io/110131/posts_1.json
      blog.posts = data;
      console.log(blog.posts);
    });
    
    blog.tab = 'blog';
    
    blog.selectTab = function(setTab){
      blog.tab = setTab;
      console.log(blog.tab)
    };
    
    blog.isSelected = function(checkTab){
      return blog.tab === checkTab;
    };
    
    blog.post = {};
    blog.addPost = function(){
      blog.post.createdOn = Date.now();
      blog.post.comments = [];
      blog.post.likes = 0;
      blog.posts.unshift(this.post);
      console.log(this.post);
      blog.tab = 0;
      blog.post ={};
    };   
    
  }]);
  
  app.controller('CommentController', function(){
    this.comment = {};
    this.addComment = function(post){
      this.comment.createdOn = Date.now();
      post.comments.push(this.comment);
      this.comment ={};
    };
  });
 
})();