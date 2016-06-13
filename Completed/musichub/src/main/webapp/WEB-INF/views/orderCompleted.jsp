<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/common.jsp"%>

<div class="container  well text-center">

	<h2>Thank you for Shopping</h2>
	<h3>Your order submitted successfully.</h3>

	<p>Your order will be shipped with in three business days!</p>
	<div class="span5">
		<a href="<spring:url value="/" />" class="btn btn-primary">Continue
			to shop</a>
	</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp"%>