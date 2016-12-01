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
                if ( cookie.getName().equals("user_id") ) {
                    userID = cookie.getValue();
                    break;
                }
            }
        }

        if (!userID.isEmpty()) {
            out.println("<h3>Welcome, " + userID + "</h3><br>" );
            response.setIntHeader("Expires",0);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        } else {
            response.sendRedirect("/JSS-15-09/JSS/w06_p01/Login.html");
        }

    %>

    <form action="/JSS-15-09/LogoutServlet" method="post">
        <input title="submit" value="Logout" >
    </form>
</body>
</html>