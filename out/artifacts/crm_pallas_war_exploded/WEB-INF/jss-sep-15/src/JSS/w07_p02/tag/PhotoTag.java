package JSS.w07_p02.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author Cyril Kadomsky
 */
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
        out.println("<a href='/JSS-15-09/photo?id=" + id +"'>");
        out.println("<img src='/JSS-15-09/photo?id=" + id +"' alt='photo' height='" + height + "' width='" + width + "'>");
        out.println("</a>");
    }
}
