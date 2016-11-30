<%@ page import="java.util.Date" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Check new clients</title>
</head>

<%
    String themeColor = "white";
    if (request.getParameter("themeColor")!=null) {
        themeColor = request.getParameter("themeColor");
        session.setAttribute("themeColor",themeColor);
    }
    if (session.getAttribute("themeColor")!=null) {
        themeColor = (String) session.getAttribute("themeColor");
    }
%>


<body style="background-color: <%=themeColor%>">
<%
    // Get session creation time.
    Date createTime = new Date(session.getCreationTime());
    // Get last access time of this web page.
    Date lastAccessTime = new Date(session.getLastAccessedTime());

    String title = "Welcome Back to my app";
    int reqCount = 1;
    String userID = "";

    // Check if this is new comer on our web page.
    if (session.isNew() || session.getAttribute("userID")==null) {
        title = "Welcome to my app";
        userID = "User" + new Random().nextInt(1000);
        session.setAttribute("userID", userID);
        session.setAttribute("reqCount", 1);
    } else {
        reqCount = (Integer) session.getAttribute("reqCount");
        reqCount = reqCount + 1;
        userID = (String) session.getAttribute("userID");
    }
    session.setAttribute("reqCount", reqCount);
%>

<h2> <%=title%> </h2>
<table border="1" align="center">
    <tr bgcolor="#949494"> <th>Session info</th><th>value</th></tr>
    <tr>  <td>id</td>  <td> <%= session.getId()%> </td></tr>
    <tr>  <td>Creation Time</td>  <td>   <%= createTime %> </td></tr>
    <tr>  <td>Time of Last Access</td> <td>   <%= lastAccessTime %> </td></tr>
    <tr>  <td>User ID</td>  <td>  <%= userID %> </td></tr>
    <tr>  <td>Number of requests</td> <td> <%= reqCount %> </td></tr>
</table>

<br>
<h3>Settings</h3>
<form method="get" action="">
    Theme color
    <select name="themeColor" required>
        <option selected disabled>Select one...</option>
        <option value="azure" style="background-color: azure">Azure</option>
        <option value="bisque" style="background-color: bisque">Bisque</option>
        <option value="lightgreen" style="background-color: lightgreen">Lightgreen</option>
    </select> <br>
    <input type="submit" value="Save">
    <input type="reset" value="Discard">

</form>
</body>
</html>
