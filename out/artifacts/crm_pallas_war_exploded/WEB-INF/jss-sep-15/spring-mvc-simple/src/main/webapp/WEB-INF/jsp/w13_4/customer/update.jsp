<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrill
  Date: 09.04.2016
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update customer</title>
</head>
<body>

    <c:url var="saveUrl" value="/w13_4/customer/save.htm"/>
    <%-- <context>/customer/save.htm --%>

    <form:form modelAttribute="customerAttribute" method="POST" action="${saveUrl}">
      <form:hidden path="id"/>
      <form:input path="name"/>
      <form:input path="rating"/>
      <input title="submit" value="Save">
    </form:form>

</body>
</html>
