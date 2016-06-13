<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/common.jsp"%>
<div class="container" style="width: 50%; margin: 35px auto;">
	<form:form
		action="${pageContext.request.contextPath}/admin/item/editItem"
		method="post" commandName="item" enctype="multipart/form-data">
		<form:hidden path="itemId" value="${item.itemId}" />
		<div>
			<div>
				<h3>Edit Product Details</h3>
			</div>
			<div>
				<div class="control-group">
					<label class="control-label">Name</label>
					<form:errors path="itemName" cssStyle="color: #ff0000;" />
					<div class="controls docs-input-sizes">
						<form:input path="itemName" id="name" class="form-Control"
							value="${item.itemName}" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Description</label>
					<form:errors path="itemDescription" cssStyle="color: #ff0000;" />
					<div class="controls docs-input-sizes">
						<form:textarea path="itemDescription" id="description"
							class="form-Control" value="${item.itemDescription}" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Category</label>
					<form:errors path="itemCategory" cssStyle="color: #ff0000;" />
					<div class="controls docs-input-sizes">
						<form:select path="itemCategory">
							<form:option value="" label="----Please Select------" />
							<form:options items="${categoryList}" />
						</form:select>
					</div>
				</div>


				<div class="control-group">
					<label class="control-label">Unit In Stock</label>
					<form:errors path="itemInStock" cssStyle="color: #ff0000;" />
					<div class="controls docs-input-sizes">
						<form:input path="itemInStock" id="unitInStock"
							class="form-Control" value="${item.itemInStock}" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Manufacturer</label>
					<div class="controls docs-input-sizes">
						<form:input path="itemManufacturer" id="manufacturer"
							class="form-Control" value="${item.itemManufacturer}" />
					</div>
				</div>
			</div>
			<div>
				<div class="control-group">
					<label class="control-label">Care Instructions</label>
					<div class="controls docs-input-sizes">
						<form:input path="itemCareInstructions" id="careinstructions"
							class="form-Control" value="${item.itemCareInstructions}" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Color</label>
					<form:errors path="itemColor" cssStyle="color: #ff0000;"
						value="${item.itemColor}" />
					<div class="controls docs-input-sizes">
						<form:input path="itemColor" id="color" class="form-Control" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Warranty</label>
					<form:errors path="itemWarranty" cssStyle="color: #ff0000;"
						value="${item.itemWarranty}" />
					<div class="controls docs-input-sizes">
						<form:input path="itemWarranty" id="warranty" class="form-Control" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Material</label>
					<form:errors path="itemMaterial" cssStyle="color: #ff0000;"
						value="${item.itemMaterial}" />
					<div class="controls docs-input-sizes">
						<form:input path="itemMaterial" id="material" class="form-Control" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Upload Picture</label>
					<div class="controls docs-input-sizes">
						<form:input id="itemImage" path="itemImage" type="file"
							class="form:input-large" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Price</label>
					<form:errors path="itemPrice" cssStyle="color: #ff0000;" />
					<div class="controls docs-input-sizes">
						<form:input path="itemPrice" id="itemPrice" class="form-Control"
							value="${item.itemPrice}" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Status</label>
					<div class="controls docs-input-sizes">
						<form:radiobutton path="itemStatus" id="status" value="active" />
						&nbsp;&nbsp;Active &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<form:radiobutton path="itemStatus" id="status" value="inactive" />
						&nbsp;&nbsp;Inactive
					</div>
				</div>
				<br>
				<div>
					<input type="submit" style="margin-right: 5px;" value="Submit"
						class="btn btn-primary pull-left" />
				</div>
				<div>
					<a href="<c:url value="/admin/Instrumentsinventory" />"
						class="btn btn-danger">Cancel</a>
				</div>
			</div>
		</div>
	</form:form>
</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp"%>
