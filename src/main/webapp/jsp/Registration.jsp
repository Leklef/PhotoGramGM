<%--
  Created by IntelliJ IDEA.
  User: lenar
  Date: 07.10.16
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>PhotoGram</title>
    <link href="${pageContext.request.contextPath}../../css/RegistrationStyle.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/RegistrationJS.js"></script>
</head>
<body>
<div id ="registration">
    <h1>Добро пожаловать в PhotoGram</h1>
    <h2>Пожалуйста зарегистрируйтесь</h2>
    <form method="POST" id="loginform" action="Registration">
        <input id="email" class="input3" name="email"  type = "email" size = "38" placeholder="Эл.адрес"><span></span>
        <input id="name" class="input3" name="name" type="text" size = "38" placeholder="Имя и фамилия"><span></span>
        <input id="nickname" class="input3" name="nickname" type="text" size="38" placeholder="Имя пользователя"><span></span>
        <input id="password" class="input3" type="password" name="password" size="38" placeholder="Пароль"><span></span><br><br>
        <button type="submit" name="register" id="register">Регистрация</button>
    </form>
    <p>Регистрируясь, вы соглашаетесь с нашими <strong>Условиями и Политикой конфиденциальности.</strong></p>
</div>
<div id="signin">
    <br>Есть аккаунт? <a href="/Login">Вход</a>
</div>
</body>
</html>
