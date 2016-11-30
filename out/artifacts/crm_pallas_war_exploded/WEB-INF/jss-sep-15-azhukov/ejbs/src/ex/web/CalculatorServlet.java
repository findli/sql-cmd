package ex.web;

import ex.CalculatorBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calc"})
public class CalculatorServlet extends HttpServlet {

    @EJB
    CalculatorBean calculatorBean;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.getWriter().println("CalculatorServlet");
        if (request.getParameter("a") != null && request.getParameter("b") != null){
            Double a = Double.valueOf(request.getParameter("a"));
            Double b = Double.valueOf(request.getParameter("b"));
            Double res = calculatorBean.calculate(a, b);

            response.getWriter().format("%f + %f = %f", a, b, res);
        }
    }
}
