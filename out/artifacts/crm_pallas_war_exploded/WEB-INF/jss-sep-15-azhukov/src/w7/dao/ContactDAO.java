package w7.dao;

import w7.AttributeType;
import w7.om.Contact;
import w7.om.Meet;

import java.sql.*;
import java.util.*;

public class ContactDAO implements DAO<Contact> {

    private LinkedHashMap<Long, Contact> data = new LinkedHashMap(100);  // todo: request data dynamicaly
    //  private Map<Long, Contact> immutableData = Collections.unmodifiableMap(data);
    private Connection conn = null;
    private String filter = "";
    private String person;
    private ResultSet rs;
    private PreparedStatement stm;

    public ContactDAO() {
        conn = w2.DBConnection.getConnection("az_organizer");
    }
  /*public final List<Contact> getMap(){
        List<Contact> immutableData;
        for (long key : data.keySet()){
            immutableData = Collections.unmodifiableList()
        }
        return Collections.unmodifiableMap(immutableData);
    }*/


    @Override
    public void refresh() {
       /* StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String stackTraceElements1 = Thread.currentThread().getStackTrace()[1].getClassName();
        String message = "";
        if(stackTraceElements.length >= 3) {
            StackTraceElement element = stackTraceElements[1];
            String className = element.getClassName();
            String methodName = element.getMethodName();
            String el= element.getFileName();
            message = className + ": " + methodName;
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!" + className);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!" + methodName);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!" + el);
        }*/
        data.clear();
        try {
            stm = conn.prepareStatement("SELECT * FROM contact WHERE nameContact LIKE ?");
            stm.setString(1, '%' + filter + '%');
            rs = stm.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact(rs.getLong("idContact"), rs.getString("nameContact"));
                data.put(contact.getId(), contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public List<Contact> getAsList() {
        // CK : �������� ����� �� �����������. ���� ����� ����� ����� ����������.
        // ���� ���� �������� ������ data.values() ������ ��� ������ - ��������� ������������� �����������, ��� �� ������� ����������� ������

  //      return Collections.unmodifiableList((List) data.values());
        List list = new ArrayList(data.size());
        data.values().forEach(o -> list.add(o));
        //    List list = new ArrayList<>(10);
        //  list = (List) getMap().values();
        return list;
    }

    @Override
    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public void remove(int id) {
        try (CallableStatement removeItem = conn.prepareCall("{call az_organizer.removeItem(?)}")) {
            removeItem.setInt(1, id);
            removeItem.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getByID(int id) {
        try {
            stm = conn.prepareStatement("SELECT * FROM contact WHERE idContact = ?");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                this.person = rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.person;
    }

    @Override
    public String update(int id, String item) {
        return null;
    }

    @Override
    public <T> void typeClass(Class<T> type) {
        System.out.println(type.getClass().getName());
    }

    @Override
    public Iterator<Contact> iterator() {
        return data.values().iterator();
        // return getMap().values().iterator();
    }


}
