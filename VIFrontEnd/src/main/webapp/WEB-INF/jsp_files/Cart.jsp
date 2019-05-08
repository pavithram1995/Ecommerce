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

<title>Cart</title>
</head>
<body>
<%@ include file="Header.jsp"%>

<div class="container">
<table class="table table-striped" style="border-width:3px;border-color:black;">
 <thead>
		<td>Product image</td>
		<td>Name</td>
		<td>Total</td>
		<td>Quantity</td>
       </thead>
       <c:forEach items="${listCarts}" var="cart">
       <tr>
       <form method="post" action="<c:url value="/updatecart/${cart.cartId}"/>">
       <td><img src="<c:url value="/resources/images/${cart.productId}.jpg"/>" width="75px" height="75px"><br>
       
       <c:if test="${Cart.cartId==cart.cartId}">
		${alert}
		</c:if>
       </td>
      <td>${cart.productName}</td>
	<td>${cart.subtotal}</td>
<td><input name="quantity" id="sel" value="${cart.quantity}"></td>
<td><button type="submit"class="btn btn-info">Check Price</button></td>
</form>
<div>
<td><a href="<c:url value="/deletecart/${cart.cartId}"/>"><button type="submit"class="btn btn-link ">Delete</button></a></td>
</div>
<td>
</td>
       </tr>
       </c:forEach>
       <tr>
<td>GrandTotal<td>
<td>${grandtotal}</td>
<td></td>

<td>
</td>
<td>
</td>
</tr>
<td><a href="<c:url value="/displayProduct"/>"><button type="submit"class="btn btn-secondary">Continue Shopping</button></a></td>


<center>
     <td>  <a href="<c:url value="/confirm"/>"><button type="submit"class="btn btn-info ">Confirm Order</button></a></td>
</center>       
</table>
</div>

</body>
</html>