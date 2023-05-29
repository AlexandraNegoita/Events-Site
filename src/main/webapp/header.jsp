<%@page import="java.sql.*"%>
<%@page import="connect.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg fixed-top navbar-dark w-100" id="nvbar" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://npmcdn.com/bootstrap@4.0.0-alpha.5/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="js/scripts.js"></script>

				 
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="navbar-toggler-icon"></span>
				</button> <a class="navbar-brand" href="index.jsp">EVENTIS</a>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
					<ul class="navbar-nav" >
						<li class="nav-item active" >
							 <a class="navbar-brand" href="ConnToEventCategories?type=Concerts" >Concerts</a>
						</li>
						<li class="nav-item">
							 <a class="navbar-brand" href="ConnToEventCategories?type=Fairs">Fairs</a>
						</li>
						<li class="nav-item">
							 <a class="navbar-brand" href="ConnToEventCategories?type=Shows">Shows</a>
						</li>
					</ul>
					<% 
						if(session.getAttribute("isLoggedIn") != null && session.getAttribute("isLoggedIn").equals("y")){
							User currentUser = (User) session.getAttribute("currentSessionUser");
							if(currentUser.getRole().equals("user")) {
					%>
					<ul class="navbar-nav ml-md-auto">
						<li class="nav-item active">
							 <a class="nav-link" href=""><%= currentUser.getUsername() %></a>
						</li>
						<li class="nav-item active">
							 <a class="nav-link" href="ConnToPlannerEvents">My Planner</a>
						</li>
						<li class="nav-item active">
							 <a class="nav-link" href="UserLogout">Log Out</a>
						</li>
					</ul>
						<%} else { %> 
					<ul class="navbar-nav ml-md-auto">
						<li class="nav-item active">
							 <a class="nav-link" href=""><%= currentUser.getUsername() %></a>
						</li>
						<li class="nav-item active">
							 <a class="nav-link" href="add-event.jsp">Add New Event</a>
						</li>
						<li class="nav-item active">
							 <a class="nav-link" href="UserLogout">Log Out</a>
						</li>
					</ul>
						<%}} else { %>
					<ul class="navbar-nav ml-md-auto">
						<li class="nav-item active">
							 <a class="nav-link" href="login-page.jsp">Log In</a>
						</li>
						<li class="nav-item active">
							 <a class="nav-link" href="register-page.jsp">Register<span class="sr-only">(current)</span></a>
						</li>
					</ul>
					<% } %>
				</div>
			</nav>
		