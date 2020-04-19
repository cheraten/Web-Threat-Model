<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>������ �1</title>
</head>
<body>

<h3>����������� ������ �������� ������������ �������������� �������.</h3>
<form:form method="POST" action="sequritylevel"  modelAttribute="sequrityLevel">
    <p><b>����� ��������� ������������� �������������� �������?</b></p>
    <p><form:radiobutton path="sequrityLevel1" value="high"/>���������� �������������� �������</p>
    <p><form:radiobutton path="sequrityLevel1" value="medium"/>��������� �������������� �������</p>
    <p><form:radiobutton path="sequrityLevel1" value="low"/>�������������� �������������� �������</p>

    <p><b>�������� ����������, ����������� � ������� �������:</b></p>
    <p><form:checkbox path="sequrityLevel2" value="low"/>������� �� ������ �������������</p>
    <p><form:checkbox path="sequrityLevel2" value="low"/>�������, ����������� �������� ����������</p>
    <p><form:checkbox path="sequrityLevel2" value="low"/>������� � ���������� ������������</p>
    <p><form:checkbox path="sequrityLevel2" value="low"/>������� � ������������ ������������� �������</p>
    <p><form:checkbox path="sequrityLevel2" value="low"/>����-�������</p>
    <p><form:checkbox path="sequrityLevel2" value="medium"/>����������������� �������</p>

    <p><b>�������� �������� �����������, ���������� ��� ����� �������:</b></p>
    <p><form:checkbox path="sequrityLevel3" value="high"/>������� �� ������ ������� �������</p>
    <p><form:checkbox path="sequrityLevel3" value="medium"/>������� �� ������ ������������ ����</p>
    <p><form:checkbox path="sequrityLevel3" value="low"/>����-��������� �������</p>
    <p><form:checkbox path="sequrityLevel3" value="low"/>����� ��������� ������</p>
    <p><form:checkbox path="sequrityLevel3" value="low"/>������� � ��������� �������� �������������</p>
    <p><form:checkbox path="sequrityLevel3" value="medium"/>������� � ������� ������ ������������ ������</p>
    <p><form:checkbox path="sequrityLevel3" value="medium"/>������� � ����������� �����������, ����������� �� ������������ ������</p>
    <p><form:checkbox path="sequrityLevel3" value="medium"/>�������, ������������ ���������� ������ �����</p>

    <p><b>��������������� �� ������� � �������� ���������?</b></p>
    <p><form:radiobutton path="sequrityLevel4" value="low"/>���������������</p>
    <p><form:radiobutton path="sequrityLevel4" value="high"/>�� ���������������</p>

    <p><b>���������� �� ������� � ����� ������ �����������?</b></p>
    <p><form:radiobutton path="sequrityLevel5" value="low"/>����������</p>
    <p><form:radiobutton path="sequrityLevel5" value="medium"/>���������� ����� ���������� �������������� (gov.ru ��� ����)</p>
    <p><form:radiobutton path="sequrityLevel5" value="high"/>�� ����������</p>

    <p><b>��� ��������� ���������� ������� �� ��������� � �������������� ����?</b></p>
    <p><form:radiobutton path="sequrityLevel6" value="high"/>� �������� ����� �������������� ����</p>
    <p><form:radiobutton path="sequrityLevel6" value="medium"/>� �������� ���������� �������������� ���</p>
    <p><form:radiobutton path="sequrityLevel6" value="low"/>��� �������������� ����</p>

    <p><b>����� ��������� ���������� � �������:</b></p>
    <p><form:radiobutton path="sequrityLevel7" value="low"/>���������������������</p>
    <p><form:radiobutton path="sequrityLevel7" value="high"/>��������������������</p>

    <p><b>���������������� �� ����� ������� � �������?</b></p>
    <p><form:radiobutton path="sequrityLevel8" value="medium"/>����������������</p>
    <p><form:radiobutton path="sequrityLevel8" value="low"/>�� ����������������</p>

    <p><b>��� ��������� ������� �� ���������� �������������� ��������?</b></p>
    <p><form:radiobutton path="sequrityLevel9" value="medium"/>������� ����� ��� ����������������� �������� � ��������� ����� /
                                                            ��� ����������������� ������������ ��������� ������� ������ /
                                                            ��� ����������������� ������������ ���������� ������ �����</p>
    <p><form:radiobutton path="sequrityLevel9" value="low"/>�� ���������</p>

    <p><b>�������������� �� �������������� �������?</b></p>
    <p><form:radiobutton path="sequrityLevel10" value="medium"/>��������������</p>
    <p><form:radiobutton path="sequrityLevel10" value="low"/>�� ��������������</p>

    <p><input type="submit" name="submit" value="��������� ������"></p>
</form:form>
</body>
</html>