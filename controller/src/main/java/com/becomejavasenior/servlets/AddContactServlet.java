package com.becomejavasenior.servlets;

import com.becomejavasenior.DAO.DAOException;
import com.becomejavasenior.bean.Company;
import com.becomejavasenior.service.CompanyService;
import com.becomejavasenior.service.impl.CompanyServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addContactServlet", urlPatterns = "/addContact")
public class AddContactServlet extends HttpServlet {

}
