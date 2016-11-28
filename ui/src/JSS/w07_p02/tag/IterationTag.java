package JSS.w07_p02.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class IterationTag extends SimpleTagSupport {

    private String data[] = new String[]{"First", "Second", "Third", "Fourth", "Fifth"};
    private int begin = 0;
    private int end = 0;
    private String var = "items";

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println(getJspContext().getAttribute("var", PageContext.SESSION_SCOPE));
        System.out.println(getJspContext().getAttribute("var", PageContext.PAGE_SCOPE));
        for (int i = 0; i < data.length; i++) {
            getJspContext().setAttribute(var, data[i], PageContext.PAGE_SCOPE);
            // для каждого элемента выполнить внутренность тега - <tr><td>${item1}</td></tr>
            getJspBody().invoke(null);
        }
    }
}
