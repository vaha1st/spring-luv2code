<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First Name: <form:input path="firstName" />

		<br><br>
	
		Last Name: <form:input path="lastName" />


		<br><br>
		
		Country : 	<form:select path="country">
						
						<form:options items="${student.countryOptions}"/>
					
					</form:select>
		
		<br><br>
		
		Favorite language: 
		<br>
		Java <form:radiobutton path="favoriteLang" value="Java"/>
		C# <form:radiobutton path="favoriteLang" value="C#"/>
		PHP <form:radiobutton path="favoriteLang" value="PHP"/>
		Ruby <form:radiobutton path="favoriteLang" value="Ruby"/>
		
		
		<br><br>
		
		OS: 
		
		MacOS <form:checkbox path="operationalSystem" value="Macos"/>
		Linux <form:checkbox path="operationalSystem" value="Linux"/>
		Windows <form:checkbox path="operationalSystem" value="Windows"/>
		
		<br><br>

		<input type="submit" value="Submit" />

	</form:form>

</body>

</html>