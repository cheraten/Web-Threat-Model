<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>Результаты тестирования</title>
</head>
<body bgcolor="#F5FFFA">
<h3>Результаты тестирования:</h3>
<p>Исходный уровень защищённости системы: ${sequrityLevel}</p>
<p>Вероятность реализации угрозы: ${probability}
<p>Реализуемость угрозы: ${feasibility}
<p>Опасность угрозы: ${danger}
<p>Актуальность угрозы: ${relevance}
<p></body>
<p></html>