<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Edit item</title>
</head>
<body>
<%!
    Connection conn = null;

    @Override
    public void jspInit() {
        conn = w2.om.DBConnection.getConnection("az_organizer");       // CK : It's OK for now, but not really efficient
    }
%>
<%
    int idContact = Integer.parseInt(request.getParameter("idContact"));
    // String setName = request.getParameter("nameContact");
    // CK : (!!!) To recognize the edit form's request
    // better use some specific parameter which only that form produces (see the revised form)
    String formSubmit = request.getParameter("formEditSubmit");


    if (formSubmit != null)  // CK : Use the specific parameter that only the edit form produces
    {
        // CK : "idContact" parameter from the form is in idContact variable
        // CK : Here obtain the rest of the form parameters
        String setNameContact = request.getParameter("contactName");
        String setEmail = request.getParameter("e_mail");
        String setPhoneWork = request.getParameter("phone_work");
        String setPhoneHome = request.getParameter("phone_home");
        String setMeetDate = request.getParameter("meetDate");

        String sql = "set @updateID =( select idContact from contact where  idContact = ?);\n" +
                "update e_mail SET e_mail = ? where idContact = @updateID;\n" +
                "update phone set phone_home = ?, phone_work =? where idContact =@updateID;\n" +
                "update contact set nameContact = ? where idContact = @updateID;"+
                "SET SQL_SAFE_UPDATES=0;"+
                "update meet set meetDate = ? where idMeet= (select idMeet from contact_has_meet where contact_has_meet.idContact = @updateID);\n"+
                "SET SQL_SAFE_UPDATES=1;";
        try {
        PreparedStatement psUpdate = conn.prepareStatement(sql);
            psUpdate.setInt(1, idContact);
            psUpdate.setString(2, setEmail);
            psUpdate.setString(3, setPhoneHome);
            psUpdate.setString(4, setPhoneWork);
            psUpdate.setString(5, setNameContact);
            psUpdate.setString(6, setMeetDate);// CK : (!!!) Now it comes from the form's hidden field
            psUpdate.executeUpdate();       // CK: (!!!) Not executeQuery()
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // CK : Here redirecting to the main page (Demo.jsp) is appropriate.
        //      may use RequestDispatcher to transfer some message via request attributes (you cannot add parameters)

    }

    // CK : The rest is needed only if the request came from the main page (not from the edit form)

    String sql = "select nameContact,phone_work, phone_home, e_mail,reminderDate, meetDate\n" +
            "from contact\n" +
            "inner join phone on phone.idContact=contact.idContact\n" +         // CK : don't need join if editing only contact table
            "inner join e_mail on e_mail.idContact=contact.idContact\n" +       // CK : in my version of DB some contacts are lost in this query. That means broken foreign keys
            "inner join contact_has_meet on  contact_has_meet.idContact=contact.idContact\n" +
            "inner join meet on  contact_has_meet.idMeet=meet.idMeet\n" +
            "inner join reminder on reminder.idMeet=meet.idMeet\n" +
            "where contact.idContact = ?;";
    PreparedStatement stm;
    ResultSet rs;

        stm = conn.prepareStatement(sql);
        stm.setInt(1, idContact);
        rs = stm.executeQuery();


    // CK : Use rs to find out name, phone and other contact details
    String contactName = "";
    String phone_work = "";
    String phone_home = "";
    String e_mail = "";
    String meetDate = "";
    if (rs.next()) {
        contactName = rs.getString("nameContact");
        phone_work = rs.getString("phone_work");
        phone_home = rs.getString("phone_home");
        e_mail = rs.getString("e_mail");
        meetDate = rs.getString("meetDate");
    }
%>

<form method="post">
    <p><b>New name contact</b>
        <input type="hidden" name="idContact" value="<%=idContact%>"> <%-- CK : We need to receive idContact with the request too  --%>
        <input type="text" size="30" name="contactName" value="<%=contactName %>"></p>

    <p><b>New phone work</b>
        <input type="text" size="30" name="phone_work" value="<%=phone_work %>"></p>

    <p><b>New phone home</b>
        <input type="text" size="30" name="phone_home" value="<%=phone_home %>"></p>

    <p><b>New e-mail</b>
        <input type="text" size="30" name="e_mail" value="<%=e_mail %>"></p>

    <p><b>New meetDate</b>
        <input type="//text" size="30" name="meetDate" value="<%=meetDate %>"></p>
    </p>
    <p></p>
    <input type="submit" name="formEditSubmit" value="Ok"> <%-- CK : This i sused to regognize the request from this particular form--%>
</form>
</body>
</html>
