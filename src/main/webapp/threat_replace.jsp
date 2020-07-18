<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div class="header"><a><h2>Угроза</h2></a></div>
<div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>

<div class="container">
    <div class="center_item">
        <form:form method="POST" action="/threat" modelAttribute="threatForm">
            <input type="hidden" name="action" value="replaceThreat"/>
            <input type="hidden" value="${threat}" var="threat"/>
            <input type="hidden" name="id" value="${threat.id}"/>
            <c:forEach items="${allISystems}" var="isystem">
                <p><form:radiobutton path="isystem" name="isystem_id" value="${isystem.id}"/>${isystem.name}</p>
            </c:forEach>
            <p><input type="hidden" name="name" value="${threat.name}"/></p>
            <p><input type="hidden" name="probability" value="${threat.probability}"/></p>
            <p><input type="hidden" name="feasibility" value="${threat.feasibility}"/></p>
            <p><input type="hidden" name="relevance" value="${threat.relevance}"/></p>
            <p><input type="hidden" name="danger" value="${threat.danger}"/></p>
            <p><div class="error">${nameError}</div></p>
            <p><button type="submit">submit</button></p>
        </form:form>
    </div>
</div>

</body>
</html>