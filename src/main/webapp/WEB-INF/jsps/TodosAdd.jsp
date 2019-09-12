<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todos Add</title>
</head>
<body>

	<form:form method="POST" action="/jquery-app/add-todo-by-form" modelAttribute="todos">
	
		<table>
			<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id"/></td>
			</tr>
			
			<tr>
				<td><form:label path="status">Status</form:label></td>
				<td><form:input path="status"/></td>
			</tr>
			
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input path="description"/></td>
			</tr>
		
			<tr>
				<td><form:label path="date">Date</form:label></td>
				<td><form:input path="date"/></td>
			</tr>
			
			<tr>			
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>