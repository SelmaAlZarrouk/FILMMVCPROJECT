<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
	<title>Film DB Application</title>
</head>

<link href="/css/style.css" rel="stylesheet" type="text/css">

</head>
	
	<body>
	
 	<form action="add-film" method="POST">
		  <label id="title">Film Title:</label>  
		  <input type="text" name="title">
		  <label id="year">Year:</label>
		   <input type="text" name="year">
		  <label id="director">Director:</label>
		   <input type="text" name="director">
		  <label id="stars">Stars:</label>
		   <input type="text" name="stars">
		    <label id="review">Review:</label>
		  <input type="text" name="review" >
		  
		  
		
		  <input type="submit" value="send" >
		  
	  </form>
	</body>	
	
	
</html>
		