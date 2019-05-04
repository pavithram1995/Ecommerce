<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<title>Update category</title>

</head>
<body>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
<h4 align="center">Product Updation</h4>
 <form id="updateproduct" class="form-horizontal" action="/UpdateProduct" method="post" enctype="multipart/form-data">
<div style="padding-left:250px; padding-right: 250px;">
	<div class="form-group">
      <label for="sel1">Category ID:</label>
      <select class="form-control" id="sel1" name="sellist1">
      <c:forEach items="${listcat}" var="cat">
        <option value="${cat.categoryId}">${cat.categoryName}</option>
        </c:forEach>
      </select>
      <br>
      </div>
	<div class="form-group">
      <label for="sel1">Supplier ID:</label>
      <select class="form-control" id="sel1" name="sellist1">
      <c:forEach items="${listsup}" var="sup">
        <option value="${sup.supplierId}">${sup.supplierName}</option>
        </c:forEach>
      </select>
      <br>
      </div>
<br>
   
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Product ID:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" readonly id="proid" name="proid" value="${productInfo.productId}"/>
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Product Name:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="proname" name="proname" value="${productInfo.productName}"/>
    </div>
  </div>
	
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Product Description:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="prodesc" name="prodesc" value="${productInfo.prodDesc}"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Product Stock:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="stock" name="stock" value="${productInfo.stock}"/>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="text">Product Price:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="price" name="price" value="${productInfo.price}"/>
    </div>
  </div> 
  
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
      <button type="submit" class="btn btn-default">Reset</button>
    </div>
  </div>
	
	</form>
	</div>
	</div>
	
<div class="container">
	   <table class="table table-bordered">
	   <thead>
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Product Desc</td>
		<td>Stock</td>
		<td>Price</td>
		<td>Image</td>
	</thead>
	<c:forEach items="${listProducts}" var="pro">
	<tr>
		<td>${pro.productId}</td>
		<td>${pro.productName}</td>
		<td>${pro.prodDesc}</td>
		<td>${pro.stock}</td>
		<td>${pro.price}</td>
		<td><img src="<c:url value="/resources/images/${pro.productId}.jpg"/>" width="100" height="100"/></td>
	</tr>
	</c:forEach>
	
</table>
</div>
</body>
</html>

