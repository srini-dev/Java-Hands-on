<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Hub</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="mobile-view">
		<center>
			<strong>Sorry the webpage is not made for mobile phones</strong>
		</center>
	</div>
	<div id="desktop-view">

		<div id="tophalf">
			<section class="aaa">Srinivas : NIITYLN : BLR</section>
			<div id="logo">
				<h3 class="text-center">
					<strong>Music Hub Inc.</strong>
				</h3>
				<c:if test="${pageContext.request.userPrincipal.name  == null}">
					<center>
						<a href="<c:url value="/login/" />"
							class="btn btn-primary btn-sm buttons text-center">SignIn</a> <a
							href="<c:url value="/register" />"
							class="btn btn-primary btn-sm buttons">SignUp</a>
					</center>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
						<li><a href="<c:url value="/user/cart" />"
							class="btn btn-primary btn-sm buttons">Cart</a></li>
					</c:if>

					<li><a href="<c:url value="/home" />"
						class="btn btn-primary btn-sm buttons">Hello,
							${pageContext.request.userPrincipal.name}</a></li>
					<li><a class="btn btn-primary btn-sm buttons"
						href="<c:url value="/j_spring_security_logout" />">Sign Out</a></li>
				</c:if>
			</div>
			<div class="container pad-top">
				<h1 class="text-center "
					style="text-shadow: 2px 2px #000; font-size: 4.5em;">
					<strong>Music Hub</strong>
				</h1>
				<h5 class="text-center">THE ONLINE MUSIC SHOP</h5>
				<ul>
					<li><img src="<c:url value="/resources/images/1.jpg" />"
						alt=""></li>
					<li><img src="<c:url value="/resources/images/2.jpg" />"
						alt=""></li>
					<li><img src="<c:url value="/resources/images/3.jpg" />"
						alt=""></li>
					<li><img src="<c:url value="/resources/images/4.jpg" />"
						alt=""></li>
				</ul>
			</div>
		</div>
		<div id="bottomhalf">
			<div class="container" id="logop">
				<ul>
					<li><img src="<c:url value="/resources/images/5.jpg" />"></li>
					<li><img src="<c:url value="/resources/images/6.jpg" />"></li>
					<li><img src="<c:url value="/resources/images/7.jpg" />"></li>
				</ul>
				<p class="text-center clearfix text">Lorem ipsum dolor sit amet,
					consectetur adipisicing elit. Non nam, in ut architecto asperiores,
					ipsum nihil voluptatem neque itaque facere nesciunt, vitae esse
					possimus totam consectetur aspernatur? Iste, a, numquam?Lorem ipsum
					dolor sit amet, consectetur adipisicing elit. Nisi dolorum eveniet
					libero minus perspiciatis iusto numquam, fugiat inventore
					doloremque autem magnam ipsum aperiam dolore enim, voluptatum
					tempore cumque sequi dicta.Lorem ipsum dolor sit amet, consectetur
					adipisicing elit. Optio incidunt fugit consequuntur ut similique
					officia, alias omnis at amet culpa, quidem. Enim, odit! Sequi sunt
					sint unde cupiditate, deserunt dignissimos.</p>
			</div>
			<div class="text-center brand">
				<h1>Music Hub</h1>
				<h5 class="text-center">Copyright &copy; 2016</h5>
			</div>
		</div>
	</div>

</body>
</html>