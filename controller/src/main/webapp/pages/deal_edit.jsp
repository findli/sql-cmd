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
    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/style.css">
    <title>Edit deal</title>
</head>
<body>
<header>
    <div class="wrapper">
        <div class="header__logo">
            <p>Logo</p>
        </div>
        <div class="header__title">
            <h3>Edit deal</h3>
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
            <div class="forms">

                <!--Add deal-->
                <div class="forms--nDeal">
                    <fieldset>
<<<<<<< HEAD
                    <form class="form-horizontal">
                        <h2>Edit deal</h2><br>

                        <div class="form-group">
                            <%--<span id="idDeal"></span>--%>
                            <label class="col-sm-3 control-label">Name </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" value="${deal.getTitle()}" id="dealNewName" name="dealNewName">
=======
                        <form class="form-horizontal">
                            <h2>Edit deal</h2><br>

                            <div class="form-group">
                                <%--<span id="idDeal"></span>--%>
                                <label class="col-sm-3 control-label">Name </label>
                                <div class="col-sm-9">
                                    <input class="form-control" type="text" value="${deal.getTitle()}" id="dealNewName" name="dealNewName">

                                </div>
>>>>>>> 50cf5c182a3dd4372af6b8b7ffa929918c179119

                            </div>

                        </div>


<<<<<<< HEAD
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Tag </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" placeholder="Tag не реализовано" id="dealTag" name="dealTag">
=======
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Responsible </label>
                                <select class="col-sm-9 form-control" id="responsibleUser" name="responsibleUser">
                                    <option>${responsibleUser}</option>
                                    <c:forEach var="user" items="${users}">
                                        <option><c:out value="${user.getlName()}"/></option>
                                    </c:forEach>
                                </select>
>>>>>>> 50cf5c182a3dd4372af6b8b7ffa929918c179119
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Responsible </label>
                            <select class="col-sm-9 form-control" id="responsibleUser" name="responsibleUser">
                                <option>${responsibleUser}</option>
                                <c:forEach var="user" items="${users}">
                                    <option><c:out value="${user.getlName()}"/></option>
                                </c:forEach>
                            </select>
                        </div>

<<<<<<< HEAD
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Budget </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" value="${deal.budget}" id="dealBudget" name="dealBudget">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Stage </label>
                            <select class="col-sm-9 form-control" id="stageDeal" name="stageDeal">
                                <option>${stageTitle}</option>
                                <c:forEach var="stage" items="${stages}">
                                    <option><c:out value="${stage.title}"/></option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="form-group">
                            <div class="col-sm-10">
                                    <input type="hidden" id="idDeal" value="${deal.getId()}" />
                                    <button type="button" class="btn btn-success" id="bttEditDeal">Применить</button>
                            </div>
                        </div>
                        <span id="result1" style="color:red"></span>

                    </form>
                    </fieldset>

                </div>

                <!--Add task-->
                <div class="forms--nDeal--Task">
                    <form class="form-horizontal">
                        <h2>Edit task</h2><br>

                        <!-- Навигация -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a href="#task" aria-controls="task" role="tab" data-toggle="tab">Task</a></li>
                            <li><a href="#comment" aria-controls="comment" role="tab" data-toggle="tab">Comment</a></li>
                            <li><a href="#action" aria-controls="action" role="tab" data-toggle="tab">Action</a></li>
                            <li><a href="#file" aria-controls="file" role="tab" data-toggle="tab">File</a></li>
                        </ul>

                        <!-- Содержимое вкладок -->
                        <div class="tab-content">
                            <br>
                            <div role="tabpanel" class="tab-pane active" id="task">
                                Task

                            </div>

                            <div role="tabpanel" class="tab-pane" id="comment">
                                Comment
                            </div>

                            <div role="tabpanel" class="tab-pane" id="action">
                                Action
                            </div>

                            <div role="tabpanel" class="tab-pane" id="file">
                                File
                            </div>

                        </div>
                    </form>

                </div>
