package net.javajoy.jss.w13_2.annotated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cyril Kadomsky
 */


@Configuration
@ComponentScan(value={"net.javajoy.jss.w13_2.annotated"})
public class DIConfig {

//    @Bean(name={"application"})
//    public Application getApp() {
//        Application app =  new Application( );
//        app.setService(getEmailMessageService());
//        return app;
//    }

//    @Bean(name={"application"})
//    public Application getApp() {
//        return new Application(
//                new MessagingService() {
//                    @Override
//                    public boolean sendMessage(String receiver, String message) {
//                        System.out.println("Mock class");
//                        return true;
//                    }
//                });
//    }


    @Bean(name={"emailService"})
    @Scope("prototype")
    public MessagingService getEmailMessageService(){
        return new EmailService();
    }

    @Bean(name={"smsService"})
    @Scope("prototype")
    public MessagingService getSmsMessageService(){
        return new SmsService();
    }

    @Bean
    @Scope("prototype")
    public List<MessagingService> msgServiceResource() {
        List<MessagingService> list = new ArrayList<>(2);
        list.add(new EmailService());
        list.add(new EmailService());
        return list;
    }
}
