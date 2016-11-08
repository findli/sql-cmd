<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/reset.css">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <title>Contact</title>
</head>
<body>
<header>
    <div class="wrapper">
        <div class="header__logo">
            <p>Logo</p>
        </div>
        <div class="header__title">
            <h3>Contact</h3>
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
                <li><a href="#" target="_self">Deals</a></li>
                <li><a href="#" target="_self">Company</a></li>
                <li><a href="#" target="_self">Contacts</a></li>
                <li><a href="#" target="_self">Tasks</a></li>
                <li><a href="#" target="_self">Analitics</a></li>
                <li><a href="#" target="_self">Settings</a></li>
            </ul>
        </div>
        <div class="wrapper__aboutCompany">
            <div class="wrapper__aboutCompany">
                <div class="forms">
                    <div class="forms--nFilter">
                        <h2>Фильтры</h2><br>
                        <div id="contacts" class="tab-pane fade">
                            <form class="form-horizontal" id="formContact">
                                <div class="form-group">
                                    <div class="radio">
                                        <label class="radio"><input type="radio" name="contactStd"
                                                                    value="0" checked> Полный список контактов</label>
                                    </div>
                                    <div class="radio">
                                        <label class="radio"><input type="radio" name="contactStd"
                                                                    value="1"> Контакты без задач</label>
                                    </div>
                                    <div class="radio">
                                        <label class="radio"><input type="radio" name="contactStd"
                                                                    value="2"> Контакты с просроченными задачами</label>
                                    </div>
                                    <div class="radio">
                                        <label class="radio"><input type="radio" name="contactStd"
                                                                    value="3"> Удаленные</label>
                                    </div>
                                </div>
                                <hr>
                                <div class="form-group">
                                    <label class="control-label col-md-4" for="contactWhen">Когда:</label>
                                    <select class="form-control" id="contactWhen" onchange="">
                                        <option value="0">за все время</option>
                                        <option value="1">за сегодня</option>
                                        <option value="2">за 3 дня</option>
                                        <option value="3">за неделю</option>
                                        <option value="4">за месяц</option>
                                        <option value="5">за квартал</option>
                                        <option value="6">за период</option>
                                    </select>
                                </div>

                                <div class="form-group" align="left">
                                    <input class="actionBut" type="button" value="Созданные">
                                    <input class="actionBut" type="button" value="Изменённые">
                                    <!-- <button>Созданные</button>
                                    <button>Изменённые</button> -->
                                </div>

                                <hr>
                                <div class="form-group">
                                    <label class="control-label col-md-4">Этапы:</label>
                                    <ul>
                                        <li><label class="checkbox"><input type="checkbox" class="checkbox" name="contactStages"
                                                                           value="0"> Без сделок</label></li>
                                        <li><label class="checkbox"><input type="checkbox" class="checkbox" name="contactStages"
                                                                           value="1"> Без открытых сделок</label></li>
                                        <li><label class="checkbox"><input type="checkbox" class="checkbox" name="contactStages"
                                                                           value="2"> Первичный контакт</label></li>
                                        <li><label class="checkbox"><input type="checkbox" class="checkbox" name="contactStages"
                                                                           value="3"> Переговоры</label></li>
                                        <li><label class="checkbox"><input type="checkbox" class="checkbox" name="contactStages"
                                                                           value="4"> Принимают решение</label></li>
                                        <li><label class="checkbox"><input type="checkbox" class="checkbox" name="contactStages"
                                                                           value="5"> Согласование договора</label></li>
                                        <li><label class="checkbox"><input type="checkbox" class="checkbox" name="contactStages"
                                                                           value="6"> Успешно реализован</label></li>
                                        <li><label class="checkbox"><input type="checkbox" class="checkbox" name="contactStages"
                                                                           value="7"> Закрыто и не реализовано</label></li>
                                    </ul>
                                </div>
                                <hr>
                                <div class="form-group">
                                    <label class="control-label col-md-4" for="contactManager">Менеджер:</label>
                                    <select class="form-control" id="contactManager" name="contactManager">
                                        <option value="0">Менеджер 1</option>
                                        <option value="1">Менеджер 2</option>
                                        <option value="2">Менеджер 3</option>
                                    </select>
                                </div>
                                <hr>
                                <div class="form-group">
                                    <label class="control-label col-md-4" for="contactTask">Задачи:</label>
                                    <select class="form-control" id="contactTask" name="contactTask">
                                        <option value="0">не учитывать</option>
                                        <option value="1">на сегодня</option>
                                        <option value="2">на завтра</option>
                                        <option value="3">на этой неделе</option>
                                        <option value="4">в этом месяце</option>
                                        <option value="5">в этом квартале</option>
                                        <option value="6">нет задач</option>
                                        <option value="7">просрочены</option>
                                    </select>
                                </div>
                                <hr>
                                <div class="form-group">
                                    <label class="control-label col-md-4" for="contactTag">Теги:</label>
                                    <select class="form-control" id="contactTag" name="contactTag">
                                        <option value="0">в работе</option>
                                        <option value="1">не в работе</option>
                                        <option value="2">завтра</option>
                                    </select>
                                </div>
                                <hr>
                                <div class="form-group" align="center">
                                    <input class="formAddBut" type="button" value="Применить">
                                    <input class="formAddBut" type="button" value="Очистить">
                                </div>
                            </form>
                        </div>

                    </div>
                    <div class="forms--nContact">

                        <div class="col-md-12" align="left">
                            <input class="actionBut" type="button" value="Contact">
                            <input class="actionBut" type="button" value="Company">
                            <input class="actionBut" type="button" value="All">
                        </div>
                        <div align="right">
                            <input class="formAddBut" type="button" value="Add contact">
                            <!-- <button>Add contact</button> -->

                            <br><br><br>

                            <div class="row rowHideable" id="allEntityRowTable">
                                <div class="">
                                    <table class="table table-bordered" border="1" cellpadding="10" cellspacing="1">
                                        <tr>
                                            <th>Имя</th>
                                            <th>Компания</th>
                                            <th>Телефон</th>
                                            <th>Email</th>
                                        </tr>
                                        <tr>
                                            <td>Иван Петров</td>
                                            <td>БМВ Бавария</td>
                                            <td>(067) 485-85-03</td>
                                            <td>ivan@google.com</td>
                                        </tr>
                                        <tr>
                                            <td>Елена Бабич</td>
                                            <td>Митсубиси</td>
                                            <td>(067) 444-67-34</td>
                                            <td>elena@google.com</td>
                                        </tr>
                                        <tr>
                                            <td>Дмитрий Агафонов</td>
                                            <td>Митсубиси Электрик</td>
                                            <td>(067) 454-77-84</td>
                                            <td>dmitry@google.com</td>
                                        </tr>

                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
</body>
<!-- <script src="https://code.jquery.com/jquery-2.0.0.min.js"></script> -->
<script type="text/javascript" src="js/script.js"></script>
</html>
