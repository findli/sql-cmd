<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrill
  Date: 31.10.2015
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Demo JSP</title>
</head>
<body>



    <!-- <h1> Current week </h1>  -->

    <%
        response.getWriter().println( request.getRequestURI() + "<p><p>");

        Calendar calendar = new GregorianCalendar();

        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        calendar.add(Calendar.DAY_OF_YEAR,-weekday+2);

        for(int i=0; i<7; i++ ) {
          %> <%= calendar.get(Calendar.DAY_OF_MONTH) + ", " %> <%
          calendar.add(Calendar.DAY_OF_YEAR,1);
        }

        hitCount++;

    %>
    <p> Hit Count = <%= hitCount %>

</body>
</html>

<%! static int hitCount = 0; %>

<%!
    public void jspInit() {
        hitCount = 100;
        System.out.println("jspInit() fired!!!!!!!");
    }

%>
