<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ include file="comprobarNavegacion.jsp"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Listado de tus viajes como promotor</title>
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
			<li><a href="cerrarSesion">Cerrar Sesión</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<h3>Viajes a confirmar</h3>
		<hr />
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Origen</th>
					<th>Destino</th>
					<th>Fecha de salida</th>
					<th>Plazas</th>
					<th>Confirmación</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${viajesPromotor}" varStatus="i">
					<tr id="item_${i.index}">
						<td>${entry.id}</td>
						<td>${entry.departure.city}</td>
						<td>${entry.destination.city}</td>
						<td><fmt:formatDate type="date"
								value="${entry.departureDate}" /></td>
						<td>${entry.availablePax}</td>
						<td><div class="form-group" align="center">
								<button type="button" class="btn btn-primary"
									onclick="location.href='mostrarAplicaciones?id=${entry.id}'">Mostrar</button>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>