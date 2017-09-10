<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div style="background: ghostwhite">
    <a href="<c:url value="/"/> ">
        <button>Главная</button>
    </a>

    <sec:authorize access="isAuthenticated()">
        <form:form servletRelativeAction="/logout" cssStyle="float: right">
            <button>Выйти</button>
        </form:form>
        <sec:authorize url="/myBills">
            <a href="<c:url value="/myBills"/>">
                <button>Мои законопроекты</button>
            </a>
        </sec:authorize>
        <b style="float: right">Добро пожаловать, ${loggedUser.deputy.surname} ${loggedUser.deputy.name} </b>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <a href="<c:url value="/login"/>" style="float: right">
            <button>Войти</button>
        </a>
        <a href="<c:url value="/register"/>" style="float: right">
            <button>Зарегистрироваться</button>
        </a>
    </sec:authorize>
</div>
