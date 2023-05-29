<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>My Events Planner</title>
	<link href="css/style.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	 <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container-fluid" style="width: 100vw; height: 100vh; padding-left:0px;padding-right:0px;margin-left:0px;margin-right:0px;background-image: url(resources/0/event_header.jpg); overflow-y: scroll; overflow-x: hidden">
	<div class="row w-100" style="margin-left:0px;margin-right:0px">
				<c:import url="header.jsp"/>
	
		
	</div>
	<div class="row d-flex justify-content-center" style="padding:0;width:100vw; margin-top: 20vh">
			<h2 style="width: auto; color: white">
				My Planner
			</h2>
	</div>
	<div class="row " style="margin: 0; margin-top: 5vh; margin-bottom: 5vh; padding: 0">
			<div class="col-md-12 d-flex justify-content-center align-items-center">
				<div id="accordion" style="width: 80vh">
				<c:forEach items="${events_planner}" var="event">
					  <div class="card">
					    <div class="card-header d-flex justify-content-between align-items-center" id=<c:out value="heading${event.getEventID()}"/>>
					    	<h5><c:out value="${event.getEventDate()} ${event.getDateBegin().getMonth()} ${event.getDateBegin().getYear()}"/></h5>
					        <h5><button class="btn" data-bs-toggle="collapse" data-bs-target=<c:out value="#collapse${event.getEventID()}"/> aria-expanded="false" aria-controls=<c:out value="collapse${event.getEventID()}"/>>
					          <c:out value="${event.getEventName()}"/>
					        </button></h5>
					        <div class="btn-group btn-group-sm justify-content-end" role="group">
					        <a href=<c:out value="PlannerDeleteEvent?eventID=${event.getEventID() }"/>>
								<button class="btn btn-outline-primary" type="button">
									Delete
								</button> </a>
							</div>
					    </div>
					
					    <div id=<c:out value="collapse${event.getEventID()}"/> class="collapse" aria-labelledby=<c:out value="heading${event.getEventID()}"/> data-bs-parent="#accordion">
					      <div class="card-body">
								<c:out value="${event.getDescription()}"/>					      
							</div>
							<div class="card-footer">
								<a class="w-50" href=<c:out value="${event.getEventLink() }"/>>
									<button type="button" class="btn btn-outline-primary w-100">
										Visit Website
									</button>
								</a>
							</div>
					    </div>
					  </div>
					  </c:forEach>
				</div>
			</div>
		</div>
	</div>
   <script src="js/scripts.js"></script>
    
</body>
</html>