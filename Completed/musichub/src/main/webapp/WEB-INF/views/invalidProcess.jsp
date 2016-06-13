<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/common.jsp"%>

<div>

	<h1>Invalid Cart</h1>
	<br>
	<div>
		<a href="<spring:url value="/musichub/allItems" />"
			class="btn btn-primary">Continue Shopping</a>
	</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp"%>