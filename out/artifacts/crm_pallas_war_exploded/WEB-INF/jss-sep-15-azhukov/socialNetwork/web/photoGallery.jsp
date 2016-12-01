
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My photo gallery</title>
</head>
<body>

<%
  Object attr = request.getAttribute("message");
  String message = (attr!=null)? (String) attr : "";
%>

<form method="post" action="/UploadServlet" enctype="multipart/form-data">
  <table border="0">
    <tr>
      <td>name file: </td>
      <td><input title="text" name="description" size="50"/></td>
    </tr>
    <tr>
      <td>Add file: </td>
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
