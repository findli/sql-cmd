<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="misctags" uri="http://javajoy.net/JSS/miscTags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrill
  Date: 28.11.2015
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User's Album</title>
</head>
<body>

    <jsp:useBean id="photoDAO" class="JSS.w07_p02.bean.PhotoDAO" scope="session"/>
    ${photoDAO.addToSession(pageContext.request.session)}

    <h3> Photos: </h3>

    <table>
        <tr>
            <c:forEach var="i" begin="0" end="${photoDAO.size-1}">
                <td>
                    <misctags:photoTag id="${i}"/>
                </td>
            </c:forEach>
        </tr>
        <tr>
            <c:forEach var="name" items="${photoDAO.namesAsList}">
                <td>
                    ${name}
                </td>
            </c:forEach>
        </tr>
        <tr>
            <c:forEach var="i" begin="0" end="${photoDAO.size-1}">
                <td>
                        <a href="/removePhotoServlet?id=${i}"> Remove </a>
                </td>
            </c:forEach>
        </tr>
    </table>
    <p>
    <form action="/JSS-15-09/uploadPhoto" method="post" enctype="multipart/form-data">
        <input type="file" name="file" accept="image/jpeg"> <br>
        <input type="submit" value="Upload">
    </form>


</body>
</html>
