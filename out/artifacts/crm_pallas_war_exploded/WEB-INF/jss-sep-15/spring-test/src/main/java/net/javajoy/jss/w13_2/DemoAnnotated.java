package net.javajoy.jss.w13_2;

import net.javajoy.jss.w13_2.annotated.Application;
import net.javajoy.jss.w13_2.annotated.DIConfig;
import net.javajoy.jss.w13_2.aop.Customer;
import net.javajoy.jss.w13_2.aop.CustomerDAO;
import net.javajoy.jss.w13_2.aop.SimpleCustomerDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Cyril Kadomsky
 */
public class DemoAnnotated {
    private static ApplicationContext context
            = new AnnotationConfigApplicationContext(DIConfig.class);

    private static ApplicationContext contextXML
            = new ClassPathXmlApplicationContext("spring-config-2.xml");

    public static void main(String[] args) {

        // demoAnnotated();

        demoAOP();

    }

    public static void demoAnnotated() {

        Application app = (Application) context.getBean(Application.class);

        app.processMessage("Hello!", "user@gmail.com");

        System.out.println(app.getMsgServicesAutowired());
        System.out.println(app.getMsgServicesAutowired());

        System.out.println(app.getMsgServiceResource());
        System.out.println(app.getMsgServiceResource());

    }

    public static void demoAOP() {


        CustomerDAO dao = (CustomerDAO) contextXML.getBean(SimpleCustomerDAO.class);

        Customer cust1 = dao.get(2);
        System.out.println(" dao returned : " + cust1);

        Customer cust2 = dao.get(2);
        System.out.println(" dao returned : " + cust2);

        dao.size();

        System.out.println(cust1==cust2);


    }

}
