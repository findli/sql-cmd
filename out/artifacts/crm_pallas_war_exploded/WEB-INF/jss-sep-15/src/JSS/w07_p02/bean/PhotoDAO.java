package JSS.w07_p02.bean;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cyril Kadomsky
 * stored in session scope
 */
public class PhotoDAO {

    public static final String ATTRIBUTE_NAME = "PhotoDAO";

    private List<String>  photoNames = new ArrayList<>(10);
    private List<byte[]>  photoData = new ArrayList<>(10);

    public PhotoDAO() {
        try {
            BufferedImage img  = ImageIO.read(new File("d:\\Downloads\\1.jpg"));
            addPhoto("first", img);
            addPhoto("second", ImageIO.read(new File("d:\\Downloads\\2.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addPhoto(String name, byte[] data) {
        photoNames.add(name);
        photoData.add(data);
    }

    public void addPhoto(String name, BufferedImage img) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(img,"jpg", bos);
            addPhoto("first", bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> getNamesAsList() {
        return photoNames;
    }

    public byte[] getPhotoData(int index) {
        return photoData.get(index);
    }

    public String getPhotoName(int index) {
        return photoNames.get(index);
    }

    public int getSize() {
        return photoData.size();
    }

    // removePhoto();

    // Add DAO object to session
    public void addToSession(HttpSession session) {
        session.setAttribute(ATTRIBUTE_NAME, this);
    }

    public static PhotoDAO getPhotoDAO(HttpSession session) {
        PhotoDAO dao = (PhotoDAO) session.getAttribute(ATTRIBUTE_NAME);
        if (dao==null) {
            dao = new PhotoDAO();
            dao.addToSession(session);
        }

        return dao;
    }

}
