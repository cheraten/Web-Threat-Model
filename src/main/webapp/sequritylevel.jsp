<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>Вопрос №1</title>
    <style>
        p {
        margin-top: 0.1em;
        margin-bottom: 0.1em;
        }
        p2 {
            margin-top: 0.3em;
            margin-bottom: 0.3em;
        }
    </style>
</head>
<body bgcolor="#F5FFFA">
<h3>Определение уровня исходной защищённости информационной системы.</h3>
<form:form method="POST" action="sequritylevel"  modelAttribute="sequrityLevel">
    <p2><p><b>Какой структуре соответствует информационная система?</b></p>
    <p><form:radiobutton path="sequrityLevel1" value="high"/>Автономная информационная система</p>
    <p><form:radiobutton path="sequrityLevel1" value="medium"/>Локальная информационная система</p>
    <p><form:radiobutton path="sequrityLevel1" value="low"/>Распределенная информационная система</p></p2>

    <p2><p><b>Отметьте технологии, применяемые в составе системы:</b></p>
    <p><form:checkbox path="sequrityLevel2" value="low"/>Системы на основе виртуализации</p>
    <p><form:checkbox path="sequrityLevel2" value="low"/>Системы, реализующие облачные вычисления</p>
    <p><form:checkbox path="sequrityLevel2" value="low"/>Системы с мобильными устройствами</p>
    <p><form:checkbox path="sequrityLevel2" value="low"/>Системы с технологиями беспроводного доступа</p>
    <p><form:checkbox path="sequrityLevel2" value="low"/>Грид-системы</p>
    <p><form:checkbox path="sequrityLevel2" value="medium"/>Суперкомпьютерные системы</p></p2>

    <p2><p><b>Отметьте свойства архитектуры, подходящие для вашей системы:</b></p>
    <p><form:checkbox path="sequrityLevel3" value="high"/>Система на основе тонкого клиента</p>
    <p><form:checkbox path="sequrityLevel3" value="medium"/>Система на основе одноранговой сети</p>
    <p><form:checkbox path="sequrityLevel3" value="low"/>Файл-серверная система</p>
    <p><form:checkbox path="sequrityLevel3" value="low"/>Центр обработки данных</p>
    <p><form:checkbox path="sequrityLevel3" value="low"/>Система с удаленным доступом пользователей</p>
    <p><form:checkbox path="sequrityLevel3" value="medium"/>Система с разными типами операционных систем</p>
    <p><form:checkbox path="sequrityLevel3" value="medium"/>Система с прикладными программами, независимых от операционных систем</p>
    <p><form:checkbox path="sequrityLevel3" value="medium"/>Система, использующая выделенные каналы связи</p></p2>

    <p2><p><b>Взаимодействует ли система с внешними системами?</b></p>
    <p><form:radiobutton path="sequrityLevel4" value="low"/>Взаимодействует</p>
    <p><form:radiobutton path="sequrityLevel4" value="high"/>Не взаимодействует</p></p2>

    <p2><p><b>Подключена ли система к сетям общего пользования?</b></p>
    <p><form:radiobutton path="sequrityLevel5" value="low"/>Подключена</p>
    <p><form:radiobutton path="sequrityLevel5" value="medium"/>Подключена через выделенную инфраструктуру (gov.ru или иную)</p>
    <p><form:radiobutton path="sequrityLevel5" value="high"/>Не подключена</p></p2>

    <p2><p><b>Как размещены компоненты системы по отношению к контролируемой зоне?</b></p>
    <p><form:radiobutton path="sequrityLevel6" value="high"/>В пределах одной контролируемой зоны</p>
    <p><form:radiobutton path="sequrityLevel6" value="medium"/>В пределах нескольких контролируемых зон</p>
    <p><form:radiobutton path="sequrityLevel6" value="low"/>Вне контролируемой зоны</p></p2>

    <p2><p><b>Режим обработки информации в системе:</b></p>
    <p><form:radiobutton path="sequrityLevel7" value="low"/>Многопользовательский</p>
    <p><form:radiobutton path="sequrityLevel7" value="high"/>Однопользовательский</p></p2>

    <p2><p><b>Разграничиваются ли права доступа к системе?</b></p>
    <p><form:radiobutton path="sequrityLevel8" value="medium"/>Разграничиваются</p>
    <p><form:radiobutton path="sequrityLevel8" value="low"/>Не разграничиваются</p></p2>

    <p2><p><b>Как разделены функции по управлению информационной системой?</b></p>
    <p><form:radiobutton path="sequrityLevel9" value="medium"/>Рабочие места для администрирования выделены в отдельный домен /
                                                            для администрирования используются отдельные сетевые адреса /
                                                            для администрирования используются выделенные каналы связи</p>
    <p2><p><form:radiobutton path="sequrityLevel9" value="low"/>Не разделены</p></p2>

    <p2><p><b>Сегментирована ли информационная система?</b></p>
    <p><form:radiobutton path="sequrityLevel10" value="medium"/>Сегментирована</p>
    <p><form:radiobutton path="sequrityLevel10" value="low"/>Не сегментирована</p></p2>

    <p2><input type="submit" name="submit" value="Следующий вопрос"></p2>
</form:form>
</body>
</html>