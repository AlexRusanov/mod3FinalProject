<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EParliament | Законопроект: ${bill.title} </title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
    <h1>Законопроект: ${bill.title}</h1>
    <div>
        Дата внесения законопроекта: ${bill.submissionDate.format(dateTimeFormatter)}<br>
        Автор: ${bill.author}<br>
        <br>
        ${bill.text}
    </div>
    <div>
        <h3>Результаты голосования</h3>
        <c:choose>
            <c:when test="${billVoting.size() == 0}">
                Данный законопроект не проголосован
            </c:when>
            <c:otherwise>
                <c:forEach items="${billVoting}" var="voting">
                    <p>
                        <strong>${voting.deputy.surname} ${voting.deputy.name}</strong> <br>
                            ${voting.vote}
                    </p>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
    <a href="<c:url value="/bills/${billSession.id}/sessionbills"/> ">
        <button>Назад к списку законопроектов сессии №${billSession.id}</button>
    </a>
</body>
</html>
