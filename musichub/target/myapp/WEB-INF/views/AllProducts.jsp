<%@page import="com.google.gson.Gson"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<script	src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>

<!--  <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script> -->
<!--   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
    <style>
        body { padding-top:0px;
        background-color: #F4D5D5  ; }
       
    </style>

   
    
   <script>
 // app.js
    var app = angular.module('sortApp', []);

function mainController($scope, $http) {

	  $scope.sortType     = 'name'; // set the default sort type
	  $scope.sortReverse  = false;  // set the default sort order
	  $scope.searchPName   = '';     // set the default search/filter term

        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'GsonCon'
                }).success(function(data, status, headers, config) {
                        $scope.Products = data;
                        
                }).error(function(data, status, headers, config) {
                        
                });

        };
};

    </script>
    
</head>
<body>
<!-- ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ -->
<!-- ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ -->

<div class="cotainer">
	<div class="heading">
	
	</div>
	<div class="tabs">
	<div class="container" ng-app="sortApp" ng-controller="mainController">
  <h3>Details Of AllProducts</h3>

				<div class="row">
					<div class="col-sm-4">
						<div >
							<p>Sort Type: {{ sortType }}</p>
							<p>Sort Reverse: {{ sortReverse }}</p>
							<p>Search Query: {{ searchpnm }}</p>
						</div>
					</div>
				<div class="col-sm-8">
						<div  style="float: right;" >

<!-- 							<button type="button" class="btn btn-info text-capitalize" data-toggle="modal" data-target="#myModal">More Info</button> -->
						</div>
					</div>
				
					
				</div>
				<!--   <button ng-click="getDataFromServer()">Fetch Data</button> -->
  <form>
    <div class="form-group" >
      <div class="input-group">
        <div class="input-group-addon" ><i class="fa fa-search"></i></div>

        <input type="text" class="form-control"  placeholder="Search Products Name" ng-model="searchpnm">

      </div>      
    </div>
  </form>
  <div ng-init="getDataFromServer()">
  <table class="table table-bordered table-striped">
    
     <thead>
      <tr>
      <td>
          <a href="#" ng-click="sortType = 'pid';">
            Products Name 
            <span ng-show="sortType == 'pid' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'pid' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
        <td>
          <a href="#" ng-click="sortType = 'pnm';">
            Products Name 
            <span ng-show="sortType == 'pnm' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'pnm' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'pdis'; ">
          Description 
            <span ng-show="sortType == 'pis' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'pdis' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'pprc'; ">
          Price 
            <span ng-show="sortType == 'pprc' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'pprc' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        
      </tr>
    </thead>
  
    <tbody>
      <tr class="clickable-row" ng-repeat="roll in Products | orderBy:sortType:sortReverse | filter:searchpnm ">
     
     
 
      
<%--       <td><c:out value="${roll.pid}"/></td> --%>
        <td>{{ roll.pid }}</td>
        <td>{{ roll.pnm }}</td>
        <td>{{ roll.pdis }}</td>
        <td>{{ roll.pprc }}</td>
        <td>
             <a href="del?nnn={{roll.pid}}" <%request.setAttribute("pd", "{{roll.pid}}");%> class="btn-danger" data-toggle="modal data-target="#myModal" style="float: right;margin-left: 10px;">DELETE</a>
             <a href="getEdit?nnn={{roll.pid}}" class="btn-success" style="float: right;">UPDATE</a>
         
        </td>
      </tr>
    </tbody>
    </table>
     <a href="welcome" class="btn btn-primary"  >HOME</a>
    </div>
   
  
</div>
	</div>
</div>

<!-- popup modol of More Info starts  -->


  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Scroll For More Music Instruments Details</h4>
        </div>
        <div class="modal-body">
         <script>
         function getval(){
         var s=document.getElementById("myModel").value;
         document.getElementById("mn").innerHtml=s;}
         </script>
         <div id="mn"></div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">HOME</button>
        </div>
      </div>
      
    </div>
  </div>
 
</div>
<!-- Modal ends -->

</body>
<!-- disp select itm on modal -->
<script>
$(".clickable-row").click(function(){
    if($(this).hasClass("highlight"))
        $(this).removeClass('highlight');
    else
        $(this).addClass('highlight').siblings().removeClass('highlight');
})
	</script>
<!-- disp select itm on modal -->
</html>
