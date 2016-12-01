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
        conn = w2.om.DBConnection.getConnection("az_organizer");
    }
%>

<%
    int idContact = Integer.parseInt(request.getParameter("idContact"));
    String formOkSubmit = request.getParameter("formatOkSubmit");
    PreparedStatement stmt;
    ResultSet rs;
    if (conn != null) {
        try {
            stmt = conn.prepareStatement("select nameContact from contact where idContact = ?");
            stmt.setInt(1, idContact);
            rs = stmt.executeQuery();
            while (rs.next()) out.println("Do you want remove all info about " + rs.getString(1) + "<br>");
            if (formOkSubmit != null) {
                CallableStatement removeItem;
                removeItem = conn.prepareCall("{call az_organizer.removeItem(?)}");
                removeItem.setInt(1, idContact);
                removeItem.execute();
                out.println("Item has removed");
            }
        } catch (SQLException e) {
            e.printStackTrace(new PrintWriter(out, true));
        }
    }
%>

<form>
    <input title="hidden" name="idContact" value="<%=idContact%>">
    <input title="submit" name="formatOkSubmit" value="Ok"><b></b>
    <input title="button" value="Back" onclick="HomeButton()">
    <script>
        function HomeButton() {
            location.href = "/jss/w6/Demo.jsp";
        }
    </script>
</form>
</body>
</html>
