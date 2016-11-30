<%--Детализация контакта--%>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person details</title>
</head>
<body>
<%!
    Connection conn = null;

    @Override
    public void jspInit() {
        conn = ru.javajoy.jss.db.DBConnection.getConnection("az_organizer");
    }
%>

<%
    String strDateFrom = request.getParameter("df") == null ? "2000-01-01" : request.getParameter("df");
    String strDateTo = request.getParameter("dt") == null ? "2030-12-31" : request.getParameter("dt");
    int idPerson = Integer.parseInt(request.getParameter("idPerson"));
    PreparedStatement stmt;
    ResultSet rs;
    if (conn != null) {
        try {
            stmt = conn.prepareStatement("select nameContact from contact where idContact = ?");
            stmt.setInt(1, idPerson);
            rs = stmt.executeQuery();
            while (rs.next()) out.println("Person: " + rs.getString(1) + "<br>");
            stmt = conn.prepareStatement("select * from e_mail where idContact = ?");
            stmt.setInt(1, idPerson);
            out.println("e-mail: ");
            rs = stmt.executeQuery();
            while (rs.next()) {
                String refEdit = String.format("<a href='/jss/w6/Edit.jsp?idMail=%d&idContact=%d&action=item'>" + rs.getString(3) + "</a>", rs.getInt("idMail"), rs.getInt("idContact"));
                out.println(refEdit + ";");
            }
            out.println("<br>");

            out.println("Date of meet:<br>");
            stmt = conn.prepareStatement("select * from contact\n" +
                    "inner join contact_has_meet on contact_has_meet.idContact = contact.idContact\n" +
                    "inner join meet on contact_has_meet.idMeet = meet.idMeet\n" +
                    "where contact.idContact = ? and meetDate >  ? AND meetDate < ?");
            stmt.setInt(1, idPerson);
            stmt.setString(2, strDateFrom);
            stmt.setString(3, strDateTo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String refEdit = String.format("<a href='/jss/w6/Edit.jsp?idMeet=%d&idContact=%d&action=item'>" + rs.getString(8) + "</a>", rs.getInt("idMeet"), rs.getInt("idContact"));
                out.println(refEdit + "<br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>

<form method="post">
    Date from
    <input type="text" name="df" <%=strDateFrom != null ? strDateFrom : "" %> />
    to
    <input type="text" name="dt" <%=strDateTo != null ? strDateTo : "" %>
    <p></p>
    <input type="button" value="Home" onclick="HomeButton()">
    <script>
        function HomeButton() {
            location.href = "/jss/w6/Demo.jsp";
        }
    </script>
    <input type="submit" value="Ok">
</form>
</body>
</html>
