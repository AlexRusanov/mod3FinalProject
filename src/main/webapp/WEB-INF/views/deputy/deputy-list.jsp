<%@ page import="eparliament.dto.DeputySort" %><%--<%@ page import="edu.bionic.dto.ProductSort" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EParliament | Список депутатов текущего созыва</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
<h1>Список депутатов текущего созыва</h1>
<form>
    <p>
        <label for="sort">Сортировка</label>
        <select id="sort" name="sort">
            <option value="<%= DeputySort.SURNAME_ASC.name() %>"
                    <%= DeputySort.SURNAME_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>По
                алфавиту А-Я
            </option>
            <option value="<%= DeputySort.SURNAME_DESC.name() %>"
                    <%= DeputySort.SURNAME_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>По
                алфавиту Я-А
            </option>
        </select>
    </p>
    <button type="submit">Сортировать</button>
</form>
<ul>
    <c:forEach items="${deputies}" var="deputy">
        <jsp:useBean id="deputy" type="eparliament.domain.Deputy"/>
        <li>
            <p>
                ${deputy.printInfo()}<br>
                Дата рождения ${deputy.birthday.format(dateTimeFormatter)}
            </p>
        </li>
    </c:forEach>

    <%-- Paginator --%>
    <%--<p>--%>
        <%--<c:set var="page" value="${param.page != null ? param.page : 1}"/>--%>
        <%--<c:set var="query" value="${pageContext.request.queryString != null ? pageContext.request.queryString.replaceFirst('&page=\\\\d+', '') : ''}"/>--%>
        <%--<c:forEach begin="1" end="${productCount % pageSize == 0 ? productCount / pageSize : productCount / pageSize + 1 }" varStatus="loop">--%>
            <%--<c:choose>--%>
                <%--<c:when test="${page == loop.index}">--%>
                    <%--<button type="button" disabled>${loop.index}</button>--%>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    <%--<a href="<c:url value="products?${query}&page=${loop.index}"/>">--%>
                        <%--<button type="button">${loop.index}</button>--%>
                    <%--</a>--%>
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
        <%--</c:forEach>--%>
    <%--</p>--%>
</ul>
</body>
</html>
