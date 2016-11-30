<%@ page import="java.util.Date" %>
<%@ page import="JSS.w07_p01.beans.CalculatorBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Beans Test</title>
</head>
<body>

    <h3> Date bean </h3>
    <jsp:useBean id="dateValue" class="java.util.Date" />
    <%--<% new Date().setTime(10);%>--%>
    <jsp:setProperty name="dateValue" property="time" value="${pageContext.session.creationTime}" />
    <jsp:getProperty name="dateValue" property="time"/>
    ${dateValue.toString()} <br>
    Session creation time = <fmt:formatDate value="${dateValue}" pattern="dd/MM/yyyy HH:mm:ss" /> <br>
    <jsp:setProperty name="dateValue" property="time" value="${pageContext.session.lastAccessedTime}" />
    Session last access time = <fmt:formatDate value="${dateValue}" pattern="dd/MM/yyyy HH:mm:ss" /> <br>



    <h3> Calculator bean </h3>
    <jsp:useBean id="calc" class="JSS.w07_p01.beans.CalculatorBean" scope="session"/>
    <jsp:setProperty name="calc" property="a" value="12"/>
    <jsp:setProperty name="calc" property="b" value="13"/>
    <jsp:setProperty name="calc" property="operation" value="*"/>
    ${calc.a} ${calc.operation} ${calc.b} = ${calc.result} <br>
    ${calc.reset()}
    ${calc.result}<br>


</body>
</html>
