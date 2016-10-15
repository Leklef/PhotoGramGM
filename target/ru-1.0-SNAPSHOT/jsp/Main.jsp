<%--
  Created by IntelliJ IDEA.
  User: lenar
  Date: 15.10.16
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>PhotoGram</title>
    <link href="${pageContext.request.contextPath}../../css/MainStyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="header">
    <h1>PhotoGram</h1>
    <form method="post" action="">
    <input type="text" id="search" class="input3" placeholder="Поиск пользователей">
    <button type="submit" class="myprofile" name="myprofile">Мой профиль</button>
    <button type="submit" class="newphoto" name="newphoto">Добавить фото</button>
    <button type="submit" class = "exit" name="exit">Выйти</button>
    </form>
</div>
<div class = "main">

    <div class="news">

    </div>

</div>
</body>
</html>
