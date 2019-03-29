<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../base/headerLogged.jsp" %>

<form:form modelAttribute="drugUser" method="post" action="${pageContext.request.contextPath}/drug/myDrug">

<div>
    <form:input path="myDoze" placeholder="Moja dawka"/>
    <form:errors path="myDoze"/>
</div>
<div>
    <form:input path="time" placeholder="hh:mm"/>
    <form:errors path="time"/>

</div>

    <input type="submit" value="Dodaj mój lek"/>
</form:form>

<br>

</body>
</html>
