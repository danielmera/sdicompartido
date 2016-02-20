<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ include file="comprobarNavegacion.jsp" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Página principal del usuario</title>
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
			<li><a href="principal.jsp">Home</a></li>
			<li><a href="listarViajes">Viajes</a></li>
			<li><a href="modificarperfil.jsp">Perfil</a></li>
		</ul>
		<ul class="nav navbar-nav pull-right">
			<li><a href="cerrarSesion">Cerrar Sesión</a></li>
		</ul>
	</div>
	</nav>
	Es Vd el usuario número: ${contador}
	<a href="registrarViaje.jsp">Registrar un viaje</a>
	<div class="container">
		<h3>Viajes activos</h3>
		<hr />
		<table class="table table-bordered"
			style="background-color: LightGray">
			<thead>
				<tr>
					<th>Id</th>
					<th>Origen</th>
					<th>Destino</th>
					<th>Promotor</th>
					<th>Precio</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${listaViajesActivos}" varStatus="i">
					<tr id="item_${i.index}">
						<td><a href="mostrarViaje?id=${entry.id}">${entry.id}</a></td>
						<td>${entry.departure.city}</td>
						<td>${entry.destination.city}</td>
						<td>${entry.promoterId}</td>
						<td>${entry.estimatedCost}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<h3>Viajes realizados</h3>
		<hr />
		<table class="table table-bordered"
			style="background-color: LightGray">
			<thead>
				<tr>
					<th>Id</th>
					<th>Origen</th>
					<th>Destino</th>
					<th>Promotor</th>
					<th>Precio</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${listaViajesHechos}" varStatus="i">
					<tr id="item_${i.index}">
						<td><a href="mostrarViaje?id=${entry.id}">${entry.id}</a></td>
						<td>${entry.departure.city}</td>
						<td>${entry.destination.city}</td>
						<td>${entry.promotorId}</td>
						<td>${entry.estimatedCost}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	<div class="footer navbar-fixed-bottom navbar-inner">
		<p class="text-muted" align="center">@ShareMyTrip SDI 2016</p>
	</div>
</body>
</html>
