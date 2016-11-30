<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="misc" uri="http://javajoy.net/JSS/miscFunctions" %>


<html>
<head>
    <title> Functions </title>
</head>
<body>

    <h3> Standard </h3>

    <c:set var="str" value="abcdEF"/>
    ${fn:replace(fn:toLowerCase(str), "de", "XXXX")}

    <h3> Custom </h3>

    ${misc:concat("Abc"," def")}
    <p>
    ${misc:map2String(header, "<br>", " : ")}
    <p>
    <fmt:setLocale value="ru_RU" scope="session"/>
    <c:set var="newVar" value="abdc" scope="session"/>
    ${misc:map2String(sessionScope, "<br>", " : ")}






</body>
</html>
