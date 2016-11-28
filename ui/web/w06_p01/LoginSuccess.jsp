<%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 11.11.16
  Time: 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<%
    String userID = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user_id")) {
                userID = cookie.getValue();
            }
        }
    }

    if (!userID.isEmpty()) {
        out.println("Welcome " + userID);
//            response.setIntHeader("Expires", 0);
//            response.setIntHeader("Refresh", 2);

//            response.setIntHeader("Expires", 0);
//            response.setHeader("Pragma", "no-cache");
//            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    } else {
        out.println("response.sendRedirect(\"/JSS-15-09/w06_p01/Login.html\")");
//            response.sendRedirect("/JSS-15-09/w06_p/Login.html");
    }
%>
<form action="/JSS-15-09/LogoutServlet" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
