<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="/JSS/w06_p03/ErrorHandler.jsp" %>
<html>
<head>
    <title>Exceptions demo</title>
</head>
<body>
<%
    String prm = request.getParameter("prm");

    if (prm == null || prm.isEmpty()) {
//        throw new RuntimeException("Invalid parameters!");
    }

    try {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection("", "", "");
    } catch (SQLException e) {
        throw new RuntimeException("Not connected to DB");
    }
%>
</body>
</html>
