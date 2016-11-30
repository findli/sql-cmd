<%--  Для базы данных «контакты» средствами JSP создайте web-приложение, которое позволяет просматривать  информацию о ваших контактах.
 Форма приложения должна содержать фильтры для отбора записей

 @author Artem Zhukov
 --%>

<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> DB Contact </title>
</head>
<body>
<%!
    Connection conn = null;
    String sqlDefault = "SELECT  * FROM contact ";

    @Override
    public void jspInit() {
        conn = ru.javajoy.jss.db.DBConnection.getConnection("az_organizer");
    }
%>
<%
    if (request.getAttribute("message") != null) {
        out.println("<div style='font-face: courier new'>" + request.getAttribute("message") + "</div>");
    }
    String strPerson = request.getParameter("a") == null ? "" : request.getParameter("a");
    PreparedStatement stmt;
    ResultSet rs;
    try {
        stmt = conn.prepareStatement(sqlDefault + "WHERE nameContact LIKE ? ORDER BY nameContact");
        stmt.setString(1, "%" + strPerson + "%");
        rs = stmt.executeQuery();
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();
        out.println("<table border =1> <tr>");
        for (int i = 1; i <= columnCount; i++) {
            if (i <= columnCount) {
                switch (rs.getMetaData().getColumnName(i)) {
                    case "idContact":
                        out.println("<th>" + "id" + "\t" + "</th>");
                        break;
                    case "nameContact":
                        out.println("<th>" + "name" + "\t" + "</th>");
                        break;
                }
            }
        }
        out.println("<th> Remove" + "\t" + "</th>");
        out.println("</tr>");
        while (rs.next()) {
            String refDelete = String.format("<a href='/jss/w6/RemoveItem.jsp?id=%d&action=remove'>Remove</a>", rs.getInt("idContact"));
            out.println("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                if (i == 2) {
                    String refPerson = String.format("<a href='/jss/w6/DetailPerson.jsp?idPerson=%d&action=veiw'>" + rs.getString(i) + "</a>",
                            rs.getInt("idContact"));
                    out.println("<td>" + refPerson + "\t" + "</td>");
                } else {
                    out.println("<td>" + rs.getString(i) + "\t" + "</td>");
                }
            }
            out.println("<td>" + refDelete + "\t" + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<i><small> Filter has used: name " + strPerson + "</small></i>");
    } catch (SQLException e) {
        e.printStackTrace(new PrintWriter(out, true));
    }
%>
<form method="post">
    <H4> Filter </H4>
    By name
    <input type="text" name="a" value="<%=strPerson != null ? strPerson : "" %>"/>

    <p></p>
    <input type="submit" value="Ok">
</form>
</body>
</html>

