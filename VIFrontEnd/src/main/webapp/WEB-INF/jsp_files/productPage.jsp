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
<style type="text/css">

</style>
<title>product</title>
</head>
<body>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
<form id="product" action="productsave" method="post" enctype="multipart/form-data">
Product details<br><br>
<br>
<div style="padding-left:250px; padding-right: 250px;">
<div class="form-group">
      <label for="sel1">Category ID:</label>
      <select class="form-control" id="catid" name="catid">
      <c:forEach items="${listcat}" var="cat">
        <option value="${cat.categoryId}">${cat.categoryName}</option>
        </c:forEach>
      </select>
      <br>
      </div>
<div class="form-group">
      <label for="sel1">Supplier ID:</label>
      <select class="form-control" id="supid" name="supid">
      <c:forEach items="${listsup}" var="sup">
        <option value="${sup.supplierId}">${sup.supplierName}</option>
        </c:forEach>
      </select>
      <br>
      </div>
<br>
Product Name:
 <div class="form-group">
      <input type="text" class="form-control form-control-sm" placeholder="Enter the product name" name="proname" id="proName"/>
    </div>
Product Description:
 <div class="form-group">
      <input type="text" class="form-control form-control-sm" placeholder="Enter the product description" name="prodesc" id="proDesc">
    </div>
    Stock
 <div class="form-group">
      <input type="text" class="form-control form-control-sm" placeholder="Enter the number of stock available" name="stock" id="stock">
    </div>
    Price
 <div class="form-group">
      <input type="text" class="form-control form-control-sm" placeholder="Enter the price" name="price" id="price">
    </div>
    Image
    <div class="form-group">
      <input type="file" accept="resources/images/*" name="pimage">
    </div>
    
<input type="submit" value="submit"/>
</center>
</div>
	<div class="container">
	   <table class="table table-bordered">
	   <thead>
	   <td>Category ID</td>
		<td>Supplier ID</td>
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Product Desc</td>
		<td>Stock</td>
		<td>Price</td>
		<td>Image</td>
		<td></td>
		
       </thead>
	<c:forEach items="${prolist}" var="pro">
		<tr>
			<td>${pro.categoryId}</td>
			<td>${pro.supplierId}</td>
			<td>${pro.productId}</td>
			<td>${pro.productName}</td>
			<td>${pro.prodDesc}</td>
			<td>${pro.stock}</td>
			<td>${pro.price}</td>
			<td>
			<img src="<c:url value="/resources/images/${pro.productId}.jpg"/>" width="100" height="100"/>
			<br/></td>
			<td>
				<a href="<c:url value="/updateProduct/${pro.productId}"/>">Update</a>
				<a href="<c:url value="/deleteProduct/${pro.productId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>

</table>
</div>
</form>
</div>

</body>
</html>