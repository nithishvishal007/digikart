<%@include file="Header.jsp"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8"> 
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="login.css">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>

 
<body id="LoginForm">
<div class="container">
<h1 class="form-heading"><center>Login Form </center></h1>
<div class="login-form">
<div class="main-div">
    <div class="panel">
   <h2>User Login</h2>
   <p>Please enter your email and password</p>
   <p>${errorInfo}</p>
   </div>
    <form id="Login" action="<c:url value="/perform_login" ></c:url>" method="post">
    <div class="form-group">
    <input type="text" class="form-control" id="inputEmail" placeholder="User Name" name="username" required>
     </div>
     <div class="form-group">
     <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password" required>
	 </div>
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary" >Login</button> 
    </form>
    </div>
    <p class="botto-text">A website by Digitalkart</p>
     </div></div></div>


</body>
</html>
