<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Add Event Thumbnail</title>
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
					(2/2) Add Event Thumbnail
				</h3>
				<form method="post" action="AddEventThumbnail" enctype="multipart/form-data">
					<div class="custom-file" style="margin-bottom:2vh">
					    <input type="file" class="custom-file-input" name="eventThumb" id="exampleInputFile">
					    <label class="custom-file-label" for="exampleInputFile">Choose thumbnail</label>
				    </div>
				    <script type="application/javascript">
					    $('input[type="file"]').change(function(e){
					        var fileName = e.target.files[0].name;
					        $('.custom-file-label').html(fileName);
					    });
					</script>
					<div class="input-group-append">
					    <button class="btn btn-outline-secondary" type="submit">Submit Thumbnail</button>
					 </div>
				</form>
			</div>
		</div>
	</div>
   <script src="js/scripts.js"></script>
    
</body>
</html>