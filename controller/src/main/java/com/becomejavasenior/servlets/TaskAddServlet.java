package com.becomejavasenior.servlets;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.PeriodInDaysType;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.bean.TaskType;
import com.becomejavasenior.bean.User;

import com.becomejavasenior.service.PeriodInDaysTypeService;
import com.becomejavasenior.service.TaskService;
import com.becomejavasenior.service.TaskTypeService;
import com.becomejavasenior.service.UserService;
import com.becomejavasenior.service.impl.PeriodInDaysTypeServiceImpl;
import com.becomejavasenior.service.impl.TaskServiceImpl;
import com.becomejavasenior.service.impl.TaskTypeServiceImpl;
import com.becomejavasenior.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TaskAddServlet", urlPatterns = "/taskAdd")
public class TaskAddServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        List<User> listUsers = null;
        List<TaskType> listTaskTypes = null;
        List<PeriodInDaysType> listPeriods = null;

        UserService userService = new UserServiceImpl();
        TaskTypeService taskTypeService = new TaskTypeServiceImpl();
        PeriodInDaysTypeService periodService = new PeriodInDaysTypeServiceImpl();
        try {
            listUsers = userService.getAll();
            listTaskTypes = taskTypeService.getAll();
            listPeriods = periodService.getAll();
        }catch (DaoException e){
          e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        session.setAttribute("ResponsibleUserList", listUsers);
        session.setAttribute("TaskTypeList", listTaskTypes);
        session.setAttribute("PeriodInDaysTypeList", listPeriods);
        request.getRequestDispatcher("/pages/taskAdd.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Task task = new Task();
        TaskType taskType = new TaskType();
        User user = new User();
        PeriodInDaysType periodInDaysType = new PeriodInDaysType();

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy HH:mm");
        Date date = null;

        TaskTypeService taskTypeService = new TaskTypeServiceImpl();
        PeriodInDaysTypeService periodInDaysService = new PeriodInDaysTypeServiceImpl();
        UserService userService = new UserServiceImpl();
        TaskService taskService = new TaskServiceImpl();

        try {
             user = userService.getById(parseString(request.getParameter("ResponsibleUsers")));
             taskType = taskTypeService.getById(parseString(request.getParameter("TaskType")));
             date = format.parse(request.getParameter("DeadlineDate"));
            periodInDaysType = periodInDaysService.getById(parseString(request.getParameter("PeriodInDaysType")));
        }catch ( ParseException e){
          e.printStackTrace();
        }catch (DaoException e){
          e.printStackTrace();
        }
        task.setTitle(request.getParameter("Title"));
        task.setTaskType(taskType);
        task.setDescription(request.getParameter("Description"));
        task.setDeadlineDate(date);
        task.setPeriodInDaysType(periodInDaysType);
        task.setPeriodInMinutes((int) date.getTime());
        task.setResponsibleUser(user);
        task.setFinished(false);
        task.setDeleted(false);

        try {
            taskService.addTask(task);
        }catch (DaoException e){
          e.printStackTrace();
        }
        request.getRequestDispatcher("/pages/taskList.jsp").forward(request, response);
    }

    private int parseString(String text){
        int id = Integer.parseInt(text);
        return id;
    }
}
