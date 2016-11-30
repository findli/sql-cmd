package w7.tag;

import w7.bean.ContactBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class DetailTag extends SimpleTagSupport {

    private int idPerson;
    // CK : В тег лучше все параметры передавать. Тег обычно часто вызывается, и создавать в нем каждый раз dao-объект накладно
    // * передаваться будет бин-объект, не сам ContactDAO
    //  private ContactDAO contactDAO = new ContactDAO();
    //  private BeanEmail beanEmail = new BeanEmail();
    private String varEmail;
    private String varMeet;
    private ContactBean contactBean = new ContactBean();   // todo : use the bean from jsp-page
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public void setVarEmail(String varEmail) {
        this.varEmail = varEmail;
    }

    public void setVarMeet(String varMeet) {
        this.varMeet = varMeet;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (varEmail != null) {
            contactBean.getEmailList(idPerson);
            for (int i = 0; i < contactBean.getSize(); i++) {
                getJspContext().setAttribute(id, contactBean.getIdMail(i));
                getJspContext().setAttribute(varEmail, contactBean.getEmails(i));
                getJspBody().invoke(null);
            }
        } if (varMeet != null){
            contactBean.getMeetList(idPerson);
            for (int i = 0; i < contactBean.getSize(); i++) {
                getJspContext().setAttribute(id, contactBean.getIdMeet(i));
                getJspContext().setAttribute(varMeet, contactBean.getMeets(i));
                getJspBody().invoke(null);
            }
        }
    }
}
