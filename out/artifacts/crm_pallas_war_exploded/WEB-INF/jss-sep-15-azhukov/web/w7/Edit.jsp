<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<head>
    <title>Edit item</title>
</head>
<%-- AZ: Вызываю метод uodate() напрямую из dao, т.к. бин класс будет просто посрелником. Так можно?--%>
<jsp:useBean id="email" class="w7.dao.EmailDAO" scope="page"></jsp:useBean>
<jsp:useBean id="meet" class="w7.dao.MeetDAO" scope="page"></jsp:useBean>


<c:if test="${param.idEmail != null}">
    <c:set var="resultItem" value="${email.getByID(param.idEmail)}"/>
</c:if>
<c:if test="${param.idMeet != null}">
    <c:set var="resultItem" value="${meet.getByID(param.idMeet)}"/>
</c:if>

<c:if test="${param.sub.equals('Ok')}">
    <c:if test="${param.idEmail != null}">
        <c:set var="resultItem" value="${email.update(param.idEmail,param.item)}"/>
    </c:if>
    <c:if test="${param.idMeet!= null}">
        <c:set var="resultItem" value="${meet.update(param.idMeet,param.item)}"/>
    </c:if>
    The item has been updated
</c:if>

<form method="post">
    <p><b>Correct item</b>
        <input title="text" size="30" name="item" value="${resultItem}"></p>
    <a href='/jss/w7/Detail.jsp?idContact=${param.idContact}'>&lt;&lt;Back</a><br>
    <input title="button" value="Home" onclick="HomeButton()">
    <script>
        function HomeButton() {
            location.href = "/jss/w7/Contact.jsp";
        }
    </script>
    <input title="submit" name="sub" value="Ok">
</form>
</body>
</html>
