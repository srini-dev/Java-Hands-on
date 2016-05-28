<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style type="text/css">
    .bs-example{
    	margin: 100px;
    }
    body{
    background-color: #D1F2EB  ;
    }
</style>
<title>Insert title here</title>
</head>
<body>
<div class="cotainer">
	<div class="heading">
	<h1></h1>
	</div>
	<div class="datas">
		
		<div class="imag">
		<h3></h3>
		</div>
		
		<div class="bs-example">
		<h3>Details Of ${pnm}</h3>
		<table class="table" >
		<tr class="success" ><th>ProductID</th>
		<th>ProductName</th>
		<th>ProductDiscription</th>
		<th>ProductPrice</th></tr>
		<tr class="danger"><td>${pid}</td>
		<td>${pnm}</td>
		<td>${pdis}</td>
		<td>${pprc}</td></tr>
		
		</table>
		</div>
	
	</div>
</div>
</body>
</html>