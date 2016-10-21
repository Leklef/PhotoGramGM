<%--
  Created by IntelliJ IDEA.
  User: lenar
  Date: 17.10.16
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>PhotoGram</title>
    <link href="${pageContext.request.contextPath}../css/NewPostStyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="header">
    <h1>PhotoGram</h1>
    <button class="myprofile">Мой профиль</button>
    <button type="submit"  class = "exit">Выйти</button>
</div>
<div>
    <form name="newPost" enctype="multipart/form-data" action="NewPost" method="post">
        <input class="download" type="file" id="file" accept="image/*" name="file">
        <%--<img src="star-wars-battlefront-2016-2560x1440-wallpaper-18492.jpg">--%>
    <label for="comment">Комментарий</label>
    <textarea id="comment" class="comment" name="comment"></textarea>
    <button type="submit" class="send" id="send">Отправить</button>
    </form>
</div>
</body>
</html>
