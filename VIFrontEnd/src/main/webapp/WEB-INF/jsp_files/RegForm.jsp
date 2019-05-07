<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<form id="register" action="saveuser" >
<center><b>${name}</b></center><br>
<center><b><u>Registration Form</u></b></br></br></br>
Enter Name:
<input 
	type="text" 
	name="username" 
	pattern="[A-Za-z]+" 
	title="Enter only the alphabets between a to z"
	required/><br><br>

Enter Email id:
<input 
	type="text"  
	name="email" 
	pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" 
	title="Eg:abc@xyz.com"
	required><br><br>
Enter Contact No:
<input type="text" name="mobno" pattern="[6-9]{1}[0-9]{9}" title="Enter 10 digit numbers, first digit should be from 6 to 9" required> </br></br>
Password:
<input id="passwd" type="password" class="form-control" name="passwd" placeholder="Password"><br><br>
<input type="submit" name="register" value="Register"/>
</table>
</center>
</form>
</body>
</html>