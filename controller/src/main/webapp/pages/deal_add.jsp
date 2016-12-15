<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/style.css">

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
                <li><a href="/index.jsp" target="_self">Home</a></li>
                <li><a href="/deal" target="_self">Deals</a></li>
                <li><a href="/company" target="_self">Company</a></li>
                <li><a href="/contact" target="_self">Contacts</a></li>
                <li><a href="/taskList" target="_self">Tasks</a></li>
                <li><a href="#" target="_self">Analitics</a></li>
                <li><a href="#" target="_self">Settings</a></li>
            </ul>
        </div>

        <div class="wrapper__aboutCompany">
            <form class="form-horizontal" role="form" method="post" action="/dealCreate" id="dealCreate"
                  enctype="multipart/form-data">
                <div class="forms">
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
                        <%--</form>--%>
                    </div>

                    <!--Add task-->
                    <div class="forms--nDeal--Task">
                        <%--<form class="form-horizontal">--%>
                        <h2>Add task</h2>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Title </label>
                            <div class="col-sm-9">
                                <input type="text" name="Title"  class="form-control"  placeholder="Title"/>
                            </div>
                        </div>

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
                            <label class="col-sm-3 control-label">Date and time </label>
                            <div class="col-sm-8">
                                <div class="input-group date" id="datetimepicker">
                                    <input type="text" name="DeadlineDate" class="form-control" />
                                    <span class="input-group-addon">
                                            <span class="glyphicon-calendar glyphicon"></span>
                                        </span>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Responsible </label>
                            <div class="col-sm-9">
                                <select class="form-control"  name="ResponsibleUserTask">
                                    <c:forEach var="user" items="${users}">
                                        <option value="${user.getId()}"><c:out value="${user.getfName()}"/> <c:out value="${user.getlName()}"/> </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Task type </label>
                            <div class="col-sm-9">
                                <select class="form-control" name="TaskType">
                                    <c:forEach var="taskType" items="${TaskTypeList}">
                                        <option value="${taskType.getId()}"><c:out value="${taskType.getType()}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Comment </label>
                            <div class="col-sm-9">
                                <textarea class="form-control" name="Description" placeholder="Message"></textarea>
                            </div>
                        </div>

                    </div>

                    <!--Add company-->
                    <div class="forms--nDeal">
                        <%--<form class="form-horizontal">--%>
                        <h2>Add company</h2>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Name </label>
                            <div class="col-sm-9">
                                <select class="form-control" style="float: none; width: 250px" id="companyDeal" name="companyDeal">
                                    <c:forEach var="company" items="${companyList}">
                                        <option><c:out value="${company.getTitle()}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <%--<div class="form-group">--%>
                        <%--<label class="col-sm-3 control-label">Address </label>--%>
                        <%--<div class="col-sm-9">--%>
                        <input onclick="location.href='#modalAddCompany'" class="formAddBut" type="button"
                               value="Add company">
                        <%--</div>--%>
                        <%--</div>--%>
                        <span id="result3" style="color:red"></span>

                    </div>

                    <!--Add contact-->
                    <div class="forms--nDeal--Contact">
                        <%--<form class="form-horizontal">--%>
                        <h2>Add contact</h2>

                        <div class="panel-group" id="collapse-group">
                            <c:forEach items="${contactList}" var="contactList">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#collapse-group" href="#el1">Первый элемент</a>
                                        </h4>
                                    </div>
                                    <div id="el1" class="panel-collapse collapse in">
                                        <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                                            sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>

                        <input onclick="location.href='#modalAddContact'" class="formAddBut" type="button"
                               value="Add contact">
                        <%--</form>--%>
                    </div>
                    <!--Modal window contact-->
                    <div id="modalAddContact" class="modalDialog">
                        <%--<form class="form-horizontal">--%>
                        <div>
                            <header>
                                <div class="wrapper__modal1Title">
                                    <div><i class="fa fa-user"></i></div>
                                    <h3>Add contact</h3>
                                </div>
                            </header>
                            <p style="display: inline">Name <input style="float: none; width: 148px" type="text"
                                                                   class="modalInput" placeholder="Name"></p>
                            <p style="display: inline;">Surname <input style="float: none; width: 147px" type="text"
                                                                       class="modalInput" placeholder="Surname"></p>
                            <p>Position <input type="text" class="modalInput" id="modalContactPosition" placeholder="Position"></p>
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
                            <p>Email <input type="text" class="modalInput"  placeholder="Email"></p>
                            <p>Skype <input type="text" class="modalInput"  placeholder="Skype"></p>
                            <input class="modalBut" type="button" value="Save contact" onclick="add_contact();">
                            <input class="modalBut cancel" onclick="location.href='#close'" type="button"
                                   value="Cancel">
                        </div>
                        <%--</form>--%>
                    </div>
                    <!--End-->

                </div>
            </form>
            <!--Modal window contact-->
            <div id="modalAddCompany" class="modalDialog">
                <form class="form-horizontal" style="height: 400px; position: relative; margin: 10% auto; background: #fff; width: 460px">
                    <div style="height: 300px;">
                        <header>
                            <div class="wrapper__modal1Title">
                                <div><i class="fa fa-industry"></i></div>
                                <h3>Add address</h3>
                            </div>
                        </header>
                        <p>Title <input type="text" class="modalInput" id="companyName" placeholder="Name company"></p>
                        <p>Phone <input type="text" class="modalInput" id="companyPhone" placeholder="Phone"></p>
                        <p>Email <input type="text" class="modalInput" id="companyEmail" placeholder="Email"></p>
                        <p>Web <input type="text" class="modalInput" id="companyWeb" placeholder="Web"></p>
                        <p>Address</p>
                        <p>Country <input type="text" class="modalInput" id="AddressCountry" placeholder="Country"></p>
                        <p>City <input  type="text" class="modalInput" id="AddressCity" placeholder="City"></p>
                        <p>Street <input type="text" class="modalInput" id="AddressStreet" placeholder="Street"></p>
                        <p>zip code <input type="text" class="modalInput" id="AddressZipcode" placeholder="Zip code"></p>
                        <p>Building number <input type="text" class="modalInput" id="AddressBuilding" placeholder="Building number"></p>
                        <p>office room <input type="text" class="modalInput" id="AddressRoom" placeholder="office room"></p>
                        <%--<input class="modalBut" onclick="location.href='#close'" type="button"--%>
                        <%--value="Save">--%>
                        <button onclick="location.href='#close'" type="button" class="btn btn-success" id="bttAddCompany">Применить</button>
                    </div>
                </form>
            </div>
            <!--End-->
        </div>
    </div>
</div>
<%--<script type="text/javascript">--%>
<%--$(function () {--%>
<%--$('#datetimepicker').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});--%>
<%--});--%>
<%--</script>--%>

</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="../js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
</html>