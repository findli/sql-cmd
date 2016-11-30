package JSS.w07_p02.servlet;

import JSS.w07_p02.bean.PhotoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Cyril Kadomsky
 */
@WebServlet(name = "PhotoServlet", urlPatterns = {"/photo"})
public class PhotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        int id = Integer.parseInt(request.getParameter("id"));

        OutputStream binaryOut = response.getOutputStream();

        PhotoDAO dao = PhotoDAO.getPhotoDAO(request.getSession());

        if (dao!=null && id<dao.getSize()) {
            byte data[] = dao.getPhotoData(id);
            binaryOut.write(data,0,data.length);
        } else {
            // send error image
        }
    }
}
