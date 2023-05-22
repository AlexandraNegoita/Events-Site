<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<title>proiect</title>
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
				      	<img class="d-block w-100" src="resources/1.jpg" alt="First slide">
				    </div>
				    <div class="carousel-item">
				      	<img class="d-block w-100" src="resources/2.jpg" alt="Second slide">
				    </div>
				    <div class="carousel-item">
				      	<img class="d-block w-100" src="resources/3.jpg" alt="Third slide">
				    </div>
			   </div>
			</div>
			
		</div>
		<div id="title-card">
				<h1 class="display-1">titlu</h1>
				<p class="h3">Find events that happen near you</p>
				<form class="form-inline" action="ConnToEventTypes" method="GET" id="city-selector">
					<div class="input-group w-100">
						  <select class="custom-select w-60" name="selectCity" id="inputGroupSelect04">
							    <option selected>Choose...</option>
							    <%
									Class.forName("com.mysql.jdbc.Driver");
									Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectdb","root", "toor");
            						Statement stmt = conn.createStatement();
            						String sql = "select * from cities";
									ResultSet rs = stmt.executeQuery(sql);
									try {
										while (rs.next()) {	
									%>
										<option value=<%= rs.getString("cityName") %>><%= rs.getString("cityName") %></option>
									<%
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
									%>
						  </select>
						  <div class="input-group-append">
						    	<button class="btn btn-primary w-100" type="submit">Search Events</button>
						  </div>
					</div>
				</form>
			</div>
	</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>