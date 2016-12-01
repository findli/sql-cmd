<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title> Localized page </title>
</head>
<body>
    <%--<c:forEach var="element" items="${sessionScope}">--%>
        <%--${element.key} : ${element.value} <br>--%>
    <%--</c:forEach>--%>
    <%--<p>--%>

    Session locale : ${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']} <br>
    Request locale : ${pageContext.request.locale} <br>
    <p>


    <fmt:setLocale value="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}" />

    <fmt:bundle basename="JSS.w07_p01.bundle.MyBundle" prefix="localizedPage." >

        <c:set var="date" value="01.12.15"/>
        <c:set var="amount" value="123000.456"/>

        <%--Number Parsing    --%>
        <fmt:parseNumber value="${amount}" title="number" parseLocale="en_US" var="parsedNumber"/>
        Number: <fmt:formatNumber title="number" value="${parsedNumber}" /> <br>
        Currency: <fmt:formatNumber title="currency" value="${parsedNumber}" />  <br>
        Formatted number: <fmt:formatNumber title="number" value="${parsedNumber}" pattern="####.###E0" />  <br>

        <%--Date formatting--%>
        <fmt:parseDate value="${date}" pattern="dd.MM.yy" var="parsedDate" />  <br>
        <fmt:message key="date" />
        <fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd"/>  <br>

    </fmt:bundle>

</body>
</html>
