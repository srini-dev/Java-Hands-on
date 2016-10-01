<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="js">

<head>
    <meta charset="utf-8">
    <title>Welcome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<spring:url value="/resources/css/bootstrap.css" var="bootstrap" /><link rel="stylesheet" href="${bootstrap}">
<spring:url value="/resources/css/freelancer.css" var="freelancercss" /><link rel="stylesheet" href="${freelancercss}">    
    <!-- Custom Fonts -->
<spring:url value="/resources/font-awesome/css/font-awesome.min.css" var="font" /><link href="${font}" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <style>
        
    </style>
    <!-- Loading Flat UI -->
<spring:url value="/resources/css/flat-ui.min.css" var="flat" /><link href="${flat}" rel="stylesheet">


    <link rel="shortcut icon" href="img/favicon.ico">



    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="js/vendor/html5shiv.js"></script>
      <script src="js/vendor/respond.min.js"></script>
    <![endif]-->
</head>

<body id="page-top">
    <div id="preloader"></div>
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top">NIIT Yln</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="#portfolio">Portfolio</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#about">About</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#contact">Contact</a>
                    </li>
                    <li>
                        <a href="register">Sign Up</a>
                    </li>
                    <li>
                        <a href="signin">Sign In</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">

                    <div class="intro-text">
                        <span class="name">NIIT Yln</span>
                        <hr class="star-light">
                        <span class="skills">Community</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Portfolio Grid Section -->
    <section id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Portfolio</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                       <spring:url value="/resources/img/portfolio/cabin.png" var="url"/><img src="${url}" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <spring:url value="/resources/img/portfolio/cake.png" var="url1"/><img src="${url1 }" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                       <spring:url value="/resources/img/portfolio/circus.png" var="url2"/> <img src="${url2 }" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                        <spring:url value="/resources/img/portfolio/game.png" var="url3"/><img src="${url3 }" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                       <spring:url value="/resources/img/portfolio/safe.png" var="url4"/> <img src="${url4 }" class="img-responsive" alt="">
                    </a>
                </div>
                <div class="col-sm-4 portfolio-item">
                    <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                        <div class="caption">
                            <div class="caption-content">
                                <i class="fa fa-search-plus fa-3x"></i>
                            </div>
                        </div>
                       <spring:url value="/resources/img/portfolio/submarine.png" var="url5"/> <img src="${url5 }" class="img-responsive" alt="">
                    </a>
                </div>
            </div>
        </div>
    </section>

    <!-- About Section -->
    <section class="success" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>About</h2>
                    <hr class="star-light">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-lg-offset-2">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eius aliquam quasi deleniti, velit nobis earum reiciendis officia, voluptatem vel, magni veritatis rem deserunt fuga! Autem, enim quam quas repellat tenetur!</p>
                </div>
                <div class="col-lg-4">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Qui quaerat veritatis ducimus impedit cum. Officia rem, consequuntur velit optio omnis animi quis quod. Iure, non. Autem architecto earum laboriosam ipsum.</p>
                </div>

            </div>
        </div>
    </section>

    <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Contact Us</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <!-- To configure the contact form email address, go to mail/ and update the email address in the PHP file on line 19. -->
                    <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                    <form name="sentMessage" id="contactForm" novalidate>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Name</label>
                                <input type="text" class="form-control" placeholder="Name" id="name" required data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Email Address</label>
                                <input type="email" class="form-control" placeholder="Email Address" id="email" required data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Phone Number</label>
                                <input type="tel" class="form-control" placeholder="Phone Number" id="phone" required data-validation-required-message="Please enter your phone number.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Message</label>
                                <textarea rows="5" class="form-control" placeholder="Message" id="message" required data-validation-required-message="Please enter a message."></textarea>
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn btn-success btn-lg">Send</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="text-center">
        <div class="footer-above">
            <div class="container">
                <div class="row">
                    <div class="footer-col col-md-4">
                        <h3>Location</h3>
                        <p>32 Yelahanka New Town
                            <br>Bangalore, IN 560064</p>
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>Around the Web</h3>
                        <ul class="list-inline">
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-facebook"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-google-plus"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-twitter"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-linkedin"></i></a>
                            </li>
                            <li>
                                <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-dribbble"></i></a>
                            </li>
                        </ul>
                    </div>
                    <div class="footer-col col-md-4">
                        <h3>About NIIT Yln</h3>
                        <p>Freelance is a free to use, open source Bootstrap theme created by.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        Copyright &copy; Your Website 2016
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll visible-xs visible-sm">
        <a class="btn btn-primary" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>

    <!-- Portfolio Modals -->
    <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                           <spring:url value="/resources/img/portfolio/cabin.png" var="cabin" /><img src="${cabin }" class="img-responsive img-centered" alt="">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quia suscipit atque iusto. Nisi reiciendis commodi placeat repellat inventore veniam voluptate accusamus, asperiores harum laboriosam atque. Maxime culpa rem quis placeat!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="#">NIIT Yln</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="#">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="#">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <spring:url value="/resources/img/portfolio/cake.png" var="cake" /> <img src="${cake }" class="img-responsive img-centered" alt="">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus aliquid labore laudantium asperiores aperiam iste unde incidunt totam, est laboriosam et ipsam. Perferendis sed deleniti, architecto dignissimos laborum repellat dicta!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="#">NIIT Yln</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="#">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="#">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                            <spring:url value="/resources/img/portfolio/circus.png" var="cir" /> <img src="${cir }" class="img-responsive img-centered" alt="">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta quisquam voluptatem delectus, numquam, quaerat quae iste vero magnam consequatur incidunt dolore enim! Eum error facilis et repellat fugit ipsum tempora!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="#">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="#">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="#">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                             <spring:url value="/resources/img/portfolio/game.png" var="game" /><img src="${game }" class="img-responsive img-centered" alt="">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eius sit fuga perferendis magni est sed, inventore blanditiis quis enim dolorum vitae accusantium illum, non iure, aspernatur labore debitis similique libero.</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="#">NIIT Yln</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="#">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="#">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                             <spring:url value="/resources/img/portfolio/safe.png" var="safe" /><img src="${safe }" class="img-responsive img-centered" alt="">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vero ad suscipit fugiat nam, asperiores ea. Itaque nihil ea quis sit, in molestiae libero ullam quibusdam officiis vel labore, ipsa consequatur!</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="#">Start Bootstrap</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="#">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="#">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <div class="modal-body">
                            <h2>Project Title</h2>
                            <hr class="star-primary">
                             <spring:url value="/resources/img/portfolio/submarine.png" var="sub" /><img src="${sub }" class="img-responsive img-centered" alt="">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel possimus, nihil eligendi! Excepturi odit ducimus, nemo ex maxime iste earum veniam deserunt similique veritatis nesciunt, dolorum dolores optio cum commodi?</p>
                            <ul class="list-inline item-details">
                                <li>Client:
                                    <strong><a href="#">NIIT Yln</a>
                                    </strong>
                                </li>
                                <li>Date:
                                    <strong><a href="#">April 2014</a>
                                    </strong>
                                </li>
                                <li>Service:
                                    <strong><a href="#">Web Development</a>
                                    </strong>
                                </li>
                            </ul>
                            <button type="button" class="btn btn-default " data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>







    <!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
    <spring:url value="/resources/js/vendor/jquery.min.js" var="jquery" /><script src="${jquery }"></script>
    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <spring:url value="/resources/js/classie.js" var="classie" /><script src="${classie }"></script>
    <spring:url value="/resources/js/cbpAnimatedHeader.js" var="aniheader" /><script src="${aniheader }"></script>

    <!-- <!-- Contact Form JavaScript -->
    <spring:url value="/resources/js/jqBootstrapValidation.js" var="vali" /><script src="${vali }"></script>
     <spring:url value="/resources/js/contact_me.js" var="conatct" /><script src="${contact }"></script> 

    <!-- Custom Theme JavaScript -->
    <spring:url value="/resources/js/freelancer.js" var="freelancer" /><script src="${freelancer }"></script>

    <!-- Include all compiled plugins (below), or include individual files as needed -->
<%--    <spring:url value="/resources/js/flat-ui.min.js" var="video" />  <script src="${video }"></script> --> --%>
    <spring:url value="/resources/js/flat-ui.min.js" var="flatui" /><script src="${flatui }"></script>
    <script>
        jQuery(document).ready(function ($) {

            // site preloader -- also uncomment the div in the header and the css style for #preloader
            $(window).load(function () {
                $('#preloader').delay(1000).slideUp('slow', function () {
                    
                    console.log('delayed');
                    console.log('loaded!');
                    $(this).remove();
                   
                });
            });

        });
    </script>
</body>

</html>