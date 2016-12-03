<%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 29.11.16
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/userValidator" method="post">
    Name: <input type="text" name="name"/>
    Password: <input type="password" name="password"/>
    <input type="submit" value="LogIn"/>
</form>
</body>
</html>
