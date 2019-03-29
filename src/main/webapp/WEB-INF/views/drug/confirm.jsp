<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../base/headerLogged.jsp" %>

<p>Are you sure that you want to delete drug "${drug.name}"?</p>
<a href="${pageContext.request.contextPath}/drug/list">Cancel</a>
<a href="${pageContext.request.contextPath}/drug/delete/${book.id}">Delete</a>

</body>
</html>
