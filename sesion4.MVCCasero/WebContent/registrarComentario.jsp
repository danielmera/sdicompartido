<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarUsuarioConectado.jsp"%>
<%@ taglib uri="http://www.uniovi.es/sdi" prefix="tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Añadir comentario</title>
<meta content="width=device-width, initial-scale=1" name="viewport" />
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Rating css -->
<link href="css/star-rating.css" media="all" rel="stylesheet"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="js/star-rating.js" type="text/javascript"></script>

<link href="css/estilos.css" type="text/css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">ShareMyTrip</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="cargarUsuarios?id=${sessionScope.tripId}">Volver</a></li>
		</ul>
		<ul class="nav navbar-nav pull-right">
			<li><a href="cerrarSesion">Cerrar sesion</a></li>
		</ul>
	</div>
	</nav>

	<!-- Mensaje de alerta para mostrar información de la operación de de registro de viajes
		al usuario registrado en caso de error -->
	<tags:messageError mensaje="${requestScope.message}" />

	<div class="container">
		<form class="form-signin" action="añadirComentario" method="POST">
			<h2 class="form-signin-heading">Añadir comentario</h2>
			<hr>
			<div class="form-group">
				<label for="vuelo">Vuelo </label> <input type="text"
					id="vuelo" class="form-control" value="${sessionScope.tripId}" disabled/>
			</div>
			<div class="form-group">
				<label for="sobre">Sobre el usuario </label> <input type="text"
					id="sobre" class="form-control" value="${sessionScope.aboutUserId}" disabled/>
			</div>
			<div class="form-group">
				<label for="input-rating">Puntuación </label> <input
					id="input-rating" name="rating" class="rating rating-loading" data-step="1" data-show-caption="false" data-animate="false" required/>
			</div>
			<div class="form-group">
				<label for="comentario">Comentario:</label>
				<textarea class="form-control" id="comentario" name="comentario"
					required></textarea>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Añadir</button>
				<button type="button" class="btn btn-primary" onclick="location.href='cargarUsuarios?id=${sessionScope.tripId}'">Cancelar</button>
			</div>
		</form>
	</div>
	<div class="footer navbar-fixed-bottom navbar-inner">
		<p class="text-muted" align="center">@ShareMyTrip SDI 2016</p>
	</div>
</body>
</html>