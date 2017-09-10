<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EParliament | Список внесенных Вами законопроектов</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
    <h1>Список внесенных Вами законопроектов</h1>
    <c:choose>
        <c:when test="${userBills.size() == 0}">
            Вы не вносили законопроекты
        </c:when>
        <c:otherwise>
            <ul>
                <table border="1" cellpadding="5">
                    <tr>
                        <th>№</th>
                        <th>Название</th>
                        <th>Дата внесения законопроекта</th>
                        <th>Просомтр/редактирование</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${userBills}" var="userbill" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${userbill.title}</td>
                            <td>${userbill.submissionDate.format(dateTimeFormatter)}</td>
                            <td>
                                <a href="<c:url value="/myBills/${userbill.id}"/> ">
                                    <button>+</button>
                                </a>
                            </td>
                            <td>
                                <form method="post" action="<c:url value="/myBills/${userbill.id}/delete"/>">
                                    <button type="submit">Удалить</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </ul>
        </c:otherwise>
    </c:choose>
    <a href="<c:url value="/myBills/newBill"/>">
        <button type="button">Внести новый законопроект</button>
    </a>
</body>
</html>
