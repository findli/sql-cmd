<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>update customer</title>
</head>
<body>
update customer
<c:url var="saveUrl" value="save.htm"></c:url>
<%--<context>/save.htm--%>
<form:form modelAttribute="customerAttribute" method="POST" action="${saveUrl}">
    <form:hidden path="id"/>
    <form:input path="name"/>
    <form:input path="rating"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
