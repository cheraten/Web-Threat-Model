<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>������ �2</title>
</head>
<body>

<h3>����������� ����������� ���������� ������.</h3>
<form:form method="POST" action="probability"  modelAttribute="probability">
    <p><b>�������� �����������, ����������, �� ��� ������, ���������� ��� ����� �������:</b></p>
    <p><form:checkbox path="probabilityString" value="low"/>������� �������� (���������� ����)</p>
    <p><form:checkbox path="probabilityString" value="low"/>������ ���������</p>
    <p><form:checkbox path="probabilityString" value="medium"/>����������������, ������������� ��������, ������</p>
    <p><form:checkbox path="probabilityString" value="low"/>����, ������������ ��� ���������, �������, �������, �����-���������� � ���� �����</p>
    <p><form:checkbox path="probabilityString" value="low"/>������������ �������������� �������</p>
    <p><form:checkbox path="probabilityString" value="medium"/>�������������� �������������� ������� � �������������� ������������</p>
    <p><form:checkbox path="probabilityString" value="medium"/>����������������, �������������� �����������</p>
    <p><form:checkbox path="probabilityString" value="medium"/>���������� ������ (������������ ���������)</p>
    <p><form:checkbox path="probabilityString" value="medium"/>������������� �����������</p>
    <p><form:checkbox path="probabilityString" value="medium"/>������������, �������������, ���������� �� � ����������� �������</p>
    <p><form:checkbox path="probabilityString" value="high"/>����������� ������ ����������� ���������� (������ ����������)</p>

    <p><input type="submit" name="submit" value="��������� ������"></p>
</form:form>
</body>
</html>