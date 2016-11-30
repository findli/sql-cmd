<%@ taglib prefix="entry" uri="WEB-INF/entry.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<jsp:useBean id="profiles" class="dao.ProfilesDAO" scope="page"></jsp:useBean>
<jsp:useBean id="bean" class="dao.EntryDAO" scope="page"></jsp:useBean>
${profiles.refresh(param.idProfile)}
Name: ${profiles.asListColl.get(0).firstName} ${profiles.asListColl.get(0).lastName} <br>
Sex: ${profiles.asListColl.get(0).sex}<br>
Date of birth: ${profiles.asListColl.get(0).dateBirth} <br>
Country and city: ${profiles.asListColl.get(0).country}, ${profiles.asListColl.get(0).city}<br>
<p></p>
<a href=${'photoGallery.jsp?idProfile'}=${param.idProfile}> My photo </a>
<p></p>
Posts : <p></p>
<table border="0">
    <col width="500">
    <col width="30">
<entry:entryTag idProfile="${param.idProfile}" var="entryObject" dateActivity="dateActivity" bean="${bean}">
    <tr>
        <td>${entryObject.text}</td>
        <td>${entryObject.activity.date}</td>
    </tr>
</entry:entryTag>
</table>
</body>
</html>


<%--
<my:Post id=>

--%>