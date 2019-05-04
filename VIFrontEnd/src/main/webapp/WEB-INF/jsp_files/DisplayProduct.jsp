<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <jsp:include page="Header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Product</title>
</head>
<body>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="displayProduct" method="post">
<div class="container">

<c:forEach items="${prolist}" var="pro">
<table class="table table-bordered">
 <tr>
 <td>
 <a href="<c:url value="/descriptionProduct/${pro.productId}"/>"><img src="<c:url value="/resources/images/${pro.productId}.jpg"/>" width="100" height="100"/></a><br></td>
    	<td>Product Name:	${pro.productName}<br></td>
		<td>Available stock:	${pro.stock}<br></td>
		<td>Price:INR. ${pro.price}<br>    </td>
 </tr>
   </table>
    </c:forEach>
    
  </div>
</form>
</body>
</html>