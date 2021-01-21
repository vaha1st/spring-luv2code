<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>luv2code Home page</title>
</head>
<body>
	<h2>luv2code Home page</h2>
	<hr>
	<p>
		Welcome to luv2code Home page!
	</p>
	
	<!-- Add a logout button -->	
	
	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		 <input type="submit" value="Logout"/>
	</form:form>
</body>
</html>