<%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 19.11.16
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>jstl tags</title>
</head>
<body>
<c:forEach var="prm" items="${param}">
    ${prm.key} = ${prm.value}
</c:forEach>
<br>
<br>
<c:set var="cart.items" scope="session" value="First,Second,Third"></c:set>
<c:forEach var="item" items="${sessionScope['cart.items']}" varStatus="st1">
    <c:out value="${item}"/>
    <c:out value="${st1.index}"/>
    <br>
</c:forEach>
<br>
<br>
<c:forTokens var="name" items="asd,asd,asd" delims=",">
    ${name}<br>
</c:forTokens>
<br>
<br>
<%
    /*
    Map items -> Map.Entry
    items int, float -> Integer, Float
    items Iterator, Enumerator -> can't reuse
     */
%>
<c:set var="items" value="2,3,4,6,8df,456,dfhg,dfgh,fgh,dfgh,sfg,3"/>

<c:forEach var="elem" items="${items}" begin="2" end="6" step="2" varStatus="status">
    current: <br>
    ${status.current}
    count: <br>
    ${status.count}

    index:
    <br>
    ${status.index}
    <br>
    first: ${status.first}
    <br>
    first: ${status.last}
    ${elem} <br>
</c:forEach>

<%--<c:import url="http://ya.ru">
    <c:param name="name1"></c:param>
</c:import>--%>
<%--<c:forTokens></c:forTokens>--%>
<c:url value="http://ya.ru"></c:url>
<br>
<%--<c:redirect url="http://ya.ru"></c:redirect>--%>
<%
    /*
    ${value_a["value_b"]}

        // value_a - Map
        if (value_a.containsKey(value_b)) {
            return value_a.get(value_b);
        }else return null;
        // value_a List/Array
        return value_a.get(value_b);
        return Array.get(value_a, value_b);
        // IndexOutOfBoundExceprtion not throws - return null

        // if value_a JavaBeans then value_b - bean param.
    */

    // эти не меняют ClientID из ${pageContext.request.getParameter('ClientID')} !!!!!
    pageContext.getRequest().setAttribute("ClientID", "val1");
    request.setAttribute("ClientID", "123");
%>
// клюки: скоп реквест а не перезаписывает гет параметр !!!!
<c:set var="ClientID" value="val1" scope="request"/>
\${pageContext.request.getParameter('ClientID')}:
<c:out value="${pageContext.request.getParameter('ClientID')}"></c:out>
<br>
header[pageScope.headerAgent]:
<c:out value="${header[pageScope.headerAgent]}"/>
<br>
<br>
<c:out value="${pageContext.session.isNew()}"/>
<c:out value="${pageContext.session['new']}"/>
<c:out value="${pageContext.session.attributeNames}"/>
<br>
<br>
<c:out value="${param.useID}"/>
<br>
<c:out value="${param.useID}"/>
<br>
<c:out value="${paramValues}"/>
<br>
<c:out value="${header}"/>
<br>
<c:out value="${headerValues}"/>
<br>
<c:out value="${cookie}"/>
<br>
<c:out value="${initParam}"/>
<br>
<%
    PageContext pageContext1 = pageContext;
    pageContext.getServletContext();
    HttpSession session1 = session;
    HttpServletRequest request1 = request;
    HttpServletResponse response1 = response;

%>
// order:
<c:set scope="page" var="v1"/>
<c:set scope="request" var="v1"/>
<c:set scope="session" var="v1"/>
<c:set scope="application" var="v1"/>
<br>
<br>
<c:out value="${empty param['clientID'] ? 'clientID is empty or null because not passed as GET param' : 'clientID is NOT empty or null'}"/>
<br>
<c:choose>
    <c:when test="${empty var1}">
        var1 is empty or null.
    </c:when>
    <c:when test="${var1 == 1}">
        var1 is empty or null.
    </c:when>
    <c:otherwise>
        var1 is NOT empty or null.
    </c:otherwise>
</c:choose>
<br>
<br>
<c:set var="var" value="not empty"/>
<c:if test="${not empty var}">// not empty - keywords.
    var isn't empty, not NULL!
