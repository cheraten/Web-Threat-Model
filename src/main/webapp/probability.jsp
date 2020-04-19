<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>Вопрос №2</title>
</head>
<body>

<h3>Определение вероятности реализации угрозы.</h3>
<form:form method="POST" action="probability"  modelAttribute="probability">
    <p><b>Выберите нарушителей, обладающих, на ваш взгляд, мотивацией для атаки системы:</b></p>
    <p><form:checkbox path="probabilityString" value="low"/>Внешние субъекты (физические лица)</p>
    <p><form:checkbox path="probabilityString" value="low"/>Бывшие работники</p>
    <p><form:checkbox path="probabilityString" value="medium"/>Административный, обслуживающий персонал, охрана</p>
    <p><form:checkbox path="probabilityString" value="low"/>Лица, привлекаемые для установки, наладки, монтажа, пуско-наладочных и иных работ</p>
    <p><form:checkbox path="probabilityString" value="low"/>Пользователи информационной системы</p>
    <p><form:checkbox path="probabilityString" value="medium"/>Администраторы информационной системы и администраторы безопасности</p>
    <p><form:checkbox path="probabilityString" value="medium"/>Террористические, экстремистские группировки</p>
    <p><form:checkbox path="probabilityString" value="medium"/>Преступные группы (криминальные структуры)</p>
    <p><form:checkbox path="probabilityString" value="medium"/>Конкурирующие организации</p>
    <p><form:checkbox path="probabilityString" value="medium"/>Разработчики, производители, поставщики ПО и технических средств</p>
    <p><form:checkbox path="probabilityString" value="high"/>Специальные службы иностранных государств (блоков государств)</p>

    <p><input type="submit" name="submit" value="Следующий вопрос"></p>
</form:form>
</body>
</html>