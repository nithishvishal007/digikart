<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product catalog</title>
</head>
<body>
<div class="container">
<c:forEach items="${prodductList}" var="product">
<div class="row">
<div class="col-md-4 col-xs-12 col-sm-6">
<img src="<c:url value="/resources/images/${product.productid}.jpg"/>">
</div>
</div>
</c:forEach>
</div>
</body>
</html>