<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Página de Error</title>
<meta content="width=device-width, initial-scale=1" name="viewport" />
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="css/estilos.css" type="text/css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">ShareMyTrip</a>
		</div>
	</div>
	</nav>
	
		<%
	if (request.getAttribute("message") != null) {
	%>
	<div class="alert alert-danger">
		<%=request.getAttribute("message")%>
	</div>
	<% }%>
	
	<a class="a-center" href="login.jsp">Volver al inicio</a>
	
	<div class="footer navbar-fixed-bottom navbar-inner">
		<p class="text-muted" align="center">@ShareMyTrip SDI 2016</p>
	</div>
</body>
</html>