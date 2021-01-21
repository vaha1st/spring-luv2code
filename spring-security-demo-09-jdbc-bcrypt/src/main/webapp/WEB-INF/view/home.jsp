<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
	
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
	
	<hr>
		
		<!-- Display user name and role -->
		
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s: <security:authentication property="principal.authorities"/>)
		</p>
	
	<!-- Add link to /leaders -->
	<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href = "${pageContext.request.contextPath}/leaders">Leadership Meeting </a> 
		(Only for managers)
	</p>
	</security:authorize>
	
	<!-- Add link to /systems for admins -->
	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href = "${pageContext.request.contextPath}/systems">IT System Meeting </a> 
		(Only for admin peeps)
	</p>
	</security:authorize>
	
	<hr>
	
	<!-- Add a logout button -->	
	
	<form:form action="${pageContext.request.contextPath}/logout" method="post">
		 <input type="submit" value="Logout"/>
	</form:form>
</body>
</html>