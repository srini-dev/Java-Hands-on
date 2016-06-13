<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />

<%@include file="/WEB-INF/views/common.jsp"%>
<div class="container">
	<form:form commandName="order" class="form-horizaontal">
		<div>
			<div>
				<h3>Order Details</h3>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div>

						<div>
							<address>
								<strong>Shipping Address</strong><br>
								${order.cart.usersDetail.shippingAddress.houseNumber} <br>
								${order.cart.usersDetail.shippingAddress.addressLine1},
								${order.cart.usersDetail.shippingAddress.addressLine2} <br>
								${order.cart.usersDetail.shippingAddress.city},
								${order.cart.usersDetail.shippingAddress.state} <br>
								${order.cart.usersDetail.shippingAddress.country},
								${order.cart.usersDetail.shippingAddress.zipCode} <br>
							</address>
						</div>
						<div>
							<p>
								<strong><u>Shipping Date: <fmt:formatDate
											type="date" value="${now}" /></u></strong>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div>
						<address>
							<strong>Billing Address</strong><br>
							${order.cart.usersDetail.billingAddress.houseNumber} <br>
							${order.cart.usersDetail.billingAddress.addressLine1},${order.cart.usersDetail.billingAddress.addressLine2}
							<br> ${order.cart.usersDetail.billingAddress.city},
							${order.cart.usersDetail.billingAddress.state} <br>
							${order.cart.usersDetail.billingAddress.country},
							${order.cart.usersDetail.billingAddress.zipCode} <br>
						</address>
					</div>
				</div>
			</div>
			<div class="row" ng-controller="cartCtrl"
				ng-init="initCartId('${cartId}')">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>

							<th>Image</th>
							<th>Product Name</th>
							<th>Unit Price</th>
							<th>Quantity</th>
							<th>Price(in Rs.)</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="cartItem" items="${order.cart.cartItems}">
							<tr>
								<td class="span1"><img
									style="width: 200.33px; height: 100.33px;"
									src="<c:url value="/resources/images/${cartItem.item.itemId}.png" /> "
									alt="image" /></td>
								<td class="col-md-9"><em>${cartItem.item.itemName}</em></td>
								<td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
								<td class="col-md-1" style="text-align: center">${cartItem.item.itemPrice}</td>
								<td class="col-md-1" style="text-align: center">${cartItem.totalPrice}</td>
							</tr>
						</c:forEach>

						<tr>
							<td></td>
							<td></td>
							<td class="text-right">
								<h4>
									<strong>Grand Total(in Rs.) </strong>
								</h4>
							</td>
							<td class="text-center text-danger">
								<h4>
									<strong>${order.cart.grandTotal}</strong>
								</h4>
							</td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="text-center">
				<button class="btn btn-primary"
					name="_eventId_backToShippingAddProcess">Back</button>

				<input type="hidden" name="_flowExecutionKey" /> <input
					type="submit" value="Submit Order" class="btn btn-primary"
					name="_eventId_validateOrderProcessCompleted" />

				<button class="btn btn-danger" name="_eventId_cancel">Cancel</button>
			</div>

		</div>
	</form:form>
	<br>
</div>


<%@include file="/WEB-INF/views/footer.jsp"%>
