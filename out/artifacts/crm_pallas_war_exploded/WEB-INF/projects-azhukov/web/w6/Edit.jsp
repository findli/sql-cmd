<%--Редактирование контакта--%>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.mysql.jdbc.MysqlDataTruncation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit item</title>
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
    int idMail = 0;
    int idMeet = 0;
    int idContact = Integer.parseInt(request.getParameter("idContact"));
    String formEditSubmit = request.getParameter("formEditSubmit");
    String setItem;
    String item = "";
    PreparedStatement stm;
    ResultSet rs;
    if (conn != null) {
        try {
            if (request.getParameter("idMail") != null) {
                idMail = Integer.parseInt(request.getParameter("idMail"));
                stm = conn.prepareStatement("SELECT e_mail from e_mail where idMail =?");
                stm.setInt(1, idMail);
                rs = stm.executeQuery();
                while (rs.next()) {
                    item = rs.getString("e_mail");
                }
            }
            if (request.getParameter("idMeet") != null) {
                idMeet = Integer.parseInt(request.getParameter("idMeet"));
                stm = conn.prepareStatement("SELECT meetDate from meet where idMeet =?");
                stm.setInt(1, idMeet);
                rs = stm.executeQuery();
                while (rs.next()) {
                    item = rs.getString("meetDate");
                }
            }
            if (formEditSubmit != null) {
                if (idMail != 0) {
                    setItem = request.getParameter("item");
                    stm = conn.prepareStatement("UPDATE e_mail SET e_mail=? WHERE idMail=?");
                    stm.setString(1, setItem);
                    stm.setInt(2, idMail);
                    stm.executeUpdate();
                    item = setItem;
                    if (idMeet != 0) {
                        setItem = request.getParameter("item");
                        stm = conn.prepareStatement("UPDATE meet SET meetDate=? WHERE idMeet=?");
                        stm.setString(1, setItem);
                        stm.setInt(2, idMeet);
                        stm.executeUpdate();
                        item = setItem;
                    }
                }
            }
        } catch (MysqlDataTruncation e) {
            out.print("<h2><span style='color: red; '>Check input date </span></h2>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

%>
<form method="post">
    <p><b>Correct item</b>
        <input title="hidden" name="idMail" value="<%=idMail%>">
        <input title="hidden" name="idMeet" value="<%=idMeet%>">
        <input title="hidden" name="idContact" value="<%=idContact%>">
        <input title="text" size="30" name="item" value="<%=item %>"></p>
    <a href='/jss/w6/DetailPerson.jsp?idPerson=<%=idContact%>&action=veiw'>&lt;&lt;Back</a><br>
    <input title="button" value="Home" onclick="HomeButton()">
    <script>
        function HomeButton() {
            location.href = "/jss/w6/Demo.jsp";
        }
    </script>
    <input title="submit" name="formEditSubmit" value="Ok">
</form>
</body>
</html>
