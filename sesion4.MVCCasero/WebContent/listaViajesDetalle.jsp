<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarUsuarioConectado.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Listado de viajes</title>
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
			<li><a href="listarViajesUsuario">Home</a></li>
			<li><a href="listarViajes">Viajes</a></li>
			<li><a href="modificarperfil.jsp">Perfil</a></li>
		</ul>
		<ul class="nav navbar-nav pull-right">
			<li><a href="cerrarSesion">Cerrar Sesión</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<h3>Viajes disponibles</h3>
		<hr />
		<table id="exampleDos" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>ID viaje</th>
					<th>Fecha Cierre</th>
					<th>Fecha Llegada</th>
					<th>Fecha Salida</th>
					<th>Ciudad Origen</th>
					<th>País Origen</th>
					<th>Ciudad Destino</th>
					<th>País Destino</th>
					<th>Plazas libres</th>
					<th>Precio</th>
					<th>Estado</th>
					<th>Promotor</th>
					<th>Comentarios</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${listaViajes}" varStatus="i">
					<tr id="item_${i.index}">
						<c:set var="previous" scope="session" value="viajes"></c:set>
						<td><a href="cargarViaje?id=${entry.id}">${entry.id}</a></td>
						<td><fmt:formatDate type="both" value="${entry.closingDate}" /></td>
						<td><fmt:formatDate type="both" value="${entry.arrivalDate}" /></td>
						<td><fmt:formatDate type="both"
								value="${entry.departureDate}" /></td>
						<td>${entry.departure.city}</td>
						<td>${entry.departure.country}</td>
						<td>${entry.destination.city}</td>
						<td>${entry.destination.country}</td>
						<td>${entry.availablePax}</td>
						<td>${entry.estimatedCost}$</td>
						<td>${entry.status}</td>
						<td>${entry.promoterId}</td>
						<td><a class="btn btn-info"
							href="cargarComentarios?trip_id=${entry.id}">Ver comentarios</a></td>
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