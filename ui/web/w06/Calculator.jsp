<%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 30.10.16
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Enumeration" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<%!
    // this brackets will put this function to servlet class, not in one method like < %
    private String test1(String text) {
        text += " from test1()";
        return text;
    }
%>
<%
    String out1 = test1("test text");
    out.println(out1);
%>
<br>
<br>
<%
    String stringA = request.getParameter("a");
    String stringB = request.getParameter("b");
    String operation = request.getParameter("operation");
%>
<form action="" method="get">
    <input type="text" name="a" size="10" value="<%=stringA!=null?stringA:""%>">
    <select name="operation" id="">
        <option value="+">add</option>
        <option value="-">division</option>
        <option value="/">subtraction</option>
        <option value="*">multiply</option>
    </select>
    <input type="text" name="b" size="10">
    <br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
<%

    if (stringA != null && stringB != null && operation != null) {
        int a = Integer.parseInt(stringA);
        int b = Integer.parseInt(stringB);
        String resultString = a + " " + operation + " " + b + "=";
        switch (operation) {
            case "-":
                resultString += a - b;
                break;
            case "+":
                resultString += a + b;
                break;
            case "/":
                resultString += a / b;
                break;
            case "*":
                resultString += a * b;
                break;
            default:
        }
        response.getWriter().println(resultString);
%>
<%=resultString%>
<%
} else {
%>
<h3>Enter two operations and select operation.</h3>
<%
    }
%>

<div style="font-family: 'Courier New'">
    <p>Parameters:</p>
    <%
        Enumeration<String> prmNames = request.getParameterNames();
        while (prmNames.hasMoreElements()) {
            String prmName = prmNames.nextElement();
            String[] values = request.getParameterValues(prmName);
    %>
    <%=prmName%> <%=Arrays.toString(values)%>
    <%
        }
    %>
</div>
</body>
</html>
