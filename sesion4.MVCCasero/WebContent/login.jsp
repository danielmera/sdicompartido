<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.uniovi.es/sdi" prefix="tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Inicie sesión</title>
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
		<ul class="nav navbar-nav">
			<li><a href="listarViajes">Ver viajes</a></li>
		</ul>
		<ul class="nav navbar-nav pull-right">
			<li><a href="registro.jsp">Registrarse</a></li>
		</ul>
	</div>
	</nav>
	<!-- Mensaje de alerta para mostrar información de la operación de registro de viajes al 
		usuario registrado en caso de éxito-->
	<tags:messageSuccess mensaje="${requestScope.messageSuccess}" />

	<!-- Código para mostrar mensajes informativos en caso de validarse incorrectamente -->

	<tags:messageError mensaje="${requestScope.message}" />

	<div class="container">
		<form class="form-signin" action="validarse" method="post">
			<h3 class="form-signin-heading">Iniciar sesión</h3>
			<hr>
			<br>
			<div class="form-group">
				<label for="nombreUsuario">Login:</label> <input type="text"
					class="form-control" id="nombreUsuario" name="nombreUsuario"
					placeholder="Enter login">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Enter password">
			</div>
			<button type="submit" class="btn btn-primary btn-block">Aceptar</button>
		</form>
	</div>
	<div class="footer navbar-fixed-bottom navbar-inner">
		<p class="text-muted" align="center">@ShareMyTrip SDI 2016</p>
	</div>
</body>
</html>