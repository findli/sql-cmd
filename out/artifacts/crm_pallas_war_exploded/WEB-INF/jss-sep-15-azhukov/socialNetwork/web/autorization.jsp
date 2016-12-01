<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<jsp:useBean id="idProfile" class="dao.AutorizationDAO" scope="page"></jsp:useBean>
test login: artem; password: 1234;<p></p>
<c:if test="${param.sub.equals('Ok')}">

    <%--todo: use filters for authentication/authorization--%>

    <c:if test="${param.login !=null && param.password != null}">
        <c:set var="idProfile" value="${idProfile.checkLoginPassword(param.login,param.password)}"/>
    </c:if>
    <c:if test="${idProfile != -1}">
        <c:redirect url="mainPage.jsp?idProfile=${idProfile}"/>
    </c:if>
</c:if>

<form method="post">
    Login <input title="text" size="20" name="login"> <p></p>
    Password <input title="text" size="20" name="password"> <p></p>
    <input title="submit" name="sub" value="Ok">
</form>
</body>
</html>
