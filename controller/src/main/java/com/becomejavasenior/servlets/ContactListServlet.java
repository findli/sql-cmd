
package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DaoException;
import com.becomejavasenior.bean.Contact;
import com.becomejavasenior.bean.User;
import com.becomejavasenior.service.ContactService;
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
import java.util.List;

@WebServlet(name = "contactListServlet", urlPatterns = "/contact")
@Controller("contactListServlet")
public class ContactListServlet extends HttpServlet {

    @Autowired
    @Qualifier("contactService")
    ContactService contactService;

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Contact> contactList = null;
        List<User> users = null;

        try {
            contactList = contactService.getAll();
            users = userService.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("users", users);
        session.setAttribute("contactList", contactList);

        response.sendRedirect("/pages/contact.jsp");

    }

}
