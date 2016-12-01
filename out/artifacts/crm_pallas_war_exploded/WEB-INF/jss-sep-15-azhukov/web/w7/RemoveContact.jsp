<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head>
    <title>Remove item</title>
</head>
<body>
<jsp:useBean id="contactBean" class="w7.bean.ContactBean" scope="page">
</jsp:useBean>
Do you want remove all info about ${contactBean.getPerson(param.idContact)} ?
<c:if test="${param.formatOkSubmit.equals('Ok')}">
    ${contactBean.removeItem(param.idContact)}
    Remove item is complete
</c:if>
</body>
<form method="post">
    <input title="submit" name="formatOkSubmit" value="Ok"><b></b>
    <input title="button" value="Back" onclick="HomeButton()">
    <script>
        function HomeButton() {
            location.href = "http://localhost:8080/jss/w7/Contact.jsp";
        }
    </script>
</form>
</html>
