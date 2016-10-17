<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenar
  Date: 11.10.16
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PhotoGram</title>
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto">
    <link href="${pageContext.request.contextPath}/css/LoginStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="signin">
    <h1>PhotoGram</h1>
    <form method="POST" id="loginForm" name="form">
    <input class="input3" name="nickname" id="nickname" type="text" size="38" placeholder="Логин">
    <input class="input3" name="password" id="password" type="password" size="38" placeholder="Пароль">
    <button type="submit" name="Login" id="Login" onclick="document.form.action='/Login'"><strong>Войти</strong></button>
    </form>
    </div>
<div id="registration">
    <br>Еще нет аккаунта? <a href="/Registration">Зарегистрироватся</a>
</div>
</body>
</html>
