<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@ include file="comprobarNavegacion.jsp"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Modificar Perfil de Usuario</title>
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
	<!-- Código para mostrar mensajes informativos sobre la operación actualizar positivos-->
	<%
		if (request.getAttribute("messageSuccess") != null) {
	%>
	<div class="alert alert-success">
		<%=request.getAttribute("messageSuccess")%>
	</div>
	<%
		}
	%>
	<!-- Código para mostrar mensajes informativos sobre la operación actualizar negativos-->
	<%
		if (request.getAttribute("message") != null) {
	%>
	<div class="alert alert-danger">
		<%=request.getAttribute("message")%>
	</div>
	<%
		}
	%>
	<jsp:useBean id="user" class="uo.sdi.model.User" scope="session" />
	<div class="container">
		<form action="modificarDatos" class="form-signin">
			<h4 class="from-signin-heading">Perfil</h4>
			<div class="form-group">
				<label for="login">Login:</label> <input type="text" name="login"
					class="form-control" id="name" value="<jsp:getProperty property="login" name="user"/>" disabled>
			</div>
			<div class="form-group">
				<label for="name">Nombre:</label> <input type="text" name="name"
					class="form-control" id="name" value="<jsp:getProperty property="name" name="user"/>">
			</div>
			<div class="form-group">
				<label for="apellidos">Apellidos:</label> <input type="text" name="surname"
					class="form-control" id="apellidos" value="<jsp:getProperty property="surname"name="user" />">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email" name="email"
					class="form-control" id="email" value="<jsp:getProperty property="email" name="user"/>">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password" name="pass"
					class="form-control" id="password" value="<jsp:getProperty property="password" name="user"/>">
			</div>
			<div class="form-group">
				<label for="repassword">Reintroduzca la password:</label> <input type="password" name="repass"
					class="form-control" id="repassword" value="<jsp:getProperty property="password" name="user"/>">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Modificar</button>
				<button type="button" class="btn btn-primary" onclick="location.href='listarViajesUsuario'">Cancelar</button>
			</div>
		</form>
	</div>
	<div class="footer navbar-fixed-bottom navbar-inner">
			<p class="text-muted" align="center">@ShareMyTrip SDI 2016</p>
	</div>
</body>
</html>