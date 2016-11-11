<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.css">
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
    <title>Add deal</title>
</head>
<body>
<header>
    <div class="wrapper">
        <div class="header__logo">
            <p>Logo</p>
        </div>
        <div class="header__title">
            <h3>Add deal</h3>
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

                <!--Add deal-->
                <div class="forms--nDeal">
                    <form class="form-horizontal">
                        <h2>Add deal</h2>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Name </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Tag </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Tag">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Responsible </label>
                            <select class="col-sm-9 form-control">
                                <option>Manager1</option>
                                <option>Manager2</option>
                                <option>Manager3</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Budget </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="$">
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

                <!--Add contact-->
                <div class="forms--nDeal--Contact">
                    <form class="form-horizontal">
                        <h2>Add contact</h2>
                        <div class="wrapper__users">
                            <div class="users__panel">
                                <br>
                                <label>Makarov</label>
                                <a href="#">Edit</a>
                                <a href="#">Undock</a>
                                <input class="users__panel--input" type="checkbox">
                            </div>
                            <div class="users__panel--body">
                                <label>Position: Director</label><br>
                                <label>Email: makarov@gmail.com</label><br>

                                <div class="form-group">
                                    <select class="col-sm-4 form-control">
                                        <option>Work telephone</option>
                                        <option>Mobile telephone</option>
                                        <option>Home telephone</option>
                                    </select>
                                    <div class="col-sm-7">
                                        <input class="form-control" type="text" name="formPhone"
                                               placeholder="Number">
                                    </div>
                                </div>


                                <label>Skype: skypeMakarov</label>
                            </div>
                        </div>

                        <input onclick="location.href='#modalAddContact'" class="formAddBut" type="button"
                               value="Add contact">
                    </form>
                </div>
                <!--Modal window contact-->
                <div id="modalAddContact" class="modalDialog">
                    <div>
                        <header>
                            <div class="wrapper__modal1Title">
                                <div><i class="fa fa-user"></i></div>
                                <h3>Add contact</h3>
                            </div>
                        </header>
                        <p style="display: inline">Name <input style="float: none; width: 148px" type="text"
                                                               class="modalInput"
                                                               id="modalContactName" value="${contact.setfName()}"></p>
                        <p style="display: inline;">Surname <input style="float: none; width: 147px" type="text"
                                                                   class="modalInput"
                                                                   id="modalContactSurname" value="${contact.setlName()}"></p>
                        <p>Position <input type="text" class="modalInput" id="modalContactPosition" value="${contact.setPosition()}"></p>
                        <p>Phone <i class="fa fa-plus-square"></i>
                            <select>
                                <option>Working</option>
                                <option>Direct working</option>
                                <option>Mobile</option>
                                <option>Fax</option>
                                <option>Home</option>
                                <option>Other</option>
                            </select>
                            <input style="float: none; width: 140px" class="modalInput" id='modalContactPhone' name="formPhone"
                                   placeholder="+38(067)123-45-67">
                        </p>
                        <p>Email <input type="text" class="modalInput" id="modalContactEmail" value="${contact.setEmail()}"></p>
                        <p>Skype <input type="text" class="modalInput" id="modalContactSkype" value="${contact.setSkype()}"></p>
                        <input class="modalBut" type="button" value="Save contact">
                        <input class="modalBut cancel" onclick="location.href='#close'" type="button"
                               value="Cancel">
                    </div>
                </div>
                <!--End-->

                <!--Add company-->
                <div class="forms--nDeal--Company">
                    <form class="form-horizontal">
                        <h2>Add company</h2>
                        <div class="wrapper__users">
                            <div class="users__panel">
                                <br>
                                <label>Bank PeterPen</label>
                                <a href="#">Edit</a>
                                <a href="#">Undock</a>
                                <input class="users__panel--input" type="checkbox">
                            </div>
                            <div class="users__panel--body">
                                <label>Name:</label><br>
                                <label>Tags:</label><br>
                                <label>Email: makarov@gmail.com</label><br>

                                <div class="form-group">
                                    <select class="col-sm-4 form-control">
                                        <option>Work telephone</option>
                                        <option>Mobile telephone</option>
                                        <option>Home telephone</option>
                                    </select>
                                    <div class="col-sm-7">
                                        <input class="form-control" type="text" name="formPhone"
                                               placeholder="Number">
                                    </div>
                                </div>
                                <label>Web: site.ua</label><br>
                                <label>Address:</label><br>
                                <label>Skype: skypeMakarov</label>
                            </div>
                        </div>

                        <input onclick="location.href='#modalAddCompany'" class="formAddBut" type="button"
                               value="Add company">
                    </form>
                </div>
                <!--Modal window contact-->
                <div id="modalAddCompany" class="modalDialog">
                    <div>
                        <header>
                            <div class="wrapper__modal1Title">
                                <div><i class="fa fa-user"></i></div>
                                <h3>Add company</h3>
                            </div>
                        </header>
                        <p>Name <input style="float: none; width: 148px" type="text"
                                       class="modalInput"
                                       id="modalContactName" value="${contact.setfName()}"></p>
                        <p>Tags <input style="float: none; width: 147px" type="text"
                                       class="modalInput"
                                       id="modalContactSurname" value="${contact.setlName()}"></p>

                        <p>Phone <i class="fa fa-plus-square"></i>
                            <select>
                                <option>Working</option>
                                <option>Direct working</option>
                                <option>Mobile</option>
                                <option>Fax</option>
                                <option>Home</option>
                                <option>Other</option>
                            </select>
                            <input style="float: none; width: 140px" class="modalInput" id='modalContactPhone' name="formPhone"
                                   placeholder="+38(067)123-45-67">
                        </p>
                        <p>Email <input type="text" class="modalInput" id="modalContactEmail" value="${contact.setEmail()}"></p>
                        <p>Web <input type="text" class="modalInput" value=""></p>
                        <p>Address <input type="text" class="modalInput" value=""></p>
                        <input class="modalBut" type="button" value="Save contact">
                        <input class="modalBut cancel" onclick="location.href='#close'" type="button"
                               value="Cancel">
                    </div>
                </div>
                <!--End-->

                <!--Add task-->
                <div class="forms--nDeal--Task">
                    <form class="form-horizontal">
                        <h2>Add task</h2>

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
                            <label class="col-sm-3 control-label">Date and time </label>
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
