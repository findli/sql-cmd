package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.ContactService;
import com.becomejavasenior.service.DealService;
import com.becomejavasenior.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardServlet {

    @Autowired
    DealService dealService;

    @Autowired
    TaskService taskService;

    @Autowired
    ContactService contactService;

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dashboardStart(ModelMap model){
        List dealsForDashboard = new ArrayList<>();
        List tasksForDashboard = new ArrayList<>();
        int allContacts = 0;
        int allCompany = 0;
        int dealsWithTask = 0;
        int dealsWithNotTask = 0;
        try {
            dealsForDashboard = dealService.getDealsForDashboard();
            tasksForDashboard = taskService.getTaskForDashboard();
            allContacts = contactService.getAll().size();
            allCompany = companyService.getAll().size();
            dealsWithTask = dealService.getListDealWithTask().size();
            dealsWithNotTask = dealService.getListDealWithNotTask().size();

        }catch (DaoException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        model.addAttribute("allDeals", dealsForDashboard.get(3));
        model.addAttribute("allBudget", dealsForDashboard.get(0));
        model.addAttribute("dealsDone", dealsForDashboard.get(1));
        model.addAttribute("dealsClose", dealsForDashboard.get(2));
        model.addAttribute("tasksInProgress", tasksForDashboard.get(0));
        model.addAttribute("tasksDone", tasksForDashboard.get(1));
        model.addAttribute("tasksOverdue", tasksForDashboard.get(2));
        model.addAttribute("allContacts", allContacts);
        model.addAttribute("allCompany", allCompany);
        model.addAttribute("dealWithTask", dealsWithTask);
        model.addAttribute("dealsWithNotTask", dealsWithNotTask);
        return "WEB-INF/index";
    }

}
