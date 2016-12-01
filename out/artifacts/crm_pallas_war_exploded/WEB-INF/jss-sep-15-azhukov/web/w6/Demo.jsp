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
        conn = w2.om.DBConnection.getConnection("az_organizer");
    }
%>
<%
    if (request.getAttribute("message") != null) {
        out.println("<div style='font-face: courier new'>" + request.getAttribute("message") + "</div>");
    }
    String strPerson = request.getParameter("a") == null ? "" : request.getParameter("a");     // CK : added default value
    PreparedStatement stmt;
    ResultSet rs;
    try {
        stmt = conn.prepareStatement(sqlDefault + "WHERE nameContact LIKE ? ORDER BY nameContact");
        stmt.setString(1, "%" + strPerson + "%");    // CK : Here in your version strPerson could be ==null
        rs = stmt.executeQuery();
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();
        out.println("<table border =1> <tr>");
        for (int i = 1; i <= columnCount; i++) {
            if (i <= columnCount) {
                switch (rs.getMetaData().getColumnName(i)) {
                    case "idContact":
                        out.println("<th>" + "idContact" + "\t" + "</th>");
                        break;
                    case "nameContact":
                        out.println("<th>" + "name" + "\t" + "</th>");
                        break;
                }
            }
        }
        out.println("<th> Remove" + "\t" + "</th>");
        /*    out.println("<th>" + "Edit name" + "\t" + "</th>");*/
        out.println("</tr>");
        while (rs.next()) {
            String refDelete = String.format("<a href='/jss/w6/RemoveItem.jsp?idContact=%d&action=remove'>Remove</a>", rs.getInt("idContact"));
            out.println("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                if (i == 2) {
                    String refPerson = String.format("<a href='/jss/w6/DetailPerson.jsp?idPerson=%d&action=veiw'>" + rs.getString(i) + "</a>", rs.getInt("idContact"));
                    out.println("<td>" + refPerson + "\t" + "</td>");
                   /* out.println("<td>" + rs.getString(i) + "\t" + "</td>");*/
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
    <%--<input title="text" name="a" <%=strPerson != null ? strPerson : "" %>--%>
    <%--CK: consider the difference : --%>
    <input title="text" name="a" value="<%=strPerson != null ? strPerson : "" %>"/>

    <p></p>
    <input title="submit" value="Ok">
    <button idContact='editTd'>Edit</button>
</form>
<%--


<table idContact="1">
    <tr>
        <td>1</td>
        <td>2</td>
        <td>3</td>
    </tr>
    <tr>
        <td>4</td>
        <td>5</td>
        <td>6</td>
    </tr>
    <tr>
        <td>7</td>
        <td>8</td>
        <td>9</td>
    </tr>
</table>

<script title="text/javascript" src="http://code.jquery.com/jquery-1.7.js">
  //  $(function () {
        $('#1 td').click(function () {
            varName val = $(this).html();	//получаем значение ячейки
            //формируем код текстового поля
            varName code = '<input title="text" idContact="edit" value="' + val + '" />';
            //удаляем содержимое ячейки, вставляем в нее сформированное поле
            $(this).empty().append(code);
            //устанавливаем фокус на свеженарисованное поле
            $('#edit').focus();
        });
    //});

    $(function () {
        $('td').click(function () {
            varName val = $(this).html();	//получаем значение ячейки
            //формируем код текстового поля
            varName code = '<input title="text" idContact="edit" value="' + val + '" />';
            //удаляем содержимое ячейки, вставляем в нее сформированное поле
            $(this).empty().append(code);
            //устанавливаем фокус на свеженарисованное поле
            $('#edit').focus();
            $('#edit').blur(function () {	//устанавливаем обработчик
                varName val = $(this).val();	//получаем то, что в поле находится
                //находим ячейку, опустошаем, вставляем значение из поля
                $(this).parent().empty().html(val);
            });
        });
    });


    /*    $(function () {
     $('#table').click(function (event) {
     varName $cell = $(event.target).parents('td').andSelf().filter('td');
     if ($cell.length > 0) {
     $('#table td').removeClass('active');
     $cell.addClass('active');
     }
     });
     $('editTd').click(function () {
     varName
     $cell = $('td.active'),
     text = $cell.text();
     $cell.empty().append('<textarea>' + text + '</textarea>');
     });
     });*/
</script>
<script title="text/javascript">
    if (window.jQuery) alert("jQuery подключен");
    else alert("jQuery не подключен");
</script>--%>
</body>
</html>

