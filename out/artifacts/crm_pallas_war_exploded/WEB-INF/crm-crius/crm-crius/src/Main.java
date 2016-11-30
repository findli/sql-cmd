import dao.ContactDAO;
import om.Contact;
import om.Position;
import om.User;

import java.sql.Timestamp;

public class Main {
   static ContactDAO contacts = new ContactDAO();
   static int size = 0;


    public static void main(String[] args) {
      /* getList(2);*/
        contacts.add(new Contact("Алексей Сухой", 1, "alex_sukhoy", "0966321651", "alex_sukhoy@mail.ua", new Timestamp(2014,04,16,16,17,48,02),
                new User(3),new Position(3),  new User(3),false));
       /* System.out.println(contacts.deleteItem(5));*/

       /*getContacts();*/
    }

    public static void getList(int id) {

        contacts.setFilter(String.valueOf(id));
        contacts.refresh();
        size = contacts.getAsList().size();
    }

    public static void getContacts() {
        System.out.println(contacts.getAsList().toString());
    }

}
