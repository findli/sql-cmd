package tag;

import dao.EntryDAO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class EntryTag extends SimpleTagSupport {

    private int idProfile;
    private EntryDAO bean;
    private String var;
    private String dateActivity;
    private Integer idParent;

    public void setIdParent(long idParent) {
        this.idParent = (int)idParent;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public void setBean(EntryDAO bean) {
        this.bean = bean;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setDateActivity(String dateActivity) {
        this.dateActivity = dateActivity;
    }


    // todo: тег для итерации по элементам ( с фильтрами: родительская запись, прользователь, ...)
    @Override
    public void doTag() throws JspException, IOException {
        if (idParent!=null) {
            // ...
        }

        int idParentActivity;
        bean.getPosts(idProfile);   // List list = getPosts(...);
        for (int i = 0; i < bean.getListParent().size(); i++) {
            getJspContext().setAttribute(var, bean.getListParent().get(i));    // list.get(i)
            getJspBody().invoke(null);
        }

    }


}
