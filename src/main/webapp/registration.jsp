<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <title>Регистрация</title>
</head>

<body>
<div class="header"><a><h2>Регистрация</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>
<div class="container">
    <div class="center_item">
    <form:form method="POST" modelAttribute="userForm">
        <p><form:input type="text" path="username" placeholder="Username"
                        autofocus="true"></form:input>
            <form:errors path="username"></form:errors>
                ${usernameError} </p>
        <p><form:input type="password" path="password" placeholder="Password"></form:input></p>
        <p><form:input type="password" path="passwordConfirm"
                        placeholder="Confirm your password"></form:input>
            <form:errors path="password"></form:errors>
                ${passwordError}</p>
        <p><button type="submit">Зарегистрироваться</button></p>
    </form:form>
    <div class="item">
        <a href="/">Главная</a>
    </div>
    </div>
</div>
</body>
</html>
