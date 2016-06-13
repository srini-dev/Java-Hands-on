<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Music Hub</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Angular JS -->
<script src="<c:url value="/resources/js/angular.min.js" />">
	
</script>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">

<style>
* {
	padding: 0;
	margin: 0;
}
</style>
</head>

<body>
	<div id="mobile-view">
		<center>
			<strong>Sorry the webpage is not made for mobile phones</strong>
		</center>
	</div>
	<div id="desktop-view">


		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<c:url value="/" /> "><strong>Music
							Hub Inc.</strong></a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">


					</ul>

					<ul class="nav navbar-nav navbar-right">


						<c:if test="${pageContext.request.userPrincipal.name != null}">
							<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
								<li><a href="<c:url value="/user/cart" />">Cart</a></li>
							</c:if>
							<c:if
								test="${pageContext.request.userPrincipal.name  == 'admin'}">
								<li><a href="<c:url value="/admin/Instrumentsinventory" />">View
										Inventory</a></li>
								<li><a href="<c:url value="/admin/user" />">View
										Customer</a></li>
							</c:if>
							<li><a href="<c:url value="/home" />">Hello,
									${pageContext.request.userPrincipal.name}</a></li>
							<li><a href="<c:url value="/j_spring_security_logout" />">Sign
									Out</a></li>
						</c:if>
						<c:if test="${pageContext.request.userPrincipal.name  == null}">
							<li><a href="<c:url value="/" /> ">Back</a></li>
							<%-- 	<li><a href="<c:url value="/login/" />">Login</a></li>
									<li><a href="<c:url value="/register" />">Sign Up</a></li> --%>
						</c:if>

					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>