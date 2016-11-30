package w7.dao;

import w7.om.Contact;

import java.util.List;

public interface DAO<T> extends Iterable<T> {

    void refresh();

    List<T> getAsList();

    void setFilter(String filter);  // todo: unify it's usage

    void remove(int id); // CK : renamed, it applies not only to contact

    String getByID(int id);

    String update(int id, String item);

    <T> void typeClass(Class<T> type);


}
