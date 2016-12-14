package com.becomejavasenior.servlets;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.PeriodInDaysType;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.bean.TaskType;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.impl.PeriodInDaysTypeServiceImpl;
import com.becomejavasenior.service.impl.TaskServiceImpl;
import com.becomejavasenior.service.impl.TaskTypeServiceImpl;
import com.becomejavasenior.service.impl.UserServiceImpl;
import com.becomejavasenior.service.PeriodInDaysTypeService;
import com.becomejavasenior.service.TaskService;
import com.becomejavasenior.service.TaskTypeService;
import com.becomejavasenior.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TaskEditServlet", urlPatterns = "/taskEdit")
@Controller("taskEditServlet")
public class TaskEditServlet extends HttpServlet {

    @Autowired
    @Qualifier("taskTypeService")
    TaskTypeService taskTypeService;

    @Autowired
    @Qualifier("periodInDaysTypeService")
    PeriodInDaysTypeService periodService;

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Autowired
    @Qualifier("taskService")
    TaskService taskService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<User> listUsers = null;
        List<TaskType> listTaskTypes = null;
        List<PeriodInDaysType> listPeriods = null;
        Task task = null;
        int taskId = Integer.parseInt(request.getParameter("idTask"));
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("dd.MM.yyyy HH:mm");
        Date date;

        try {
            listUsers = userService.getAll();
            listTaskTypes = taskTypeService.getAll();
            listPeriods = periodService.getAll();
            task = taskService.getById(taskId);
        }catch (DaoException e){
           e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        date = task.getDeadlineDate();
        String deadlineDate = dateFormat.format(date);
        PeriodInDaysType periodInDaysTypeDef = task.getPeriodInDaysType();
        User userDef = task.getResponsibleUser();
        TaskType taskTypeDef = task.getTaskType();
        String description = task.getDescription();
        session.setAttribute("idTask", taskId);
        session.setAttribute("description", description);
        session.setAttribute("taskTypeDef", taskTypeDef);
        session.setAttribute("userDef", userDef);
        session.setAttribute("periodInDaysTypeDef", periodInDaysTypeDef);
        session.setAttribute("deadlineDate", deadlineDate);
        session.setAttribute("task", task);
        session.setAttribute("responsibleUserList", listUsers);
        session.setAttribute("taskTypeList", listTaskTypes);
        session.setAttribute("periodInDaysTypeList", listPeriods);
        request.getRequestDispatcher("/pages/taskEdit.jsp").forward(request, response);
    }

    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Task task = new Task();
        TaskType taskType = new TaskType();
        User user = new User();
        PeriodInDaysType periodInDaysType = new PeriodInDaysType();

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy HH:mm");
        Date date = null;
        int taskId = Integer.parseInt(request.getParameter("idTask"));

        try {
            user = userService.getById(parseString(request.getParameter("responsibleUsers")));
            taskType = taskTypeService.getById(parseString(request.getParameter("taskType")));
            date = format.parse(request.getParameter("deadlineDate"));
            periodInDaysType = periodService.getById(parseString(request.getParameter("periodInDaysType")));
        }catch ( ParseException e){
            e.printStackTrace();
        }catch (DaoException e){
            e.printStackTrace();
        }
        task.setId(Integer.parseInt(request.getParameter("idTask")));
        task.setId(taskId);
        task.setTitle(request.getParameter("task"));
        task.setTaskType(taskType);
        task.setDescription(request.getParameter("description"));
        task.setDeadlineDate(date);
        task.setDeadlineTime(new Time(date.getTime()));
        task.setPeriodInDaysType(periodInDaysType);
        task.setPeriodInMinutes((int) date.getTime());
        task.setResponsibleUser(user);
        task.setFinished(false);
        task.setDeleted(false);

        try {
            taskService.update(task);
        }catch (DaoException e){
          e.printStackTrace();
        }
        //request.getRequestDispatcher("/pages/taskList.jsp").forward(request, response);
        response.sendRedirect("/taskList");
    }

    private int parseString(String text){
        int id = Integer.parseInt(text);
        return id;
    }


}
