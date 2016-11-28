<%@ page import="java.util.Date" %>
<%@ page import="java.util.Random" %>
<%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 12.11.16
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check new clients</title>
</head>
<%
    String themeColor = null;
    if (request.getParameter("themeColor") != null) {
        themeColor = request.getParameter("themeColor");
        session.setAttribute("themeColor", themeColor);
    }
    if (session.getAttribute("themeColor") != null) {
        themeColor = (String) session.getAttribute("themeColor");
    }

    // instead final static db_name
    // use
    // because final static can't be changes without needs to recompile jsp
    // but in web.xml variables changes will take effect immediately.
    application.getInitParameter("db_name"); // site specific from web.xml
    config.getInitParameter("db_name"); // page specific from web.xml
%>
<body style="background-color: <%=themeColor%>">
<%
    Date createTime = new Date(session.getCreationTime());
    // get last access time of this web page.
    Date lastAccessTime = new Date(session.getLastAccessedTime());

    String title = "Welcome Back to this app";
    int reqCount = 1;
    String userID = "";

    if (session.isNew()) {
        title = "Welcome to this app";
        userID = "User" + new Random().nextInt(1000);
        session.setAttribute("userID", userID);
        session.setAttribute("reqCount", 1);
    } else {
        // получаемая ссылка это ссылка на копию обекта, то есть изменяя этот обхект не меняется аттрибут
        reqCount = (Integer) session.getAttribute("reqCount");
        reqCount = reqCount + 1;
        userID = (String) session.getAttribute("userID");
    }
    session.setAttribute("reqCount", reqCount);
%>

<h2><%=title%>
</h2>
<table border="1" align="center">
    <tr bgcolor="#949494">
        <th>Session info</th>
        <th>value</th>
    </tr>
    <tr>
        <td>id</td>
        <td><%= session.getId()%>
        </td>
    </tr>
    <tr>
        <td>Creation time</td>
        <td><%= createTime%>
        </td>
    </tr>
    <tr>
        <td>Time of the last access</td>
        <td><%=lastAccessTime%>
        </td>
    </tr>
    <tr>
        <td>User id</td>
        <td><%=userID%>
        </td>
    </tr>
    <tr>
        <td>Number of requests</td>
        <td><%= reqCount%>
        </td>
    </tr>
</table>
<hr>
<h3>Settings</h3>
<form action="" method="get">
    <select name="themeColor" id="" required>
        <option value="" selected disabled>select one</option>
        <option value="antiquewhite" style="background-color: antiquewhite">antiquewhite</option>
        <option value="rebeccapurple" style="background-color: rebeccapurple">rebeccapurple</option>
        <option value="saddlebrown" style="background-color: saddlebrown">saddlebrown</option>
    </select>
    <br>
    <input type="submit" value="submit">
    <input type="reset" value="discard">
</form>
</body>
</html>