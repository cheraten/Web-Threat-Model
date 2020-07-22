<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Admin access</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div class="header"><a><h2>Список пользователей сайта</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>
<div class="container">
    <div class="center_item">
    <table>
        <thead>
        <th>Имя</th>
        <th>Пароль</th>
        <th>Роль</th>
        </thead>
        <c:forEach items="${allUsers}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>
                    <c:forEach items="${user.roles}" var="role">${role.name} </c:forEach>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin" method="post">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="submit">Delete</button>
                    </form>

                </td>

            </tr>
        </c:forEach>
    </table>
    <div class="item">
        <a href="/">Главная</a>
    </div>
    </div>
</div>
</body>
</html>