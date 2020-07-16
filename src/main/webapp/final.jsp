<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <title>Результаты тестирования</title>
</head>
<body>
<div class="header"><a><h2>Результаты тестирования</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>

<div class="container">
    <div class="center_item">
    <p>Исходный уровень защищённости системы: ${securityLevel}</p>
    <p>Вероятность реализации угрозы: ${probability}</p>
    <p>Реализуемость угрозы: ${feasibility}</p>
    <p>Опасность угрозы: ${danger}</p>
    <p>Актуальность угрозы: ${relevance}</p>
    </div>
</div>
</body>
<p></html>