<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenar
  Date: 03.11.16
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PhotoGram</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/mdb.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/searchStyle.css" rel="stylesheet">
</head>
<body>
<div class="header">
    <h1>PhotoGram</h1>
    <form name="headerButtons" action="header" method="post">
        <button type="submit" name="myProfile" class="btn btn-primary waves-effect waves-light" id="myprofile">Мой профиль</button>
        <button type="submit" name="exit" id="exit" class = "btn btn-blue-grey waves-effect waves-light">Выйти</button>
    </form>
</div>
<c:set var="count" scope="session" value="${count}"/>
<c:if test="${count<=0}">
    <div id="noUser">
    <h1>Пользователь не найден</h1>
    </div>
</c:if>
<div class="col-md-5">
    <!--Image Card-->
    <c:forEach var="user" items="${SearchList}">
        <div class="card hoverable">
            <div class="card-image">
                <div class="view overlay hm-white-slight z-depth-1">
                    <img src="${user.getUserPhoto()}" class="img-responsive" alt="">
                    <a href="/friend?nickname=${user.getUsername()}">
                        <div class="mask waves-effect"></div>
                    </a>
                </div>
            </div>
            <div class="card-content">
                <h5>${user.getUsername()}</h5>
            </div>
        </div>
    </c:forEach>
    <!--Image Card-->
</div>
</body>
</html>
