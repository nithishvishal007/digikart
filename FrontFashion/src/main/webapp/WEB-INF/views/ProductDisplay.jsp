<%@include file="Header.jsp"%>

<div class="container">
<table align="center" class="table">
<tr>
<td colspan="3"><center>Product Detail</center></td>
</tr>
<tr>
	<td rowspan="9">
			<img src="<c:url value="/resources/images/images${productInfo.productid}.jpg"/>" width="300" height="400"/>
	</td>
</tr>
<tr>
	<td>Product ID</td>
	<td>${productInfo.productid}</td>
</tr>
<tr>
	<td>Product Name</td>
	<td>${productInfo.productname}</td>
</tr>
<tr>
	<td>Supplier Name</td>
	<td>${supplierName}</td>
</tr>
<tr>
	<td>Category</td>
	<td>${categoryName}</td>
</tr>
<tr>
	<td>Price</td>
	<td>${productInfo.price}</td>
</tr>
<tr>
	<td>Stock</td>
	<td>${productInfo.quantity}</td>
</tr>
<tr>
	<td>Product Description</td>
	<td>${productInfo.productDesc}</td>
</tr>
<form action="<c:url value="/addToCart/${productInfo.productid}" />" method="get">
<tr>
	<td>Quantity</td>
	<td><input type="text" name="qty" required/></td>
</tr>
<tr>
	<td></td>
	<td> <input type="submit" value="ADDTOCart" class="btn btn-info"/></td>
</tr>
</form>
</table>
</div>

