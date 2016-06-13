<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@include file="/WEB-INF/views/common.jsp"%>

<div class="container">
	<h3>Items in your cart</h3>

	<div ng-app="addToCartApp">

		<div ng-controller="addToCartCtrl" ng-init="retrieveCart('${cartId}')">
			<table class="table table-bordered table-striped fs13">
				<thead>
					<tr>

						<th>Image</th>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Price(in Rs.)</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="items in cart.cartItems">
						<td><img style="width: 200.33px; height: 100.33px;"
							src="<c:url value="/resources/images/{{items.item.itemId}}.png" /> "
							alt="image" /></td>
						<td>{{items.item.itemName}}</td>
						<td>{{items.item.itemPrice}}</td>
						<td>{{items.quantity}}</td>
						<td>{{items.totalPrice}}</td>
						<td><a href="#" class="btn btn-danger btn-xs"
							ng-click="removeItemFromCart(items.item.itemId)"> <span
								class="glyphicon glyphicon-remove"></span>remove
						</a></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td>Grand Total(in Rs.)</td>
						<td>{{GrandTotalOfItems()}}</td>
						<td>
						</th>
					</tr>
				</tbody>
			</table>



			<div class="row text-center">
				<div>
					<a href="<spring:url value="/home" />"
						class="btn btn-primary center">Continue Shopping</a> <a
						href="<spring:url value="/order/${cartId}"/>"
						class="btn btn-success center"><span
						class="glyphicon-shopping-cart glyphicon"></span> Check out </a> <a
						class="btn btn-danger center" ng-click="clearCartItems()"><span
						class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
				</div>

			</div>
		</div>
	</div>
</div>


<script src="<c:url value="/resources/js/ordercontroller.js" /> "></script>
<%@include file="/WEB-INF/views/footer.jsp"%>