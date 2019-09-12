<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Todos List</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/custom.css" rel="stylesheet">
</head>
<body>

<div class="container">
	<table class="table table-striped">
		
		<caption>Your Todos are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Done?</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="todo" items="${todosList}">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.id}</td>
					<td>${todo.status}</td>
					<td><a class="btn btn-warning" href="/jquery-app/edit-todo">Edit</a></td>
					<td><a class="btn btn-warning" href="/jquery-app/delete-todo?id=${todo.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<a class="btn btn-default" href="/jquery-app/add-todos-home">Add a Todo</a>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="js/custom.js"></script>
</div>
</body>
</html>