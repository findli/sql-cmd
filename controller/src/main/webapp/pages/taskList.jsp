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
  <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css" />

  <title>Task</title>
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

        <div class="forms--lTask--Filter">
          <form class="form-horizontal" role="form" method="post" action="/taskListFilter">
            <h2>Фильтр</h2><br>
            <div class="radio">
              <label ><input type="radio" name="optionsRadios" value="0" checked>Все задачи</label>
              </div>
            <div class="radio">
              <label><input type="radio" name="optionsRadios" value="1">Просроченные задачи</label>
            </div>
            <div class="radio">
              <label><input type="radio" name="optionsRadios" value="2" disabled>Только мои задачи</label>
            </div>
            <div class="radio">
              <label><input type="radio" name="optionsRadios" value="3">Удаленные</label>
            </div>

            <div class="form-group">
              <label class="col-sm-3 control-label">От: </label>
              <div class="col-sm-9">
                <div class="input-group date" id="datetimepicker1">
                  <input type="text" name="FromDate" value="${FromDate}" class="form-control"/>
                                    <span class="input-group-addon">
                                            <span class="glyphicon-calendar glyphicon"></span>
                                    </span>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">До: </label>
              <div class="col-sm-9">
                <div class="input-group date" id="datetimepicker2">
                  <input type="text" name="ToDate" value="${ToDate}" class="form-control"/>
                                    <span class="input-group-addon">
                                        <span class="glyphicon-calendar glyphicon"></span>
                                    </span>

                </div>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-3 control-label">Период</label>
              <div class="col-sm-9">
                <select class="form-control" name="PeriodInDaysType">
                  <option name="periodInDaysTypeDef" value="${periodInDaysTypeDef.getId()}"><c:out value="${periodInDaysTypeDef.getTitle()}"/></option>
                  <c:forEach var="period" items="${PeriodInDaysTypeList}">
                    <option value="${period.getId()}"><c:out value="${period.getTitle()}"/></option>
                  </c:forEach>
                </select>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-3 control-label">Тип задачи</label>
              <div class="col-sm-9">
                <select class="form-control" name="TaskType">
                  <option name="taskTypeDef" value="${taskTypeDef.getId()}"><c:out value="${taskTypeDef.getType()}"/></option>
                  <c:forEach var="taskType" items="${TaskTypeList}">
                    <option value="${taskType.getId()}"><c:out value="${taskType.getType()}"/></option>
                  </c:forEach>
                </select>
              </div>
            </div>

            <div class="form-group">
              <label class="col-sm-3 control-label">Ответственный</label>
              <div class="col-sm-9">
                <select class="form-control" name="ResponsibleUsers">
                  <option name="userDef" value="${userDef.getId()}"><c:out value="${userDef.getfName()}"/> <c:out value="${userDef.getlName()}"/></option>
                  <c:forEach var="users" items="${ResponsibleUserList}">
                    <option value="${users.getId()}"><c:out value="${users.getfName()}"/> <c:out value="${users.getlName()}"/> </option>
                  </c:forEach>
                </select>
              </div>
            </div>
            <hr>
            <input class="formAddBut" type="submit" name="Apply" value="Применить">
            <input class="formAddBut" type="submit" name="Clean" value="Очистить">
            </form>
        </div>

        <div class="forms--lTask">
          <div class="col-md-12">
            <br>
            <a href="/taskAdd" class="btn btn-primary pull-center">Add Task</a>
          </div>

          <br><br><br><br>

          <div class="wrapper__tasks">
            <form class="form-horizontal" role="form" method="post" action="/taskList"  >
            <table class="table table-bordered">
              <thead>
              <tr>
                <th>Пометить</th>
                <th>Дата исполнения/Ответственный</th>
                <th>Контакт или сделка</th>
                <th>Тип/Текст задачи</th>
              </tr>
              </thead>
              <tbody id="t_task">
              <c:forEach var="task" items="${listTasks}">
                <tr>
                  <td><input type="checkbox" name="${task.getId()}" ></td>
                  <td data-href="/taskEdit?idTask=${task.getId()}"><c:out value="${task.getDeadlineDate()}"/>
                      <c:out value="${task.getResponsibleUser().getlName()}"/>
                      <c:out value="${task.getResponsibleUser().getfName()}"/>
                  </td>
                  <td data-href="/taskEdit?idTask=${task.getId()}"><c:out value="${task.getTitle()}"/></td>
                  <td data-href="/taskEdit?idTask=${task.getId()}"><c:out value="${task.getDescription()}"/></td>
                </tr>
              </c:forEach>
              </tbody>

            </table>
              <input class="formAddBut" type="submit" value="Удалить">
              </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="../js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
<script src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/task.js"></script>
</html>
