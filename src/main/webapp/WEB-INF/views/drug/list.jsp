<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../base/headerLogged.jsp" %>

<div>
<c:forEach items="${drugs}" var="drug">

        <li>${drug.name}

            <a href="${pageContext.request.contextPath}/drug/form/${drug.id}">edytuj</a>
            <a href="${pageContext.request.contextPath}/drug/confirm/${drug.id}">usuń</a>
        </li>

</c:forEach>
</div>

</body>
</html>
