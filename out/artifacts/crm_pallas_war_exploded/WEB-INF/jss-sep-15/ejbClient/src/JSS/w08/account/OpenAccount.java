package JSS.w08.account;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Cyril Kadomsky
 */
@WebServlet(name = "OpenAccount",urlPatterns = {"/openAccount"})
public class OpenAccount extends HttpServlet {
    //@EJB(mappedName="stateful123")
    //BankRemote b;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            InitialContext context=new InitialContext();

            // ejbClient module has ejbs module in dependencies, so we can lookup in "java:module"
            AccountHome accountHome = (AccountHome)context.lookup("java:module/AccountEJB!JSS.w08.account.AccountHome");
            Account account = accountHome.create();


            request.getSession().setAttribute("remote",account);
            //request.getRequestDispatcher("/JSS/w08/account/operation.jsp").forward(request, response);
            response.sendRedirect("JSS/w08/account/operation.jsp");

        } catch(Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }
}
