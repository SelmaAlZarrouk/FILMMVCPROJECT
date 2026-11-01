<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchAbility</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	   		rel="stylesheet">
</head>
<body>
	<h1> Film DB SEARCHING PAGE </h1>

	<form action="searching-film" method="POST">
			<label for="searchAbility">Search by:</label>
			<select name="searchAbility" id="searchAbility">
			<!-- for security purposes i chose not to search by Id and also convension -->
			    <option value="stars"> Star</option>
			    <option value="year"> Year</option>
			    <option value="title">Title</option>
			    <option value="director"> Director</option>
			    </select>			
				<input type="search"placeholder="Search"name="filmData">
		<!-- 	<input type="submit">  -->
		<!--  	<a class="btn btn-warning float-right" type="submit">
					<!-- <a class="btn btn-warning float-right" href="./edit?id="> -->
					<!--  Search		</a> -->
					<input type= "submit" value="submit">
				
			
			
	</form>
</body>
</html>