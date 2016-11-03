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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/mdb.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/NewPostStyle.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tether.min.js"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>
</head>
<body>
<div class="header">
    <h1>PhotoGram</h1>
    <form name="headerButtons" action="header" method="post">
    <button type="submit" name="myProfile" id="myprofile" class="btn btn-default waves-effect waves-light">Мой профиль</button>
    <button type="submit" name="exit"  id="exit" class = "btn btn-danger waves-effect waves-light">Выйти</button>
    </form>
</div>
<div>
    <form name="newPost" enctype="multipart/form-data" action="NewPost" method="post">
        <div class="file-field">
        <div id="download" class="btn btn-primary waves-effect waves-light">
            <div style="text-align: center; overflow: hidden; width: 250px; height: 25px;">
                <div style="font-family: 'Helvetica Neue';">Загрузить фото</div>
                <input type="file" accept="image/*" name="file" id="file" class="file" size="1" style="margin-top: -50px; margin-left:-410px; -moz-opacity: 0; filter: alpha(opacity=0); opacity: 0; font-size: 150px; height: 100px;">
            </div>
        </div>
        </div>
        <div class="col-md-6">
        <div class="md-form">
            <textarea id="form7" class="md-textarea" name="comment"></textarea>
            <label for="form7">Комментарий</label>
        </div>
        </div>
        <button type="submit" class="send" id="send">Отправить</button>
    </form>
</div>
</body>
</html>
