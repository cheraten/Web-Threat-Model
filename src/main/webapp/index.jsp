<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div class="header"><a><h2>Главная страница</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>
<div class="container">
    <div class="center_item">
    Этот сайт посвящён автоматизации деятельности по модеелированию угроз.
    </div>
</div>
</body>
</html>