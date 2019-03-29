<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../base/headerLogged.jsp" %>

<h2>Moje dane</h2>

<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/user/form">
    <div>
        <form:hidden path="id"/>
    </div><div>
    <label>Imię:</label><form:input path="firstName" placeholder="First Name"/>
    <form:errors path="firstName"/>
</div><div>
    <label>Nazwisko:</label><form:input path="lastName" placeholder="Last Name"/>
    <form:errors path="lastName"/>
</div><div>
    <label>Login:</label><form:input path="login" placeholder="Login"/>
    <form:errors path="login"/>
</div><div>
    <label>E-mail:</label><form:input path="email" placeholder="e-mail"/>
    <form:errors path="email"/>
</div><div>
    <label>Hasło:</label><form:password path="password" placeholder="Password"/>
    <form:errors path="password"/>
</div>
    <input type="submit" value="Zapisz"/>
</form:form>


</body>
</html>
