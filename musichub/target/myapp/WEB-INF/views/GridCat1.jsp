<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="http://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>
	 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
	 <meta name="author" content="">
	  <link rel="icon" type="image/png" href="ico/favicon-32.png"/>
    <link rel="apple-touch-icon-precomposed" href="ico/favicon-152.png">
    <meta name="msapplication-TileColor" content="#fff">
    <meta name="msapplication-TileImage" content="ico/favicon-144.png">
    <title>Bootstrap Template</title>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	 <script src="<%=request.getContextPath() %>/resources/cssbxhr/angular.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/cssbxhr/style2.css"></script>
 </head>
<body>
<!-- ******************************** -->
<div class="container">
    <h1 class="text-center text-muted">HOVER-EFFECT CSS</h1>
      <div class="row">
        <div class="col-xs-6 col-sm-3 hover-zoomin">
          <a href="#" title="">
            <img src="http://lorempixel.com/260/260/nature/1/" alt=""/>
          </a>
          <h4 class="text-center">Hover-ZoomIn</h4>
        </div>
        <div class="col-xs-6 col-sm-3 hover-fade">
          <a href="#" title="">
            <img src="http://lorempixel.com/260/260/nature/2/" alt=""/>
          </a>
          <h4 class="text-center">Hover-Fade</h4>
        </div>
        <div class="col-xs-6 col-sm-3 hover-blur">
          <a href="#" title="">
            <img src="http://lorempixel.com/260/260/nature/3/" alt=""/>
            <h2><span class="text-white">Hover Blur</span></h2>
          </a>
          <h4 class="text-center">Hover-Blur</h4>
        </div>
        <div class="col-xs-6 col-sm-3 hover-mask">
          <a href="#" title="">
            <img src="http://lorempixel.com/260/260/nature/4/" alt=""/>
            <h2><span class="glyphicon glyphicon-search"></span></h2>
          </a>
          <h4 class="text-center">Hover-Mask</h4>
        </div>
      </div>
      <div class="row">
        <div class="col-xs-6 col-sm-3 hover-zoomout">
          <a href="" title="">
          <img src="http://lorempixel.com/260/260/nature/5/" alt="" />
          </a>
          <h4 class="text-center">Hover-Zoomout</h4> 
        </div>
        
        <div class="col-xs-6 col-sm-3 hover-blurout">
          <a href="#" title="">
            <img src="http://lorempixel.com/260/260/nature/6/" alt=""/>
            <h2><span class="glyphicon glyphicon-search"></span></h2>
          </a>
          <h4 class="text-center">Hover-Blurout</h4>
        </div>
        
        <div class="col-xs-6 col-sm-3">
          <div class="overlay-item overlay-effect">
            <img src="http://lorempixel.com/260/260/nature/7/" alt="" />
              <div class="mask">
                <h3>OVERLAY</h3>
                <p>
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus doloremque natus quidem id.
                </p>
                <a href="#" class="btn btn-default">Read More</a>
              </div>
          </div>
          <h4 class="text-center">Overlay Text</h4>
      </div>
        <!-- Hover-Fall Effect-->
        <div class="col-xs-6 col-sm-3">
          <div class="fall-item fall-effect">
                    <img src="http://lorempixel.com/260/260/nature/8/"/>
                    <div class="mask">
                        <h2>Hover Fall</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="#" class="btn btn-default">Read More</a>
                    </div>
                </div>
          <h4 class="text-center">Hover-Fall</h4>
        </div>
      </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<!-- ******************************** -->
</body>
</html>