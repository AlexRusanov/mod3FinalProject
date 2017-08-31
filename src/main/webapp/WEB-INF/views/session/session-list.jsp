<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EParliament | Список сессий</title>
</head>
<body>
    <h1>Список сессий текущего созыва</h1>
    <ul>
        <table border="1" cellpadding="5">
            <tr>
                <th>№</th>
                <th>Дата проведения</th>
                <th>Повестка дня</th>
                <th>Рассматриваемые законопроекты</th>
            </tr>
            <c:forEach items="${sessions}" var="session" varStatus="loop">
                <tr>
                    <td>${session.id}</td>
                    <td>${session.date.format(dateTimeFormatter)}</td>
                    <td>${session.agenda}</td>
                    <td>
                        <a href="<c:url value="/bills/${session.id}/sessionbills"/>">
                            <button>Список законопроектов</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </ul>
    <a href="<c:url value="/"/> ">
        <button>На главную</button>
    </a>
</body>
</html>
