<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EParliament | Главная</title>
</head>
<body>
    <h1>Официальный веб-портал Нашего Парламента</h1>
    <ul>
        <li><a href="<c:url value="/deputies"/>">Список депутатов текущего созыва</a></li>
        <li><a href="<c:url value="/sessions"/>">Список сессий текущего созыва</a></li>
    </ul>
</body>
</html>
