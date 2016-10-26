<%--
  Created by IntelliJ IDEA.
  User: lenar
  Date: 21.10.16
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>PhotoGram</title>
    <link href="${pageContext.request.contextPath}/resources/css/userPageStyle.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="about">
    <h1>PhotoGram</h1>
    <form method="post">
        <input type="text" class="search" placeholder="Поиск пользователей">
        <button type="submit" class="newphoto" name="addPhoto">Добавить фото</button>
        <button type="submit" class = "exit" name="exit">Выйти</button>
    </form>
    <%--<img src="star-wars-battlefront-2016-2560x1440-wallpaper-18492.jpg" class="profileImage">--%>
    <p class="nickname"><b>Nick</b></p>
    <%--<p class="publications">Кол-во публикаций</p>--%>
    <p class="name"><b>Name</b></p>
</div>

<div class="allPhoto">

</div>

</body>
</html>
