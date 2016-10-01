<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="js">
  <head>
    <meta charset="utf-8">
    <title>Choose</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrap" /><link href="${bootstrap}" rel="stylesheet">
  
    <!-- Custom Fonts -->
    <spring:url value="/resources/font-awesome/css/font-awesome.min.css" var="font" /><link href="${font}" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    
     <style>
         body{
    background: #2980b9 !important;
            
}
   h2{
                 color:#3498db !important;
             }
         
</style>
    <!-- Loading Flat UI -->
<spring:url value="/resources/css/flat-ui.min.css" var="flat" /><link href="${flat}" rel="stylesheet">
    
   <spring:url value="/resources/css/style.css" var="style" /> <link rel="stylesheet" href="${style}">
    <link rel="shortcut icon" href="img/favicon.ico">

      
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="js/vendor/html5shiv.js"></script>
      <script src="js/vendor/respond.min.js"></script>
    <![endif]-->
  </head>
  <body id="page-top">
  <div id="preloader"></div>
     <h2  class="text-center">Choose ?</h2>
  <header>
  </header>
  <div class="container minimize">
      <div class="row text-center bright">
  <div class="col-md-4">
        <a href="openchat"><div class="bg-circular">
            <strong>BLOG</strong>
        </div></a>
          </div>
  <div class="col-md-4 ">
       
          <div class="bg-circular">
               <strong>CHAT</strong>
          </div>
         
       </div>
  <div class="col-md-4 ">
       
          <div class="bg-circular">
              <strong>FORUM</strong>
          </div>
  
  </div>
</div>
  </div>
  <div class="dropdown">
  <spring:url value="/resources/img/user-male-icon.png" var="male" /><input type="image" width="90px" style="border-radius: 50%;" id="saveform" src="${male }" alt="Submit Form" />
  <div class="dropdown-content">
    <a href="#">Profile Settings</a>
    <a href="index">Log Out</a>
    
  </div>
</div>
    <!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
    <spring:url value="/resources/js/vendor/jquery.min.js" var="jquery" /><script src="${jquery }"></script>
     <spring:url value="/resources/js/flat-ui.min.js" var="flatui" /><script src="${flatui }"></script>
     
      <spring:url value="/resources/js/classie.js" var="classie" /><script src="${classie }"></script>

   
       

<script>
      jQuery(document).ready(function($) {  

// site preloader -- also uncomment the div in the header and the css style for #preloader
$(window).load(function(){
	$('#preloader').delay(500).slideUp('slow',function(){$(this).remove();});
});

});
      </script>
  </body>
</html>
