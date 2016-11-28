<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Select locale</title>
</head>
<body>
<fmt:setLocale value="${empty param.locale ? 'en_US' : param.locale}" scope="session"/>
<fmt:setLocale value="${empty param.locale ? 'en_US' : param.locale}" scope="page"/>

<fmt:bundle basename="JSS.w07_p01.bundle.MyBundle_en_US" prefix="setLocale.">
    <form action="" method="get">
        <fmt:message key="language"/>
        <select name="locale" id="" required>
            <option value="" disabled selected><fmt:message key="select"/></option>
            <option value="en_US"><fmt:message key="en_US"/></option>
            <option value="ru_RU"><fmt:message key="ru_RU"/></option>
        </select>
        <fmt:message key="apply" var="applyMessage"/>
        <input type="submit" name="localeSubmit" value="${applyMessage}">
    </form>

    <br>
    <br>

    <a href="/JSS-15-09/JSS/w07_p01/jstlLocalizedPage.jsp">Localized page</a>
</fmt:bundle>
</body>
</html>
