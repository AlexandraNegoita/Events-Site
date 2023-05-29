<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Add Event Details</title>
	<link href="css/style.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	 <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container-fluid" style="width: 100vw; height: 100vh; background-image: url(resources/0/event_header.jpg); overflow-y: hidden; overflow-x: hidden">
		<div class="row w-100" style="margin-left:0px;margin-right:0px">
			<c:import url="header.jsp"/>
		</div>
		<div class="row d-flex justify-content-center">
			<div id="title-card" style="margin-top:10vh; width: 40%; padding: 2%">
				<h3>
					(1/2) Add Event Details
				</h3>
				<form role="form" action="OrgAddEvent" enctype="multipart/form-data">
					<div class="form-group">
						<input type="text" class="form-control" name="eventName" placeholder="Event Name" id="exampleInputEventName" />
					</div>
					<select class="form-select w-100"  style="margin-bottom:2vh" name="eventSelectType" aria-label="Default select example">
					  <option selected disabled>Select Event Category</option>
					  <%
					  Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectdb","root", "toor");
    						Statement stmt = conn.createStatement();
    						String sql = "select * from events_type";
						ResultSet rs = stmt.executeQuery(sql);
							try {
								while (rs.next()) {	
							%>
								<option value=<%= rs.getString("type") %>><%= rs.getString("type") %></option>
							<%
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						%>
					</select>
					<select class="form-select w-100" style="margin-bottom:2vh" name="eventSelectCity" aria-label="Default select example">
					  <option selected disabled>Select City</option>
					  <%
          						 sql = "select * from cities";
							 rs = stmt.executeQuery(sql);
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
					
					<div class="form-group">
						<input type="date" class="form-control" name="eventDateBegin" placeholder="Date Begin" id="exampleInputDateBegin" />
					</div>
					<div class="form-group">
						<input type="date" class="form-control" name="eventDateEnd" placeholder="Date End" id="exampleInputDateEnd" />
					</div>
					
					
					<div class="form-group">
						<input type="text" class="form-control" name="eventLink" placeholder="Link to Event" id="exampleInputEventLink" />
					</div>
					<div class="form-group">
						<textarea class="form-control" name="description" placeholder="Event Description" id="exampleInputDescription" ></textarea>
					</div>
					<button type="submit" class="btn btn-primary w-100">
						Create Event
					</button>
						
					
				</form>
			</div>
		</div>
	</div>
   <script src="js/scripts.js"></script>
    
</body>
</html>