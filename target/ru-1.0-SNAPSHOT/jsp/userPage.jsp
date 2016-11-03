<%--
  Created by IntelliJ IDEA.
  User: lenar
  Date: 21.10.16
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>PhotoGram</title>
    <link href="${pageContext.request.contextPath}/resources/css/userPageStylee.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/SearchJS.js"></script>
</head>
<body>

<div class="about">
    <h1>PhotoGram</h1>
    <form method="post">
        <input type="text" class="search" name="search" id="search" placeholder="Поиск пользователей">
        <button type="submit" class="searchB" id="searchB"  name="searchB" onclick="checkForm()">Поиск</button>
        <button type="submit" class="newphoto" name="addPhoto">Добавить фото</button>
        <button type="submit" class = "exit" name="exit">Выйти</button>
    </form>
    <img src="/resources/img/123.png" class="profileImage">
    <p class="nickname"><b><c:out value="${UserNickName}" default="Nick"/></b></p>
    <%--<p class="publications">Кол-во публикаций</p>--%>
    <p class="name"><b><c:out value="${UserName}" default="Name"/></b></p>
</div>
<div id="block_news" class="block_news">
    <div id="newsticker">
        <c:set var="count" scope="session" value="${count}"/>
        <c:if test="${count<=0}">
            <h1>Нет фото</h1>
        </c:if>
        <ul>
    <c:forEach items="${posts}" var="item">
                <li>
                    <span><img src="${item.getPath()}"></span>
                    <p>${item.getComment()}</p>
                </li>
    </c:forEach>
        </ul>
    </div>
</div>
</body>
</html>
