<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../base/headerLogged.jsp" %>

<div>
    <h3>Lista leków:</h3>
<c:forEach items="${drugs}" var="drug">

        <li>${drug.name}

            <a href="${pageContext.request.contextPath}/drug/form/${drug.id}">edytuj</a>
            <a href="${pageContext.request.contextPath}/drug/confirm/${drug.id}">usuń</a>
        </li>

</c:forEach>
</div>

</body>
</html>
