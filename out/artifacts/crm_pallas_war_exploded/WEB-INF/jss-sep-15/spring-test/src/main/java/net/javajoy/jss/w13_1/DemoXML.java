package net.javajoy.jss.w13_1;

import net.javajoy.jss.w13_1.bean.dao.Connection;
import net.javajoy.jss.w13_1.bean.dao.CustomerDAO;
import net.javajoy.jss.w13_1.bean.dao.CustomerView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cyril Kadomsky
 */
public class DemoXML {

    private static ApplicationContext context
            = new ClassPathXmlApplicationContext("spring-config-1.xml");

    public static void main(String[] args) {

        Connection con1 = (Connection) context.getBean("connection1");
        Connection con2 = (Connection) context.getBean("connection1");
        System.out.println(con1==con2);

        diDaoBeans();

    }


    public static void diDaoBeans() {

        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");  // same as context.getBean(CustomerDAO.class)
        System.out.println(customerDAO);

        System.out.println();
        System.out.println(context.getBean(CustomerView.class));

    }

}
