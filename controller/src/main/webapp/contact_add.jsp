<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="style/reset.css">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/moment-with-locales.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
    <!-- <script type="text/javascript" src="js/bootstrap.file-input.js"></script> -->

    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
    <title>Add contact</title>
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
            <div class="forms">

                <!--Add contact-->
                <div class="forms--nCompany">
                    <h2>Contact</h2>
                    <p>Name <input class="text" id='formCompany' type="text" name="formCompany"
                                   placeholder="Name"></p>
                    <p>Tags <input class="text" id='formTag' type="text" name="formTag" placeholder="Tag"></p>
                    <a href="">Responsible</a><br>
                    <select>
                        <option>Work telephone</option>
                        <option>Mobile telephone</option>
                        <option>Home telephone</option>
                    </select>
                    <input class="text" id='formPhone' type="text" name="formPhone" placeholder="Number">
                    <p>Email <input class="text" id='formEmail' type="text" name="formEmail" placeholder="Email"></p>
                    <p>Skype <input class="text" id='formSkype' type="text" name="formSkype" placeholder="Skype"></p>
                    <p>Address <input class="text" id='formAddress' type="text" name="formAddress"
                                      placeholder="Address"></p>
                    <p>Comment <input id="formContactText" class="formActionText" type="text"></p><br>
                    <p>Add files <input type="file" name="chooseFile" title="Search for a file to add" data-bfi-disabled></p>
                    <div class="form-group" align="center">
                        <input class="formAddBut" type="button" value="Применить">
                        <input class="formAddBut" type="button" value="Очистить">
                    </div>
                </div>

                <!--Add company-->
                <div class="forms--nCompany">
                    <h2>Company</h2>
                    <p>Name <input class="text" type="text" name="formCompany"
                                   placeholder="Name company"></p>
                    <p>Tags <input class="text" type="text" name="formTag" placeholder="Tag"></p>
                    <select>
                        <option>Work telephone</option>
                        <option>Mobile telephone</option>
                        <option>Fax</option>
                    </select>
                    <input class="text" type="text" name="formPhone" placeholder="Number">
                    <p>Email <input class="text" type="text" name="formEmail" placeholder="Email"></p>
                    <p>Web <input class="text" type="text" name="formWeb" placeholder="Url"></p>
                    <p>Address <input class="text" type="text" name="formAddress"
                                      placeholder="Address"></p>
                    <div class="form-group" align="center">
                        <input class="formAddBut" type="button" value="Применить">
                        <input class="formAddBut" type="button" value="Очистить">
                    </div>
                </div>

                <!--Add task-->
                <div class="forms--nCompany">
                    <h2>Task</h2>
                    <p>Period
                        <select>
                            <option>Today</option>
                            <option>All day</option>
                            <option>Tommorow</option>
                            <option>Next week</option>
                            <option>Next month</option>
                            <option>Next year</option>
                        </select></p>

                    <p>Date and Time
                    <div class="form-group">
                        <div class="input-group date" id="datetimepicker">
                            <input type="text" class="form-control" />
                                <span class="input-group-addon">
                                    <span class="glyphicon-calendar glyphicon"></span>
                                </span>
                        </div>
                    </div></p>

                    <p>Responsible
                        <select>
                            <option>Manager 1</option>
                            <option>Manager 2</option>
                            <option>Manager 3</option>
                            <option>Manager 4</option>
                            <option>Manager 5</option>
                            <option>Manager 6</option>
                        </select></p>
                    <p>Task type
                        <select>
                            <option>Follow-up</option>
                            <option>Meeting</option>
                            <option>Order</option>
                        </select></p>
                    <p>Comment <input class="formActionText" type="text"></p><br><br>
                    <div class="form-group" align="center">
                        <input class="formAddBut" type="button" value="Применить">
                        <input class="formAddBut" type="button" value="Очистить">
                    </div>
                </div>

                <!--Add deal-->
                <div class="forms--nCompany">
                    <h2>Deal</h2>
                    <p>Name <input class="text" id='formDeal' type="text" name="formDeal"
                                   placeholder="Name deal"></p>
                    <p>Satus
                        <select>
                            <option>Deal off</option>
                            <option>in progress</option>
                            <option>pause</option>
                        </select></p>
                    <p>Budget <input class="text" id='formBudget' type="text" name="formBudget" placeholder="$"></p>
                    <div class="form-group" align="center">
                        <input class="formAddBut" type="button" value="Применить">
                        <input class="formAddBut" type="button" value="Очистить">
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});
    });
</script>
</body>
<!-- <script src="https://code.jquery.com/jquery-2.0.0.min.js"></script> -->
<script type="text/javascript" src="js/script.js"></script>
</html>
