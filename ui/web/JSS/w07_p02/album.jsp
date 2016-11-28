<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="misctags" uri="http://ya.local/sqlCmd/miskTags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User's album</title>
</head>
<body>
<jsp:useBean id="photoDAO" class="JSS.w07_p02.bean.PhotoDAO" scope="session"/>
${photoDAO.addToSession(pageContext.request.session)}
<h3>Photo:</h3>
<table>
    <tr>
        <c:forEach var="i" begin="0" end="${photoDAO.size-1}">
            <td>
                <misctags:photoTag id="${i}"/>
            </td>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach var="i" begin="0" end="${photoDAO.size-1}">
            <td>
                    ${photoDAO.getPhotoName(i)}
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
                <a href="/removePhotoServlet?id=${i}">remove</a>
            </td>
        </c:forEach>
    </tr>
</table>
<form action="/JSS-15-09/uploadPhoto" method="post" enctype="multipart/form-data">
    <input type="file" name="file" accept="image/jpeg">
    <br>
    <input type="submit" value="Upload">
</form>
</body>
</html>
