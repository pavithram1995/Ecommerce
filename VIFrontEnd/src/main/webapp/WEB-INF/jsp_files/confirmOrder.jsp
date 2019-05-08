<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<title>Confirm Order</title>
</head>
<body>

<%@ include file="Header.jsp"%>
<div class="container">
<table class="table table-bordered">

<tr>
  <td>Products</td>
  <td>Quantity</td>
  <td>Sub total</td>
</tr>

<c:forEach items="${listCarts}" var="cartItem">

 <tr> 
 <td><img src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" width="100" height="100"/></td>
 
 <td>${cartItem.quantity}</td>
 <td>INR. ${cartItem.subtotal}</td>
 </tr>
 </c:forEach>
<tr>
<td colspan="2">Grand Total</td>
<td>INR.${grandtotal}</td>

</tr>
</table>
<form action="<c:url value="/PaymentConfirm"/>" method="get">
  
  <tr>
    <td>Payment Mode:</td>
    <td>
    <input type="radio" name="mode" value="card" required/>Credit Card
    <input type="radio" name="mode" value="online" required/>Net Banking 
    <input type="radio" name="mode" value="cash" required/>Cash On Delivery
    </td>
  </tr><br>
  
  <tr>
    <td>Shipping Address:</td> 
    <td><textarea name="ShippingAdress" title="You need to fill for delivery" style="width:35%;color:black;" required></textarea></td>&nbsp;&nbsp;&nbsp;&nbsp;
    <td><button type="submit"class="btn btn-success" style="width:20%">PROCEED TO PAY</button></td>
    <td></td>
  </tr>
  
   </form>
 
</div>

</body>
</html>