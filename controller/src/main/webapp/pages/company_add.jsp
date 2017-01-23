<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/style.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<%--    <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>--%>

    <!-- <script type="text/javascript" src="js/bootstrap.file-input.js"></script> -->

    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
    <title>Add Company</title>
</head>
<html>
<body>
<header>
    <div class="wrapper">
        <div class="header__logo">
            <p>Logo</p>
        </div>
        <div class="header__title">
            <h3>Add Company</h3>
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
                <li><a href="/" target="_self">Home</a></li>
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
                <form class="form-horizontal" role="form" method="post" action="/dealCreate" id="dealForm"
                      enctype="multipart/form-data">

                    <!--Add deal-->
                    <div class="forms--nDeal">
                        <%--<form class="form-horizontal">--%>
                        <h2>Add deal</h2>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Name </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Name" id="dealName" name="dealName">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Tag </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Tag" id="dealTag" name="dealTag">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Responsible </label>
                            <select class="col-sm-9 form-control" id="responsibleUser" name="responsibleUser">
                                <c:forEach var="user" items="${users}">
                                    <option><c:out value="${user.lName}"/></option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Budget </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="$" id="dealBudget" name="dealBudget">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Comment </label>
                            <div class="col-sm-9">
                                <textarea class="form-control" placeholder="Message" id="noteDeal" name="noteDeal"></textarea>
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
                                <button>Применить</button>
                                <%--<a href="/deal" class="btn btn-primary">Применить</a>--%>
                                <%--<a href="#" class="btn btn-primary">Очистить</a>--%>
                            </div>
                        </div>
                        <%--<select class="form-control" style="float: none; width: 250px" id="companyDeal" name="companyDeal">--%>
                        <%----%>
                        <%--</select>--%>
                        <%--</form>--%>
                    </div>

                    <!--Add contact-->
                    <div class="forms--nDeal--Contact">
                        <%--<form id="add_contact_form">--%>
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
                                    <select class="col-sm-4 form-control" name="phone_type" id=phone_type">
                                        <option>Work telephone</option>
                                        <option>Mobile telephone</option>
                                        <option>Home telephone</option>
                                    </select>
                                    <div class="col-sm-7">
                                        <input class="form-control" type="text" name="formPhone" id="formPhone"
                                               placeholder="Number">
                                    </div>
                                </div>


                                <label>Skype: skypeMakarov</label>
                            </div>
                        </div>

                        <input onclick="location.href='#modalAddContact'" class="formAddBut" type="button"
                               value="Add contact">
                        <%--</form>--%>
                    </div>
                    <!--Modal window contact-->
                    <div id="modalAddContact" class="modalDialog">
                        <%--<form id="add_contact_form">--%>
                        <div>
                            <header>
                                <div class="wrapper__modal1Title">
                                    <div><i class="fa fa-user"></i></div>
                                    <h3>Add contact</h3>
                                </div>
                            </header>
                            <p style="display: inline">Name <input style="float: none; width: 148px" type="text"
                                                                   class="modalInput"
                                                                   value="${contact.setfName()}"></p>
                            <p style="display: inline;">Surname <input style="float: none; width: 147px" type="text"
                                                                       class="modalInput"
                                                                       value="${contact.setlName()}"></p>
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
                                <input style="float: none; width: 140px" class="modalInput" name="formPhone"
                                       placeholder="+38(067)123-45-67">
                            </p>
                            <p>Email <input type="text" class="modalInput"  value="${contact.setEmail()}"></p>
                            <p>Skype <input type="text" class="modalInput"  value="${contact.setSkype()}"></p>
                            <input class="modalBut" type="button" value="Save contact" onclick="add_contact();">
                            <input class="modalBut cancel" onclick="location.href='#close'" type="button"
                                   value="Cancel">
                        </div>
                        <%--</form>--%>
                    </div>
                    <!--End-->

                    <!--Add company-->
                    <div class="forms--nDeal">
                        <!--    <form class="form-horizontal"> -->
                        <h2>Company</h2>

                        <!-- Навигация -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a href="#old" aria-controls="old" role="tab"
                                                  data-toggle="tab">Companies</a></li>
                            <li><a href="#new" aria-controls="new" role="tab" data-toggle="tab">New Company</a></li>
                        </ul>

                        <!-- Содержимое вкладок -->
                        <div class="tab-content">
                            <br>
                            <div role="tabpanel" class="tab-pane active" id="old">

                                <select class="form-control" style="float: none; width: 250px" id="company"
                                        name="company">
                                    <c:forEach var="company" items="${companyList}">
                                        <option><c:out value="${company.title}"/></option>
                                    </c:forEach>
                                </select>

                            </div>

                            <div role="tabpanel" class="tab-pane" id="new">
                                <input type="hidden" id='formZipcode' value="">
                                <input type="hidden" id='formCountry' value="">
                                <input type="hidden" id='formCity' value="">
                                <input type="hidden" id='formStreet' value="">
                                <input type="hidden" id='formBuildNum' value="">
                                <input type="hidden" id='formOfficeRoom' value="">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Title: </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" id="formCompanyTabpanel" type="text" placeholder="Name">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Phone: </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" id="formPhoneTabpanel" type="text" placeholder="Phone">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">email: </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" id="formEmailTabpanel" type="text" placeholder="email">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Web: </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" id="formWebTabpanel" type="text"placeholder="Url">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Address: </label>
                                    <div class="col-sm-9" onclick="location.href='#modalAddAddress'"
                                         title="Click me for edit">
                                        <textarea disabled="disabled" class="text" id='formAddress' type="text" name="formAddress"></textarea>
                                    </div>
                                </div>
                                <input class="formAddBut" type="button" value="Add company">
                            </div>
                        </div>
                        <div id="modalAddAddress" class="modalDialog">
                            <div style="height:325px">
                                <header>
                                    <div class="wrapper__modal1Title">
                                        <div><i class="fa fa-user"></i></div>
                                        <h3>Edit address</h3>
                                    </div>
                                </header>
                                <p>Zipcode <input class="text" id='modalZipcode' type="text"
                                                  value=""></p>
                                <p>Country <input class="text" id='modalCountry' type="text"
                                                  value=""></p>
                                <p>City <input class="text" id='modalCity' type="text"
                                               value=""></p>
                                <p>Street <input class="text" id='modalStreet' type="text"
                                                 value=""></p>
                                <p>BuildNum <input class="text" id='modalBuildNum' type="text"
                                                   value=""></p>
                                <p>OfficeRoom <input class="text" id='modalOfficeRoom' type="text"
                                                     value=""></p>
                                <input class="modalBut" id="modalButAddress" type="button"
                                       onclick="location.href='#close'"
                                       value="Save contact">
                                <input class="modalBut cancel" onclick="location.href='#close'" type="button"
                                       value="Cancel">
                            </div>
                        </div>
                        <!--End-->
                        <!--    </form> -->
                    </div>

                    <!--Add task-->
                    <div class="forms--nDeal--Task">
                        <%--<form class="form-horizontal">--%>
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
                                    <c:forEach var="user" items="${users}">
                                        <option><c:out value="${user.lName}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Task type </label>
                            <div class="col-sm-9">
                                <select class="form-control">
                                    <c:forEach var="taskType" items="${taskTypeList}">
                                        <option><c:out value="${taskType.type}"/></option>
                                    </c:forEach>
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

                        <%--</form>--%>
                    </div>

                </form>

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
<script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="../js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
<script type="text/javascript" src="../js/scriptAddCompany.js"></script>
</html>