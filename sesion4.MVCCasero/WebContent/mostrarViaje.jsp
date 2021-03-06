<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarUsuarioConectado.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Detalles del viaje</title>
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
			<li><a href="listarViajesUsuario">Home</a></li>
			<li><a href="listarViajes">Viajes</a></li>
		</ul>
		<ul class="nav navbar-nav pull-right">
			<li><a href="modificarperfil.jsp">Perfil</a></li>
			<li><a href="cerrarSesion">Cerrar Sesion</a></li>
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
		<button type="submit" class="btn btn-primary" id="solicitarPlaza"
			onclick="location.href='solicitarPlaza?id=<jsp:getProperty property="id" name="trip"/>'">
			Solicitar Plaza</button>
	</div>
</body>
</html>