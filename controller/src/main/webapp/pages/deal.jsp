<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/style.css">

    <title>Deal</title>
</head>
<body>
<header>
    <div class="wrapper">
        <div class="header__logo">
            <p>Logo</p>
        </div>
        <div class="header__title">
            <h3>Deal</h3>
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
                <div class="forms--lDeal--Filter">
                    <form class="form-horizontal">
                        <h2>Фильтры</h2><br>

                        <div class="radio">
                            <label><input type="radio" name="optradio2" value="0" checked> Открытые сделки</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="optradio2" value="1"> Только мои сделки</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="optradio2" value="2"> Успешно завершённые</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="optradio2" value="3"> Не реализованные</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="optradio2" value="4"> Сделки без задач</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="optradio2" value="5"> С просроченными задачами</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="optradio2" value="6"> Удалённые</label>
                        </div>

                        <hr>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">От: </label>
                            <div class="col-sm-9">
                                <div class="input-group date" id="datetimepicker8">
                                    <input type="text" class="form-control"/>
                                    <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">До: </label>
                            <div class="col-sm-9">
                                <div class="input-group date" id="datetimepicker9">
                                    <input type="text" class="form-control"/>
                                    <span class="input-group-addon">
                                            <span class="glyphicon-calendar glyphicon"></span>
                                        </span>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Responsible </label>
                            <div class="col-sm-9">
                                <select class="form-control">
                                    <c:forEach var="user" items="${users}">
                                        <option><c:out value="${user.lName}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Task type</label>
                            <div class="col-sm-9">
                                <select class="form-control">
                                    <c:forEach var="taskType" items="${taskTypeList}">
                                        <option><c:out value="${taskType.type}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Tags </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Tag">
                            </div>
                        </div>
                        <br>
                        <hr>
                        <input class="formAddBut" type="button" value="Применить">
                        <input class="formAddBut" type="button" value="Очистить">
                    </form>
                </div>

                <div class="forms--lDeal">

                    <div class="col-md-12">
                        <a href="/funnel" class="btn btn-primary">Funnel</a>
                        <a href="/deal" class="btn btn-primary">List</a>
                        <a href="/pages/deal_add.jsp" class="btn btn-primary pull-center">Add deal</a>
                    </div>

                    <%--<input class="formAddBut" type="button" value="Add deal" align="right">--%>

                    <br><br><br><br>

                    <div class="wrapper__deals">
                        <form action="/dealEdit" method="post">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>Название сделки</th>
                                    <th>Основной контакт</th>
                                    <th>Компания контакта</th>
                                    <th>Этап сделки</th>
                                    <th>Бюджет</th>
                                </tr>
                                </thead>
                                <tbody id="t_deals">
                                <c:forEach var="deal" items="${dealList}">
                                    <%--<tr class="rowlink" onclick="window.location.href='/dealEdit?idDeal=${deal.getId()}'; return false">--%>
                                    <tr data-href="/dealEdit?idDeal=${deal.getId()}">
                                        <td class="item"><c:out value="${deal.title}"/></td>
                                        <td><c:out value="${deal.getPrimaryContact().getlName()}"/></td>
                                        <td><c:out value="${deal.getCompany().getTitle()}"/></td>
                                        <td><c:out value="${deal.getStage().getTitle()}"/></td>
                                        <td><c:out value="${deal.budget}"/></td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<script type="text/javascript">--%>
<%--$(function () {--%>
<%--$('#datetimepicker1').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});--%>
<%--$('#datetimepicker2').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});--%>

<%--});--%>
<%--</script>--%>
<%--<script type="text/javascript">--%>
<%--$(function () {--%>
<%--//Инициализация datetimepicker8 и datetimepicker9--%>
<%--$("#datetimepicker8").datetimepicker();--%>
<%--$("#datetimepicker9").datetimepicker();--%>
<%--//При изменении даты в 8 datetimepicker, она устанавливается как минимальная для 9 datetimepicker--%>
<%--$("#datetimepicker8").on("dp.change",function (e) {--%>
<%--$("#datetimepicker9").data("DateTimePicker").setMinDate(e.date);--%>
<%--});--%>
<%--//При изменении даты в 9 datetimepicker, она устанавливается как максимальная для 8 datetimepicker--%>
<%--$("#datetimepicker9").on("dp.change",function (e) {--%>
<%--$("#datetimepicker8").data("DateTimePicker").setMaxDate(e.date);--%>
<%--});--%>
<%--});--%>
<%--</script>--%>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="../js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>

</html>