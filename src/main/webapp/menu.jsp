<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div class="box">
<div class="menu">
    <div class="items-column">
            <div class="img"><p><a href="/">
                <img src="https://upload.wikimedia.org/wikipedia/commons/6/68/%D0%9B%D0%BE%D0%B3%D0%BE%D1%82%D0%B8%D0%BF_%D0%92%D0%9D%D0%98%D0%98%D0%90%D0%AD%D0%A1.jpg"
                     alt="Символ" width="50" height="50"></a></p></div>
        <h3>${pageContext.request.userPrincipal.name}</h3>
        <sec:authorize access="!isAuthenticated()">
            <h4><a href="/login">Войти</a></h4>
            <h4><a href="/registration">Зарегистрироваться</a></h4>
            </div>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <h4><a href="/logout">Выйти</a></h4>
        </sec:authorize>
            <h4><a href="/modeling">Модель угроз</a></h4>
        <sec:authorize access="hasRole('ADMIN')">
            <h4><a href="/admin">Список пользователей</a></h4>
        </sec:authorize>
    </div>
</div>
</div>
</body>