</c:if>
<br>
<c:set var="var" value=""/>
<c:if test="${empty var}">// empty - keyword.
    var is empty or NULL!
</c:if>
<br>
<c:set var="a" value="1"/>
<c:set var="b" value="b1"/>
<c:set var="c" value="a is not bool"/>
<c:out value="${a?b:c}"/>
<br>
<c:set var="a" value="true"/>
<c:set var="b" value="a is bool"/>
<c:set var="c" value="c1"/>
<c:out value="${a?b:c}"/>
<br>
<br>
<%
    request.setAttribute("userID", "request"); // not works because jsp already compiled.
    pageContext.setAttribute("userID", "pageScope"); // not works because jsp already compiled.
    session.setAttribute("userID", "session"); // not works because jsp already compiled.
%>
<c:set var="clientID" value="1" scope="page"/>
<c:set var="clientID" scope="session">
    ${requestScope.userID}
    ${pageScope.clientID}
    ${pageScope["userID"]} // and access to List
    ${pageScope["clientID"]}
    ${sessionScope.get("userID")}
    ${param.get("userID")} // param - from query string
    ${pageScope.get("clientID")}
</c:set>
<c:out value="${clientID}"/>
<br>
<c:out value="${sessionScope.clientID}"/>
<br>
<c:out value="${pageScope.clientID}"/>
<br>
<br>
<c:set var="v7" value="v7 val from 'value'"/>
<c:out value="${applicationScope['v7']}"></c:out>
<br>
<c:out value="${applicationScope.v7}"></c:out>
<br>
<c:out value="${applicationScope.get('v7')}"></c:out>
<br>
<br>
<c:set var="v2" scope="session" value="2000"/>
<c:set var="v3" scope="application" value="2000"/>
<c:set var="v4" scope="page" value="2000"/>
<c:set var="v5" scope="request" value="2000"/>
<c:set var="v6" scope="session">
    ${v5}
</c:set>
<c:out value="${v6}"></c:out>
<c:remove var="v6"/>
<c:remove scope="request" var="v5"/>
<br>
<c:out value="${v6}"></c:out>
<br>
<br>

// for custom attributes will be cast to correspond type:
<%
    out.println(Float.valueOf("1.2E4").floatValue());
%>
<br>
<br>
<c:out value="${123}"></c:out>
<br>
// order:
<br>
// from left to right
<br>
// cast to String and concatenation( +)
<br>
// cast result to attribute type
<br>
<c:set var="first">123</c:set>
<c:set var="second">456</c:set>
<c:set var="third">789</c:set>
<c:out value="some${first}${second}text${third}"></c:out>
<br>
<c:out value="${first}${second}${third}"></c:out>
<br>
<c:set var="v1">acb</c:set>
<c:out value="${2*2}${v1}"></c:out>
<br>
<br>
<c:forEach var="i" begin="2" end="10">
    ${i} &nbsp;&nbsp;&nbsp;
    // auto cast to int
    <br>
    ${i+2} &nbsp;&nbsp;&nbsp;
    // cast to int
    <br>
    ${0+i+2} &nbsp;&nbsp;&nbsp;
    // cast to string
    ${""+i+2} &nbsp;&nbsp;&nbsp;
    <br>
</c:forEach>
<br>
${(Math.PI*2)/3}
<%--comment--%>
<br>
<c:out value="equation: ${(Math.PI*2)/3}"/>
<br>

<c:forEach var="i" begin="2" end="10">
    ${i} &nbsp;&nbsp;&nbsp;
</c:forEach>
<br>
<br>
<fmt:parseDate var="dt1" value="13/12/2016" pattern="dd/mm/yyyy">
</fmt:parseDate>
<c:out value="${dt1}"></c:out>
<br>
<c:out value="${dt1}"/>
<br>
<br>
<fmt:parseDate var="dt2" pattern="dd-mm-yyyy">
    13-12-2016
</fmt:parseDate>
${dt2}
<br>
<br>
<c:out value="${dt2}"></c:out>
<br>
</body>
</html>