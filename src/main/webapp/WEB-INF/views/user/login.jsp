<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../base/header.jsp" %>

<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/user/login">

    <c:if test="${not empty errorMsg}"><span>${errorMsg}</span></c:if>

    <div>
    <label>E-mail:</label><form:input path="email" placeholder="e-mail"/>
    <form:errors path="email"/>
    </div><div>
    <label>Hasło:</label><form:password path="password" placeholder="Password"/>
    <form:errors path="password"/>
</div>
    <input type="submit" value="Zaloguj"/>
</form:form>

</body>
</html>
