<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <title>Вопрос №1</title>
</head>
<body>
<div class="header"><a><h2>Определение уровня исходной защищённости информационной системы</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>

<div class="container">
<form:form method="POST" action="security_level"  modelAttribute="securityLevelForm">
    <p><b>Выберите информационную систему, для которой будет определён уровень исходной защищённости:</b></p>
    <c:forEach items="${allISystems}" var="isystem">
        <p><form:radiobutton path="isystemId" name="isystemId" value="${isystem.id}"/>${isystem.name}</p>
    </c:forEach>
    <p><div class="error">${isystemError}</div></p>

    <p><b>Какой структуре соответствует информационная система?</b></p>
    <p><form:radiobutton path="securityLevel1" value="high"/>Автономная информационная система</p>
    <p><form:radiobutton path="securityLevel1" value="medium"/>Локальная информационная система</p>
    <p><form:radiobutton path="securityLevel1" value="low"/>Распределенная информационная система</p>
    <p><div class="error">${securityLevelError1}</div></p>

    <p><b>Отметьте технологии, применяемые в составе системы:</b></p>
    <p><form:checkbox path="securityLevel2" value="low"/>Системы на основе виртуализации</p>
    <p><form:checkbox path="securityLevel2" value="low"/>Системы, реализующие облачные вычисления</p>
    <p><form:checkbox path="securityLevel2" value="low"/>Системы с мобильными устройствами</p>
    <p><form:checkbox path="securityLevel2" value="low"/>Системы с технологиями беспроводного доступа</p>
    <p><form:checkbox path="securityLevel2" value="low"/>Грид-системы</p>
    <p><form:checkbox path="securityLevel2" value="medium"/>Суперкомпьютерные системы</p></p2>
    <div class="error">${securityLevelError2}</div></p>

    <p><b>Отметьте свойства архитектуры, подходящие для вашей системы:</b></p>
    <p><form:checkbox path="securityLevel3" value="high"/>Система на основе тонкого клиента</p>
    <p><form:checkbox path="securityLevel3" value="medium"/>Система на основе одноранговой сети</p>
    <p><form:checkbox path="securityLevel3" value="low"/>Файл-серверная система</p>
    <p><form:checkbox path="securityLevel3" value="low"/>Центр обработки данных</p>
    <p><form:checkbox path="securityLevel3" value="low"/>Система с удаленным доступом пользователей</p>
    <p><form:checkbox path="securityLevel3" value="medium"/>Система с разными типами операционных систем</p>
    <p><form:checkbox path="securityLevel3" value="medium"/>Система с прикладными программами, независимых от операционных систем</p>
    <p><form:checkbox path="securityLevel3" value="medium"/>Система, использующая выделенные каналы связи</p>
    <p><div class="error">${securityLevelError3}</div></p>

    <p><b>Взаимодействует ли система с внешними системами?</b></p>
    <p><form:radiobutton path="securityLevel4" value="low"/>Взаимодействует</p>
    <p><form:radiobutton path="securityLevel4" value="high"/>Не взаимодействует</p>
    <div class="error">${securityLevelError4}</div></p>

    <p><b>Подключена ли система к сетям общего пользования?</b></p>
    <p><form:radiobutton path="securityLevel5" value="low"/>Подключена</p>
    <p><form:radiobutton path="securityLevel5" value="medium"/>Подключена через выделенную инфраструктуру (gov.ru или иную)</p>
    <p><form:radiobutton path="securityLevel5" value="high"/>Не подключена</p>
    <p><div class="error">${securityLevelError5}</div></p>

    <p><b>Как размещены компоненты системы по отношению к контролируемой зоне?</b></p>
    <p><form:radiobutton path="securityLevel6" value="high"/>В пределах одной контролируемой зоны</p>
    <p><form:radiobutton path="securityLevel6" value="medium"/>В пределах нескольких контролируемых зон</p>
    <p><form:radiobutton path="securityLevel6" value="low"/>Вне контролируемой зоны</p>
    <p><div class="error">${securityLevelError6}</div></p>

    <p><b>Режим обработки информации в системе:</b></p>
    <p><form:radiobutton path="securityLevel7" value="low"/>Многопользовательский</p>
    <p><form:radiobutton path="securityLevel7" value="high"/>Однопользовательский</p>
    <p><div class="error">${securityLevelError7}</div></p>

    <p><b>Разграничиваются ли права доступа к системе?</b></p>
    <p><form:radiobutton path="securityLevel8" value="medium"/>Разграничиваются</p>
    <p><form:radiobutton path="securityLevel8" value="low"/>Не разграничиваются</p>
    <p><div class="error">${securityLevelError8}</div></p>

    <p><b>Как разделены функции по управлению информационной системой?</b></p>
    <p><form:radiobutton path="securityLevel9" value="medium"/>Рабочие места для администрирования выделены в отдельный домен /
                                                            для администрирования используются отдельные сетевые адреса /
                                                            для администрирования используются выделенные каналы связи</p>
    <p><form:radiobutton path="securityLevel9" value="low"/>Не разделены</p>
    <p><div class="error">${securityLevelError9}</div></p>

    <p><b>Сегментирована ли информационная система?</b></p>
    <p><form:radiobutton path="securityLevel10" value="medium"/>Сегментирована</p>
    <p><form:radiobutton path="securityLevel10" value="low"/>Не сегментирована</p>
    <p><div class="error">${securityLevelError10}</div></p>

    <p2><input type="submit" name="submit" value="Подтвердить"></p2>
</form:form>
</div>
</body>
</html>