<%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 11.11.16
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    public void jspInit() {
        System.out.println("jspInit()");
    }
%>
<html>
<head>
    <title>Upload file</title>
</head>
<body>

<%
    Object messageAttribute = request.getAttribute("message");
    String message = (messageAttribute != null) ? (String) messageAttribute : "";
%>
<p>application.getRealPath(""): <%=application.getRealPath("")%></p>
<br>
download file: <a href="/download">download sample file</a>
<br>
<br>
<h1>Add product</h1>

<form method="post" action="/JSS-15-09/uploadServlet" enctype="multipart/form-data">
    <table border="0">
        <tr>
            <td>Product:</td>
            <td><input type="text" name="description" size="50"></td>
        </tr>

        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" size="10"></td>
        </tr>

        <tr>
            <td>Manual file:</td>
            <td><input type="file" name="manual" size="50"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <b> <%=message%></b>
            </td>
        </tr>
    </table>
</form>
</body>
</html>