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
     <%-- <c:forEach var="i" begin="0" end="10">
      </c:forEach>--%>


      <div class="wrapper__aboutCompany">
        <div class="forms">
          <div class="forms--nCompany">
            <p>Name Company <input class="text" id='formCompany' type="text" name="formCompany"
                                   placeholder="Name Company"><c:out value="${param.formCompany}"/></p>
            <p>Tags <input class="text" id='formTag' type="text" name="formTag" placeholder="Tag"><c:out value="${param.formTags}" /></p>
            <a href="">Responsible</a><br>
            <select>
            <option>Work telephone</option>
              <option>Mobile telephone</option>
              <option>Home telephone</option>
            </select>
            <input class="text" id='formPhone' type="text" name="formPhone" placeholder="Number"><c:out value="${param.formPhone}" />
            <p>Email <input class="text" id='formEmail' type="text" name="formEmail" placeholder="Email"> <c:out value="${param.formEmail}" /></p>
            <p>Web <input class="text" id='formWeb' type="text" name="formWeb" placeholder="Url"><c:out value="${param.formWeb}" /></p>
            <p>Address <input class="text" id='formAddress' type="text" name="formAddress"
                              placeholder="Address"><c:out value="${param.formAdress}" /></p>
          </div>

          <div class="forms--users">
            <%--<jsp:useBean id="idUser"  scope="session"/> --%>                                <%--Add class--%>
            <div class="wrapper__users">
              <div id="fu1" class="users__panel">
                <p><c:out value="${idUser.name}"/></p>                                   <%--Correct--%>
                <a href="#">Edit</a>
                <a href="#">Undock</a>
                <input class="users__panel--input" id='cbfu1' type="checkbox">
              </div>
              <div class="users__panel--body">
                <p>Position</p>
                <p>Email</p>
                <select>
                  <option>Work telephone</option>
                  <option>Mobile telephone</option>
                  <option>Home telephone</option>
                </select>
                <input class="text" id='formPhonefu1' type="text" name="formPhone" placeholder="Number">
                <p>Skype</p>
              </div>

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
                  <h3>Add contact ServletCompany</h3>
                </div>
              </header>

              <p style="display: inline">Name <input style="float: none; width: 148px" type="text"
                                                     class="modalInput"
                                                     id="modalContactName"></p>
              <p style="display: inline;">Surname <input style="float: none; width: 147px" type="text"
                                                         class="modalInput"
                                                         id="modalContactSurname"></p>
              <p>Position <input type="text" class="modalInput" id="modalContactPosition"></p>
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
              <p>Email <input type="text" class="modalInput" id="modalContactEmail"></p>
              <p>Skype <input type="text" class="modalInput" id="modalContactSkype"></p>
              <input class="modalBut" type="button" value="Save contact">
              <input class="modalBut cancel" onclick="location.href='#close'" type="button"
                     value="Cancel">
            </div>
          </div>
          <!--End-->
          <div class="form--deals">
            <div class="wrapper__deals">
              <div class="deal__panel">
                <p>Total deals: </p>
                <p>Amount: </p>
              </div>
              <div class="deal__panel--body">
                <p>Name deal</p>
                <p>Stage deal</p>
                <p>100 USD</p>
                <input class="formDealEditDeal" type="button" value="Edit deal">
              </div>

              <!--Для примера -->
              <div class="deal__panel--body">
                <p>Name deal</p>
                <p>Stage deal</p>
                <p>100 USD</p>
                <input class="formDealEditDeal" type="button" value="Edit deal">
              </div>
              <div class="deal__panel--body">
                <p>Name deal</p>
                <p>Stage deal</p>
                <p>100 USD</p>
                <input class="formDealEditDeal" type="button" value="Edit deal">
              </div>
              <div class="deal__panel--body">
                <p>Name deal</p>
                <p>Stage deal</p>
                <p>100 USD</p>
                <input class="formDealEditDeal" type="button" value="Edit deal">
              </div>
              <div class="deal__panel--body">
                <p>Name deal</p>
                <p>Stage deal</p>
                <p>100 USD</p>
                <input class="formDealEditDeal" type="button" value="Edit deal">
              </div>
              <div class="deal__panel--body">
                <p>Name deal</p>
                <p>Stage deal</p>
                <p>100 USD</p>
                <input class="formDealEditDeal" type="button" value="Edit deal">
              </div>
              <div class="deal__panel--body">
                <p>Name deal</p>
                <p>Stage deal</p>
                <p>100 USD</p>
                <input class="formDealEditDeal" type="button" value="Edit deal">
              </div>
              <div class="deal__panel--body">
                <p>Name deal</p>
                <p>Stage deal</p>
                <p>100 USD</p>
                <input class="formDealEditDeal" type="button" value="Edit deal">
              </div>
              <div class="deal__panel--body">
                <p>Name deal</p>
                <p>Stage deal</p>
                <p>100 USD</p>
                <input class="formDealEditDeal" type="button" value="Edit deal">
              </div>
              <div class="deal__panel--body">
                <p>Name deal</p>
                <p>Stage deal</p>
                <p>100 USD</p>
                <input class="formDealEditDeal" type="button" value="Edit deal">
              </div>
            </div>

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
                  <tr>
                    <td>deal</td>
                    <td>6500</td>
                    <td>USD</td>
                  </tr>
                  <tr>
                    <td>deal</td>
                    <td>6500</td>
                    <td>USD</td>
                  </tr>
                  <tr>
                    <td>deal</td>
                    <td>6500</td>
                    <td>USD</td>
                  </tr>
                </table>
                <span><input class="checkboxDeal" type="checkbox">Add more deals</span>
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
                <p>Budget: <input type="text" class="modalInput" id="modalDealBudget" disabled></p>
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

              <div class="cd-timeline-block">
                <div class="cd-timeline-content">
                  <div id="task" class="action__task action--task">
                    <h4>Task</h4>
                    <p>Time of completion:</p>
                    <p>Responsible</p>
                    <p>Type of task</p>
                    <!--<input id="formTaskText" class="formActionText" type="text">-->
                    <textarea rows="3" cols="21" id="formTaskText" class="formActionText" name="text"></textarea>
                    <input id="formTaskDel" class="actionBut" type="button" value="Delete">
                    <input id="formTaskEdit" class="actionBut" type="button" value="Edit">
                    <input id="formTaskDone" class="actionBut" type="button" value="Done">
                  </div>
                  <span class="cd-date">Jan 14</span>
                </div> <!-- cd-timeline-content -->
              </div> <!-- cd-timeline-block -->

              <div class="cd-timeline-block">
                <!-- ... -->
              </div>


              <div class="cd-timeline-block">
                <div class="cd-timeline-content">
                  <div id="note" class="action__task action--note">
                    <h4>Note</h4>
                    <p>Created:</p>
                    <p>User name:</p>
                    <!--      <input id="formNoteText" class="formActionText" type="text">-->
                    <textarea rows="3" cols="21" id="formNoteText" class="formActionText" name="text"></textarea>
                    <input id="formNoteDel" class="actionBut" type="button" value="Delete">
                    <input id="formNoteEdit" class="actionBut" type="button" value="Edit">
                  </div>
                  <span class="cd-date">Jan 20</span>
                </div> <!-- cd-timeline-content -->
              </div> <!-- cd-timeline-block -->

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

              <div class="cd-timeline-block">
                <div class="cd-timeline-content">
                  <div id="file" class="action__task">
                    <h4>File</h4>
                    <p>Created;</p>
                    <p>User name:</p>
                    <input id="formFileDel" class="actionBut" type="button" value="Delete">
                  </div>
                  <span class="cd-date">Jan 20</span>
                </div> <!-- cd-timeline-content -->
              </div> <!-- cd-timeline-block -->

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
                  <input class="clockpicker" value="Choose time" data-default="20:48">
                </div>
                <p>Type:
                  <select>
                    <option>Choose from the list</option>
                    <option>Follow-up</option>
                    <option>meet</option>
                    <option>other</option>
                  </select>
                </p>
                <p>Description:<textarea class="modalTextArea" rows="5" cols="42" name="text"></textarea></p>
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
