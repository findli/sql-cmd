<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers list</title>
    </head>

    <a href="create.htm">Create new customer</a>
    <br><br>
    <body>
        <c:forEach items="${customers}" var="customer">
            ${customer.name}
            <a href="update/${customer.id}.htm">edit</a>
            <a href="delete/${customer.id}.htm">delete</a>
            <br>
        </c:forEach>

    </body>
</html>
