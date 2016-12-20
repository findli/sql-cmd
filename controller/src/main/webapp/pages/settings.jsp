<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="../css/bootstrap.css">
  <link rel="stylesheet" href="../style/reset.css">
  <link rel="stylesheet" href="../style/style.css">
  <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />


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
        <li><a href="/taskList" target="_self">Tasks</a></li>
        <li><a href="#" target="_self">Analitics</a></li>
        <li><a href="/settings" target="_self">Settings</a></li>
      </ul>
    </div>
    <div class="wrapper__aboutCompany">
      <div class="forms">
        <div class="col-md-12">
          <br>
          <a href="/userAdd" class="btn btn-primary pull-center">Добавить пользователя</a>
        </div>
      <div class="forms--nDeal--Task">
      <form class="form-horizontal" role="form" method="post" action="/settings">
        <h2>General settings</h2>
        <br><br>
        <div class="form-group">
          <label class="col-sm-3 control-label">Временная зона </label>
          <div class="col-sm-9">
          <select class="form-control" name="TimeZone">
            <c:forEach var="timeZone" items="${TimeZoneList}">
              <option value="${timeZone.getId()}"><c:out value="${timeZone.getTitle()}"/></option>
            </c:forEach>
            </select>
            </div>
          </div>

        <div class="form-group">
          <label class="col-sm-3 control-label">Язык </label>
          <div class="col-sm-9">
          <select class="form-control" name="Language">
            <c:forEach var="language" items="${LanguageList}">
              <option value="${language.getId()}"><c:out value="${language.getTitle()}"/></option>
            </c:forEach>
          </select>
            </div>
        </div>

        <div class="form-group">
          <label class="col-sm-3 control-label">Валюта </label>
          <div class="col-sm-9">
            <select class="form-control" name="Currency">
              <c:forEach var="currency" items="${CurrencyList}">
                <option value="${currency.getId()}"><c:out value="${currency.getTitle()}"/></option>
              </c:forEach>
            </select>
          </div>
        </div>

        <div class="form-group">
          <div class="col-sm-10">
            <input class="formAddBut" type="submit" value="Save" >
          </div>
          </div>

        </form>
        </div>
        </div>
    </div>
  </div>
</div>

</body>
<script src="../js/bootstrap.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script title="text/javascript" src="../js/script.js"></script>
<script title="text/javascript" src="../js/moment-with-locales.min.js"></script>
<script title="text/javascript" src="../js/bootstrap.min.js"></script>
</html>