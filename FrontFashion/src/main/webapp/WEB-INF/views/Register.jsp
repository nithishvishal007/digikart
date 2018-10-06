<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="registerUser" modelAttribute="user" method="post">
<table align="center">
	<tr>
		<td colspan="2"><center>Register User </center></td>
	</tr>
	<tr>
		<td>User Name</td>
		<td><form:input path="username" /></td>
	</tr>
	<tr bgcolor="pink">
		<td>Password</td>
		<td><form:input path="password" type="password"/></td>
	</tr>
	<tr>
		<td> Name</td>
		<td><form:input path="customername" /></td>
	</tr>
	<tr>
		<td>Email ID</td>
		<td><form:input path="emailId" type="email" /></td>
	</tr>
	<tr bgcolor="pink">
		<td>Phone number</td>
		<td><form:input path="mobileno" /></td>
	</tr>
	<tr>
		<td colspan="2"><center>
				<input type="submit" value="Register" />
				<center>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>