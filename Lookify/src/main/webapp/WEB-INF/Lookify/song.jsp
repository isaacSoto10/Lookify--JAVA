<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="top1">
			<a href="/Dashboard"><h2 class="right">Dashboard</h2></a>
		</div>
		<h2>Title:  <c:out value="${song.title}"/></h2>
		<h2>Artist:  <c:out value="${song.artist}"/></h2>
		<h2>Rating (1-10):  <c:out value="${song.rating}"/></h2>
		<a href="/delete/<c:out value="${song.id}"/>"><h2>Delete</h2></a>
	</div>
</body>
</html>