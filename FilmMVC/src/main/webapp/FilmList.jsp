<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  <!-- loads JSTL -->
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Film" %>
<!DOCTYPE html>
<html>
<head>
<title>Films DB Web Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/dist/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
		<div class="row mt-5">
		<div class= "col">
<h4>Film Db Dynamatic Web Application Lab </h4>

	<td>
		<a class="btn btn-warning " href="./add-film">
					Add Film			
		</a></td>
	<td>
		<a class="btn btn-warning " href="./searching-film">
					Search Film
		</a></td>
             
<table class= "table table-striped table-hover">
		<tr>
			<th>Film Title: </th>
			<th>Year: </th>
			<th>Director: </th>
			<th>Stars: </th>
			<th>Review: </th>
		</tr>
			<c:forEach items="${films}" var="f" >
		<tr>
			<%-- <th>${f.getId()}</th> --%>
			<td>${f.getTitle()}</td>
			<td>${f.getYear()}</td>
			<td>${f.getDirector()}</td>
			<td>${f.getStars()}</td>
			<td>${f.getReview()}</td>  
			<td><a class="btn btn-danger float-right" href="./delete-film?id=${f.getId()}" onClick="return confirm(' Dear Admin By clicking Ok you are confirming that you Wish to delete this Film')">
					Delete
					<!-- <a class="btn btn-danger float-right" href="./delete?id=${c.id}"> -->
					 <!-- 🗑️  -->
					</a><a class="btn btn-warning float-right" href="./update-film?id=${f.getId()}">
					<!-- <a class="btn btn-warning float-right" href="./edit?id=${c.id}"> -->
					     Edit
					
					 <!--✏️-->
			 </a></td>         
			</tr>
	
					
					 
			</c:forEach>
	</table>
</body>
</html>
<!--  id, String title, int year, String director, String stars -->
