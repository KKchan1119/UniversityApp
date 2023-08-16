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
    <script src="js/login.js"></script>
</head>
<body>
<div class="logIn-form">
    <form name="formLogin" action="login.do" method="post">
        <div>university</div>
        <input type="text" class="text-field" name="userId" placeholder="아이디"/>
        <input type="password" class="text-field" name="password" placeholder="비밀번호"/>

        <input type="button" onclick="fn_checkEmpty()" value="로그인" class="login-btn"/>
    </form>
    <div class="links">
        <a href="insertUser.do">계정이 없으신가요?</a>
    </div>
</div>
</body>
</html>