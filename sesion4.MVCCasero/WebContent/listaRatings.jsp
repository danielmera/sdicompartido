<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>ShareMyTrip - Comentarios viaje</title>
<meta content="width=device-width, initial-scale=1" name="viewport" />
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css"
	rel="stylesheet" />
<!-- Rating css -->	
<link href="css/star-rating.css" media="all" rel="stylesheet" type="text/css" />	
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
<script src="js/star-rating.js" type="text/javascript"></script>
<link href="css/estilos.css" type="text/css" rel="stylesheet">
<script>
	$("#input-rating").rating({});
</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">ShareMyTrip</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="listarViajes">Volver</a></li>
		</ul>
		<ul class="nav navbar-nav pull-right">
			<li><a href="cerrarSesion">CerrarSesion</a></li>
		</ul>
	</div>
	</nav>
	<div class="container">
		<h3>Comentarios del viaje</h3>
		<hr />
		<table id="exampleDos" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>De</th>
					<th>Sobre</th>
					<th>Comentario</th>
					<th>Puntuación</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${ratings}" varStatus="i">
					<tr id="item_${i.index}">
						<td>${entry.seatFromUserId}</td>
						<td>${entry.seatAboutUserId}</td>
						<td>${entry.comment}</td>
						<td><input id="input-rating" value="${entry.value}" class="rating rating-loading" data-readonly="true" data-show-caption="false" data-show-clear="false"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>