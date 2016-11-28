<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<%
    exception.printStackTrace(response.getWriter());
    out.println("<br>");
    out.println("<br>");
    out.println("Exception: " + pageContext.getException() + "<br>");
    out.println("URI: " + pageContext.getErrorData().getRequestURI() + "<br>");
    out.println("Code: " + pageContext.getErrorData().getStatusCode() + "<br>");
    out.println("Stack trace: <br>");
    for (StackTraceElement element : exception.getStackTrace()) {
        out.println(element + "<br>");
    }
%>
</body>
</html>
