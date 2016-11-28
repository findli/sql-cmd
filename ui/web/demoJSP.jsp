<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %><%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 29.10.16
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo JSP</title>
</head>
<body>

<h3>hit counter:</h3>
<%=++hitCount%>
<%!
    // вставляется вне функции service  в класс сервлета
    static int hitCount = 0; %>
<br>
<br>
<h1>current week:</h1>
<br>
<%
    GregorianCalendar calendar = new GregorianCalendar();
    int weekday = calendar.get(Calendar.DAY_OF_WEEK);
    calendar.add(Calendar.DAY_OF_YEAR, -weekday + 2);

    for (int i = 0; i < 7; i++) {
        response.getWriter().println(request.getRequestURI() + " i: " + i + "<br />");
%>
        <%= calendar.get(Calendar.DAY_OF_MONTH) + ", " %>
<%
        calendar.add(Calendar.DAY_OF_YEAR, 1);
    }
%>
</body>
</html>
