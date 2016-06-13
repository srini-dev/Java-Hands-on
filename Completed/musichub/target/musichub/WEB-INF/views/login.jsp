<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<div class="container">
	<div class="container" style="width: 40%; margin: 35px auto;">


		<form name="loginForm"
			action="<c:url value="/j_spring_security_check" />" method="post">
			<c:if test="${not empty error}">
				<div class="error" style="color: #ff0000;">${error}</div>
			</c:if>
			<div class="text-center">
				<c:if test="${not empty msg}">
					<div class="msg">${msg}
						<br>
						<br>
					</div>
				</c:if>
				<div class="control">
					<div class="control-group">
						<label class="control-label">User ID</label>
						<div class="controls docs-input-sizes">
							<input type="text" id="username" name="username"
								class="form-control" placeholder="Enter Your User ID" />
						</div>
					</div>
					<br>
					<div class="control-group">
						<label class="control-label">Password</label>
						<div class="controls docs-input-sizes">
							<input type="password" id="password" name="password"
								class="form-control" placeholder="Enter Your Password" />
						</div>
					</div>
					<br>
					<br>
					<div class="text-center">
						<input type="submit" value="Submit" class="btn btn-primary">

						<a href="<spring:url value="/" />"
							class="btn btn-danger margin-left25">Cancel</a>
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
		</form>
	</div>
</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp"%>
