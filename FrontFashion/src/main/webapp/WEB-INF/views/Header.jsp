<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Header</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<!-- Brand/logo -->
					<a class="navbar-brand" href="#">DigitalKart</a>
				

				<!-- Links -->
				
			<c:if test="${!sessionScope.loggedIn}">
				<ul class="nav navbar-nav">
					<li class="nav-item">
					<a class="nav-link" href="home">Home</a>
					</li>
					<li class="nav-item">
					<a class="nav-link" href="register">Register</a>
					</li>
					<li class="nav-item">
					<a class="nav-link" href="aboutus">About Us</a>
					</li>
					<li class="nav-item">
					<a class="nav-link" href="contactus">Contact Us</a>
					</li>
					</ul>
					<ul class="nav navbar-nav navbar-right"><li>
					
					<a class="nav-link" href="Login"><span class="glyphicon glyphicon-log-in">Login</a>
					</li></ul>
					
					</c:if>					
					<c:if test="${sessionScope.loggedIn}">
					<c:if  test="${sessionScope.role=='ROLE_USER'}">
					<ul class="nav navbar-nav">
					<li  class="nav-item"><a href="home">Home</a>&nbsp&nbsp&nbsp&nbsp
					<li class="nav-item"><a class="nav-link" href="<c:url value="/productCatalog"/>">Product Catalog</a></li>&nbsp&nbsp&nbsp&nbsp
					<li class="nav-item"><a class="nav-link" href="<c:url value="/ProductDisplay"/>">Product Display</a></li>&nbsp&nbsp&nbsp&nbsp 
					<li class="nav-item"><a class="nav-link" href="<c:url value="/cart"/>">My Cart</a> &nbsp&nbsp&nbsp&nbsp
					<li class="nav-item"><a class="nav-link" href="<c:url value="/myyorder"/>">My Order</a> &nbsp&nbsp&nbsp&nbsp
					</li>
					</ul>
					<c:if test="${sessionScope.loggedIn}">
					<ul class="nav navbar-nav navbar-right">
					<li class="nav-item"><a class="nav-link">Hi ${sessionScope.username}</a></li>
					<li>
					<a class="nav-link" href="perform_logout">Logout</a>
					</li></ul>
					</c:if>
					
				</c:if>
				</c:if>
                <c:if test="${sessionScope.loggedIn}">
				<c:if  test="${sessionScope.role=='admin'}">
				<ul class="nav navbar-nav">
					<li><a href="home">Home</a>&nbsp&nbsp&nbsp&nbsp
					<li><a href="category">Manage Category</a></li>&nbsp&nbsp&nbsp&nbsp
					<li><a href="product">Manage Product</a></li>&nbsp&nbsp&nbsp&nbsp
					 <li class="nav-item">
					<a class="nav-item" href="supplier">Manage Supplier</a>&nbsp&nbsp&nbsp&nbsp
					</li>
					<li><a href="<c:url value="/ProductDisplay"/>">Product Display</a></li>&nbsp&nbsp&nbsp&nbsp
					</ul>
					<li><a href="<c:url value="/cart"/>">My Cart</a></li>&nbsp&nbsp&nbsp&nbsp
					<li class="nav-item"><a class="nav-link" href="<c:url value="/myyorder"/>">My Order</a> &nbsp&nbsp&nbsp&nbsp
					<li><a class="nav-item" href="perform_logout">LogOut</a>
					</li></ul>
				</c:if>	
				</c:if>				
			</nav>
</body>
</html>