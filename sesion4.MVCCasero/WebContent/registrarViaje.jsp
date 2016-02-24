<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="comprobarUsuarioConectado.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Página de registro de usuarios</title>
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
		</ul>
	</div>
	</nav>
	<!-- Mensaje de alerta para mostrar información de la operación de registro de viajes al 
		usuario registrado en caso de éxito-->
	<%
		if (request.getAttribute("messageSuccess") != null) {
	%>
	<div class="alert alert-success">
		<%=request.getAttribute("messageSuccess")%>
	</div>
	<%
		}
	%>
	<!-- Mensaje de alerta para mostrar información de la operación de de registro de viajes
		al usuario registrado en caso de error -->
	<%
		if (request.getAttribute("message") != null) {
	%>
	<div class="alert alert-danger">
		<%=request.getAttribute("message")%>
	</div>
	<%
		}
	%>
	<div class="container">
		<form action="registrarViaje" method="POST">
			<h2 class="from-signin-heading">Registrar un viaje</h2>
			<hr>
			<div class="row">
				<div class="col-md-6">
					<h3 class="from-signin-heading">Lugar de salida</h3>
					<div class="form-group">
						<label for="calle">Calle:</label> <input type="text"
							class="form-control" id="calle" name="calle" required>
					</div>
					<div class="form-group">
						<label for="ciudad">Ciudad:</label> <input type="text"
							class="form-control" id="ciudad" name="ciudad" required>
					</div>
					<div class="form-group">
						<label for="provincia">Provincia:</label> <input type="text"
							class="form-control" id="provincia" name="provincia" required>
					</div>
					<div class="form-group">
						<label for="pais">País:</label> <input type="text"
							class="form-control" id="pais" name="pais" required>
					</div>
					<div class="form-group">
						<label for="zipcode">ZIP Code:</label> <input type="text"
							class="form-control" id="zipcode" name="zipcode" required>
					</div>
					<div class="form-group">
						<label for="latitud">Latitud:</label> <input type="text"
							class="form-control" id="latitud" name="latitud" required>
					</div>
					<div class="form-group">
						<label for="longitud">Longitud:</label> <input type="text"
							class="form-control" id="longitud" name="longitud" required>
					</div>
					<br>
					<div class="form-group">
						<label for="fechasalida">Fecha salida:</label> <input
							type="datetime-local" class="form-control" id="fechasalida"
							name="fechasalida" required>
					</div>
					<br>
					<div class="form-group">
						<label for="fechalimite">Fecha límite para apuntarse:</label> <input
							type="datetime-local" class="form-control" id="fechalimite"
							name="fechalimite" required>
					</div>
					<br>
					<div class="form-group">
						<label for="comentarios">Comentarios:</label> <input type="text"
							class="form-control" id="comentarios" name="comentarios" required>
					</div>
					
				</div>
				<div class="col-md-6">
					<h3 class="from-signin-heading">Lugar de destino</h3>
					<div class="form-group">
						<label for="calledest">Calle:</label> <input type="text"
							class="form-control" id="calledest" name="calledest" required>
					</div>
					<div class="form-group">
						<label for="ciudaddest">Ciudad:</label> <input type="text"
							class="form-control" id="ciudaddest" name="ciudaddest" required>
					</div>
					<div class="form-group">
						<label for="provinciadest">Provincia:</label> <input type="text"
							class="form-control" id="provinciadest" name="provinciadest"
							required>
					</div>
					<div class="form-group">
						<label for="paisdest">País:</label> <input type="text"
							class="form-control" id="paisdest" name="paisdest" required>
					</div>
					<div class="form-group">
						<label for="zipcodedest">ZIP Code:</label> <input type="text"
							class="form-control" id="zipcodedest" name="zipcodedest" required>
					</div>
					<div class="form-group">
						<label for="latituddest">Latitud:</label> <input type="text"
							class="form-control" id="latituddest" name="latituddest" required>
					</div>
					<div class="form-group">
						<label for="longituddest">Longitud:</label> <input type="text"
							class="form-control" id="longituddest" name="longituddest"
							required>
					</div>
					<br>
					<div class="form-group">
						<label for="fechallegada">Fecha estimada de llegada:</label> <input
							type="datetime-local" class="form-control" id="fechallegada"
							name="fechallegada" required>
					</div>
					<br>
					<div class="form-group">
						<label for="coste">Coste estimado:</label> <input type="text"
							class="form-control" id="coste" name="coste" required>
					</div>
					<br>
					<div class="form-group">
						<label for="maxpax">Número máximo de plazas:</label> <input
							type="text" class="form-control" id="maxpax" name="maxpax"
							required>
					</div>
				</div>
				<div class="form-group" align="center">
					<button type="submit" class="btn btn-primary">Registrar
						viaje</button>
					<button type="button" class="btn btn-primary"
						onclick="location.href='listarViajesUsuario'">Cancelar</button>
				</div>
			</div>
		</form>
	</div>
	<div class="footer navbar-fixed-bottom navbar-inner">
		<p class="text-muted" align="center">@ShareMyTrip SDI 2016</p>
	</div>
</body>
</html>