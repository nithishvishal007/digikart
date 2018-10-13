<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Catalog</title>
</head>
<body>
<div class="container">
  <h2>Mobiles</h2>
   <div class="row">
  <c:forEach items="${productList}" var="product">
 
  <div class="col-md-4">
  <img src="<c:url value='/resources/images/images${product.productid}.jpg' ></c:url>" width="200 px" height="300 px"/><br />
  <p>Product Name: ${product.productname}</p><br />
  <p>Price: ${product.price}</p><br />
  <p>Quantity: ${product.quantity}</p>
  <br/>
  <a href="<c:url value="productDisplay/${product.productid}" />" ><button type="button" class="btn btn-primary">View Product</button></a>
 </div>
  </c:forEach>
  </div>
  </div>

</body>
</html>