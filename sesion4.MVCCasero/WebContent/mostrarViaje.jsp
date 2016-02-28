<%@page import="javax.jws.soap.SOAPBinding.Use"%>
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
			<c:if test="${empty requestScope.previous}">
				<li><a href="listarViajes">Volver</a></li>
			</c:if>
			<c:if test="${not empty requestScope.previous}">
				<li><a href="listarViajesUsuario">Volver</a></li>
			</c:if>
		</ul>
		<ul class="nav navbar-nav pull-right">
			<li><a href="cerrarSesion">CerrarSesion</a></li>
		</ul>
	</div>
	</nav>

	<jsp:useBean id="trip" class="uo.sdi.model.Trip" scope="request" />
	<div class="container">
		<h3>Datos del viaje seleccionado</h3>
		<hr>
		<table class="table" style="background-color: white">
			<thead>
				<tr>
					<th>ID: <jsp:getProperty property="id" name="trip" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><strong>Origen:</strong> <jsp:getProperty
							property="departure" name="trip" /></td>
				</tr>
				<tr>
					<td><strong>Destino</strong>: <jsp:getProperty
							property="destination" name="trip" /></td>
				</tr>
				<tr>
					<td><strong>Fecha de salida:</strong> <jsp:getProperty
							property="departureDate" name="trip" /></td>
				</tr>
				<tr>
					<td><strong>Fecha de llegada:</strong> <jsp:getProperty
							property="arrivalDate" name="trip" /></td>
				</tr>
				<tr>
					<td><strong>Fecha de cierre:</strong> <jsp:getProperty
							property="closingDate" name="trip" /></td>
				</tr>
				<tr>
					<td><strong>Plazas libres:</strong> <jsp:getProperty
							property="availablePax" name="trip" /></td>
				</tr>
				<tr>
					<td><strong>Precio:</strong> <jsp:getProperty
							property="estimatedCost" name="trip" /></td>
				</tr>
				<tr>
					<td><strong>Estado:</strong> <jsp:getProperty
							property="status" name="trip" /></td>
				</tr>
				<tr>
					<td><strong>Promotor:</strong> <jsp:getProperty
							property="promoterId" name="trip" /></td>
				</tr>
			</tbody>
		</table>
		<c:if test="${empty requestScope.previous}">
			<button type="submit" class="btn btn-primary"
				onclick="location.href='solicitarPlaza?id=<jsp:getProperty property="id" name="trip" />'">
				SolicitarPlaza</button>
		</c:if>
	</div>
</body>
</html>