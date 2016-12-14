package com.becomejavasenior.servlets;


import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.CrmCurrency;
import com.becomejavasenior.bean.CrmSettings;
import com.becomejavasenior.bean.Language;
import com.becomejavasenior.bean.TimeZone;
import com.becomejavasenior.service.CrmCurrencyService;
import com.becomejavasenior.service.CrmSettingsService;
import com.becomejavasenior.service.LanguageService;
import com.becomejavasenior.service.TimeZoneService;
import com.becomejavasenior.service.impl.CrmCurrencyServiceImpl;
import com.becomejavasenior.service.impl.CrmSettingsServiceImpl;
import com.becomejavasenior.service.impl.LanguageServiceImpl;
import com.becomejavasenior.service.impl.TimeZoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SettingsServlet", urlPatterns = "/settings")
public class SettingsServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<TimeZone> timeZoneList = null;
        List<Language> languageList = null;
        List<CrmCurrency> crmCurrencyList = null;

        TimeZoneService timeZoneService = new TimeZoneServiceImpl();
        LanguageService languageService = new LanguageServiceImpl();
        CrmCurrencyService crmCurrencyService = new CrmCurrencyServiceImpl();

        try{
            timeZoneList = timeZoneService.getAll();
            languageList = languageService.getAll();
            crmCurrencyList = crmCurrencyService.getAll();
        }catch (DaoException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        session.setAttribute("TimeZoneList", timeZoneList);
        session.setAttribute("LanguageList", languageList);
        session.setAttribute("CurrencyList", crmCurrencyList);
        request.getRequestDispatcher("/pages/settings.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        CrmSettings crmSettings = new CrmSettings();
        TimeZone timeZone = new TimeZone();
        Language language = new Language();
        CrmCurrency crmCurrency = new CrmCurrency();
        CrmSettingsService crmSettingsService = new CrmSettingsServiceImpl();
        TimeZoneService timeZoneService = new TimeZoneServiceImpl();
        LanguageService languageService = new LanguageServiceImpl();
        CrmCurrencyService crmCurrencyService = new CrmCurrencyServiceImpl();

        try {
            timeZone = timeZoneService.getById(parseString(request.getParameter("TimeZone")));
            language = languageService.getById(parseString(request.getParameter("Language")));
            crmCurrency = crmCurrencyService.getById(parseString(request.getParameter("Currency")));
        }catch (DaoException e){
            e.printStackTrace();
        }
        crmSettings.setTimeZone(timeZone);
        crmSettings.setLanguage(language);
        crmSettings.setCrmCurrency(crmCurrency);

        try {
            crmSettingsService.create(crmSettings);
        }catch (DaoException e){
            e.printStackTrace();
        }

        response.sendRedirect("/settings");
    }

    private int parseString(String text){
        int id = Integer.parseInt(text);
        return id;
    }
}
