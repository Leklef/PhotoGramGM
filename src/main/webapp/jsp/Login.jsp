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
    <link href="${pageContext.request.contextPath}/resources/css/LoginStyle.css" rel="stylesheet">
</head>
<body>
<table>
    <tr>
    <td>
<div id="signin">
    <h1>PhotoGram</h1>
    <form method="POST" id="loginForm" name="form">
    <input class="input3" name="nickname" id="nickname" type="text" size="38" placeholder="Логин">
    <input class="input3" name="password" id="password" type="password" size="38" placeholder="Пароль">
    <button type="submit" name="Login" id="Login" onclick="document.form.action='/Login'"><strong>Войти</strong></button>
    </form>
    </div>
    </td>
    </tr>
<td><div id="registration">
    <br>Еще нет аккаунта? <a href="/Registration">Зарегистрироватся</a>
</div>
    </td>
</table>
</body>
</html>
