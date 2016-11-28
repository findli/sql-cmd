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
 * stored in session scope
 * <p>
 * если не передается как аттрибут тега, то сериализация не будет вызываться
 */
public class PhotoDAO {

    public static final String ATTRIBUTE_NAME = "PhotoDAO";

    private List<String> photoNames = new ArrayList<>(10);
    private List<byte[]> photoData = new ArrayList<>(10);

    public PhotoDAO() {
        try {
            String path = "/Users/miiix/Yandex.Disk.localized/Programming/Java/JavaCore/JuJaSqlCmd/ui/web/";
            BufferedImage image = ImageIO.read(new File(path + "resource/image/test.png"));
            addPhoto("first", image);
            addPhoto("first", ImageIO.read(new File(path + "resource/image/test2.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PhotoDAO getPhotoDAO(HttpSession session) {
        PhotoDAO dao = (PhotoDAO) session.getAttribute(ATTRIBUTE_NAME);
        if (dao == null) {
            dao = new PhotoDAO();
            dao.addToSession(session);
        }
        return dao;
    }

    private ByteArrayOutputStream addPhoto(String name, BufferedImage image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", byteArrayOutputStream);
            addPhoto("first", byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }

    public void addPhoto(String name, byte[] data) {
        photoNames.add(name);
        photoData.add(data);
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

    // removePhoto();

    public int getSize() {
        return photoData.size();
    }

    public void addToSession(HttpSession session) {
        session.setAttribute(ATTRIBUTE_NAME, this);
    }
}
