<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarUsuarioConectado.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.uniovi.es/sdi" prefix="tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Usuarios</title>
<meta content="width=device-width, initial-scale=1" name="viewport" />
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css"
	rel="stylesheet" />
<!-- Data Table -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min.js"></script>
<!-- Bootstrap -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="js/datatable.js"></script>
<link href="css/estilos.css" type="text/css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">ShareMyTrip</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="listarViajesUsuario">Volver</a></li>
		</ul>
		<ul class="nav navbar-nav pull-right">
			<li><a href="cerrarSesion">Cerrar Sesión</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<h3>Promotor y pasajeros del viaje</h3>
		<hr />
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th style="visibility:hidden"></th>
					<th>Identificador</th>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Email</th>
					<th>Añadir comentario</th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>Promotor</td>
						<td>${promotor.id}</td>
						<td>${promotor.name}</td>
						<td>${promotor.surname}</td>
						<td>${promotor.email}</td>
						<td><tags:addcomment aboutTripId="${requestScope.trip_id}" aboutUserId="${promotor.id}" /></td>
					</tr>
				<c:forEach var="entry" items="${pasajeros}" varStatus="i">
					<tr id="item_${i.index}">
						<td>Pasajero</td>
						<td>${entry.id}</td>
						<td>${entry.name}</td>
						<td>${entry.surname}</td>
						<td>${entry.email}</td>
						<td><tags:addcomment aboutTripId="${requestScope.trip_id}" aboutUserId="${entry.id}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="footer navbar-fixed-bottom navbar-inner">
		<p class="text-muted" align="center">@ShareMyTrip SDI 2016</p>
	</div>
</body>
</html>