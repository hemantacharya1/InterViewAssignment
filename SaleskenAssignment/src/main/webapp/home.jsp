<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./Base.jsp"%>
<title>Student Reporting System</title>
</head>
<body style="background-color: #eee8ec">
	<div class="container mt-3 text-center" border-radius="50px">
		<h1 style="font-size: 60px">Welcome To Student Reporting System</h1>
		<br> <br>
		<div class="list-group">
				<a href="./home.jsp" class="list-group-item list-group-item-action"><h3>Home</h3></a> 
				<a href="./addStudent.jsp" class="list-group-item list-group-item-action"><h3>Add New Student</h3></a>
				<a href="./addMarks.jsp" class="list-group-item list-group-item-action"><h3>Edit Student Marks</h3></a> 
				<a href="./reports.jsp" class="list-group-item list-group-item-action"><h3>See Reports</h3></a>
		</div>
	</div>
</body>
</html>