<%@ page import="java.util.ArrayList" %>
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
  Object attr = request.getAttribute("message");
  String message = (attr!=null)? (String) attr : "";
%>



<h1>Add product</h1>

<form method="post" action="/JSS-15-09/uploadServlet" enctype="multipart/form-data">
  <table border="0">
    <tr>
      <td>Product: </td>
      <td><input title="text" name="description" size="50"/></td>
    </tr>
    <tr>
      <td>Price: </td>
      <td><input title="text" name="price" size="10"/></td>
    </tr>
    <tr>
      <td>Manual file: </td>
      <td><input title="file" name="manual" size="50"/></td>

    </tr>
    <tr>
      <td colspan="2">
        <input title="submit" value="Add">
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <b> <%=message%> </b>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
