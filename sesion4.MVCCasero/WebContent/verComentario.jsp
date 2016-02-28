<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarUsuarioConectado.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Listado de viajes</title>
<meta content="width=device-width, initial-scale=1" name="viewport" />
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="css/star-rating.css" media="all" rel="stylesheet" type="text/css" />	
<!-- Data Table -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Bootstrap -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="js/star-rating.js" type="text/javascript"></script>
<script>
	$("#input-rating").rating({});
</script>
<link href="css/estilos.css" type="text/css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">ShareMyTrip</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="cargarUsuarios?id=${trip_id}">Volver</a></li>
		</ul>
		<ul class="nav navbar-nav pull-right">
			<li><a href="cerrarSesion">Cerrar Sesión</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<h3>Comentario y puntuación del usuario [${comment.seatAboutUserId}]</h3>
		<hr />
		<table id="exampleDos" class="table table-striped">
			<thead>
				<tr>
					<th>Viaje</th>
					<th>Sobre</th>
					<th>Comentario</th>
					<th>Puntuación</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${comment.seatFromTripId}</td>
					<td>${comment.seatAboutUserId}</td>
					<td>${comment.comment}</td>
					<td><input id="input-rating" value="${comment.value}" class="rating rating-loading" data-readonly="true" data-show-caption="false" data-show-clear="false"/></td>
				</tr>	
			</tbody>
		</table>
	</div>
	<div class="footer navbar-fixed-bottom navbar-inner">
		<p class="text-muted" align="center">@ShareMyTrip SDI 2016</p>
	</div>
</body>
</html>