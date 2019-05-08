<%@ page language="java" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<center>
	<div class="container" style="padding-left:500px; padding-right: 500px;">
	<br><br><br><br><b>Login</b>
	</div>
	<br><br><br><br>
	<div class="container"; style=" padding-left:500x;">
	
	<form id="login" action="<c:url value="/perform_login"/>" method= "post">
    		<div class="input-group">
     		 <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		<input 
		id="name"
	type="text" 
	name="username" 
	class="form-control"
	placeholder="Enter your user name"
	pattern="[A-Za-z]+" 
	title="Enter only the alphabets between a to z"
	required/><br><br>
		</div>
		<br><br>
		
		<div class="input-group">
      		<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      		<input id="password" type="password" class="form-control" name="password" placeholder="Password">
  		</div>
		<br><br>
		
		<br><br>
		<input type="submit" class="btn btn-info" value="Login"/>
		<input class="btn btn-secondary" type="reset" value="Reset">
		</form>
	</div>
	</div>
	</center>
</body>
</html>
		