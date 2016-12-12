<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/style.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <title>Company List</title>
</head>
<body>
<header>
    <div class="wrapper">
        <div class="header__logo">
            <p>Logo</p>
        </div>
        <div class="header__title">
            <h3>Company List</h3>
            <div class="header__user">
                <div class="header__user--photo">
                    <i class="fa fa-user"></i>
                </div>
                <p id="user">User</p>
                <a href="">Log out</a>
            </div>
        </div>
    </div>
</header>
<div class="aboutCompany">
    <div class="wrapper">
        <div id="navbar">
            <ul>
                <li><a href="/index.jsp" target="_self">Home</a></li>
                <li><a href="/deal" target="_self">Deals</a></li>
                <li><a href="/company" target="_self">Company</a></li>
                <li><a href="/contact" target="_self">Contacts</a></li>
                <li><a href="#" target="_self">Tasks</a></li>
                <li><a href="#" target="_self">Analitics</a></li>
                <li><a href="#" target="_self">Settings</a></li>
            </ul>
        </div>
        <div class="wrapper__aboutCompany">
            <div class="forms">

                <div class="forms--lDeal">

                    <div class="col-md-12">
                        <a href="/companyadd" class="btn btn-primary pull-center">Add company</a>
                    </div>

                    <br><br><br><br>

                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Название компании</th>
                                <th>Тел. номер</th>
                                <th>эл. почта</th>
                            </tr>
                            </thead>
                            <tbody id="t_company">
                            <c:forEach var="company" items="${companyList}">
                                <tr data-href="/companyDetail?idCompany=${company.getId()}">
                                    <td><c:out value="${company.getTitle()}"/></td>
                                    <td><c:out value="${company.getPhoneNumber()}"/></td>
                                    <td><c:out value="${company.getEmail()}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script src="https://code.jquery.com/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="../js/scriptCompany.js"></script>
</html>