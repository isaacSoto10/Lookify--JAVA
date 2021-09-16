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
			<h2 class="left">Top Ten Songs:</h2>
			<a href="/Dashboard"><h2 class="right">Dashboard</h2></a>
		</div>
		<ul>
			<c:forEach items="${songs}" var="song">
				<li>
					<h2><c:out value="${song.rating}"/> - <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> - <c:out value="${song.artist}"/></h2>
				</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>