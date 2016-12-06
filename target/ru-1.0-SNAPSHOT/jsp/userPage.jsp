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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/mdb.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/compiled.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/sweetalert.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sweetalert.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/userStyle.css" />
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
                <li class="nav-item active">
                    <a href="/user" class="nav-link">Моя страница <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect waves-light" href="/NewPost">Добавить фото</a>
                </li>
                <li class="nav-item">
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
<script>var user_id = '<c:out value=""/>'</script>
<div id="profileImageDiv" class="view overlay hm-white-slight z-depth-1" onclick="changeUserPhoto(user_id)">
    <img src="${userPhoto}" class="img-responsive" id="profileImage">
    <a>
        <div class="mask waves-effect"></div>
    </a>
</div>
<div id="header" class="view overlay hm-white-slight z-depth-1">
    <h1>${UserNickName}</h1>
    <h2>${UserName}</h2>
</div>
<c:set var="count" scope="session" value="${count}"/>
<c:if test="${count<=0}">
    <h1 class="noPhoto">Нет фото</h1>
</c:if>

<div class="col-md-5">
    <!--Image Card-->
    <c:forEach var="posts" items="${posts}">
        <div class="card hoverable" onclick="clicked('<c:out value="${posts.getPath()}"/>')">
            <div class="card-image">
                <div class="view overlay hm-white-slight z-depth-1">
                    <img src="${posts.getPath()}" id="img" class="img-responsive" alt="">
                    <a>
                        <div class="mask waves-effect"></div>
                    </a>
                </div>
            </div>
            <div class="card-content">
                <h5>${posts.getComment()}</h5>
            </div>
        </div>
    </c:forEach>
    <!--Image Card-->
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tether.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/friendPageSearch.js"></script>
</body>
</html>
