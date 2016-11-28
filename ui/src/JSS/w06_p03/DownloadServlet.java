package JSS.w06_p03;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@WebServlet(name = "download", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request, response);
    }

    private void doService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = request.getParameter("file") != null ? request.getParameter("file") : "test.png";

        String contextPath = getServletContext().getRealPath("/");
        System.out.println("Download: " + contextPath + "data/" + fileName);
        File file = new File(contextPath + "/resource/image/" + fileName);

        if (file.exists() && file.isDirectory() == false) {

            // it gets file MIME-type
            response.setContentType(Files.probeContentType(file.toPath()));
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentLength((int) file.length());

            // get resource from WAR
//            InputStream fileInputStream2 = getServletContext().getResourceAsStream("/WEB-INF/data/01.pdf");
//            response.setContentLength(fileInputStream2.available());

            FileInputStream fileInputStream = new FileInputStream(file);
            ServletOutputStream responseOutputStream = response.getOutputStream();
            byte buf[] = new byte[1024 * 8];
            int read = 0;
            do {
                read = fileInputStream.read(buf, 0, buf.length);
                responseOutputStream.write(buf, 0, read);
            } while (read > 0);
        } else {
            response.sendError(404, "No such file!");
        }
    }
}
