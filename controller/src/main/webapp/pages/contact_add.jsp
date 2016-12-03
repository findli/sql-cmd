<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.css">

    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <%--  <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>--%>
    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/style.css">
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

                <!--Add contact-->
                    <div class="forms--nCompany">
                        <form class="form-horizontal">
                            <h2>Contact</h2>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Name </label>
                                <div class="col-sm-9">
                                    <input class="form-control" type="text" placeholder="Name">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Tags </label>
                                <div class="col-sm-9">
                                    <input class="form-control" type="text" placeholder="Tag">
                                </div>
                            </div>

                            <div class="form-group">
                                <a href="#">Responsible</a><br>
                            </div>

                            <div class="form-group">
                                <select class="col-sm-3 form-control">
                                    <option>Work</option>
                                    <option>Mobile</option>
                                    <option>Home</option>
                                </select>
                                <div class="col-sm-9">
                                    <input class="form-control" type="text" name="formPhone" placeholder="Number">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Email </label>
                                <div class="col-sm-9">
                                    <input class="form-control" type="text" placeholder="Email">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Skype </label>
                                <div class="col-sm-9">
                                    <input class="form-control" type="text" placeholder="Skype">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Address </label>
                                <div class="col-sm-9">
                                    <input class="form-control" type="text" placeholder="Address">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Comment </label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" placeholder="Message"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Add files </label>
                                <div class="col-sm-9">
                                    <input type="file" title="Search for a file to add">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input class="formAddBut" type="button" value="Применить">
                                    <input class="formAddBut" type="button" value="Очистить">
                                </div>
                            </div>
                        </form>
                    </div>

                <!--Add company-->
                <div class="forms--nCompany">
                    <form class="form-horizontal">
                        <h2>Company</h2>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Name </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Name company">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Tags </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Tag">
                            </div>
                        </div>

                        <div class="form-group">
                            <select class="col-sm-3 form-control">
                                <option>Work</option>
                                <option>Mobile</option>
                                <option>Home</option>
                            </select>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" name="formPhone" placeholder="Number">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Email </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Email">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Web </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Url">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Address </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Address">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10">
                                <input class="formAddBut" type="button" value="Применить">
                                <input class="formAddBut" type="button" value="Очистить">
                            </div>
                        </div>
                    </form>
                </div>

                <!--Add task-->
                <div class="forms--nContact--Task">
                    <form class="form-horizontal">
                        <h2>Task</h2>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Period </label>
                            <div class="col-sm-9">
                                <select class="form-control">
                                    <option>Today</option>
                                    <option>All day</option>
                                    <option>Tommorow</option>
                                    <option>Next week</option>
                                    <option>Next month</option>
                                    <option>Next year</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-4 control-label">Date and time </label>
                            <div class="col-sm-8">
                                <div class="input-group date" id="datetimepicker">
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
                            <label class="col-sm-3 control-label">Task type </label>
                            <div class="col-sm-9">
                                <select class="form-control">
                                    <option>Follow-up</option>
                                    <option>Meeting</option>
                                    <option>Order</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Comment </label>
                            <div class="col-sm-9">
                                <textarea class="form-control" placeholder="Message"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10">
                                <input class="formAddBut" type="button" value="Применить">
                                <input class="formAddBut" type="button" value="Очистить">
                            </div>
                        </div>

                    </form>
                </div>

                <!--Add deal-->
                <div class="forms--nContact--Deal">
                    <form class="form-horizontal">
                        <h2>Deal</h2>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Name </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Name deal">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Status </label>
                            <div class="col-sm-9">
                                <select class="form-control">
                                    <option>Deal off</option>
                                    <option>in progress</option>
                                    <option>pause</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Budget </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="$">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10">
                                <input class="formAddBut" type="button" value="Применить">
                                <input class="formAddBut" type="button" value="Очистить">
                            </div>
                        </div>
                    </form>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
</html>
