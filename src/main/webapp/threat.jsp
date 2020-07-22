<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Создание угрозы</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div class="header"><a><h2>Угроза</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>

<div class="container">
    <div class="center_item">
        <form:form method="POST" action="/threat" modelAttribute="threatForm">
            <p><b>Введите название угрозы:</b></p>
            <input type="hidden" name="action" value="createThreat"/>
            <p><input name="name" type="text" placeholder="Threat name" autofocus="true"/></p>

            <p><b>Выберите информационную систему, которой принадлежит угроза:</b></p>
            <c:forEach items="${allISystems}" var="isystem">
            <p><form:radiobutton path="isystem" name="isystem_id" value="${isystem.id}"/>${isystem.name}</p>
            </c:forEach>
            <p><input type="hidden" name="probability" value="unconfined"/></p>
            <p><input type="hidden" name="feasibility" value="unconfined"/></p>
            <p><input type="hidden" name="relevance" value="unconfined"/></p>
            <p><input type="hidden" name="danger" value="unconfined"/></p>
            <p><div class="error">${nameError}</div></p>
            <p><button type="submit">Подтвердить</button></p>
        </form:form>
        <a href="/modeling">Назад</a>
    </div>
</div>

</body>
</html>