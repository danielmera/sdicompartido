$(document).ready(function() {
	$('#example').DataTable({
		// Hacer que por defecto no tenga seleccionado ningún filtro de
		// ordenación
		"aaSorting" : [],
		// Eliminar la paginación de la tabla
		"bPaginate" : false,
		// Eliminar el número de elementos visible en la tabla
		"bLengthChange" : false,
		// Opciones del lenguaje para los mensajes que se muestran
		language : {
			// Cambiar el lenguaje a español
			url : "//cdn.datatables.net/plug-ins/1.10.11/i18n/Spanish.json",
			// Definir el contenido del placeholder de Search
			searchPlaceholder : "Filtrar..."
		},
	});
	$('#exampleDos').DataTable({
		// Hacer que por defecto no tenga seleccionado ningún filtro de
		// ordenación
		"aaSorting" : [],
		// Eliminar la paginación de la tabla
		"bPaginate" : false,
		// Eliminar el número de elementos visible en la tabla
		"bLengthChange" : false,
		// Opciones del lenguaje para los mensajes que se muestran
		language : {
			// Cambiar el lenguaje a español
			url : "//cdn.datatables.net/plug-ins/1.10.11/i18n/Spanish.json",
			// Definir el contenido del placeholder de Search
			searchPlaceholder : "Filtrar..."
		},
		"columnDefs" : [ {
			"targets" : -1,
			"orderable" : false,
		} ]
	});
});
