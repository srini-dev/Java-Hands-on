<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.2.0/sandstone/bootstrap.min.css">
<script	src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<script	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
<style>
        body { padding-top:50px;
        background-color: #F4D5D5  ; }
       
    </style>
</head>
<body>

	<div class="cotainer tabs">

		<div class="nav" style="margin: auto;">
		
		</div>



		<div class="bdyCont" style="width:400px;margin:auto;">
<h3>Updating Product</h3>
			<form:form modelAttribute="prod"  cssClass="form-horizontal" action="edt" method="POST">

				<div class="form-group">
					<label path="pid" class="col-sm-2 control-label"> Name:</label>
					<div class="col-sm-10">
						<form:input  path="pid" value="${pd.pid}"  cssClass="form-control" />
					</div>
				</div>
				
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label"> Name:</label>
					<div class="col-sm-10">
						<form:input path="pnm" value="${pd.pnm}" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label"> Name:</label>
					<div class="col-sm-10">
						<form:input path="pdis" value="${pd.pdis}" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label for="number" class="col-sm-2 control-label"> Name:</label>
					<div class="col-sm-10">
						<form:input path="pprc" value="${pd.pprc}"  cssClass="form-control" />
					</div>
				</div>

				
				<div class="form-group">
					<div class="col-sm-2">
						<input type="submit" value="UPDATE" class="btn btn-primary" />
					</div>
					
					<div class="col-sm-2" style="margin-left: 15px;">
						<a href="product?name=allpro" class="btn btn-primary" >BACK</a>
					</div>


				</div>

			</form:form>





		</div>
	</div>

</body>
</html>