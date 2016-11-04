<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenar
  Date: 07.10.16
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PhotoGram</title>
    <link href="${pageContext.request.contextPath}/resources/css/SignUpStyle.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/mdb.min.css" rel="stylesheet">
</head>
<body>
<div class="card">
    <div class="card-block">

        <div class="form-header blue-gradient">
            <h1>PhotoGram</h1>
        </div>

        <form method="post" id="loginform" action="Registration">
        <div class="md-form">
            <input type="text" name="name" id="name" class="form-control">
            <label for="name">ФИО</label>
        </div>
        <div class="md-form">
            <input type="text" name="email" id="email" class="form-control">
            <label for="email">Email</label>
        </div>
            <div class="md-form">
                <input type="text" name="nickname" id="nickname" class="form-control">
                <label for="nickname">Имя пользователя</label>
            </div>
        <div class="md-form">
            <input type="password" name="password" id="password" class="form-control">
            <label for="password">Пароль</label>
        </div>

        <div class="text-xs-center">
            <button name="register" id="register" class="btn btn-indigo">Зарегистрироваться</button>
        </div>
        </form>
        <div class="modal-footer">
            <div class="options">
                <p>Уже зарегистрированы? <a href="/Login">Вход</a></p>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/RegistrationJS.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tether.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>
</body>
</html>
