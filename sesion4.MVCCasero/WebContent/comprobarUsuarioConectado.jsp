<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.user==null}">
	<%session.invalidate();
	request.setAttribute("message", "URL restringida, debes de logearte para poder acceder"); %>
	<jsp:forward page="error.jsp" />
</c:if>