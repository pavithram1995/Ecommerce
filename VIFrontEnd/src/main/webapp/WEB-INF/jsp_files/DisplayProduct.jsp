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
<form action="<c:url value="/displayProduct"/>" method="post">
<div class="container">


<table class="table table-bordered">
 <tr>
 <c:forEach items="${prolist}" var="product">
<td>
<c:choose>
  <c:when test="${product.stock>0}">
    <a href="<c:url value="/descriptionProduct/${product.productId}"/>"><img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.jpg"/>" style="width:200px; height:200px;"></a>
 <br>Stock:${product.stock}
  </c:when>
  <c:otherwise>
  <img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.jpg"/>" style="width:200px; height:200px;">
  <br>
 <font color="red">Out of Stock</font>
  </c:otherwise>
</c:choose>
</td>
</c:forEach>
 
 
 </tr>
   </table>
    
    
  </div>
</form>
</body>
</html>