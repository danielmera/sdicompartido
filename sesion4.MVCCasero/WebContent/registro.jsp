<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.uniovi.es/sdi" prefix="tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Página de registro de usuarios</title>
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
		<ul class="nav navbar-nav pull-right">
			<li><a href="login.jsp">Volver a login</a></li>
		</ul>
	</div>
	</nav>
	<!-- Mensaje de alerta para mostrar información de la operación de registro al usuario PÚBLICO -->
		<tags:messageError mensaje="${requestScope.message}"/>

	<form class="form-signin" action="registrarUsuario" method="POST">
		<%-- <input id='mv' type='hidden' value='${requestScope.message}' /> --%>
		<h4 class="from-signin-heading">Registrarse como usuario</h4>
		<div class="form-group">
				<label for="login">Login:</label> <input type="text"
					class="form-control" id="login" name="login" required>
			</div>
			<div class="form-group">
				<label for="name">Nombre:</label> <input type="text"
					class="form-control" id="name" name="name" required>
			</div>
			<div class="form-group">
				<label for="apellidos">Apellidos:</label> <input type="text"
					class="form-control" id="apellidos" name="surname" required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" name="password" required>
			</div>
			<div class="form-group">
				<label for="repassword">Reintroduzca la password:</label> <input type="password"
					class="form-control" id="repassword" name="repassword" required>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Registrarse</button>
				<button type="button" class="btn btn-primary" onclick="location.href='login.jsp'">Cancelar</button>
			</div>
	</form>
	<div class="footer navbar-fixed-bottom navbar-inner">
			<p class="text-muted" align="center">@ShareMyTrip SDI 2016</p>
	</div>
</body>
</html>