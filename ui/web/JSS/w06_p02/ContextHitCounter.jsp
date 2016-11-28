<%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 18.11.16
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hit counter using context</title>
</head>
<body>
<%
    Integer hitCounter = (Integer) application.getAttribute("hitCounter");
    String message = "";
    if (hitCounter == null || hitCounter == 0) {
        // first visit
        out.println("You're the first visitor of the site!");
        hitCounter = 1;
    } else {
        // return visit
        out.println("We had visitors before.");
        hitCounter += 1;
    }
    application.setAttribute("hitCounter", hitCounter);
%>
<p>Total number of visits: <%= hitCounter %></p>
</body>
</html>
