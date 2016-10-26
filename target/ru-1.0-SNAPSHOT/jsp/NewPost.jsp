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
    <link href="${pageContext.request.contextPath}/resources/css/NewPostStyle.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="header">
    <h1>PhotoGram</h1>
    <form name="headerButtons" action="header" method="post">
    <button type="submit" name="myProfile" class="myprofile">Мой профиль</button>
    <button type="submit" name="exit"  class = "exit">Выйти</button>
    </form>
</div>
<div>
    <form name="newPost" enctype="multipart/form-data" action="NewPost" method="post">
        <input class="download" type="file" id="file" accept="image/*" name="file">
        <label for="comment">Комментарий</label>
        <textarea id="comment" class="comment" name="comment"></textarea>
        <button type="submit" class="send" id="send">Отправить</button>
    </form>
</div>
</body>
</html>
