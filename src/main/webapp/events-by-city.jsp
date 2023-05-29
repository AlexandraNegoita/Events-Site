<%@page import="java.sql.*"%>
<%@page import="connect.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Events By City</title>
	<link href="css/style.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	 <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>

<script src="https://npmcdn.com/bootstrap@4.0.0-alpha.5/dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid" style="padding-left:0px;padding-right:0px;margin-left:0px;margin-right:0px">
	<div class="row w-100" style="margin-left:0px;margin-right:0px">
				<c:import url="header.jsp"/>
	
		<div class="col-md-12" style="padding:0;width:100%">
			
			<div style="width:100%">
				<div style="padding-top:20vh; 
							padding-bottom:10vh;
							padding-left:10vh;
							padding-right:0;
							margin-right:0;
    						background-image: url(resources/0/event_header.jpg);
    						color: white">
					<h2>
						Events in <%= request.getParameter("selectCity") %>
					</h2>
				</div>
				<div class="row d-flex justify-content-center" style="margin:0; padding:0; padding-left:15px; padding-top:10px">
				
					<ul class="nav nav-pills">
						
						<li class="nav-item" style="padding-left:10px;" >
    							<a class="nav-link btn btn-outline-primary btn_types" data-type="all" href="">Show all<span class="badge badge-light"><c:out value="${totalEvents}"/></span></a>
    					</li>
					
					   <c:forEach items="${types}" var="type">
							<li class="nav-item" style="padding-left:10px;" >
    							<a class="nav-link btn btn-outline-primary btn_types" data-type=<c:out value="${type.getTypeName()}"/> href=""> <c:out value="${type.getTypeName()}"/> <span class="badge badge-light"><c:out value="${type.getEventCount()}"/></span></a>
    						</li>
  						</c:forEach>
					</ul>
				</div>
				<div class="row d-flex justify-content-between" style="margin:0; padding:0; padding-left:15px">
				
					<ul class="nav nav-tabs">
						<li class="nav-item">
							<p class="nav-link disabled">Sort by</p>
						</li>
						<li class="nav-item">
							<a class="btn btn-outline-secondary nav-link" id="sort-alph" href="">A - Z</a>
						</li>
						<li class="nav-item">
							<a class="btn btn-outline-secondary nav-link" id="sort-date" href="">Date</a>
						</li>
						<li class="nav-item">
							<a class="btn btn-outline-secondary nav-link" id="reset-sort" href="">Reset</a>
						</li>
					</ul>
					<form class="form-inline">
						<input id="search-event" class="form-control mr-sm-2" type="text" placeholder="Search for event.." /> 
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="row w-100" id="listEvents" style="padding-left:15px">
		<c:forEach items="${events}" var="event">
			<div class="col-md-4 event <c:out value="${event.getType()}"/>" data-eventName=<c:out value="${event.getEventSearchData()}"/> data-beginDate=<c:out value="${event.formatDate(event.getDateBegin())}"/>>
				<div class="row fade" style="height: 30vh; object-fit: cover; overflow: hidden">
					<img alt="thumbnail"  class="img-thumbnail rounded mx-auto d-block" src="resources/${event.getEventID()}/thumb.jpg" />
				</div>
				<div class="row w-100 cardRow">
					<div class="col-md-2 d-flex align-items-center justify-content-center">
						 <div class="row d-flex justify-content-center">
						 		<h4><c:out value="${event.getEventDate()}"/></h4>
						 	 	<h6><c:out value="${event.getDateBegin().getMonth()}"/></h6>
						 </div>
					</div>
					<div class="col-md-10 cardCol">
						<div class="card">
							<h5 class="card-header d-flex align-items-center justify-content-center event-name" style="height: 10vh">
								<c:out value="${event.getEventName()}"/>
							</h5>
							<div class="card-body fade" style="height: 40vh; overflow: hidden; ">
								<p class="card-text">
									<c:out value="${event.getDescription()}"/>
								</p>
							</div>
							<div class="card-footer">
								<a class="w-50"  href=<c:out value="${event.getEventLink() }"/>>
									<button type="button" style="margin-bottom: 1vh" class="btn btn-outline-primary w-100">
										Visit Website
									</button>
								</a>
								<% 
									if(session.getAttribute("isLoggedIn") != null && session.getAttribute("isLoggedIn").equals("y")){
										User currentUser = (User) session.getAttribute("currentSessionUser");						
								%>
								<a class="w-50"  href=<c:out value="PlannerAddEvent?eventID=${event.getEventID()}"/>>
									<button type="button" class="btn btn-primary w-100">
										Add to My Planner
									</button>
								</a>
								<% } %>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
   <script src="js/scripts.js"></script>
    
</body>
</html>