package JSS.w07_p02.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SimpleTag extends SimpleTagSupport{
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        getJspContext().getOut().println("The simple tag.");
    }
}
