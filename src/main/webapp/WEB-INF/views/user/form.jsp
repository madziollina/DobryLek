<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="../base/header.jsp" %>

<h2>Formularz rejestracji</h2>

<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/user/form">
    <div>
        <form:hidden path="id"/>
    </div><div>
    <label>Imię:</label><form:input path="firstName" placeholder="First Name"/>
    <form:errors path="firstName"/>
</div><div>
    <form:input path="lastName" placeholder="Last Name"/>
    <form:errors path="lastName"/>
</div><div>
    <form:input path="login" placeholder="Login"/>
    <form:errors path="login"/>
</div><div>
    <form:input path="email" placeholder="e-mail"/>
    <form:errors path="email"/>
</div><div>
    <form:password path="password" placeholder="Password"/>
    <form:errors path="password"/>
</div>
    <input type="submit" value="Zapisz"/>
</form:form>


</body>
</html>
