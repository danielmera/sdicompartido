<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${requestScope.jspSiguiente==null}">
	<% request.setAttribute("message", "URL inv�lida, no se puede acceder a esta p�gina"); %>
	<jsp:forward page="error.jsp" />
</c:if>
