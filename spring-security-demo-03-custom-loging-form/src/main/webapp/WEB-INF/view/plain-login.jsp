<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom Login Page</title>
	<style>
		.failed {
			color: red;
		}
	</style>
</head>
<body>

<h3>My Custom Login Page</h3>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
				method="post">
				
				<!-- Check for logging error -->
				<c:if test="${param.error != null}">
					<i class="failed">Sorry! You entered invalid username or password</i>
				</c:if>
				
				<p>
					User name: <input type="text" name="username"/>
				</p>
				
				<p>
					Password: <input type="password" name="password"/>
				</p>
				
				<input type="submit" name="Login">
	
	</form:form>
	
</body>
</html>