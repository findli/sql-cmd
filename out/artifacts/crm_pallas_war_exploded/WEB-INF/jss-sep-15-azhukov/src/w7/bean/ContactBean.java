package w7.bean;

import w7.AttributeType;
import w7.dao.ContactDAO;
import w7.dao.DAO;
import w7.dao.EmailDAO;
import w7.dao.MeetDAO;
import w7.om.Contact;
import w7.om.Mail;
import w7.om.Meet;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ContactBean implements Serializable {

    // CK : ѕока что этот класс не добавл€ет ничего нового к функциональности ContactDAO
    // ≈сли так и оставить, то он не нужен, можно использовать сам dao-класс как bean
    // Ќо хорошо бы здесь бы разместить дополнительную логику, котора€ может облегчить написание jsp-страниц,
    // например, построению списка емейлов/встреч дл€ заданного контакта
    // здесь же может строитьс€ сложный фильтр по нескольким параметрам

    // AZ : ћожно метод getAsList() из dao классов перенести в этот класс, тогда в данном классе можно будет отказать от
    // getId...  и getMeetList / getEmailList. ¬ызывать getAsList() из jsp классов. Ќу не знаю на сколько это будет правильно

    private DAO<Contact> contactDAO = new ContactDAO();    // todo: remove from class scope
    private DAO<Mail> mailDAO;
    private DAO<Meet> meetDAO;
    private int size;

    public ContactBean() {
        super();
        filter("");
    }

    public void filter(String filter) {
        System.out.println("!!!!!!!" + getParameterizedTypes(contactDAO) + " !!!!!!!!!!!!");
        contactDAO.setFilter(filter);
        contactDAO.refresh();
        size = contactDAO.getAsList().size() - 1;
        contactDAO.typeClass(contactDAO.getClass());

    }

    public static Type[] getParameterizedTypes(Object object) {
        Type superclassType = object.getClass().getGenericSuperclass();
        if (!ParameterizedType.class.isAssignableFrom(superclassType.getClass())) {
            return null;
        }
        return ((ParameterizedType)superclassType).getActualTypeArguments();
    }

    public int getIdContact(int index) {
        return (int) contactDAO.getAsList().get(index).getId();
    }

    public String getName(int index) {
        return contactDAO.getAsList().get(index).getName();
    }

    public int getSize() {
        return size;
    }

    public String getPerson(int id) {
        return contactDAO.getByID(id);
    }

    public void removeItem(int id) {
        contactDAO.remove(id);
    }

    public void getEmailList(int idContact) {
        mailDAO = new EmailDAO();
        mailDAO.setFilter(String.valueOf(idContact));
        mailDAO.refresh();
        size = mailDAO.getAsList().size();
    }

    public String getEmails(int index) {
        return mailDAO.getAsList().get(index).getEmail();
    }

    public int getIdMail(int index) {
        return (int) mailDAO.getAsList().get(index).getIdMail();
    }

    public void getMeetList(int idContact) {
        meetDAO = new MeetDAO();
        meetDAO.setFilter(String.valueOf(idContact));
        meetDAO.refresh();
        size = meetDAO.getAsList().size();
    }

    public String getMeets(int i) {
        return meetDAO.getAsList().get(i).getDateMeet();
    }

    public int getIdMeet(int index) {
        return (int) meetDAO.getAsList().get(index).getIdMeet();
    }


}
