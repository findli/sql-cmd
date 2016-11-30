<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Error page</title>
</head>
<body>


<%
    response.getWriter().println("<h1> Error occurred </h1>");

    // exception.printStackTrace(response.getWriter());

%>

<table width="100%" border="1" cellspacing="0">
    <tr valign="top">
        <td width="30%"><b>Error:</b></td>
        <td><%=pageContext.getException()%></td>
    </tr>
    <tr valign="top">
        <td><b>URI:</b></td>
        <td><%=pageContext.getErrorData().getRequestURI()%></td>
    </tr>
    <tr valign="top">
        <td><b>Status code:</b></td>
        <td><%=pageContext.getErrorData().getStatusCode()%></td>
    </tr>
    <tr valign="top">
        <td><b>Stack trace:</b></td>
        <td>
            <%
                StackTraceElement[] trace = pageContext.getException().getStackTrace();
                for (StackTraceElement element : trace) {
                    out.println(element + "<br>");
                }
            %>

        </td>
    </tr>
</table>


</body>
</html>
