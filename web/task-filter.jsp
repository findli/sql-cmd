<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <link rel="stylesheet" href="style/reset.css">
    <link rel="stylesheet" href="style/timeline.css">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="style/ion.calendar.css">
    <link rel="stylesheet" href="style/jquery-clockpicker.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
    <title>Company</title>
</head>
<body>
<%--<jsp:useBean id="user"  scope="session"/>             &lt;%&ndash;Add class&ndash;%&gt;--%>
<%--<jsp:useBean id="contact" scope="session"/>--%>
<%--<jsp:useBean id="deal" scope="session"/>--%>
<%--<jsp:useBean id="task" scope="session"/>--%>
<%--<jsp:useBean id="company" scope="session"/>--%>
<header>
    <div class="wrapper">
        <div class="header__logo">
            <p>Logo</p>
        </div>
        <div class="header__title">
            <h3>Company</h3>
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
            <div>
                <a href="#add-task-block">Add task</a>
                <a href="#to-do-line-block">To-do line</a>
                <a href="#day-block">Day</a>
                <a href="#week-block">Week</a>
                <a href="#month-block">Month</a>
                <a href="#list-block">List</a>
                <a href="#filter-block">filter</a>
            </div>
            <br>
            <div>
                <h4>Фильтр</h4>
                <br>
                <ul>
                    <li>Только мои задачи</li>
                    <li>Просроченные задачи</li>
                    <li>Выполненные задачи</li>
                    <li>Не реализованные</li>
                    <li>Все задачи</li>
                    <li>Удаленные</li>
                </ul>
            </div>
            <div class="forms">
                <div class="forms--nCompany">
                    <p>Name Company <input class="text" id='formCompany' type="text" name="formCompany"
                                           placeholder="Name Company" value="${company.setTitle()}"></p>
                    <p>Tags <input class="text" id='formTag' type="text" name="formTag" placeholder="Tag" value="${company.setTags()}">>    </p>
                    <a href="">Responsible</a><br>
                    <select>
                        <option>Work telephone</option>
                        <option>Mobile telephone</option>
                        <option>Home telephone</option>
                    </select>
                    <input class="text" id='formPhone' type="text" name="formPhone" placeholder="Number" value="${company.setPhoneNumber()}">>
                    <p>Email <input class="text" id='formEmail' type="text" name="formEmail" placeholder="Email"value="${company.setEmail()}">></p>
                    <p>Web <input class="text" id='formWeb' type="text" name="formWeb" placeholder="Url"value="${company.setWebsite()}">></p>
                    <p>Address <input class="text" id='formAddress' type="text" name="formAddress"
                                      placeholder="Address"value="${company.setAdress()}">></p>
                </div>

                <div class="forms--users">

                    <div class="wrapper__users">
                        <c:forEach items="contact" var="0">
                        <div id="fu${contact.getId()}" class="users__panel">
                            <p>${contact.getName()}</p> <%--Correct--%>
                            <a href="#">Edit</a>
                            <a href="#">Undock</a>
                            <input class="users__panel--input" id='cbfu${contact.getId()}' type="checkbox"> <%--Correct--%>
                        </div>
                        <div class="users__panel--body">
                            <p>Position ${contact.getPosition()}</p> <%--Correct--%>
                            <p>Email ${contact.getEmail()}</p> <%--Correct--%>
                            <select>
                                <option>Work telephone</option>
                                <option>Mobile telephone</option>
                                <option>Home telephone</option>
                            </select>
                            <input class="text" id='formPhonefu${contact.getId()}' type="text" name="formPhone"
                                   placeholder="Number">
                            <p>Skype ${contact.getSkype()}</p> <%--Correct--%>
                        </div>
                        </c:forEach>
                    </div>

                    <input onclick="location.href='#modalAddContact'" class="formAddBut" type="button"
                           value="Add contact">
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
                            <input class="modalInput" id='modalContactPhone' name="formPhone"
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
                <div class="form--deals">
                    <c:forEach items="${company.getDeals()}" var="deal">
                        <c:set var="totalDeals" value="0" scope="page"/>
                        <c:set var="amount" value="${deal.getBudget()}" scope="page"/>
                        <div class="wrapper__deals">
                            <div class="deal__panel">
                                <p>Total deals: ${totalDeals}</p>
                                <p>Amount: ${deal.getBudget()}</p>
                            </div>
                            <div class="deal__panel--body">
                                <p>Name deal ${deal.getTitle()}</p>
                                <p>Stage deal ${deal.getStage()}</p>
                                <p>${deal.budget}</p>
                                <input class="formDealEditDeal" type="button" value="Edit deal">
                            </div>
                            <c:set var="totalDeals" value="${totalDeals+1}" scope="page"/>
                            <c:set var="amount" value="${amount+deal.getBudget()}" scope="page"/>
                        </div>
                    </c:forEach>
                    <input onclick="location.href='#modalDeal'" class="formAddBut" type="button"
                           value="Quickly add deal">

                    <!--Modal window deal-->
                    <div id="modalDeal" class="modalDialog modalDeal">
                        <div>
                            <header>
                                <div class="wrapper__modal1Title">
                                    <div><i class="fa fa-briefcase"></i></div>
                                    <h3>Add deal</h3>
                                </div>
                            </header>
                            <table border="1">
                                <caption>Current deals with ServletCompany:</caption>
                                <tr>
                                    <th>deal(s)</th>
                                    <th style="width: 60px">6500</th>
                                    <th style="width: 60px">USD</th>
                                </tr>
                                <c:forEach items="company.getDeals" var="0">
                                <tr>
                                    <td>${deal.getTitle()}"</td>
                                    <td>${deal.getBudget()}"</td>
                                    <td>USD</td>
                                </tr>
                                </c:forEach>
                            </table>
                            <span><input class="checkboxDeal" type="checkbox" value="${deal.setTitle()}">Add more deals</span>
                            <p>Title: <input type="text" class="modalInput" id="modalDealTitle" disabled></p>
                            <p>Stage:
                                <select disabled>
                                    <option>Choose from the list ...</option>
                                    <option>First contact</option>
                                    <option>Conversation</option>
                                    <option>Deciding</option>
                                    <option>Approval of the contract</option>
                                    <option>Successfully implemented</option>
                                    <option>Closed or sold</option>
                                </select>
                            </p>
                            <p>Budget: <input type="text" class="modalInput" id="modalDealBudget" disabled value="${deal.setBudget()}"></p>
                            <input class="modalBut" type="button" value="Save contact">
                            <input class="modalBut cancel" onclick="location.href='#close'" type="button"
                                   value="Cancel">
                        </div>
                    </div>
                    <!--End-->


                </div>
                <div class="form--action">
                    <h3>Tasks and Notes</h3>

                    <section id="cd-timeline">
                        <c:forEach items="${Ddal.getTask}" var="task">
                            <div class="cd-timeline-block">
                                <div class="cd-timeline-content">
                                    <div id="task" class="action__task action--task">
                                        <h4>Task ${task.getTitle}</h4>
                                        <p>Time of completion: ${task.getDeadlineDate()}</p>
                                        <p>Responsible ${task.getResponsibleUser()}</p>
                                        <p>Type of task ${task.getTaskType()}</p>
                                        <textarea rows="3" cols="21" id="formTaskText${task.getId()}" class="formActionText"
                                                  name="text"></textarea>
                                        <input id="formTaskDel" class="actionBut" type="button" value="Delete">
                                        <input id="formTaskEdit" class="actionBut" type="button" value="Edit">
                                        <input id="formTaskDone" class="actionBut" type="button" value="Done">
                                    </div>
                                    <span class="cd-date">${task.getDeadlineDate()}</span>
                                </div> <!-- cd-timeline-content -->
                            </div>
                            <!-- cd-timeline-block -->
                        </c:forEach>

                        <div class="cd-timeline-block">
                            <!-- ... -->
                        </div>
                        <c:forEach items="${deal.getNote()}" var="note">
                            <div class="cd-timeline-block">
                                <div class="cd-timeline-content">
                                    <div id="note" class="action__task action--note">
                                        <h4>Note</h4>
                                        <p>Created: ${note.getDateCreate()}</p>
                                        <p>User name: ${note.getCreatetByUserId()}</p>
                                        <textarea rows="3" cols="21" id="formNoteText" class="formActionText"
                                                  name="text"></textarea>
                                        <input id="formNoteDel" class="actionBut" type="button" value="Delete">
                                        <input id="formNoteEdit" class="actionBut" type="button" value="Edit">
                                    </div>
                                    <span class="cd-date">Jan 20</span>
                                </div> <!-- cd-timeline-content -->
                            </div>
                            <!-- cd-timeline-block -->
                        </c:forEach>

                        <div class="cd-timeline-block">
                            <!-- ... -->
                        </div>

                        <div class="cd-timeline-block">
                            <div class="cd-timeline-content">
                                <div id="action" class="action__task">
                                    <h4>Action</h4>
                                    <p>Activiity;</p>
                                    <p>User name:</p>
                                    <p>Name ServletCompany:</p>
                                    <p>Name entity:</p>
                                </div>
                                <span class="cd-date">Jan 20</span>
                            </div> <!-- cd-timeline-content -->
                        </div> <!-- cd-timeline-block-->

                        <div class="cd-timeline-block">
                            <!-- ... -->
                        </div>
                        <c:forEach items="${deal.getNote}" var="file">
                            <div class="cd-timeline-block">
                                <div class="cd-timeline-content">
                                    <div id="file" class="action__task">
                                        <h4>File</h4>
                                        <p>Created: ${file.getFileName()}</p>
                                        <p>User name: </p>
                                        <a>${file.getFileName()}</a>
                                        <input id="formFileDel" class="actionBut" type="button" value="Delete">
                                    </div>
                                    <span class="cd-date">Jan 20</span>
                                </div> <!-- cd-timeline-content -->
                            </div>
                            <!-- cd-timeline-block -->
                        </c:forEach>
                        <div class="cd-timeline-block">
                            <!-- ... -->
                        </div>
                    </section>


                    <div class="wrapper__actionBut">
                        <input onclick="location.href='#modalTask'" class="actionBut" type="button" value="Add task">
                        <input class="actionBut" type="button" value="Add note">
                        <p><input class="checkbox" id="actionButNote" type="checkbox">Note contact</p>
                        <p><input class="checkbox" id="actionButDeal" type="checkbox">Note deal</p>
                    </div>

                    <!--Modal window task-->
                    <div id="modalTask" class="modalDialog modalTask">
                        <div>
                            <header>
                                <div class="wrapper__modal1Title">
                                    <div><i class="fa fa-tasks"></i></div>
                                    <h3>Add task</h3>
                                </div>
                            </header>

                            <p>Duration:
                                <select>
                                    <option>Choose from the list</option>
                                    <option>today</option>
                                    <option>tomorrow</option>
                                    <option>next week</option>
                                    <option>next month</option>
                                    <option>next year</option>
                                </select>
                            </p>
                            <div class="myCalendar" id="myCalendar-1"></div>

                            <div class="container">
                                <input class="clockpicker" value="Choose time" data-default="20:48" value="${task.setTime()}">
                            </div>
                            <p>Type:
                                <select>
                                    <option>Choose from the list</option>
                                    <option>Follow-up</option>
                                    <option>meet</option>
                                    <option>other</option>
                                </select>
                            </p>
                            <p>Description:<textarea class="modalTextArea" rows="5" cols="42" name="text" value="${task.setDescription()}"></textarea>
                            </p>
                            <input class="modalBut" type="button" value="Save contact">
                            <input class="modalBut cancel" onclick="location.href='#close'" type="button"
                                   value="Cancel">
                        </div>
                    </div>
                    <!--End-->
                </div>


            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="js/jquery-clockpicker.js"></script>
</body>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/moment2.1.js"></script>
<script type="text/javascript" src="js/ion.calendar.min.js"></script>
</html>
