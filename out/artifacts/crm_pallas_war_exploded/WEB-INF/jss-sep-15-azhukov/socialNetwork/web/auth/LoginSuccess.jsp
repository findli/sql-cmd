<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login Success Page</title>
</head>
<body>


<%-- Authorization -> filter --%>
    <c:if test="${not empty sessionScope.login}" var="auth">
        <h3>Welcome, ${sessionScope.login} </h3><br>
        <%-- DB -> userID .... --%>
        <%-- Can userID access this page ???--%>
        ${pageContext.response.setIntHeader("Expires",0)}
        ${pageContext.response.setHeader("Pragma", "no-cache")}
        ${pageContext.response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")}

    </c:if>
    <c:if test="${not auth}" >
        <c:redirect url="/auth/Login.html"/>
        <%-- sendRedirect() --%>
    </c:if>

    Page content

    <form action="/social/auth/LogoutServlet" method="post">
        <input type="submit" value="Logout" >
    </form>
</body>
</html>