<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Header.jsp" />
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<title>Description</title>
</head>
<body>
 <form action="<c:url value="/moveCart/${dispinfo.productId}"/>"method="post" enctype="multipart/form-data">
<center>
<section class="intro">
    <row>
      <div class="col-lg-6 col-sm-12 left">
        
          <td>
			<img src="<c:url value="/resources/images/${dispinfo.productId}.jpg"/>" width="250" height="250"/>
			<br/></td>       
      </div>
      <center>
      <div class="col-lg-6 col-sm-12 right">
        <br><br><br>
        	Name:
          <td>${dispinfo.productName}</td><br><br><br>
          Description:
			<td>${dispinfo.prodDesc}</td><br><br><br>
			No.of Stock available:
			<td>${dispinfo.stock}</td><br><br><br>
			Price
			<td>${dispinfo.price}</td><br><br><br>
			
			<button class="btn btn-info" ><span class="glyphicon glyphicon-shopping-cart">Add to Cart</span></button>
		
       
      </div>
      
    </row>
  </section>
  </center>
  </form>
</body>
</html>