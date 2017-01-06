package com.becomejavasenior.servlets;



import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.PeriodInDaysType;
import com.becomejavasenior.bean.Task;
import com.becomejavasenior.bean.TaskType;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.PeriodInDaysTypeService;
import com.becomejavasenior.service.TaskTypeService;
import com.becomejavasenior.service.UserService;
import com.becomejavasenior.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;


@Controller
public class TaskListServlet {

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @Autowired
    TaskTypeService taskTypeService;

    @Autowired
    PeriodInDaysTypeService periodService;

    @RequestMapping(value = "/taskList", method = RequestMethod.GET)
    protected String doGet(ModelMap model) {
        List<Task> listTasks = null;
        List<User> listUsers = null;
        List<TaskType> listTaskTypes = null;
        List<PeriodInDaysType> listPeriods = null;
        try {
            listTasks = taskService.getAll();
            listUsers = userService.getAll();
            listTaskTypes = taskTypeService.getAll();
            listPeriods = periodService.getAll();
        }catch (DaoException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        model.addAttribute("listTasks", listTasks);
        model.addAttribute("ResponsibleUserList", listUsers);
        model.addAttribute("TaskTypeList", listTaskTypes);
        model.addAttribute("PeriodInDaysTypeList", listPeriods);
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

    @RequestMapping(value = "/taskListFilter", params = "Clean", method = RequestMethod.POST)
    public String taskFilterClean(){
        return "redirect:/taskList";
    }

    @RequestMapping(value = "/taskListFilter", params = "Apply", method = RequestMethod.POST)
    public String taskFilterApply(HttpServletRequest request, ModelMap model){
        List<Task> listTasks = null;
        List<User> listUsers = null;
        List<TaskType> listTaskTypes = null;
        List<PeriodInDaysType> listPeriods = null;
        TaskType taskType = new TaskType();
        User user = new User();
        PeriodInDaysType period = new PeriodInDaysType();

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date fromDate = null;
        Date toDate = null;
        int period_id = 0;
        int task_type_id = 0;
        int user_id = 0;
        String dateFrom = request.getParameter("FromDate");
        String dateTo = request.getParameter("ToDate");
        try {
            if(!dateFrom.equals("")) {
                fromDate = format.parse(dateFrom);
            }
            if(!dateTo.equals("")) {
                toDate = format.parse(dateTo);
            }
            if(!request.getParameter("PeriodInDaysType").equals("")) {
                period_id = parseString(request.getParameter("PeriodInDaysType"));
            }
            if(!request.getParameter("TaskType").equals("")) {
                task_type_id = parseString(request.getParameter("TaskType"));
            }
            if(!request.getParameter("ResponsibleUsers").equals("")) {
                user_id = parseString(request.getParameter("ResponsibleUsers"));
            }
            listUsers = userService.getAll();
            listTaskTypes = taskTypeService.getAll();
            listPeriods = periodService.getAll();
            if(task_type_id != 0){
                taskType = taskTypeService.getById(task_type_id);
            }
            if(user_id != 0){
                user = userService.getById(user_id);
            }
            if(period_id != 0){
                period = periodService.getById(period_id);
            }
            if(request.getParameter("optionsRadios").equals("0")) {
                listTasks = taskService.getAllTasksForFilter(fromDate, toDate, period_id, task_type_id, user_id);
            }
            if(request.getParameter("optionsRadios").equals("1")) {
                listTasks = taskService.getOverdueTasksForFilter(fromDate, toDate, period_id, task_type_id, user_id);
            }
            if(request.getParameter("optionsRadios").equals("3")) {
                listTasks = taskService.getDeletedTasksForFilter(fromDate, toDate, period_id, task_type_id, user_id);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (DaoException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        model.addAttribute("listTasks", listTasks);
        model.addAttribute("ResponsibleUserList", listUsers);
        model.addAttribute("TaskTypeList", listTaskTypes);
        model.addAttribute("PeriodInDaysTypeList", listPeriods);
        model.addAttribute("taskTypeDef", taskType);
        model.addAttribute("userDef", user);
        model.addAttribute("periodInDaysTypeDef", period);
        model.addAttribute("FromDate", dateFrom);
        model.addAttribute("ToDate", dateTo);
        return "pages/taskList";
    }

    private int parseString(String text){
        int id = Integer.parseInt(text);
        return id;
    }
}