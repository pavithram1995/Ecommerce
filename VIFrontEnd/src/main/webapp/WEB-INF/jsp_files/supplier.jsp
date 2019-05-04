<%@ page language="java" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<center>
<div class="container">
<form id="supplier" action="suppliersave" method="post">
Category details<br><br>
Category Name:
 <div class="form-group">
      <input type="text" class="form-control form-control-sm" placeholder="Enter the supplier name" name="supname" id="supName">
    </div>
category Description:
 <div class="form-group">
      <input type="text" class="form-control form-control-sm" placeholder="Enter the supplier location" name="supdesc" id="supDesc">
    </div>
<input type="submit" value="submit"/>
</center>
</form>
<div class="container">
	   <table class="table table-bordered">
	   <thead>
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Desc</td>
		<td>Operation</td>
       </thead>
	<c:forEach items="${suplist}" var="sup">
		<tr>
			<td>${sup.supplierId}</td>
			<td>${sup.supplierName}</td>
			<td>${sup.supplierLocation}</td>
			<td>
			<a href="<c:url value="/updateSupplier/${sup.supplierId}"/>">Update</a>       
				<a href="<c:url value="/deleteSupplier/${sup.supplierId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>

</table>
</div>
</body>
</html>