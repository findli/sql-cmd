package JSS.w07_p02.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PhotoTag extends SimpleTagSupport {
    private int width = 100;
    private int height = 100;
    private int id = 0;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String photoPage = "/JSS-15-09/JSS/w07_p02/album-image";
        out.println("<a href='" + photoPage + "?id=" + id + "'>");
//        String photoPage = "photo.jsp";
        out.println("<img src='" + photoPage + "?id=" + id + "' alt='photo stub' height='" + height + "' width='" + width + "' />");
        out.println("</a>");
    }
}
