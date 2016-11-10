
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem on 07.11.2016.
 */
public class ServletCompany extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        List<Deal> dealList =new ArrayList();
        List<Task> taskList = new ArrayList();
        List<Contact> contactList =new ArrayList();
        User user = new User();
        Contact contact = new Contact();
        Company company = new Company();

        company.setTitle(request.getParameter("formCompany"));
        company.setTags(request.getParameter("formTag"));
        company.setPhoneNumber(request.getParameter("formPhone"));
        company.setEmail(request.getParameter("formEmail"));
        company.setWebsite(request.getParameter("formWeb"));
        company.setAdress(request.getParameter("formAddress"));







    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }
}
