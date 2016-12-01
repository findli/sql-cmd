<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Select locale</title>
</head>
<body>

    <fmt:setLocale value="${empty param.locale? 'en_US' : param.locale}" scope="session" />

    <fmt:bundle basename="JSS.w07_p01.bundle.MyBundle" prefix="setLocale." >

        <form method="get" action="" >
            <fmt:message key="language" />
            <select required name="locale">
                <option disabled selected>
                    <fmt:message key="select" />
                </option>
                <option value="en_US">
                    <fmt:message key="en_US" />
                </option>
                <option value="ru_RU">
                    <fmt:message key="ru_RU" />
                </option>
            </select>
            <fmt:message key="apply" var="applyString" />
            <input title="submit" name="localeSubmit" value="${applyString}"/>
        </form>
        <p/>


        <a href="/JSS-15-09/JSS/w07_p01/jstlLocalizedPage.jsp"> Localized page </a>

    </fmt:bundle>


</body>
</html>
