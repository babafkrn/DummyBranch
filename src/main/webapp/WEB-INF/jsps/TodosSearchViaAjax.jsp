<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Todos Search</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/custom.css" rel="stylesheet">
</head>
<body>

<h3>Search Todos</h3>

<div id="feedback"></div>

<div class="container" style="min-height: 500px">

	<div class="starter-template">
		
		<form class="form-horizonal" id="search-form">
		
			<div class="form-group form-group-lg">
				
				<label class="col-sm-2 control-label">Enter Status</label>
				
				<div class="col-sm-10">
					<input type="text" class="form-control" id="status"/>
				</div>
			</div>
		
			<div class="form-group">
			
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="btn-search" class="btn btn-primary btn-lg">Search</button>
				</div>
			</div>
		
		</form>
	</div>
</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="js/todos.js"></script>
</body>
</html>