package com.becomejavasenior.servlets;



import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.service.impl.TaskServiceImpl;
import com.becomejavasenior.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "TaskListServlet", urlPatterns = "/taskList")
public class TaskListServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        List<Task> listTasks = null;
        TaskService taskService = new TaskServiceImpl();
        try {
            listTasks = taskService.getAll();
        }catch (DaoException e){
          e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        session.setAttribute("listTasks", listTasks);
        request.getRequestDispatcher("/pages/taskList.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        TaskService taskService = new TaskServiceImpl();

        Enumeration listParameters =  request.getParameterNames();
        while(listParameters.hasMoreElements()){
            String paramName = (String)listParameters.nextElement();
                 try {
                     taskService.deleteTask(Integer.parseInt(paramName));
                 }catch (DaoException e){
                     e.printStackTrace();
                 }
        }
        request.getRequestDispatcher("/pages/taskList.jsp").forward(request, response);
    }
}
