<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@include file="/WEB-INF/views/common.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-xs-6">
			<h3>Products List</h3>
		</div>
		<div class="col-xs-6">
			<a style="float: right;"
				href="<spring:url value="/admin/item/addItem" />"
				class="btn btn-primary">Add Product</a>
		</div>
	</div>




	<div ng-app="cartApp">

		<table class="table table-bordered table-striped ">
			<thead>
				<tr>
					<th>Image</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Description</th>
					<th>Price(in Rs.)</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${items}" var="items">
					<tr>
						<td><img style="width: 150.33px; height: 100.33px;"
							src="<c:url value="/resources/images/${items.itemId}.png" /> "
							alt="image" /></td>
						<td>${items.itemName}</td>
						<td>${items.itemCategory}</td>
						<td>${items.itemDescription}</td>
						<td>${items.itemPrice}</td>
						<td><a
							href="<spring:url value="/musichub/showitem/${items.itemId}" />"
							class="btn btn-primary btn-xs">View</a> <a
							href="<spring:url value="/admin/item/editItem/${items.itemId}" />"
							class="btn btn-primary btn-xs"> Edit</a> <a
							href="<spring:url value="/admin/item/deleteItem/${items.itemId}" />"
							class="btn btn-danger btn-xs">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>

	<%@include file="/WEB-INF/views/footer.jsp"%>