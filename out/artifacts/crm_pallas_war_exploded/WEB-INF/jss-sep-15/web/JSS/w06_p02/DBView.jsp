<%@ page import="JSS.w03_pract.model.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%! %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Products View</title>
<%
    String themeColor = "white";

    if (session.getAttribute("themeColor")!=null) {
        themeColor = (String) session.getAttribute("themeColor");
    }
%>

<body style="background-color: <%=themeColor%>">

<%
    request.setCharacterEncoding("UTF-8");      //  !!!
    String filterDescr = request.getParameter("filterDescr") == null ? "" : request.getParameter("filterDescr");
    String filterPriceMin = request.getParameter("filterPriceMin");
    String filterPriceMax = request.getParameter("filterPriceMax");
    if (filterPriceMin == null || filterPriceMin.isEmpty()) {
        filterPriceMin = "0";
    }
    if (filterPriceMax == null || filterPriceMax.isEmpty()) {
        filterPriceMax = "10000";
    }

    String actionStatus = (String) request.getAttribute("actionStatus");
    if (actionStatus!= null) {
        out.println(actionStatus+"<br><br>");
    }

%>


<h3> Filter </h3>
<form method="post" accept-charset="UTF-8">
    <table >
        <tr> <td>Product </td> <td> <input title="text" name="filterDescr" size="25" value="<%=filterDescr%>"> </td> </tr>
        <tr> <td>Min price</td> <td> <input title="text" name="filterPriceMin" size="5" value="<%=filterPriceMin%>"> </td> </tr>
        <tr> <td>Max price</td> <td> <input title="text" name="filterPriceMax" size="5" value="<%=filterPriceMax%>"> </td> </tr>
    </table>
    <p/>
    <input title="submit" value="Set Filter">
    <input title="reset" value="Cancel">
</form>


<%
    String dbName = application.getInitParameter("db_name");
    // config.getInitParameter("db_name");
    Connection conn = DatabaseConnection.getConnection(dbName==null? "salesdept" : dbName);
%>

<table border="1" cellspacing="0" width ="400px" >
    <tr> <th>Product</th> <th>Price</th>

            <%
  //    String sql = "SELECT * FROM Customers";
  //    try ( java.sql.PreparedStatement  stmt = conn.prepareStatement(sql); ) {
  //        ResultSet rs = stmt.executeQuery(sql);
    String sql = "SELECT * FROM Products WHERE description LIKE ? and price >= ? and price <= ?";
    String sqlExecuted = "";

    try (java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, "%" + filterDescr + "%");
        stmt.setString(2, filterPriceMin);
        stmt.setString(3, filterPriceMax);
        ResultSet rs = stmt.executeQuery();
        sqlExecuted = stmt.toString();

        while (rs.next()) {
            String refDelete = String.format("<a href='/JSS-15-09/dbAction?id=%d&action=delete'>Delete</a>",rs.getInt("id"));
            String refView = String.format("<a href='?id=%d&action=view'>View</a>",rs.getInt("id"));
            String refEdit = String.format("<a href='?id=%d&action=edit'>Edit</a>",rs.getInt("id"));

            out.println("<tr> <td>" +
                    rs.getString("description") + "</td> <td>" +
                    rs.getString("price") + "</td> <td>" +
                    refView + "</td> <td>" +
                    refDelete + "</td></tr>");
        }
        rs.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
%>

</table>
<div style="color: #AAA;"><%=sqlExecuted%> </div>

<%
    if (request.getParameter("action") != null && request.getParameter("action").equals("view") ) {
        int id = Integer.parseInt(request.getParameter("id"));
        String sql1 = "SELECT details FROM Products WHERE id=?";
        PreparedStatement stm = conn.prepareStatement(sql1);
        stm.setInt( 1, id );
        ResultSet rs1 = stm.executeQuery();
        if (rs1.next()) {
            out.println("<p><div style='color:#555'>" + rs1.getString(1) + "</div>");
        }
    }

    if (request.getParameter("action") != null && request.getParameter("action").equals("edit") ) {
        // Edit form with submit name="update"
        // and <input title="hidden" name="id" value="actual_id">

    }
%>

</body>
</html>
