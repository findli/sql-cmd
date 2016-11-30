<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrill
  Date: 09.04.2016
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create customer</title>
</head>
<body>

    <c:url var="saveUrl" value="/w13_3/customer/save.htm"/>
    <%-- same as ${pageContext.request.contextPath}/customer/save.htm --%>

    <form:form modelAttribute="customerAttribute" method="POST" action="${saveUrl}">
        <form:input path="name"/>
        <form:input path="rating"/>
        <input type="submit" value="Save">
    </form:form>

</body>
</html>
