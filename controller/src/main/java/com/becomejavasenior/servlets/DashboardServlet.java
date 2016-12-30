package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Deal;
import com.becomejavasenior.service.DealService;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dashboardStart(ModelMap model){
        List<Deal> dealList = new ArrayList<>();
        try {
            dealList = dealService.getAll();
        }catch (DaoException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        model.addAttribute("allDeals", dealList.size());
        return "WEB-INF/index";
    }

}
