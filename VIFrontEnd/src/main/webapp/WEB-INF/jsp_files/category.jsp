<%@ page language="java" contentType="text/html"%>
<jsp:include page="Header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>


<center>
<div class="container">
<form id="category" action="categorysave" method="post">
Category details<br><br>
Category Name:
 <div class="form-group">
      <input type="text" class="form-control form-control-sm" placeholder="Enter the category name" name="catname" id="catName">
    </div>
category Description:
 <div class="form-group">
      <input type="text" class="form-control form-control-sm" placeholder="Enter the category description" name="catdesc" id="catDesc">
    </div>
<input type="submit" value="submit"/>
</center>
</form>
<div class="container">
	   <table class="table table-bordered">
	   <thead>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operation</td>
       </thead>
	<c:forEach items="${catlist}" var="cat">
		<tr>
			<td>${cat.categoryId}</td>
			<td>${cat.categoryName}</td>
			<td>${cat.categoryDesc}</td>
			<td>
			<a href="<c:url value="/updateCategory/${cat.categoryId}"/>">Update</a>       
				<a href="<c:url value="/deleteCategory/${cat.categoryId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>

</table>
</div>
</body>
</html>