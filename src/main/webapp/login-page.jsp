<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<title>EVENTIS - Log In</title>
    <link href="css/style.css" rel="stylesheet">
    
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  </head>
  <body>

    <div class="container-fluid">
	<div class="row d-flex align-items-center justify-content-center" >
		<div class="col-md-12" style="padding:0px; height: 100%; overflow:hidden">
			<c:import url="header.jsp" />

			
			<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
			  <div class="carousel-inner" id="carousel-first-page">
				    <div class="carousel-item active">
				      	<img class="d-block w-100" src="resources/0/1.jpg" alt="First slide">
				    </div>
				    <div class="carousel-item">
				      	<img class="d-block w-100" src="resources/0/2.jpg" alt="Second slide">
				    </div>
				    <div class="carousel-item">
				      	<img class="d-block w-100" src="resources/0/3.jpg" alt="Third slide">
				    </div>
			   </div>
			</div>
			
		</div>
		<div id="title-card">
				<h3>
					Log in to continue
				</h3>
				<form role="form" action="ConnUserLogin">
					<div class="form-group">
						<input type="text" class="form-control" name="username" placeholder="Username" id="exampleInputUsername" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="password" placeholder="Password" id="exampleInputPassword" />
					</div>
					<button type="submit" class="btn btn-primary w-100">
						Log in
					</button>
				</form>
			</div>
	</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>