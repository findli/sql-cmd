<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="misc" uri="http://ya.local" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: miiix
  Date: 20.11.16
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Functions</title>
</head>
<body>

<h3>Standard</h3>
<c:set var="str" value="abcdEF"></c:set>
${fn:replace(fn:toLowerCase(str), "de", "XXXX")}

<h3>Custom</h3>
${misc:concat("Abc", "def")}
<br>
<%--${misc:map2String(header, "<br>", " : ")}--%>
<fmt:setLocale value="ru_RU" scope="session"/>
<c:set var="newVar" value="abcd" scope="session"/>
${misc:map2String(sessionScope, "<br>", " : ")}
</body>
</html>
