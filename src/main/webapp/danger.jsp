<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>������ �3</title>
</head>
<body bgcolor="#F5FFFA">
<h3>����������� ��������� �� ���������� ��������������� ������.</h3>
<form:form method="POST" action="danger"  modelAttribute="danger">
    <p><b>������� ������� ������ �� ���������� ������:</b></p>
    <p><form:radiobutton path="dangerString" value="high"/>�������</p>
    <p><form:radiobutton path="dangerString" value="medium"/>�������</p>
    <p><form:radiobutton path="dangerString" value="low"/>������</p>

    <p><input type="submit" name="submit" value="��������� ������"></p>
</form:form>
</body>
</html>