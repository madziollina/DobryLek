<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: madziollina
  Date: 26.03.19
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/user/login">

    <c:if test="${not empty errorMsg}"><span>${errorMsg}</span></c:if>


    <form:input path="email" placeholder="e-mail"/>
    <form:errors path="email"/>

    <form:password path="password" placeholder="Password"/>
    <form:errors path="password"/>

    <input type="submit" value="log in"/>
</form:form>

</body>
</html>
