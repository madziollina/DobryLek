<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="../base/header.jsp" %>

<form:form method="post" modelAttribute="connect">
    <div>
    <form:input path="drug1" placeholder="Pierwszy lek"/>
    <form:errors path="drug1"/>
    </div><div>
    <form:input path="drug2" placeholder="Drugi lek"/>
    <form:errors path="drug2"/>
    <input type="submit" value="Sprawdź">
</div>
</form:form>

</body>
</html>
