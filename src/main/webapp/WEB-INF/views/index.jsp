<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EParliament | Главная</title>
</head>
<body>
<jsp:include page="components/header.jsp"/>
    <h1>Официальный веб-портал Нашего Парламента</h1>
    <ul>
        <li><a href="<c:url value="/deputies"/>">Список депутатов текущего созыва</a></li>
        <li><a href="<c:url value="/sessions"/>">Список сессий текущего созыва</a></li>
    </ul>
</body>
</html>
