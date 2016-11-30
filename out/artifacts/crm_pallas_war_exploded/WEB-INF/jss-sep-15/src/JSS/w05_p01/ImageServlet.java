package JSS.w05_p01;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;


@WebServlet(name="ImageServlet", urlPatterns = {"/image","/img/*"}, loadOnStartup = 1 )
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();

        File f = new File("d:\\IdeaProjects\\tomcat.png");
        BufferedImage bi = ImageIO.read(f);
        ImageIO.write(bi,"png",os);
        os.close();
    }
}
