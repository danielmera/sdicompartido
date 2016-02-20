<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarNavegacion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Listado de viajes</title>
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
			<li><a href="login.jsp">Login</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<h3>Viajes disponibles</h3>
		<hr />
		<table class="table table-bordered"
			style="background-color: LavenderBlush">
			<thead>
				<tr>
					<th>Id</th>
					<th>Origen</th>
					<th>Destino</th>
					<th>Plazas</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${listaViajes}" varStatus="i">
					<tr id="item_${i.index}">
						<td><a href="mostrarViaje?id=${entry.id}">${entry.id}</a></td>
						<td>${entry.departure.city}</td>
						<td>${entry.destination.city}</td>
						<td>${entry.availablePax}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="registrarViaje.jsp">Registrar viaje</a>
</body>
</html>