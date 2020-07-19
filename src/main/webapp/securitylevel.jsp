<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <title>������ �1</title>
</head>
<body>
<div class="header"><a><h2>����������� ������ �������� ������������ �������������� �������</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>

<div class="container">
<form:form method="POST" action="security_level"  modelAttribute="securityLevelForm">
    <p><b>�������� �������������� �������, ��� ������� ����� �������� ������� �������� ������������:</b></p>
    <c:forEach items="${allISystems}" var="isystem">
        <p><form:radiobutton path="isystemId" name="isystemId" value="${isystem.id}"/>${isystem.name}</p>
    </c:forEach>
    <p><div class="error">${isystemError}</div></p>

    <p><b>����� ��������� ������������� �������������� �������?</b></p>
    <p><form:radiobutton path="securityLevel1" value="high"/>���������� �������������� �������</p>
    <p><form:radiobutton path="securityLevel1" value="medium"/>��������� �������������� �������</p>
    <p><form:radiobutton path="securityLevel1" value="low"/>�������������� �������������� �������</p>
    <p><div class="error">${securityLevelError1}</div></p>

    <p><b>�������� ����������, ����������� � ������� �������:</b></p>
    <p><form:checkbox path="securityLevel2" value="low"/>������� �� ������ �������������</p>
    <p><form:checkbox path="securityLevel2" value="low"/>�������, ����������� �������� ����������</p>
    <p><form:checkbox path="securityLevel2" value="low"/>������� � ���������� ������������</p>
    <p><form:checkbox path="securityLevel2" value="low"/>������� � ������������ ������������� �������</p>
    <p><form:checkbox path="securityLevel2" value="low"/>����-�������</p>
    <p><form:checkbox path="securityLevel2" value="medium"/>����������������� �������</p></p2>
    <div class="error">${securityLevelError2}</div></p>

    <p><b>�������� �������� �����������, ���������� ��� ����� �������:</b></p>
    <p><form:checkbox path="securityLevel3" value="high"/>������� �� ������ ������� �������</p>
    <p><form:checkbox path="securityLevel3" value="medium"/>������� �� ������ ������������ ����</p>
    <p><form:checkbox path="securityLevel3" value="low"/>����-��������� �������</p>
    <p><form:checkbox path="securityLevel3" value="low"/>����� ��������� ������</p>
    <p><form:checkbox path="securityLevel3" value="low"/>������� � ��������� �������� �������������</p>
    <p><form:checkbox path="securityLevel3" value="medium"/>������� � ������� ������ ������������ ������</p>
    <p><form:checkbox path="securityLevel3" value="medium"/>������� � ����������� �����������, ����������� �� ������������ ������</p>
    <p><form:checkbox path="securityLevel3" value="medium"/>�������, ������������ ���������� ������ �����</p>
    <p><div class="error">${securityLevelError3}</div></p>

    <p><b>��������������� �� ������� � �������� ���������?</b></p>
    <p><form:radiobutton path="securityLevel4" value="low"/>���������������</p>
    <p><form:radiobutton path="securityLevel4" value="high"/>�� ���������������</p>
    <div class="error">${securityLevelError4}</div></p>

    <p><b>���������� �� ������� � ����� ������ �����������?</b></p>
    <p><form:radiobutton path="securityLevel5" value="low"/>����������</p>
    <p><form:radiobutton path="securityLevel5" value="medium"/>���������� ����� ���������� �������������� (gov.ru ��� ����)</p>
    <p><form:radiobutton path="securityLevel5" value="high"/>�� ����������</p>
    <p><div class="error">${securityLevelError5}</div></p>

    <p><b>��� ��������� ���������� ������� �� ��������� � �������������� ����?</b></p>
    <p><form:radiobutton path="securityLevel6" value="high"/>� �������� ����� �������������� ����</p>
    <p><form:radiobutton path="securityLevel6" value="medium"/>� �������� ���������� �������������� ���</p>
    <p><form:radiobutton path="securityLevel6" value="low"/>��� �������������� ����</p>
    <p><div class="error">${securityLevelError6}</div></p>

    <p><b>����� ��������� ���������� � �������:</b></p>
    <p><form:radiobutton path="securityLevel7" value="low"/>���������������������</p>
    <p><form:radiobutton path="securityLevel7" value="high"/>��������������������</p>
    <p><div class="error">${securityLevelError7}</div></p>

    <p><b>���������������� �� ����� ������� � �������?</b></p>
    <p><form:radiobutton path="securityLevel8" value="medium"/>����������������</p>
    <p><form:radiobutton path="securityLevel8" value="low"/>�� ����������������</p>
    <p><div class="error">${securityLevelError8}</div></p>

    <p><b>��� ��������� ������� �� ���������� �������������� ��������?</b></p>
    <p><form:radiobutton path="securityLevel9" value="medium"/>������� ����� ��� ����������������� �������� � ��������� ����� /
                                                            ��� ����������������� ������������ ��������� ������� ������ /
                                                            ��� ����������������� ������������ ���������� ������ �����</p>
    <p><form:radiobutton path="securityLevel9" value="low"/>�� ���������</p>
    <p><div class="error">${securityLevelError9}</div></p>

    <p><b>�������������� �� �������������� �������?</b></p>
    <p><form:radiobutton path="securityLevel10" value="medium"/>��������������</p>
    <p><form:radiobutton path="securityLevel10" value="low"/>�� ��������������</p>
    <p><div class="error">${securityLevelError10}</div></p>

    <p2><input type="submit" name="submit" value="�����������"></p2>
</form:form>
</div>
</body>
</html>