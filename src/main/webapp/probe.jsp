<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 6.3.19
  Time: 16.36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JDBC probe</title>
</head>
<body>
    <p>${permiss}</p>
    <form action="" method="POST">
        <h2>Регистрация</h2>
        <p>Логин<br><input type="text" name="login" autocomplete="off"></p>
        <p>Полное имя<br><input type="text" name="fullName" autocomplete="off"></p>
        <p>Пароль<br><input type="password" name="password"></p>
        <p>Подтверждение пароля<br><input type="password" name="password2"></p>
        <button type="submit" name="do_registration">Зарегистрироваться</button>
    </form>
</body>
</html>
