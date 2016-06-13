<div class="container">
	<div class="row" style="max-width: 100% !important;">
		<h3>Our Products</h3>
		<br>

		<!-- <ul  class="thumbnails" style="list-style:none; padding:10px; display:inline-flex; "> -->


		<c:forEach items="${items}" var="item">
			<c:if
				test="${searchCondition != null && searchCondition == item.itemCategory}">
				<div class="col-md-4">
					<!-- <li  style="width:150px;height:150px;"> -->
					<div class="thumbnail">
						<a href="<spring:url value="/musichub/showitem/${item.itemId}" />">
							<img style="width: 263.33px; height: 175.33px;" alt=""
							src="<c:url value="/resources/images/${item.itemId}.png" /> ">
							<div class="caption">
								<h5>${item.itemName}</h5>
								Price: ${item.itemPrice}
						</a>
						<h5>Item Id : ${item.itemId}</h5>
						<br>
						<br>
					</div>
					<p>-------------------------THIS IS FOR
						TESTING-------------------------------------------</p>
				</div>
				<div></div>
				<!-- </li> -->
	</div>
	</c:if>
	<c:if test="${searchCondition == null }">
		<div class="col-md-4">
			<!-- <li  style="width:150px;height:150px;padding:0px 5px;"> -->
			<div class="thumbnail">
				<a href="<spring:url value="/musichub/showitem/${item.itemId}" />">
					<img style="width: 263.33px; height: 175.33px;" alt=""
					src="<c:url value="/resources/images/${item.itemId}.png" /> ">
					<div class="caption">
						<h5>${item.itemName}</h5>
						Price: Rs. ${item.itemPrice}
				</a><br>
				<br>
			</div>
		</div>
		<!-- </li> -->
</div>
</c:if>

</c:forEach>


<!-- </ul> -->
</div>
</div>
</div>