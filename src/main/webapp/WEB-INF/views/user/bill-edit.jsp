<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EParliament | Законопроект: ${bill.title}</title>
</head>
<body>
<jsp:include page="../components/header.jsp"/>
    <h1>${isNew ? "Новый товар" : "Просмотр/редактирование ".concat(bill.title)}</h1>
    <form:form modelAttribute="bill">
        <form:hidden path="id"/>
        <p>
            <label for="title">Наименование</label>
            <form:input path="title"/>
            <form:errors path="title" cssStyle="color: red"/>
        </p>
        <p>
            <label for="author">Автор</label>
            <form:input path="author"/>
            <form:errors path="author" cssStyle="color: red"/>
        </p>
        <p>
            <label for="submissionDate">Дата внесения</label>
            <form:input path="submissionDate" disabled="true"/>
            <form:errors path="submissionDate" cssStyle="color: red"/>
        </p>
        <p>
            <label for="text">Текст</label><br>
            <form:textarea path="text" rows="10" cols="30"/>
        </p>
        <a href="<c:url value="/myBills"/>"><button type="button">Вернуться</button></a>
        <form:hidden path="user.id" value="${bill.user.id}"/>
        <c:if test="${bill.session.id != 0}">
            <form:hidden path="session.id" value="${bill.session.id}"/>
        </c:if>
        <button type="submit">Сохранить</button>
    </form:form>
    <c:if test="${updateIsSuccessful}">
        <span style="color: green;">Изменения сохранены</span>
    </c:if>
    <c:if test="${createIsSuccessful}">
        <span style="color: green;">Законопроект внесен</span>
    </c:if>
</body>
</html>
