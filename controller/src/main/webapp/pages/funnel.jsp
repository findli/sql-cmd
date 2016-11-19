<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/style.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="../js/moment-with-locales.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />

    <title>Funnel</title>
</head>
<body>
<header>
    <div class="wrapper">
        <div class="header__logo">
            <p>Logo</p>
        </div>
        <div class="header__title">
            <h3>Sales funnel</h3>
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
                <li><a href="#" target="_self">Home</a></li>
                <li><a href="/deal" target="_self">Deals</a></li>
                <li><a href="#" target="_self">Company</a></li>
                <li><a href="#" target="_self">Contacts</a></li>
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
                                <div class="input-group date" id="datetimepicker1">
                                    <input type="text" class="form-control" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon-calendar glyphicon"></span>
                                        </span>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">До: </label>
                            <div class="col-sm-9">
                                <div class="input-group date" id="datetimepicker2">
                                    <input type="text" class="form-control" />
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
                                    <option>Manager 1</option>
                                    <option>Manager 2</option>
                                    <option>Manager 3</option>
                                    <option>Manager 4</option>
                                    <option>Manager 5</option>
                                    <option>Manager 6</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Task type</label>
                            <div class="col-sm-9">
                                <select class="form-control">
                                    <option>Follow-up</option>
                                    <option>Meeting</option>
                                    <option>Order</option>
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
                        <a href="/dealCreate" class="btn btn-primary pull-center">Add deal</a>
                    </div>

                    <br><br><br><br>

                    <div class="table-responsive">
                        <table class="table table-striped">
                            <tr>
                                <th>Первичный контакт</th>
                                <th>Переговоры</th>
                                <th>Принимают решение</th>
                                <th>Согласование договора</th>
                            </tr>
                            <tr>
                                <td>Name deal1<br>
                                    10000$<br>
                                    Ivanov, Petrov<br>
                                    MMM
                                </td>
                                <td>Name deal2<br>
                                    15200$<br>
                                    Zaharov, Petrov<br>
                                    Bank
                                </td>
                                <td></td>
                                <td>Name deal3<br>
                                    2520$<br>
                                    Agapov, Ivanov2<br>
                                    STO
                                </td>
                            </tr>
                            <tr>
                                <td>Name deal3<br>
                                    2520$<br>
                                    Agapov, Ivanov2<br>
                                    STO
                                </td>
                                <td></td>
                                <td></td>
                                <td>Name deal4<br>
                                    32400$<br>
                                    Agapov, Ivanov2<br>
                                    STO2
                                </td>
                            </tr>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});
        $('#datetimepicker2').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});

    });
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.js"></script>
</body>
<!-- <script src="https://code.jquery.com/jquery-2.0.0.min.js"></script> -->
<script type="text/javascript" src="../js/script.js"></script>
</html>
