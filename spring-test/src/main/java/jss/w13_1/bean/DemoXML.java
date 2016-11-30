package jss.w13_1.bean;

import jss.w13_1.bean.dao.Connection;
import jss.w13_1.bean.dao.CustomerDAO;
import jss.w13_1.bean.dao.CustomerView;
import jss.w13_1.bean.dao.Ordering;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoXML {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    public static void main(String[] args) {
//        System.out.println(context.getBean("connection1"));
//        System.out.println(context.getBean("connection1"));

//        context.getBean(Connection.class);
//        System.out.println(context.getBean("connection1"));
//        System.out.println(context.getBean("connection1"));

        Connection connection1 = (Connection) context.getBean("connection1");
        Connection connection2 = (Connection) context.getBean("connection1");
        System.out.println(connection1 == connection2);

        diDaoBeans();
    }

    private static void diDaoBeans() {
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");// same as context.getBean(CustomerDAO.class)
        System.out.println(customerDAO);

        System.out.println();
        System.out.println(context.getBean(CustomerView.class));
    }
}
