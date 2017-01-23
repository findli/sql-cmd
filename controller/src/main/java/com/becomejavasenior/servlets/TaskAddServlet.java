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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


@Controller
public class TaskAddServlet {

    @Autowired
    UserService userService;

    @Autowired
    TaskTypeService taskTypeService;

    @Autowired
    PeriodInDaysTypeService periodService;

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/taskAdd", method = RequestMethod.GET)
    public String doGet(ModelMap model) {

        List<User> listUsers = null;
        List<TaskType> listTaskTypes = null;
        List<PeriodInDaysType> listPeriods = null;

        try {
            listUsers = userService.getAll();
            listTaskTypes = taskTypeService.getAll();
            listPeriods = periodService.getAll();
        }catch (DaoException e){
          e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        model.addAttribute("ResponsibleUserList", listUsers);
        model.addAttribute("TaskTypeList", listTaskTypes);
        model.addAttribute("PeriodInDaysTypeList", listPeriods);
        return "pages/taskAdd";
    }

    @RequestMapping(value = "/taskAdd", method = RequestMethod.POST)
    public String doPost(HttpServletRequest request) {

        Task task = new Task();
        TaskType taskType = new TaskType();
        User user = new User();
        PeriodInDaysType periodInDaysType = new PeriodInDaysType();

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy HH:mm");
        Date date = null;

        try {
             user = userService.getById(parseString(request.getParameter("ResponsibleUsers")));
             taskType = taskTypeService.getById(parseString(request.getParameter("TaskType")));
             date = format.parse(request.getParameter("DeadlineDate"));
            periodInDaysType = periodService.getById(parseString(request.getParameter("PeriodInDaysType")));
        }catch ( ParseException e){
          e.printStackTrace();
        }catch (DaoException e){
          e.printStackTrace();
        }
        task.setTitle(request.getParameter("Title"));
        task.setTaskType(taskType);
        task.setDescription(request.getParameter("Description"));
        task.setDeadlineDate(date);
        task.setDeadlineTime(new Time(date.getTime()));
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
        return "redirect:/taskList";
    }

    private int parseString(String text){
        int id = Integer.parseInt(text);
        return id;
    }
}
