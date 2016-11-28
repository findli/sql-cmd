<%@ page import="JSS.w03_pract.model.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 13.11.16
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // for ContextHitCounter.jsp
    Integer hitCounter = (Integer) application.getAttribute("hitCounter");
    String message = "";
    if (hitCounter == null || hitCounter == 0) {
        // first visit
        hitCounter = 1;
    } else {
        // return visit
        hitCounter += 1;
    }
    application.setAttribute("hitCounter", hitCounter);
%>

<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html" charset="utf-8">
    <title>Products view</title>
    <%
        String themeColor = "white";

        if (session.getAttribute("themeColor") != null) {
            themeColor = (String) session.getAttribute("themeColor");
        }
    %>
</head>
<body style="background-color: <%=themeColor%>">
<%
    request.setCharacterEncoding("UTF-8"); // !!!
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
    if (actionStatus != null) {
        out.println(actionStatus + "<br /><br />");
    }
%>

<h3>Filter</h3>
<form action="" method="post" accept-charset="UTF-8">
    <table>
        <tr>
            <td>Product</td>
            <td><input type="text" name="filterDescr" size="25" value="<%=filterDescr%>"></td>
        </tr>
        <tr>
            <td>Min price</td>
            <td><input type="text" name="filterPriceMin" size="5" value="<%=filterPriceMin%>"></td>
        </tr>
        <tr>
            <td>Max price</td>
            <td><input type="text" name="filterPriceMax" size="5" value="<%=filterPriceMax%>"></td>
        </tr>
        <br>
        <input type="submit" value="Set Filter">
        <input type="reset" value="Discard form changes">
    </table>
</form>
<%
    Connection conn = DatabaseConnection.getConnection("java_jss_salesdept");
%>

<table border="1" cellspacing="0" width="400px">
    <tr>
        <th>Product</th>
        <th>Price</th>
    </tr>
    <%
        //        String sql = "SELECT * FROM Customers";
//        try (java.sql.PreparedStatement stmt = conn.prepareStatement(sql);){
//            ResultSet rs = stmt.executeQuery(sql);
        String sql = "SELECT * FROM Products WHERE description LIKE ? and price >= ? and price <= ?";
        String sqlExecuted = "";
        try (java.sql.PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, "%" + filterDescr + "%");
            stmt.setString(2, filterPriceMin);
            stmt.setString(3, filterPriceMax);

            ResultSet rs = stmt.executeQuery();
            sqlExecuted = stmt.toString(); // @Ya ??????

            while (rs.next()) {
                String refDelete = String.format("<a href='/JSS-15-09/dbAction?id=%d&action=delete'>Delete</a>", rs.getInt("id"));
                String refView = String.format("<a href='/JSS-15-09/?id=%d&action=view'>View</a>", rs.getInt("id"));
                String refEdit = String.format("<a href='/JSS-15-09/?id=%d&action=edit'>Edit</a>", rs.getInt("id"));

                out.println("<tr><td>" +
                        rs.getString("description") + "</td><td>" +
                        rs.getString("price") + "</td><td>" +
                        refView + "</td><td>" +
                        refDelete + "</td><td>" +
                        refEdit + "</td>" +
                        "</tr>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        }
    %>
</table>
<div style="color: #AAAAAA;"><%=sqlExecuted%>

    <%
        if (request.getParameter("action") != null &&
                request.getParameter("action").equals("view")) {
            out.println("<p><div style='color: #555'>");
            String sql1 = "SELECT description, details, manual FROM Products WHERE  id = " + request.getParameter("id");
            Statement statement = conn.createStatement();
            ResultSet rs1 = statement.executeQuery(sql1);
            if (rs1.next()) {
                out.println(rs1.getString(1));
                out.println("<br/>");
                out.println(rs1.getString(2));
                out.println("<br/>");
                out.println(rs1.getString(3));
                out.println("<br/>1");
            }
            out.println("</div></p>");
        }
        if (request.getParameter("action") != null &&
                request.getParameter("action").equals("edit")) {
            // form edit with submit name = "Edit"
        }
    %>
</div>
</body>
</html>
