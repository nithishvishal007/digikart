<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>--%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
   <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
 <form action="addCategory" method="post">
<table align="center" class="table-bordered">
<tr>
<td colspan="2"><centre>Category Detail</centre></td>
</tr>
<tr>
<td>Category Name</td>
<td><input type="text" name="categoryName"/></td>
</tr>
<tr>
<td>Category Description</td>
<td><input type="text" name="categoryDesc"/></td>
</tr>
<tr>
<td colspan="2"><center>
<input type="submit" value="Enter category"/></center>
</td>
</tr>
</table>
</form>
</br>
</br>
<hr>

<table align = "center" class="table-bordered">
<tr><td colspan="4"><center> Category Detail </center></td></tr>
<tr>
<tr>
<td> Category ID</td>
<td> Category Name</td>
<td> Category Desc</td>
<td>Operations</td>
</tr>
<c:forEach items="${categoryList}" var="category">
<tr>
<td>${category.categoryid}</td>
<td>${category.categoryName}</td>
<td>${category.categoryDesc}</td>
<td>
<a href="<c:url value='/deleteCategory/${category.categoryid}'/>"><button type="button" class="btn btn-danger">Delete</button></a>
<a href="<c:url value='/editCategory/${category.categoryid}'/>"><button type="button" class="btn btn-warning">Edit</button></a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html> 