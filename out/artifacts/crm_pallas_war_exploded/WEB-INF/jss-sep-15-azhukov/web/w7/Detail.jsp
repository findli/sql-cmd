<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="detail" uri="WEB-INF/detail.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title> Detail </title>
</head>
<body>


<%-- CK: detailTag уже организует повторение - зачем внутри еще цикл --%>
<%-- Повторяться будет все тело, а должен повторяться только вывод очередного телефона --%>
<%-- То есть на лицо потребность в двух разных тегах, напрмер :

    <some:contactDetail id="..." var="contact">
       ... ${contact.name} ... ${contact.someProperty}
       <table ... >
            <some:contactEmails contact="${contact}" var="email">
                ... ${email} ...
            </some:contactEmails>
       </table>
    </some:contactDetail>

первый тег без итерации - просто предоставляет общую информацию о контакте, другой - для итерации по телефонам
плодить лишние переменные тоже не надо, есть же классы для всего

так ведь стройнее код получается и легко расширить на встречи, телефоны, и т.д.?
это потому что иерархия тегов стала похожа на реальную структуру данных

--%>

<jsp:useBean id="contact" class="w7.bean.ContactBean" scope="page"></jsp:useBean>

Person: ${contact.getPerson(param.idContact)}
<p></p>
Email:
<detail:detailTag idPerson="${param.idContact}" varEmail="email" id="idEmail">
    <a href=${'/jss/w7/Edit.jsp?idEmail'}=${idEmail}&idContact=${param.idContact}&action=item> ${email}; </a>
</detail:detailTag>
<p></p>
Meet:
<detail:detailTag idPerson="${param.idContact}" varMeet="meet" id="idMeet">
    <a href=${'/jss/w7/Edit.jsp?idMeet'}=${idMeet}&idContact=${param.idContact}&action=item> ${meet}; </a>
</detail:detailTag>
<p></p>

<form method="post">
    <input type="button" value="Back" onclick="Back()">
    <script>
        function Back() {
            location.href = "http://localhost:8080/jss/w7/Contact.jsp";
        }
    </script>
</form>
</body>
</html>
