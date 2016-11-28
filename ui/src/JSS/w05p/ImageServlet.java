package JSS.w05p;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// не надо писать в web.xml
//@WebServlet(name = "Image1Servlet", urlPatterns = "/test/image1")
@WebServlet(name = "image1", urlPatterns = {"/test/image1", "/test/image1/*"}, loadOnStartup = 1, initParams = {})
public class ImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    // реинтерабильность
    // если бы происходило запись в файл, то этот блок должен быть synchronize
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // поток закроется все равно когда сборщик мусора освободится НО когда слишком много запросов в ед времени - нужно закрывать.
        // wrongWay(request, response);
        rightWay(request, response);
    }

    private void wrongWay(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("image/png");
        ServletOutputStream stream = response.getOutputStream();

        ServletContext context = request.getServletContext();
        File file = new File(context.getRealPath("/resource/image/test.png"));
        // ImageIO для чтения/записи файлов с картинками
        BufferedImage bufferedImage = ImageIO.read(file);

        ImageIO.write(bufferedImage, "png", stream);
        stream.close();
    }

    // src: http://stackoverflow.com/questions/8623709/output-an-image-file-from-a-servlet
    private void rightWay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/resource/image/test.png");

        String mimeType = servletContext.getMimeType(realPath);
        if (mimeType == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        response.setContentType(mimeType);
        File file = new File(realPath);
        int fileLength = (int) file.length();
        response.setContentLength(fileLength);

        FileInputStream fileInputStream = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();

        byte[] buff;
        if (fileLength > 0) {
            buff = new byte[fileLength];
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        int count = 0;
        // buff может быть меньше файла и тогда можно читать частями
        // output.write(buff, 0, length_count);
        // count это сколько реально было прочитано байтов
        while ((count = fileInputStream.read(buff)) >= 0) {
            outputStream.write(buff, 0, count);
        }
        outputStream.close();
        fileInputStream.close();
    }

    // должен проверять что все service методы завершены, так как destroy() может быть вызван не дожидаясь завершения service() при выключении сервера
    @Override
    public void destroy() {
        super.destroy();
    }
}
