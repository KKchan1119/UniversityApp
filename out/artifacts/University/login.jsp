<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-08-13
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="css/login.css">
    <link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
</head>
<body>
<div class="logIn-form">
    <form action="login.do" method="post">
        <div>university</div>
        <input type="text" class="text-field" name="userId" placeholder="아이디"/>
        <input type="password" class="text-field" name="password" placeholder="회원가입"/>
        <input type="submit" name="button" value="로그인" class="login-btn"/>
    </form>
    <div class="links">
        <a href="signIn.html">계정이 없으신가요?</a>
    </div>
</div>
</body>
</html>