<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Chat</title>
    <script src="http://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/normalize.css">
   <spring:url value="/resources/css/style.css" var="style" /> <link rel="stylesheet" href="${style}">
    <link rel='stylesheet prefetch' href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/110131/responsive.css'>
<spring:url value="/resources/css/flat-ui.min.css" var="flat" /><link href="${flat}" rel="stylesheet">
    
   <spring:url value="/resources/css/blog.css" var="blog" /> <link rel="stylesheet" href="${blog}">

    
    
    
    
  </head>

  <body>

    <body ng-app="NIITYLNblogApp">
  
  <div ng-controller="NIITYLNBlogController as blog">
     
  
      <div class="topbar overlay">
        <div class="container ">
          <div class="row">
           <center>
            <div class="col-md-6">
             
              <h4 ng-click="blog.selectTab('blog')">{{blog.title}}</h4>
                
            </div>
            </center>
            <center>
            <div class="col-md-6" >
              <nav role='navigation'>
                <ul>
                  <li class="pushed"><button href="#" ng-click="blog.selectTab('blog')" class="btn btn-primary">See All Posts</button></li> &asymp;
                  <li ><button href="#" ng-click="blog.selectTab('new')" class="btn btn-primary">Add New Post</button></li>
                    <li style="float:right;right:0;"><h6 class="sign-out"><strong><a href="index">Sign Out</a></strong></h6></li>
                </ul>
              </nav> 
           
            </div>
                </center>
          </div>
        </div>
         </div>
 
      
      <div class="content">
        <div class="container">
          <div class="row">
            <ul class="post-grid spacing" ng-show="blog.isSelected('blog')">
          <li ng-repeat="post in blog.posts" class="col-s-4" ng-class="{ 'reset-s' : $index%3==0 }" ng-click="blog.selectTab($index)" >
            <h3>{{post.title}}</h3>
            <p>{{post.body[0] | limitTo:70}}...</p>
            <p class="fa fa-commenting push-left"> {{post.comments.length}}
            </p>
            <p class="fa fa-thumbs-up push-right"> {{post.likes}}
            </p>
          </li>
        </ul>
        <div class="post" ng-repeat="post in blog.posts" ng-show="blog.isSelected($index)">
          <div>
            
            <h2>{{post.title}}</h2>
            <img src="{{post.image}}" ng-show="{{post.image}}"/>
            <cite>by {{post.author}} on {{post.createdOn | date}}</cite>
            <div class="post-body">
             <p ng-repeat="paragraph in post.body">
               {{paragraph}}
             </p> 
            </div>
            
            <div class="comments" ng-controller="CommentController as commentCtrl">
              <button class="fa fa-heart" ng-click="post.likes = post.likes+1"> {{post.likes}}</button>
              <h3>Comments</h3>
              <ul>
               <li ng-repeat="comment in post.comments">
                 "{{comment.body}}"
                 <cite>- <b>{{comment.author}}</b></cite>
               </li>
              </ul>
              <form name="commentForm" ng-submit="commentForm.$valid && commentCtrl.addComment(post)" novalidate>
              
                
                <h4>Add Comment</h4>
                  <textarea ng-model="commentCtrl.comment.body" cols="30" rows="10" required></textarea>
                <label for="">by:</label>
                  <input type="text" ng-model="commentCtrl.comment.author" required placeholder="Name"/>
                  
                  <input type="submit" value="Submit" />
                </form>
            </div>
        </div>
      </div>
        <div class="post" ng-show="blog.isSelected('new')">
          <h2>Add New Post</h2>
          
          <form name="postForm" ng-submit=" blog.addPost()" novalidate>
                  <h4>Title</h4>
                  <input type="text" ng-model="blog.post.title"/>
                  <h4>Body</h4>
                  <textarea ng-model="blog.post.body" ng-list="/\n/" rows="10"></textarea>
                  <label for="">Featured Image URL</label>
                  <input type="text" ng-model="blog.post.image" placeholder="http://placekitten.com/g/2000/600" />
                  <label for="">by:</label>
                  <input type="text" ng-model="blog.post.author" placeholder="Author Name" required/>
                  
                  <input type="submit" value="Submit" />
                </select></form>
          
            </div>
            
          </div>
        </div>
        
    </div>
  </div>
 
 
</body>
    <script src='http://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/angularjs/1.2.9/angular-animate.js'></script>
<script src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/110131/jquery-2.1.0.min.js'></script>
<script src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/110131/responsive.js'></script>

     <spring:url value="/resources/js/index.js" var="index" /><script src="${index }"></script>
        

    
    
    
  </body>
</html>
