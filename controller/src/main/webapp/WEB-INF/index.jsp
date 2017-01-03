<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../style/bootstrap.css">
    <link rel="stylesheet" href="../style/reset.css">
    <link rel="stylesheet" href="../style/style.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


    <title>Home</title>
</head>
<body>
<header>
    <div class="wrapper">
        <div class="header__logo">
            <p>Logo</p>
        </div>
        <div class="header__title">
            <h3>Home</h3>
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
                <li><a href="/WEB-INF/index.jsp" target="_self">Home</a></li>
                <li><a href="/deal" target="_self">Deals</a></li>
                <li><a href="/company" target="_self">Company</a></li>
                <li><a href="/contact" target="_self">Contacts</a></li>
                <li><a href="/taskList" target="_self">Tasks</a></li>
                <li><a href="#" target="_self">Analitics</a></li>
                <li><a href="/settings" target="_self">Settings</a></li>
            </ul>
        </div>
        <div class="wrapper__aboutCompany">
         <div class="card-container">
            <div class="form--cards">
            <div class="card-bloc">
                <div class="card-header">
                    <b>Сделки</b>
                </div>
                <div class="card-body">
                    <br>
                    Всего сделок : <b><a href="/deal" target="_self">${allDeals}</a></b>
                    <br>
                    Бюджет : <b><a href="/deal" target="_self">${allBudget}</a></b>
                    <br>
                </div>
            </div>
        </div>

            <div class="form--cards">
                <div class="card-bloc">
                    <div class="card-header">
                        <b>Успешные сделки</b>
                    </div>
                    <div class="card-body">
                        <br>
                        Успешных сделок : <b><a href="/deal" target="_self">${dealsDone}</a></b>
                        <br>
                        Нереализовано : <b><a href="/deal" target="_self">${dealsClose}</a></b>
                        <br>
                    </div>
                </div>
            </div>

            <div class="form--cards">
                <div class="card-bloc">
                    <div class="card-header">
                        <b>Сделки без задач</b>
                    </div>
                    <div class="card-body">
                        <br>
                        Сделок без задач : <b><a href="/deal" target="_self">${dealsWithNotTask}</a></b>
                        <br>
                        Сделок с задачами : <b><a href="/deal" target="_self">${dealWithTask}</a></b>
                        <br>
                    </div>
                </div>
            </div>

             <div class="form--cards">
                 <div class="card-bloc">
                     <div class="card-header">
                         <b>Задачи в работе</b>
                     </div>
                     <div class="card-body">
                         <br>
                         Задачи в работе : <b><a href="/taskList" target="_self">${tasksInProgress}</a></b>
                         <br>
                         Выполненные : <b><a href="/taskList" target="_self">${tasksDone}</a></b>
                         <br>
                         Просроченные : <b><a href="/taskList" target="_self">${tasksOverdue}</a></b>
                         <br>
                     </div>
                 </div>
             </div>

             <div class="form--cards">
                 <div class="card-bloc">
                     <div class="card-header">
                         <b>Всего контактов и компаний</b>
                     </div>
                     <div class="card-body">
                         <br><br>
                         Контактов : <b><a href="/contact" target="_self">${allContacts}</a></b>
                         <br>
                         Компаний : <b><a href="/company" target="_self">${allCompany}</a></b>
                         <br>
                     </div>
                 </div>
             </div>

         </div>
        </div>
    </div>
</div>

</body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
<script type="text/javascript" src="../js/moment-with-locales.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</html>