=======
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Budget </label>
                                <div class="col-sm-9">
                                    <input class="form-control" type="text" value="${deal.budget}" id="dealBudget" name="dealBudget">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Stage </label>
                                <select class="col-sm-9 form-control" id="stageDeal" name="stageDeal">
                                    <option>${stageTitle}</option>
                                    <c:forEach var="stage" items="${stages}">
                                        <option><c:out value="${stage.title}"/></option>
                                    </c:forEach>
                                </select>
                            </div>


                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input type="hidden" id="idDeal" value="${deal.getId()}" />
                                    <button type="button" class="btn btn-success" id="bttEditDeal">Применить</button>
                                </div>
                            </div>
                            <span id="result1" style="color:red"></span>

                        </form>
                    </fieldset>

                </div>

                <!--Add task-->
                <div class="forms--nDeal--Task">
                    <form class="form-horizontal">
                        <h2>Edit task</h2><br>

                        <!-- Навигация -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a href="#task" aria-controls="task" role="tab" data-toggle="tab">Task</a></li>
                            <li><a href="#comment" aria-controls="comment" role="tab" data-toggle="tab">Comment</a></li>
                            <li><a href="#action" aria-controls="action" role="tab" data-toggle="tab">Action</a></li>
                            <li><a href="#file" aria-controls="file" role="tab" data-toggle="tab">File</a></li>
                        </ul>

                        <!-- Содержимое вкладок -->
                        <div class="tab-content">
                            <br>
                            <div role="tabpanel" class="tab-pane active" id="task">
                                Task

                            </div>

                            <div role="tabpanel" class="tab-pane" id="comment">
                                Comment
                            </div>

                            <div role="tabpanel" class="tab-pane" id="action">
                                Action
                            </div>

                            <div role="tabpanel" class="tab-pane" id="file">
                                File
                            </div>

                        </div>
                    </form>

                </div>

                <!--Edit company-->
                <div class="forms--nDeal">
                    <form class="form-horizontal">
                        <h2>Edit company</h2><br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Name </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" value="${company.title}" id="companyNewName" name="companyNewName">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Phone </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" value = "${company.getPhoneNumber()}" placeholder="Phone" id="companyNewPhone" name="companyNewPhone">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">email </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" value="${company.getEmail()}" placeholder="email" id="companyNewEmail" name="companyNewEmail">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Web </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" value="${company.getWebsite()}" placeholder="Url" id="companyNewWeb" name="companyNewWeb">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Address </label>
                            <div class="col-sm-9">
                                <input onclick="location.href='#modalEditAddress'" class="formAddBut" type="button"
                                       value="Edit address">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10">
                                <%--<input type="hidden" id="idDeal" value="${deal.getId()}" />--%>
                                <button type="button" class="btn btn-success" id="bttEditCompany">Применить</button>
                            </div>
                        </div>
                        <span id="result2" style="color:red"></span>
                        <!--Modal window contact-->
                        <div id="modalEditAddress" class="modalDialog">
                            <%--<form id="add_address_form">--%>
                            <div style="height: 300px;">
                                <header>
                                    <div class="wrapper__modal1Title">
                                        <div><i class="fa fa-industry"></i></div>
                                        <h3>Edit address</h3>
                                    </div>
                                </header>
                                <p>Country <input type="text" class="modalInput" id="AddressCountry" value="${address.getCountry()}"></p>
                                <p>City <input  type="text" class="modalInput" id="AddressCity" value="${address.getCity()}"></p>
                                <p>Street <input type="text" class="modalInput" id="AddressStreet" value="${address.getStreet()}"></p>
                                <p>zip code <input type="text" class="modalInput" id="AddressZipcode" value="${address.getZipcode()}"></p>
                                <p>Building number <input type="text" class="modalInput" id="AddressBuilding" value="${address.getBuildNum()}"></p>
                                <p>office room <input type="text" class="modalInput" id="AddressRoom" value="${address.getOfficeRoom()}"></p>
                                <%--<input class="modalBut" type="button" value="Save contact" onclick="add_contact();">--%>
                                <input class="modalBut" onclick="location.href='#close'" type="button"
                                       value="Save">
                            </div>
                            <%--</form>--%>
                        </div>
                        <!--End-->

                    </form>

                </div>

                <!--Edit contact-->
                <div class="forms--nDeal">
                    <form class="form-horizontal">
                        <h2>Edit contact</h2><br>

                        <!-- Навигация -->

                        <ul class="nav nav-tabs" role="tablist">
                            <c:set var="i" value="${0}"/>
                            <c:forEach items="${contacts}" var="contact">

                                <c:if test="${i == 0}">
                                    <li class="active"><a href="#${contact.getlName()}" aria-controls="${contact.getlName()}" role="tab" data-toggle="tab">${contact.getlName()}</a></li>
                                </c:if>
                                <c:if test="${i > 0}">
                                    <li><a href="#${contact.getlName()}" aria-controls="${contact.getlName()}" role="tab" data-toggle="tab">${contact.getlName()}</a></li>
                                </c:if>
                                <c:set var="i" value="${i + 1}"/>
                            </c:forEach>
                        </ul>

                        <!-- Содержимое вкладок -->
                        <div class="tab-content">
                            <br>
                            <c:set var="i" value="${0}"/>
                            <c:forEach items="${contacts}" var="contact">
                                <c:if test="${i == 0}">
                                    <div role="tabpanel" class="tab-pane fade in active" id="${contact.getlName()}">

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Contact</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getfName()} ${contact.getlName()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Company </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getCompany().getTitle()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Position </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getPosition()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <select class="col-sm-3 form-control" style="width: 100px">
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
                                                <input class="form-control" type="text" value="${contact.getEmail()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Skype </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getSkype()}">
                                            </div>
                                        </div>

                                    </div>
                                </c:if>
                                <c:if test="${i > 0}">
                                    <div role="tabpanel" class="tab-pane fade" id="${contact.getlName()}">

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Contact</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getfName()} ${contact.getlName()}">
                                            </div>
                                        </div>
