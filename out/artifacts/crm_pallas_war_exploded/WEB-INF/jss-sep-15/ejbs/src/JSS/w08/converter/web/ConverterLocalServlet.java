package JSS.w08.converter.web;

import JSS.w08.converter.ConverterBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Enumeration;

/**
 * @author Cyril Kadomsky
 */
@WebServlet(name = "ConverterLocalServlet",urlPatterns = {"/conv"})
public class ConverterLocalServlet extends HttpServlet {
    //@EJB
    //ConverterBean converter;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Context initialContext = new InitialContext();
            ConverterBean converter = (ConverterBean)
                    initialContext.lookup("java:module/ConverterEJB");

            Context context = (Context) initialContext.lookup("java:module");
            Enumeration names = context.list ("") ;
            System.out.println("Context java:module/");
            while ( names.hasMoreElements())
                System.out.println ( names.nextElement ()) ;

            String amount = request.getParameter("amount");
            if (amount==null || amount.isEmpty()) {
                amount = "20";
            }

            BigDecimal d = new BigDecimal(amount);
            BigDecimal yenAmount = converter.dollarToYen(d);
            BigDecimal euroAmount = converter.yenToEuro(yenAmount);

            response.getWriter().println("ConverterServlet : local no-interface ejb view");
            response.getWriter().format("%s dollars are %s yen or %s euro", amount, yenAmount, euroAmount);

            converter.setEuroRate(new BigDecimal(3));


        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }
}
