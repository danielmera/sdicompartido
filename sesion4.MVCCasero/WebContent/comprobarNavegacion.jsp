<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${requestScope.servletPath=='/cargarViaje'}">
	<% request.setAttribute("message", "URL inválida, no se puede acceder a esta página"); %>
	<jsp:forward page="error.jsp" />
</c:if>
