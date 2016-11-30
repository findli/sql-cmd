<%@ taglib prefix="misc" uri="http://javajoy.net/JSS/miscTags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom tags</title>
</head>
<body>
    <c:set var="var" value="pageScope->var"/>
    <c:set var="var" value="sessionScope->var" scope="session"/>
    <%
        out.println(pageContext.getAttribute("var",PageContext.PAGE_SCOPE) + "<br>");
        out.println(pageContext.getAttribute("var",PageContext.SESSION_SCOPE) + "<br>");
    %>


    <h3> Simple tag: </h3>
    <misc:simpleTag/>

    <h3> Tag</h3>
    <table>
        <c:set var="n" value="3"/>
        <misc:iterationTag begin="1" end="${n}" var="item1">
            <tr> <td> ${item1} </td> </tr>
        </misc:iterationTag>
    </table>

</body>
</html>
