<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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

  <title>Edit Task</title>
</head>
<body>
<header>
  <div class="wrapper">
    <div class="header__logo">
      <p>Logo</p>
    </div>
    <div class="header__title">
      <h3>Tasks</h3>
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
        <div class="col-md-12">
          <br>
          <a href="/taskList" class="btn btn-primary pull-center">List Task</a>
          <a href="/taskAdd" class="btn btn-primary pull-center">Add Task</a>
        </div>
        <!--Edit task-->
        <div class="forms--nDeal--Task">
          <form class="form-horizontal" role="form" method="post" action="/taskEdit"  >
            <h2>Edit task</h2>

            <div class="form-group">
              <label class="col-sm-3 control-label">Title </label>
              <div class="col-sm-9">
                <input type="text" name="task"  class="form-control"  value="${task.getTitle()}"/>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-3 control-label">Period </label>
              <div class="col-sm-9">
                <select class="form-control" name="periodInDaysType">
                  <option name="periodInDaysTypeDef" value="${periodInDaysTypeDef.getId()}"><c:out value="${periodInDaysTypeDef.getTitle()}"/></option>
                  <c:forEach var="period" items="${periodInDaysTypeList}">
                    <option value="${period.getId()}"><c:out value="${period.getTitle()}"/></option>
                  </c:forEach>
                </select>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-3 control-label">Date and time </label>
              <div class="col-sm-8">
                <div class="input-group date" id="datetimepicker">
                  <input type="text" name="deadlineDate" value="${deadlineDate}" class="form-control" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon-calendar glyphicon"></span>
                                        </span>
                </div>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-3 control-label">Responsible </label>
              <div class="col-sm-9">
                <select class="form-control"  name="responsibleUsers">
                  <option name="userDef" value="${userDef.getId()}"><c:out value="${userDef.getfName()}"/> <c:out value="${userDef.getlName()}"/></option>
                  <c:forEach var="users" items="${responsibleUserList}">
                    <option value="${users.getId()}"> <c:out value="${users.getfName()}"/> <c:out value="${users.getlName()}"/> </option>
                  </c:forEach>
                </select>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-3 control-label">Task type </label>
              <div class="col-sm-9">
                <select class="form-control" name="taskType">
                  <option name="taskTypeDef" value="${taskTypeDef.getId()}"><c:out value="${taskTypeDef.getType()}"/></option>
                  <c:forEach var="taskType" items="${taskTypeList}">
                    <option value="${taskType.getId()}"><c:out value="${taskType.getType()}"/></option>
                  </c:forEach>
                </select>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-3 control-label">Comment </label>
              <div class="col-sm-9">
                <textarea class="form-control" name="description"><c:out value="${description}"/></textarea>
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-10">
                <input type="hidden" name="idTask" value="${idTask}">
                <input class="formAddBut" type="submit" value="Save" >
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
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.js"></script>
</body>
<!-- <script src="https://code.jquery.com/jquery-2.0.0.min.js"></script> -->
<script type="text/javascript" src="../js/script.js"></script>
</html>

