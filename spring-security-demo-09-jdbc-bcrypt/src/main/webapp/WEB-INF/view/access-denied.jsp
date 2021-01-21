<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cudtom access-denied page</title>
</head>
<body>
	<h2>
		Access denied - you are not permitted to see that page by your role
	</h2>
	<hr>
	
	<a href="${pageContext.request.contextPath}/">Back to home page</a>
</body>
</html>