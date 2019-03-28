<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DobryLek</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/drug/form">Dodaj lek</a>
<a href="${pageContext.request.contextPath}/drug/list">Apteczka</a>
<a href="${pageContext.request.contextPath}/myDrug/list">Moje leki</a>
<a href="${pageContext.request.contextPath}/allergy/list">Alergie</a>
<a href="${pageContext.request.contextPath}/charge/list">Podopieczni</a>
<a href="${pageContext.request.contextPath}/user/form/${user.id}">Moje dane</a>

<a href="${pageContext.request.contextPath}/user/logout">Wyloguj</a>

<hr>