>>>>>>> 50cf5c182a3dd4372af6b8b7ffa929918c179119

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Company </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getCompany().getTitle()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Position </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getPosition()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <select class="col-sm-3 form-control" style="width: 100px">
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
                                                <input class="form-control" type="text" value="${contact.getEmail()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Skype </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getSkype()}">
                                            </div>
                                        </div>

<<<<<<< HEAD
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Address </label>
                                <div class="col-sm-9">
                                    <input onclick="location.href='#modalEditAddress'" class="formAddBut" type="button"
                                           value="Edit address">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-10">
                                    <%--<input type="hidden" id="idDeal" value="${deal.getId()}" />--%>
                                    <button type="button" class="btn btn-success" id="bttEditCompany">Применить</button>
                                </div>
                            </div>
                            <span id="result2" style="color:red"></span>
                            <!--Modal window contact-->
                            <div id="modalEditAddress" class="modalDialog">
                                <%--<form id="add_address_form">--%>
                                <div style="height: 300px;">
                                    <header>
                                        <div class="wrapper__modal1Title">
                                            <div><i class="fa fa-industry"></i></div>
                                            <h3>Edit address</h3>
                                        </div>
                                    </header>
                                    <p>Country <input type="text" class="modalInput" id="AddressCountry" value="${address.getCountry()}"></p>
                                    <p>City <input  type="text" class="modalInput" id="AddressCity" value="${address.getCity()}"></p>
                                    <p>Street <input type="text" class="modalInput" id="AddressStreet" value="${address.getStreet()}"></p>
                                    <p>zip code <input type="text" class="modalInput" id="AddressZipcode" value="${address.getZipcode()}"></p>
                                    <p>Building number <input type="text" class="modalInput" id="AddressBuilding" value="${address.getBuildNum()}"></p>
                                    <p>office room <input type="text" class="modalInput" id="AddressRoom" value="${address.getOfficeRoom()}"></p>
                                    <%--<input class="modalBut" type="button" value="Save contact" onclick="add_contact();">--%>
                                    <input class="modalBut" onclick="location.href='#close'" type="button"
                                           value="Save">
=======
                                    </div>
                                </c:if>
                                <c:set var="i" value="${i + 1}"/>
                            </c:forEach>

                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input class="formAddBut" type="button" value="Добавить">
                                    <input class="formAddBut" type="button" value="Открепить">
>>>>>>> 50cf5c182a3dd4372af6b8b7ffa929918c179119
                                </div>
                            </div>

                        </div>
                    </form>

<<<<<<< HEAD
                <!--Edit contact-->
                <div class="forms--nDeal">
                    <form class="form-horizontal">
                        <h2>Edit contact</h2><br>

                        <!-- Навигация -->

                        <ul class="nav nav-tabs" role="tablist">
                            <c:set var="i" value="${0}"/>
                            <c:forEach items="${contacts}" var="contact">

                                <c:if test="${i == 0}">
                                    <li class="active"><a href="#${contact.getlName()}" aria-controls="${contact.getlName()}" role="tab" data-toggle="tab">${contact.getlName()}</a></li>
                                </c:if>
                                <c:if test="${i > 0}">
                                    <li><a href="#${contact.getlName()}" aria-controls="${contact.getlName()}" role="tab" data-toggle="tab">${contact.getlName()}</a></li>
                                </c:if>
                                <c:set var="i" value="${i + 1}"/>
                            </c:forEach>
                        </ul>

                        <!-- Содержимое вкладок -->
                        <div class="tab-content">
                            <br>
                            <c:set var="i" value="${0}"/>
                            <c:forEach items="${contacts}" var="contact">
                                <c:if test="${i == 0}">
                                    <div role="tabpanel" class="tab-pane fade in active" id="${contact.getlName()}">

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Contact</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getfName()} ${contact.getlName()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Company </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getCompany().getTitle()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Position </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getPosition()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <select class="col-sm-3 form-control" style="width: 100px">
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
                                                <input class="form-control" type="text" value="${contact.getEmail()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Skype </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getSkype()}">
                                            </div>
                                        </div>

                                    </div>
                                </c:if>
                                <c:if test="${i > 0}">
                                    <div role="tabpanel" class="tab-pane fade" id="${contact.getlName()}">

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Contact</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getfName()} ${contact.getlName()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Company </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getCompany().getTitle()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Position </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getPosition()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <select class="col-sm-3 form-control" style="width: 100px">
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
                                                <input class="form-control" type="text" value="${contact.getEmail()}">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Skype </label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="${contact.getSkype()}">
                                            </div>
                                        </div>

                                    </div>
                                </c:if>
                                <c:set var="i" value="${i + 1}"/>
                            </c:forEach>

                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input class="formAddBut" type="button" value="Добавить">
                                    <input class="formAddBut" type="button" value="Открепить">
                                </div>
                            </div>

                        </div>
                    </form>

                </div>
                <!--End-->



=======
                </div>
                <!--End-->



>>>>>>> 50cf5c182a3dd4372af6b8b7ffa929918c179119

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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="../js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>

</html>