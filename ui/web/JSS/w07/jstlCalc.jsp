<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 20.11.16
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3>calculator</h3>
<form action="" method="get">
    <input type="text" name="a" size="10" value="${param.a}">
    <select name="operation" id="operation" value="${param.operation}">
        <option value="+">Add</option>
        <option value="-">Substract</option>
        <option value="*">Multiply by</option>
        <option value="/">Divide by</option>
    </select>
    <input type="text" name="b" size="10" value="${param.b}">
    <br>
    <input type="submit">
    <input type="reset">
</form>
<c:catch var="exception">
<c:if test="${not empty param.a and not empty param.b and not empty param.operation}" var="testEmptyParam">
    <c:set var="a">
        <fmt:parseNumber value=""/>
    </c:set>
    <c:set var="b">
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
    <h3>Result: ${param.a} ${param.operation} ${param.b} = ${result}</h3>
</c:if>

<c:if test="${!testEmptyParam}">
    <h3>enter 2 operands and operation</h3>
</c:if>

</c:catch>
<c:if test="${not empty exception}">
    <h1>Error: ${exception} ${exception.message}</h1>
</c:if>
</body>
</html>
