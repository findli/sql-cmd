<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Hit counter</title>
</head>
<body>
<%
    Integer hitCount =
            (Integer) application.getAttribute("hitCounter");
    String message = "";
    if (hitCount == null || hitCount == 0) {
        // first visit
        out.println("You're the first visitor of this website!");
        hitCount = 1;
    } else {
        // return visit
        out.println("We had visitors before");
        hitCount += 1;
    }
    application.setAttribute("hitCounter", hitCount);


%>
<p>Total number of visits: <%= hitCount%></p>
</body>
</html>

<%
//Enumeration<String> contextPrmNames = application.getInitParameterNames();
//while (contextPrmNames.hasMoreElements()) {
//String prm = (String) contextPrmNames.nextElement();
//out.println(prm + " = " + application.getInitParameter(prm));
//}
  %>
