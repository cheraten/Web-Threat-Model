<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <title>������ �2</title>
</head>
<body>
<div class="header"><a><h2>����������� ����������� ���������� ������</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>

<div class="container">
<form:form method="POST" action="probability"  modelAttribute="probabilityForm">
    <p><b>�������� ������, ��� ������� ����� ���������� ����������� ����������:</b></p>
    <c:forEach items="${allThreats}" var="threat">
        <p><form:radiobutton path="threatId" name="threatId" value="${threat.id}"/>������ ${threat.name} ������� ${threat.isystem.getName()}</p>
    </c:forEach>
    <p><div class="error">${threatError}</div></p>

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
    <p><div class="error">${probabilityError}</div></p>

    <p><input type="submit" name="submit" value="�����������"></p>
</form:form>
</div>
</body>
</html>