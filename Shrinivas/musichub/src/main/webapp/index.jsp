<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link href=”/resources/bootstrap/css/bootstrap.min.css” rel=”stylesheet” type=”text/css” />
	<script type=”text/javascript” src=”/resources/bootstrap/js/bootstrap.min.js”></script>
	<script type=”text/javascript” src=”bootstrap/js/jquery-1.9.1.mini.js”></script>
	<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    <script type="text/javascript" src="/resources/bootstrap/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"></script>


  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  	
   	<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
<style>
body{}
</style>
</head>
<body >
<!-- BODY STARTS -->

<div  class="container-fluid" style="background-color:#633974;width:100%; margin:5px auto;padding:0px 10px 15px 10px; position: float ;">
	<div>
		<h2 style="font-weight:900; color:FF9999; float: left: ">DT TRAINING DAY 2 TASK</h2>
	</div>
	<div>
		<div style="position: float;">
			<h2 style="font-weight:900; color:FF9999; float: left;  ">MUSIC HUB</h2>
		</div>
		<div style="float: right; ">
			<a href="register" class="btn btn-primary"  >REGISTER</a>
			<a href="login"  class="btn btn-warning" >LOGIN</a>
		</div>
	</div>
</div>
<div style="bgcolor="#0000; width:80%; margin: 30px;">
  
  <!-- Slides Container -->
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 600px; margin: 0 auto; ">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
    <img src="<%=request.getContextPath() %>/resources/img/01.jpg">
      <!-- <img src="/resources/img/01.jpg" alt="Chania"> -->
      <div class="carousel-caption">
        <h3>Chania</h3>
        <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
      </div>
    </div>

    <div class="item">
      <img src="<%=request.getContextPath() %>/resources/img/02.jpg">
      <div class="carousel-caption">
        <h3>Chania</h3>
        <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
      </div>
    </div>

    <div class="item">
      <img src="<%=request.getContextPath() %>/resources/img/03.jpg">
      <div class="carousel-caption">
        <h3>Flowers</h3>
        <p>Beatiful flowers in Kolymbari, Crete.</p>
      </div>
    </div>
      <div class="item">
     <img src="<%=request.getContextPath() %>/resources/img/04.jpg">
      <div class="carousel-caption">
        <h3>Flowers</h3>
        <p>Beatiful flowers in Kolymbari, Crete.</p>
      </div>
    </div>

    <div class="item">
     <img src="<%=request.getContextPath() %>/resources/img/01.jpg">
      <div class="carousel-caption">
        <h3>Flowers</h3>
        <p>Beatiful flowers in Kolymbari, Crete.</p>
      </div>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<!-- Bottom images -->
<section id="team" class="bg-light-gray" style="margin:80px; ">
        <div class="container" >
            <div class="row">
                <div class="col-lg-12 text-center">
                   
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="team-member">
                        <a href="product?name=mi01"><img class="img-responsive img-circle" src="<%=request.getContextPath() %>/resources/img/01.jpg"></a>
                        <h4></h4>
                       
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <a href="product?name=mi02"><img class="img-responsive img-circle" src="<%=request.getContextPath() %>/resources/img/02.jpg"></a>
                        <h4></h4>
                        
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <a href="product?name=mi03"><img class="img-responsive img-circle" src="<%=request.getContextPath() %>/resources/img/04.jpg"></a>
                        <h4></h4>
                        
                    </div>
                </div>
            </div>
           
               

            
        </div>
        <div style="margin-top: 45px; margin-left: 40%;">
        <a href="product?name=allpro" class="btn btn-primary"  ><strong>Get All Music Products</strong></a>
        </div>
    </section>
     
    <!-- Bottom image ends -->
</div>    
    </body>


</html>
