<%--Удаление контакта--%>

<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove item</title>
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
    int id = Integer.parseInt(request.getParameter("id"));
    String formOkSubmit = request.getParameter("formatOkSubmit");
    PreparedStatement stmt;
    ResultSet rs;
    if (conn != null) {
        try {
            stmt = conn.prepareStatement("select nameContact from contact where idContact = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) out.println("Do you want remove all info about " + rs.getString(1) + "<br>");
            if (formOkSubmit != null) {
                CallableStatement removeItem;
                removeItem = conn.prepareCall("{call az_organizer.removeItem(?)}");
                removeItem.setInt(1, id);
                removeItem.execute();
                out.println("Item has removed");
            }
        } catch (SQLException e) {
            e.printStackTrace(new PrintWriter(out, true));
        }
    }
%>

<form>
    <input type="hidden" name="id" value="<%=id%>">
    <input type="submit" name="formatOkSubmit" value="Ok"><b></b>
    <input type="button" value="Back" onclick="HomeButton()">
    <script>
        function HomeButton() {
            location.href = "/jss/w6/Demo.jsp";
        }
    </script>
</form>
</body>
</html>
