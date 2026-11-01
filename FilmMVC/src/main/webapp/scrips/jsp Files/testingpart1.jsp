<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- This is my JSP page it will use 
JSTL , show casing all the records helped in the film database, 
it uses the listFilm object that I have created  
and thus will then get passed from the Servlet.
and will show a very nice form with films in a list 
showing the ID of the film , the title of the movie, the year it was made
and the stars  which are the actors -->
<head>
<meta charset="UTF-8">
<title>FilmApp</title>
</head>
<body>
<h1>Film Management Web Application</h1>
	<table>
		<tr>
			<th>Film Title: </th>
			<th>Year: </th>
			<th>Director: </th>
			<th>Stars: </th>
			<th>Review: </th>
		</tr>
			<c:forEach items="${films}" var="f" > 
			<!-- c:forEach items="${FilmList}" var="f" > -->
		<tr>
			<%-- <th>${f.getId()}</th> --%>
			<th>${f.getTitle()}</th>
			<th>${f.getYear()}</th>
			<th>${f.getDirector()}</th>
			<th>${f.getStars()}</th>
			<th>${f.getReview()}</th>
		</tr>
			</c:forEach>
	</table>

</body>
</html>
