<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div class="header"><a><h2>Вход в систему</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
<div class="container">
    <div class="center_item">
    <form method="POST" action="/login">
        <p><input name="username" type="text" placeholder="Username" autofocus="true"/></p>
        <p><input name="password" type="password" placeholder="Password"/></p>
        <p><button type="submit">Войти</button></p>
    </form>
    <div class="item">
        <a href="/registration">Зарегистрироваться</a>
    </div>
    </div>
</div>

</body>
</html>