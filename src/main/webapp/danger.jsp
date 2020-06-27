<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>Вопрос №3</title>
</head>
<body bgcolor="#F5FFFA">
<h3>Определение опасности от реализации рассматриваемой угрозы.</h3>
<form:form method="POST" action="danger"  modelAttribute="danger">
    <p><b>Оцените уровень ущерба от реализации угрозы:</b></p>
    <p><form:radiobutton path="dangerString" value="high"/>Высокий</p>
    <p><form:radiobutton path="dangerString" value="medium"/>Средний</p>
    <p><form:radiobutton path="dangerString" value="low"/>Низкий</p>

    <p><input type="submit" name="submit" value="Следующий вопрос"></p>
</form:form>
</body>
</html>