<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Contact</title>
</head>
<body>

<jsp:useBean id="сontactBean" class="w7.bean.ContactBean" scope="page">
</jsp:useBean>

<table border="1" width="25%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Remove</th>
    </tr>
    ${сontactBean.filter(param.name)}
    <c:if test="${сontactBean.size>=0}">
        <c:forEach var="i" begin="0" end="${сontactBean.size}">
            <p></p>
            <tr>
                <td>${сontactBean.getIdContact(i)}</td>
                <td><a href=${'/jss/w7/Detail.jsp?idContact'}=${сontactBean.getIdContact(i)}>${сontactBean.getName(i)} </a></td>
                <td>
                    <a href=${'/jss/w7/RemoveContact.jsp?idContact'}=${сontactBean.getIdContact(i)}>Remove</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>

</table>
<form method="post">
    <H4> Filter </H4>
    By name
    <input title="text" name="name" value="${param.name}">
    <p></p>
    <input title="submit" value="Ok">
</form>
</body>
</html>
