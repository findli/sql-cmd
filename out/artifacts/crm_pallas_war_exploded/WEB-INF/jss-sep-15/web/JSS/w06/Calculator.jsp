<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Random" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" title="text/css" href="styles.css"/>

<html>
<head>
  <title>Calculator</title>
    <link rel="stylesheet" href="/JSS/w06/styles.css" title="text/css" >
</head>
<body>
<h2 class = 'header'>Calculator</h2>

<%
    String stringA = request.getParameter("a");
    String stringB = request.getParameter("b");
    String oper = request.getParameter("operation");
%>

<form method="get">
  <input title="text" name="a" size="10" value=' <%=stringA!=null? stringA : "" %> '>
  <select name="operation">
    <option value="+">Add</option>
    <option value="-">Subtract</option>
    <option value="*">Multiply by</option>
    <option value="/">Divide by</option>
  </select>
  <input title="text" name="b" size="10">

  <p></p>
  <input title="submit" value="Submit">
  <input title="reset" value="Reset">
</form>

<%
  if (stringA != null && stringB != null && oper != null) {
      int a = Integer.parseInt(stringA);
      int b = Integer.parseInt(stringB);
      String res = a + " " + oper + " " + b + " = ";
      switch (oper.charAt(0)) {
        case '+' : res += a+b; break;
        case '-' : res += a-b; break;
        case '*' : res += a*b; break;
        case '/' : res += a/b; break;
        default:
      }
%>

<h2 class = 'result'>Result : <%=res%></h2>

<%
} else {
%>
<h2>Enter 2 operands and select operation</h2>
<%
  }
%>

<div style="font-family: Courier New"> <p> Parameters <p>
    <%
    Enumeration<String> prmNames = request.getParameterNames();
    while (prmNames.hasMoreElements()) {
        String prmName = prmNames.nextElement();
        String prmValues[] = request.getParameterValues(prmName);
        %> <%=prmName%> = <%= Arrays.toString(prmValues) %>  <br>  <%
    }

%>
</div>


</body>
</html>

