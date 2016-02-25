<%@page import="com.sun.jndi.url.iiopname.iiopnameURLContextFactory"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="comprobarUsuarioConectado.jsp" %>
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
			<li><a href="listarViajesUsuario">Home</a></li>
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
		<h3>Viajes pendientes</h3>
		<hr />
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Fecha de cierre</th>
					<th>Relacion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${viajesAux}" varStatus="i">
					<c:forEach var="viaje" items="${entry.viajes}" varStatus="j">
					<tr>
						<td><a href="mostrarViaje?id=${viaje.id}">${viaje.id}</a></td>
						<td>${viaje.closingDate}</td>
						<td>${entry.relacion}</td>
					</tr>
					</c:forEach>	
				</c:forEach>
			</tbody>
		</table>
		<br>
		<h3>Viajes realizados o cancelados</h3>
		<hr />
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Fecha de cierre</th>
					<th>Relacion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${listaViajesHechos}" varStatus="i">
					<tr id="item_${i.index}">
						<td>${entry.id}</td>
						<td>${entry.closingDate}</td>
						<td>"HECHO"</td>
					</tr>
				</c:forEach>
				<c:forEach var="entry" items="${listaViajesCancelados}" varStatus="i">
					<tr id="item_${i.index}">
						<td>${entry.id}</td>
						<td>${entry.closingDate}</td>
						<td>"CANCELADO"</td>
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
