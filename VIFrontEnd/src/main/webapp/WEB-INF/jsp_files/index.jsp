<%@ page language="java" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>books</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid" >
    <div class="navbar-header">     
	<a class="navbar-brand" href="<c:url value="/home"/>">Home</a>
	<a class="navbar-brand" href="<c:url value="/aboutus"/>">About Us</a>
	<a class="navbar-brand" href="<c:url value="/contactus"/>">Contact Us</a>
	
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
	<ul class="nav navbar-nav navbar-right">
    	<li> <a href="<c:url value="/login"/>">Login<span class="glyphicon glyphicon-log-in"></span></a></li>
		<li> <a href="<c:url value="/register"/>">register<span class="glyphicon glyphicon-pencil"></span></a></li>
	</ul>
  </div>
</div>
</nav>
<div class="container">
<div id="myCarousel" class="carouselslide" data-ride="carousel">

  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <div class="carousel-inner">
    <div class="item active">
      <img src="<c:url value="/resources/images/book1.jpg"/>" style="width:100%;"/>
    </div>

    <div class="item">
      <img src="<c:url value="/resources/images/book2.jpg"/>" />
    </div>

    <div class="item">
      <img src="<c:url value="/resources/images/book3.jpg"/>"/>
    </div>

    <div class="item">
      <img src="<c:url value="/resources/images/book4.jpg"/>"/>
    </div>
  </div>
<!-- 
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
   -->
</div>
</div>
</body>
</html> 