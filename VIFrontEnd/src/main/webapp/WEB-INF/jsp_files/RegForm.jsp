<%@ page language="java" contentType="text/html"%>
<jsp:include page="Header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Register</title>

</head>
<body>
<form id="register" action="<c:url value="/saveuser"/>">
<section class="intro">
    <row>
      <div class="col-lg-6 col-sm-12 left">
        
          <td>
			<img src="<c:url value="/resources/images/bg.jpg"/>" width="500" height="500"/>
			<br/></td>       
      </div>
      <div class="col-lg-6 col-sm-12 right">
      <center>
<br>
<b><u>Registration Form</u></b></br></br></br>
	<div class="input-group">
     		 
     		 <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
     		 <input id="name" type="text" 
	name="name" 
	class="form-control"
	placeholder="Enter your name"
	pattern="[A-Za-z]+" 
	title="Enter only the alphabets between a to z"
	required>
</div><br><br>
	
    		<div class="input-group">
     		 
     		 <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
     		 <input id="name" type="text" 
	name="username" 
	class="form-control"
	placeholder="Enter your user name"
	pattern="[A-Za-z]+" 
	title="Enter only the alphabets between a to z"
	required>
</div>
<br><br>
<div class="input-group">

 <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
 
 <input id="mail" type="text" 
	name="email" 
	class="form-control"
	placeholder="Enter your mail Id"
	pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" 
	title="Eg:abc@xyz.com"
	required>
	</div>
	<br><br>
<div class="input-group">

 <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
 <input id="num" type="text" 
	name="mobno" 
	class="form-control"
	placeholder="Enter your mobile number"
	pattern="[6-9]{1}[0-9]{9}" 
	title="Enter 10 digit numbers, first digit should be from 6 to 9"
	required>
</div>
<br><br>
<div class="input-group">

 <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
 
<input id="passwd" 
type="password" 
class="form-control" 
name="passwd" 
placeholder="Enter your password"
placeholder="Password">
</div>
<br><br>

<script>

function myFunction() 
{	
	{
  alert("${alert}");
	}
}
</script>
<br>
<button type="submit" class="btn btn-info" onclick="myFunction()">Register Me!</button>

</center>
</div>
</div>
</row>
</section>
</form>
</body>
</html>