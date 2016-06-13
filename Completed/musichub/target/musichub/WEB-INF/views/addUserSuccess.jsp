<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/common.jsp"%>

<div class="container">

	<h3 class="center-text well">You have registered successfully.</h3>
	<br>
	<div>
		<a href="<spring:url value="/" />" class="btn btn-primary center-text">Continue
			Shopping</a>
	</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp"%>