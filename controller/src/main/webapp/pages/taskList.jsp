<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

  <%--<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>--%>
  <script type="text/javascript" src="../js/moment-with-locales.min.js"></script>
  <script type="text/javascript" src="../js/bootstrap.min.js"></script>
  <script type="text/javascript" src="../js/bootstrap-datetimepicker.min.js"></script>
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
          <a href="/taskAdd" class="btn btn-primary pull-center">Add Task</a>
        </div>
        <div class="forms--lTask">

          <br><br><br><br>

          <div>
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
<script type="text/javascript">
  $(function () {
    $('#datetimepicker1').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});
    $('#datetimepicker2').datetimepicker({language: 'ru',minuteStepping:10,daysOfWeekDisabled:[0,6]});

  });
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.js"></script>
</body>
<!-- <script src="https://code.jquery.com/jquery-2.0.0.min.js"></script> -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="../js/task.js"></script>
</html>
