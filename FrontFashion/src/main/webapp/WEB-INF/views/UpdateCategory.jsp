<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>
</head>
<body>
<form action="<c:url value="/updateCategory"/>" method="post">
<table align="center" class="table-bordered">
<tr>
<td colspan="2">Category Detail</td>
</tr>
<tr>
<td>Category Id</td>
<td><input type="text" name="categoryid" value="${categoryData.categoryid}"/>
</td>
</tr>
<tr>
<td>Category name</td>
<td><input type="text" name="categoryName" value="${categoryData.categoryName}"/></td>
</tr>
<td>Category Desc</td>
<td><input type="text" name="categoryDesc" value="${categoryData.categoryDesc}"/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Update Category"/>
</td>
</tr>
</table>
</form>
</body>
</html>