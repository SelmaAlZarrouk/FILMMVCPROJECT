<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
	<h1>edit film</h1>
	<form action="update-film" method="POST">
	<label id="title">Title</label>
    <input type="text" id="title" name="title" value="${film.getTitle()}"><br>
    <label id="year">Year</label>    
    <input type="text" id="director" name="director" value="${film.getDirector()}"><br>
    <label id="stars">Stars</label>
    <input type="text" id="year" name="year" value="${film.getYear()}"><br>
    <label id="director">Director</label>
    <input type="text" id="stars" name="stars" value="${film.getStars()}"><br>
    <label id="review">Review</label>
    <input type="text" id="review" name="review" value="${film.getReview()}"><br>
    <input type="submit" name="id" value="${film.getId()}">
	</form>



</body>
</html>