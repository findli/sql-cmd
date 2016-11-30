<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>TSTL</title>
</head>
<body>

    <c:forEach var="i" begin="0" end="9">
        ${i+2} &nbsp;&nbsp;&nbsp;
    </c:forEach>

    <br>
    <c:set var="v1" value="acb"/>
    <c:out value="value = ${(Math.PI*2)/3}${v1}"/>

    <%--Vars--%>
    <br><br>
    <c:set var="clientID" scope="page" value="115255"/>

    <c:set var="clientID" scope="session" value="0"/>
    <c:if test="${not empty param['clientID']} " >
        <c:set var="clientID" scope="session">
            ${param["clientID"]}
            <%--${param.clientID}--%>
            <%--${param.get("clientID")}--%>
        </c:set>
    </c:if>
    <%--${ empty param["clientID"]? 0 : 1}--%>

    Client ID (page) = ${pageScope.clientID}
    Client ID (session) = ${sessionScope.clientID}

    <c:remove var="clientID" scope="page"/>

    Client ID (page) = ${pageScope.clientID}
    Client ID (session) = ${sessionScope.clientID}


    <%--PageContext--%>
    <br><br>
    <h3>PageContext </h3>
    Is new session (v1): ${pageContext.session.isNew()} <br>
    Is new session (v2): ${pageContext.session["new"]} <br>
    Attribute : ${pageContext.session.setAttribute("a","abc")}
            ${pageContext.session.getAttribute("a")} <br>
    Parameter (v1) : ${pageContext.request.getParameter("clientID")} <br>
    Parameter (v2) : ${param.clientID} <br>

    <%--Headers--%>
    <br><br>
    <h3>Headers </h3>
    <br><b>v1</b>
    <c:set var="headerNames" value="${header.keySet()}" scope="page"/>
    <c:forEach var="name" items="${headerNames}">
        ${name} = ${header[name]} <br>
    </c:forEach>

    <br><b>v2</b>
    <c:set var="headerNames1" value="${pageContext.getRequest().headerNames}"/>
    ${headerNames}



    <h3>Session</h3>
    <div style="font-family: Courier New">
        New = <c:out value="${pageContext.session['new']}"/>     <%-- session.new нельзя т.к. new - зарезервированное слово--%>
        <c:if test="${pageContext.session['new']}" var = "testNewSession" >
            <c:set var="visitCount" value="${1}" scope="session"/>
        </c:if>
        <c:if test="${!testNewSession}">
            <c:set var="visitCount" value="${0+visitCount+1}" scope="session"/>
        </c:if>
        Visit count = ${sessionScope.visitCount}

    </div>


    <%--ForEach--%>
    <br><br>
    <h3>ForEach </h3>
    <c:set var="items" value="2,3,6,8,dggd,fhhfh,fjfjfj,2,4,5,7"/>
    <c:forEach var="elem" items="${items}" begin="2" end="6" step="2" varStatus="status">
        ${elem} ->  Current : ${status.current} - Count : ${status.count} - Index : ${status.index} - First : ${status.first}<br>
    </c:forEach>
    <br><br>
    <c:forEach var="elem" items="${items}" varStatus="status">
        ${elem}${status.last? "<br>":","}
    </c:forEach>
    The end

    <br><b>Heders v3</b>
    <div style="font-family: Courier New"> Headers: <br>
        <c:forEach var="hdr" items="${header}">
            ${hdr.key} = ${hdr.value} <br>
        </c:forEach>
    </div>

</body>
</html>
