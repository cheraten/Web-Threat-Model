<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Новости</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div class="header"><a><h2>Моделирование угроз</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>
<div class="container">
    <ul>
        <li><h4><a href="/isystem">Добавить информационную систему</a></h4></li>
        <div class="indent"><li><h4><a href="/security_level">Определить уровень исходной защищённости системы</a></h4></li></div>
        <li><h4><a href="/threat">Добавить угрозу</a></h4></li>
        <div class="indent"><li><h4><a href="/probability">Определить вероятность реализации угрозы</a></h4></li></div>
        <div class="indent"><li><h4><a href="/danger">Определить опасность угрозы</a></h4></li></div>
    </ul>
    <div class="center_item">
        <c:forEach items="${allISystems}" var="isystem">
            <table>
            <th colspan="5">Система: ${isystem.name}, уровень исходной защищённости: ${isystem.securityLevel}</th>
            <th><form action="${pageContext.request.contextPath}/modeling" method="post">
                <input type="hidden" name="id" value="${isystem.id}"/>
                <input type="hidden" name="action" value="deleteISystem"/>
                <button type="submit">Удалить</button>
            </form>
            </th>
                <tr>
                <th>Название</th>
                <th>Вероятность реализации</th>
                <th>Реализуемость</th>
                <th>Опасность</th>
                <th>Актуальность</th>
                </tr>
                <c:forEach items="${isystem.threats}" var="threat">
                <tr>
                    <td>${threat.name}</td>
                    <td>${threat.probability}</td>
                    <td>${threat.feasibility}</td>
                    <td>${threat.danger}</td>
                    <td>${threat.relevance}</td>
                    <td>
                                 <input type="hidden" name="id" value="${threat.id}"/>
                            <input type="hidden" name="action" value="deleteThreat"/>
                            <button type="submit">Удалить</button>
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </c:forEach>

    <a href="/">Главная</a>
    </div>
</div>
</body>
</html>