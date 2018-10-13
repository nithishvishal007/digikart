<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register form</title>
<script type="text/javascript" src="https://cdn.jsdeliver.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#form').validate({
		rules:{
		username:{required:true},
		password:{required:true,minlength:5,maxlength:20},
		customername:{required:true},
		email:{required:true,email:true},
		mobileno:{required:true,number:true,minlength:10,maxlength:10}
		},
		messages:{
			username:{required:"username is mandatory"},
			password:{required:"password could be contain special characters"},
			customername:{required:"customername is mandatory"},
			email:{required:"email must be like @gmail.com"},
			mobileno:{required:"mobile number should not contain characters"},
		}
	})
})

</script>
</head>
<body>

	<form:form action="registerUser" modelAttribute="user" method="post" id="form">
<table align="center">
	<tr>
		<td colspan="2"><center>Register User </center></td>
	</tr>
	<tr>
		<td>User Name</td>
		<td><form:input path="username" name="username" required="true"  /></td>
	</tr>
	<tr bgcolor="pink">
		<td>Password</td>
		<td><form:input path="password" name="password" type="password" required="true" /></td>
	</tr>
	<tr>
		<td> Name</td>
		<td><form:input path="customername" required="true" /></td>
	</tr>
	<tr>
		<td>Email ID</td>
		<td><form:input path="emailId" type="email" required="true"/></td>
	</tr>
	<tr bgcolor="pink">
		<td>Phone number</td>
		<td><form:input path="mobileno" required="true" /></td>
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