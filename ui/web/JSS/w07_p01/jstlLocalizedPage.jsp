<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Localized page</title>
</head>
<body>
<c:forEach var="element" items="${sessionScope}">
    ${element.key} : ${element.value}
    <br>
</c:forEach>
<br>
<br>
Session locale: ${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}
<br>
Request locale: ${pageContext.request.locale}
<br>
<fmt:setLocale value="${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}" scope="session"/>
${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session']}
<br>
<%--<fmt:setLocale value="${empty param.locale ? 'en_US' : param.locale}" scope="session"/>--%>
<c:set var="date" value="01.12.15"/>
не робит! :
<%--
<c:set var="amount" value="123000.456"/>

<fmt:parseNumber value="${amount}" type="number" parseLocale="en_US" var="parsedNumber"/>
Number: <fmt:parseNumber value="${parsedNumber}" type="number"/>
<br>
Currency: <fmt:parseNumber value="${parsedNumber}" type="currency"/>
<br>
Formatted number: <fmt:parseNumber value="${parsedNumber}" type="number" pattern="###,###E0"/>
--%>
<br>
<br>
<fmt:parseDate value="${date}" pattern="dd.mm.yy" var="parseDate"/>
<br>
<fmt:formatDate value="${parseDate}" pattern="yyyy-mm-dd"/>
</body>
</html>
