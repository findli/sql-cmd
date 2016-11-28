package JSS.w07_p02.servlet;

import JSS.w07_p02.bean.PhotoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

// value bu default is urlPattern ???
@WebServlet(name = "uploadPhoto", urlPatterns = {"/uploadPhoto"})
// fileSizeThreshold - in memory not in /tmp/file
@MultipartConfig(location = "/tmp/", maxFileSize = 16 * 1024 * 1024, fileSizeThreshold = 100 * 1024)// byte
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhotoDAO dao = PhotoDAO.getPhotoDAO(request.getSession());

        Part filePart = request.getPart("file");
        if (filePart == null) {
            return;
        }

        System.out.println(filePart.getName());
        System.out.println(filePart.getContentType());
        System.out.println(filePart.getSize());

        // get part input stream
        InputStream inputStream = filePart.getInputStream();
        int size = (int) filePart.getSize();
        byte[] buf = new byte[size];
        inputStream.read(buf, 0, size);
        dao.addPhoto(filePart.getName(), buf);
        inputStream.close();

        response.sendRedirect("/JSS-15-09/JSS/w07_p02/album.jsp");
    }
}
