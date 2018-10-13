<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="center" class="table">
<tr>
<td colspan="3"><center>Product Detail</center></td>
</tr>
<tr>
	<td rowspan="9">
			<img src="<c:url value="/resources/images${productInfo.productid}.jpg"/>" width="300" height="400"/>
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
<tr>
<h2>The stock of the available product is not available!!!</h2>
</tr>
</body>
</html>