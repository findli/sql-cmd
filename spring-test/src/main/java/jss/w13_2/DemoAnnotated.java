package jss.w13_2;

import jss.w13_2.annotated.Application;
import jss.w13_2.annotated.DIConfig;
import jss.w13_2.aop.Customer;
import jss.w13_2.aop.CustomerDAO;
import jss.w13_2.aop.SimpleCustomerDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoAnnotated {
    private static ApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);

//    private static ApplicationContext contextXML = new ClassPathXmlApplicationContext("spring-config.xml");

    public static void main(String[] args) {
        demoAnnotated();

//        demoAOP();
    }

    private static void demoAnnotated() {
//        Application app = (Application) contextXML.getBean(Application.class);
        Application app = (Application) context.getBean(Application.class);

        app.processMessage("Hello!", "user@gmail.com");

        System.out.println(app.getMessagingServiceAutowired());
        System.out.println(app.getMessagingServiceAutowired());

        System.out.println(app.getMessagingServiceResource());
        System.out.println(app.getMessagingServiceResource());
    }

/*
    private static void demoAOP() {
        CustomerDAO dao = (CustomerDAO) contextXML.getBean(SimpleCustomerDAO.class);

        Customer cust1 = dao.get(2);
        System.out.println(" dao returned: " + cust1);

        Customer cust2 = dao.get(2);
        System.out.println(" dao returned: " + cust2);

        dao.size();
        System.out.println(cust1 == cust2);
    }
*/
}
