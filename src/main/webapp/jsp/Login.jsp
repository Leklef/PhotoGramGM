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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/mdb.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/SignInStyle.css" rel="stylesheet">
</head>
<body>
<div class="row">
<div class="col-lg-6 col-md-8">
<div class="card">
    <form method="post" id="loginForm" name="form">
    <div class="card-block">
        <div class="form-header blue-gradient">
            <h1>PhotoGram</h1>
        </div>

        <div class="md-form">
            <input type="text" name="nickname" id="form2" class="form-control">
            <label for="form2">Логин</label>
        </div>

        <div class="md-form">
            <input type="password" id="form4" name="password" class="form-control">
            <label for="form4">Пароль</label>
        </div>

        <div class="text-xs-center">
            <button type="submit" name="Login" id="Login" onclick="document.form.action='/Login'" class="btn btn-indigo waves-effect waves-light">Вход</button>
        </div>

    </div>
    </form>
    <div class="modal-footer">
        <div class="options">
            <p>Еще не зарегистрированы? <a href="/Registration">Зарегистрироваться</a></p>
        </div>
    </div></div>
</div>
</div>


    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tether.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>

</body>
</html>
