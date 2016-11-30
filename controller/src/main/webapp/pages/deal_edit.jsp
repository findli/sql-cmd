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

    <%--<script type="text/javascript">--%>
        <%--$(function(){--%>
            <%--$('#bttNewDeal').click(function(){--%>

                <%--var newDeal = $('#dealNewName').val();--%>
                <%--$.ajax({--%>
                    <%--type: 'POST',--%>
                    <%--data: {--%>
                        <%--newDeal : newDeal,--%>
                        <%--action : 'editDealDeal',--%>
                        <%--idDeal : ${idDeal}--%>
                    <%--},--%>
                    <%--url: '/dealEdit2',--%>
                    <%--success: function(result) {--%>
                        <%--$('#result1').html(result);--%>
                    <%--}--%>
                <%--})--%>
            <%--});--%>
        <%--});--%>
    <%--</script>--%>


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
                <li><a href="#" target="_self">Tasks</a></li>
                <li><a href="#" target="_self">Analitics</a></li>
                <li><a href="#" target="_self">Settings</a></li>
            </ul>
        </div>

        <div class="wrapper__aboutCompany">
            <div class="forms">
                <%--<form class="form-horizontal" role="form" method="post" action="/dealEdit" id="dealForm2"--%>
                      <%--enctype="multipart/form-data">--%>

                    <!--Add deal-->
                    <div class="forms--nDeal">
                        <fieldset>
                            <form class="form-horizontal">
                            <h2>Edit deal</h2><br>

                            <div class="form-group">
                                <%--<span id="idDeal"></span>--%>
                                <label class="col-sm-3 control-label">Name </label>
                                <div class="col-sm-9">
                                    <input class="form-control" type="text" value="${deal.getTitle()}" id="dealNewName" name="dealNewName">
                                    <span id="result1" style="color:red"></span>
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
                                    <input class="form-control" type="text" value="${deal.budget}" id="dealBudget" name="dealBudget">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Stage </label>
                                <select class="col-sm-9 form-control" id="stageDeal" name="stageDeal">
                                    <c:forEach var="stage" items="${stages}">
                                        <option><c:out value="${stage.title}"/></option>
                                    </c:forEach>
                                </select>
                            </div>


                            <div class="form-group">
                                <div class="col-sm-10">
                                    <%--<input class="formAddBut" type="button" value="Применить">--%>
                                    <%--<input class="formAddBut" type="button" value="Очистить">--%>
                                    <%--<input type="button" value="Применить" id="bttNewDeal">--%>
                                        <input type="hidden" id="idDeal" value="${deal.getId()}" />
                                        <button type="button" class="btn btn-success" id="bttNewDeal">Применить</button>
                                </div>
                            </div>

                        </form>
                        </fieldset>

                    </div>

                    <!--Edit contact-->
                    <div class="forms--nDeal">
                        <form>
                        <h2>Edit contact</h2><br>

                        <!-- Навигация -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active"><a href="#contact1" aria-controls="contact1" role="tab" data-toggle="tab">Contact 1</a></li>
                            <li><a href="#contact2" aria-controls="contact2" role="tab" data-toggle="tab">Contact 2</a></li>
                        </ul>

                        <!-- Содержимое вкладок -->
                        <div class="tab-content">
                            <br>
                            <div role="tabpanel" class="tab-pane active" id="contact1">

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Name </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" placeholder="Name">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Company </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" placeholder="Company">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Position </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" placeholder="Position">
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
                                        <input class="form-control" type="text" placeholder="Email">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Skype </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" placeholder="Skype">
                                    </div>
                                </div>

                            </div>

                            <div role="tabpanel" class="tab-pane" id="contact2">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Name </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" placeholder="Name">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Company </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" placeholder="Company">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Position </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" placeholder="Position">
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
                                        <input class="form-control" type="text" placeholder="Email">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Skype </label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" placeholder="Skype">
                                    </div>
                                </div>
                            </div>
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

                    <!--Edit company-->
                    <div class="forms--nDeal">
                        <form>
                        <h2>Edit company</h2><br>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Name </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" value="${company.title}" id="editDealCompanyName" name="editDealCompanyName">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Phone </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" value = "${company.getPhoneNumber()}" placeholder="Phone" id="editDealCompanyPhone" name="editDealCompanyPhone">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">email </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" value="${company.getEmail()}" placeholder="email" id="editDealCompanyEmail" name="editDealCompanyEmail">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Web </label>
                            <div class="col-sm-9">
                                <input class="form-control" type="text" value="${company.getWebsite()}" placeholder="Url" id="editDealCompanyWeb" name="editDealCompanyWeb">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">Address </label>
                            <div class="col-sm-9">
                                <textarea class="form-control" value="${company.getAddress()}"
                                          placeholder="хз пока не получилось" id="editDealCompanyAddress" name="editDealCompanyAddress"></textarea>
                            </div>
                        </div>
                        </form>

                    </div>

                    <!--Add task-->
                    <div class="forms--nDeal--Task">
                        <form>
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

                <%--</form>--%>

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
