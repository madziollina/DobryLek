<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../base/headerLogged.jsp" %>

<h2>Nowy lek</h2>

<form:form modelAttribute="drug" method="post" action="${pageContext.request.contextPath}/drug/form">
    <div>
        <form:hidden path="id"/>
    </div>
    <div>
        <form:input path="name" placeholder="name"/>
        <form:errors path="name"/>
    </div>
    <div>
        <form:input path="activeIngredient" placeholder="activeIngredient"/>
        <form:errors path="activeIngredient"/>
    </div>
    <div>
        <form:input path="activeIngredAmount" placeholder="activeIngredAmount"/>
        <form:errors path="activeIngredAmount"/>
    </div>
    <div class="checkbox">
        <label><form:checkbox path="myDrug"/>Mój lek</label>
    </div>

    <input type="submit" value="Dodaj lek"/>

</form:form>


</body>
</html>