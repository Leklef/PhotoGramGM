<%--
  Created by IntelliJ IDEA.
  User: lenar
  Date: 03.12.16
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<html>
<head>
    <title>PhotoGram</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/mdb.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/compiled.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sweetalert.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/SettingStyle.css" />
</head>
<body>

<nav class="navbar navbar-fixed-top scrolling-navbar navbar-dark bg-primary">

    <button class="navbar-toggler hidden-sm-up" type="button" data-toggle="collapse" data-target="#collapseEx2">
        <i class="fa fa-bars"></i>
    </button>

    <div class="container">
        <div class="collapse navbar-toggleable-xs" id="collapseEx2">
            <a class="navbar-brand waves-effect waves-light" href="/user">PhotoGram</a>
            <ul class="nav navbar-nav">
                <li class="nav-item">
                    <a href="/user" class="nav-link">Моя страница <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect waves-light" href="/NewPost">Добавить фото</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link waves-effect waves-light" href="/settings">Настройки</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect waves-light" href="/header?exit=1">Выход</a>
                </li>
            </ul>
            <form class="form-inline waves-effect waves-light" method="get" action="/search" id="search" name="search">
                <input id="searchTF" name="search" class="form-control" type="text" placeholder="Поиск">
            </form>
        </div>
    </div>
</nav>

<div id="profileImageDiv" class="view overlay hm-white-slight z-depth-1">
    <img src="${userPhoto}" class="img-responsive" id="profileImage">
    <a>
        <div class="mask waves-effect"></div>
    </a>
</div>

<form name="userPhotoSetting" id="userPhotoSetting" enctype="multipart/form-data" action="settings" method="post">
    <div class="file-field">
        <div id="download" class="btn btn-primary waves-effect waves-light">
            <div style="text-align: center; overflow: hidden; width: 250px; height: 25px;">
                <div style="font-family: 'Helvetica Neue';">Изменить фото</div>
                <input type="file" accept="image/*" name="file" id="file" class="file" size="1" style="margin-top: -50px; margin-left:-410px; -moz-opacity: 0; filter: alpha(opacity=0); opacity: 0; font-size: 150px; height: 100px;">
            </div>
        </div>
    </div>
    <%--<button type="submit" class="btn btn-primary waves-effect waves-light" id="send">Сохранить</button>--%>
</form>
<br>
<div id="line">
    <hr>
</div>
<div id="delete">
    <a href="/header?deletePageID=${delete}">
<button class="btn btn-primary waves-effect waves-light" id="send">Удалить страницу</button>
</a>
</div>
<%--<form name="userInfoSetting" id="userInfoSetting" enctype="text/plain" action="settings" method="post">--%>

<%--</form>--%>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tether.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/SettingJS.js"></script>
</body>
</html>
