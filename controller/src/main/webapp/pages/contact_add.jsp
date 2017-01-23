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
    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css"/>
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
            <form class="form-horizontal" role="form" method="post" action="/contactAdd">
                <div class="forms">

                    <!--Add contact-->

                    <div class="forms--nContact">
                        <!--       <form class="form-horizontal">-->
                        <h2>Contact</h2>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">First Name </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="fName" name="fName" id="fName">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Last Name </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="lName" name="lName" id="lName">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Position </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="position" name="position"
                                       id="position">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Tag </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Tag" name="Tag" id="Tag">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Responsible </label>
                            <select class="col-sm-9 form-control" id="responsibleUser" name="responsibleUser"
                                    style="width: 150px;">
                                <c:forEach var="user" items="${usersList}">
                                    <option value="${user.getId()}">
                                        <c:out value="${user.fName}"/>
                                        <c:out value="${user.lName}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <%--<div class="form-group">--%>
                        <%--<label class="col-sm-3 control-label">Position </label>--%>
                        <%--<div class="col-sm-9">--%>
                        <%--<input class="form-control" type="text" placeholder="position" name="position" id="position">--%>
                        <%--</div>--%>
                        <%--</div>--%>

                        <div class="form-group">
                            <select class="col-sm-3 form-control">
                                <option>Work</option>
                                <option>Mobile</option>
                                <option>Home</option>
                            </select>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" name="formPhone" id="formPhone"
                                       placeholder="Number">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Email </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Email" id="Email" name="Email">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Skype </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Skype" id="Skype" name="Skype">
                            </div>
                        </div>
                        <!--
                                                             <div class="form-group">
                                                                 <label class="col-sm-3 control-label">Address </label>
                                                                 <div class="col-sm-9">
                                                                     <input class="form-control" type="text" placeholder="Address" id="contactAddress" name="contactAddress">
                                                                 </div>
                                                             </div>
                                                             <div class="form-group">
                                                                 <label class="col-sm-3 control-label">Comment </label>
                                                                 <div class="col-sm-9">
                                                                     <textarea class="form-control" placeholder="Message" id="noteContact" name="noteContact"></textarea>
                                                                 </div>
                                                             </div>
                                                             <div class="form-group">
                                                                 <label class="col-sm-3 control-label">Add files </label>
                                                                 <div class="col-sm-9">
                                                                     <input type="file" title="Search for a file to add">
                                                                 </div>
                                                             </div>
                        -->
                        <div class="form-group">
                            <div class="col-sm-10">
                                <%--<input class="formAddBut" type="button" value="Save">--%>
                                <button>Подтвердить</button>
                            </div>
                        </div>
                        <!--    </form> -->
                    </div>

                    <!--Add company-->
                    <div class="forms--nContact">
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
                            <div id="modalAddAddress" class="modalDialog">
                                <div>
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
                        </div>
                        <!--    </form> -->
                    </div>

                    <!--Add task-->
                    <div class="forms--nContact--Task">
                        <!--   <form class="form-horizontal"> -->
                        <h2>Task</h2>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Period </label>
                            <div class="col-sm-9">
                                <select class="form-control" name="PeriodInDaysType">
                                    <c:forEach var="period" items="${PeriodInDaysTypeList}">
                                        <option value="${period.getId()}"><c:out value="${period.getTitle()}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Deadline</label>
                            <div class="col-sm-8">
                                <div class="input-group date" id="datetimepicker">
                                    <input type="text" name="DeadlineDate" class="form-control"/>
                                    <span class="input-group-addon">
                                                <span class="glyphicon-calendar glyphicon"></span>
                                            </span>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Responsible </label>
                            <div class="col-sm-9">
                                <select class="form-control" name="responsibleUserTask">
                                    <c:forEach var="userRow" items="${sessionScope.usersList}">
                                        <option value="${userRow.getId()}">
                                            <c:out value="${userRow.fName}"/>
                                            <c:out value="${userRow.lName}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Task type </label>
                            <div class="col-sm-9">
                                <select class="form-control" name="TaskType">
                                    <c:forEach var="taskType" items="${sessionScope.TaskTypeList}">
                                        <option value="${taskType.getId()}"><c:out
                                                value="${taskType.getType()}"/></option>
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
                        <!--   </form> -->
                    </div>

                    <!--Add deal-->
                    <div class="forms--nContact--Deal">
                        <!--  <form class="form-horizontal"> -->
                        <h2>Deal</h2>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Title </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Name deal" name="dealName" id="dealName">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Stage </label>
                            <select class="col-sm-9 form-control" id="stageDeal" name="stageDeal">
                                <c:forEach var="stage" items="${stageList}">
                                    <option><c:out value="${stage.title}"/></option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Budget </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="$" name="dealBudget" id="dealBudget">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10">
                                <input class="formAddBut" type="button" value="Применить">
                                <input class="formAddBut" type="button" value="Очистить">
                            </div>
                        </div>
                        <!--  </form> -->
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker').datetimepicker({language: 'ru', minuteStepping: 10, daysOfWeekDisabled: [0, 6]});
    });
</script>

</body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="../js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
<script type="text/javascript" src="../js/scriptAddCompany.js"></script>
</html>