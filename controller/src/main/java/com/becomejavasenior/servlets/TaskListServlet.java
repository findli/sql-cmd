package com.becomejavasenior.servlets;



import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.service.impl.TaskServiceImpl;
import com.becomejavasenior.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;


@Controller
public class TaskListServlet {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/taskList", method = RequestMethod.GET)
    protected String doGet(ModelMap model) {
        List<Task> listTasks = null;
        try {
            listTasks = taskService.getAll();
        }catch (DaoException e){
          e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        model.addAttribute("listTasks", listTasks);
        return "pages/taskList";

    }

    @RequestMapping(value = "/taskList", method = RequestMethod.POST)
    protected String doPost( HttpServletRequest request) {

        Enumeration listParameters =  request.getParameterNames();
        while(listParameters.hasMoreElements()){
            String paramName = (String)listParameters.nextElement();
                 try {
                     taskService.delete(Integer.parseInt(paramName));
                 }catch (DaoException e){
                     e.printStackTrace();
                 }
        }
        return "redirect:/taskList";
    }
}
