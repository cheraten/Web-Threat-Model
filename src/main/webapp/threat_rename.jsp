<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Переименование угрозы</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div class="header"><a><h2>Угроза</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>
<div class="container">
    <div class="center_item">
        <form:form method="POST" action="/threat" modelAttribute="threatForm">
            <input type="hidden" name="action" value="renameThreat"/>
            <input type="hidden" value="${threat}" var="threat"/>
            <input type="hidden" name="id" value="${threat.id}"/>
            <input type="hidden" path="isystem" name="isystem_id" value="${threat.isystem.getId()}"/>
            <input type="hidden" name="probability" value="${threat.probability}"/>
            <input type="hidden" name="feasibility" value="${threat.feasibility}"/>
            <input type="hidden" name="relevance" value="${threat.relevance}"/>
            <input type="hidden" name="danger" value="${threat.danger}"/>

            <p><b>Название угрозы ${threat.name} будет изменено на:</b></p>
            <p><input name="name" type="text" placeholder="Threat name" autofocus="true"/></p>
            <p><div class="error">${nameError}</div></p>
            <p><button type="submit">Подтвердить</button></p>
        </form:form>
        <a href="/modeling">Назад</a>
    </div>
</div>

</body>
</html>