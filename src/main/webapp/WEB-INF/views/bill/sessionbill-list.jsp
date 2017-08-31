<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EParliament | Список законопроектов, вынесенных на сессию №${session.id}</title>
</head>
<body>
    <h1>Список законопроектов к рассмотрению</h1>
    <c:choose>
        <c:when test="${sessionbills.size() == 0}">
            Список законопроектов для данной сессии не сформирован<br>
        </c:when>
        <c:otherwise>
            <ul>
                <table border="1" cellpadding="5">
                    <tr>
                        <th>№</th>
                        <th>Название</th>
                        <th>Автор</th>
                        <th>Дата внесения законопроекта</th>
                        <th>Подробнее о законопроекте</th>
                    </tr>
                    <c:forEach items="${sessionbills}" var="sessionbill" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${sessionbill.title}</td>
                            <td>${sessionbill.author}</td>
                            <td>${sessionbill.submissionDate.format(dateTimeFormatter)}</td>
                            <td>
                                <a href="<c:url value="/bills/${session.id}/sessionbills/${sessionbill.id}"/> ">
                                    <button>+</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                    <%-- Paginator --%>
                <p>
                    <c:set var="page" value="${param.page != null ? param.page : 1}"/>
                    <c:set var="query" value="${pageContext.request.queryString != null ? pageContext.request.queryString.replaceFirst('&page=\\\\d+', '') : ''}"/>
                    <c:forEach begin="1" end="${billCount % pageSize == 0 ? billCount / pageSize : billCount / pageSize + 1 }" varStatus="loop">
                        <c:choose>
                            <c:when test="${page == loop.index}">
                                <button type="button" disabled>${loop.index}</button>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value="/bills/${session.id}/sessionbills?${query}&page=${loop.index}"/>">
                                    <button type="button">${loop.index}</button>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </p>
            </ul>
        </c:otherwise>
    </c:choose>
    <a href="<c:url value="/sessions"/> ">
        <button>К списку сессий</button>
    </a>
</body>
</html>
