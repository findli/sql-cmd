<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Random" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="../../../test/web/w07/styles.css"/>

<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2 class="header">Calculator</h2>
<form method="get">
    <input type="text" name="a" size="10" value="${param.a}">
    <select name="operation" value="${param.operation}">
        <option value="+">Add</option>
        <option value="-">Subtract</option>
        <option value="*">Multiply by</option>
        <option value="/">Divide by</option>
    </select>
    <input type="text" name="b" size="10" value="${param.b}">

    <p></p>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>


<c:catch var="exception">
<c:if test="${not empty param.a and not empty param.b and not empty param.operation}" var="testEmptyParam">
    <c:set var="a">
        <fmt:parseNumber value=""/>
    </c:set>
    <c:set var="result" value="0"/>
        <c:choose>
            <c:when test="${param.operation == '+'}">
                <c:set var="result" value="${0 + param.a + param.b}"/>
            </c:when>
            <c:when test="${param.operation == '-'}">
                <c:set var="result" value="${0 + param.a - param.b}"/>
            </c:when>
            <c:when test="${param.operation == '*'}">
                <c:set var="result" value="${0 + param.a * param.b}"/>
            </c:when>
            <c:when test="${param.operation == '/'}">
                <c:set var="result" value="${0 + param.a / param.b}"/>
            </c:when>
        </c:choose>
        <h2 class="result">Result : ${param.a} ${param.operation} ${param.b} = ${result} </h2>

</c:if>
<c:if test="${!testEmptyParam}">
    <h2>Enter 2 operands and select operation</h2>
</c:if>
</c:catch>

<c:if test="${not empty exception}" >
    <h2> Error : ${exception} ${exception["message"]} </h2>
</c:if>


</body>
</html>


