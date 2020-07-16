<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <title>Вопрос №3</title>
</head>
<body>
<div class="header"><a><h2>Определение опасности от реализации рассматриваемой угрозы</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>

<div class="container">
<form:form method="POST" action="danger"  modelAttribute="dangerForm">
    <c:forEach items="${allThreats}" var="threat">
        <p><form:radiobutton path="threatId" name="threatId" value="${threat.id}"/>угроза ${threat.name} системы ${threat.isystem.getName()}</p>
    </c:forEach>
    <p><div class="error">${threatError}</div></p>

    <p><b>Оцените уровень ущерба от реализации угрозы:</b></p>
    <p><form:radiobutton path="dangerString" value="high"/>Высокий</p>
    <p><form:radiobutton path="dangerString" value="medium"/>Средний</p>
    <p><form:radiobutton path="dangerString" value="low"/>Низкий</p>
    <p><div class="error">${dangerError}</div></p>

    <p><input type="submit" name="submit" value="Подтвердить"></p>
</form:form>
</div>
</body>
</html>