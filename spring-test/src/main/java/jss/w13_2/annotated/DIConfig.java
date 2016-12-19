package jss.w13_2.annotated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(value = {"jss.w13_2.annotated"})
public class DIConfig {
    /*
        @Bean(name = {"application"})
        public Application getApp() {
            return new Application(getEmailMessageService());
        }
    */
    // это для теста
    /*@Bean(name = {"application"})
    public Application getApp() {
        return new Application(new MessagingService() {
            @Override
            public boolean sendMessage(String receiver, String message) {
                System.out.println("Mock clss");
                return true;
            }
        });
    }*/

    @Bean(name = {"emailService"})
    @Scope("prototype")
    public MessagingService getEmailMessageService() {
        return new EmailService();
    }

    @Bean(name = {"smsService"})
    @Scope("prototype")
    public MessagingService getSmsMessageService() {
        return new SmsService();
    }

    @Bean
    @Scope("prototype")
    public List<MessagingService> messagingServiceResource() {
        List<MessagingService> list = new ArrayList<>(2);
        list.add(new EmailService());
        list.add(new SmsService());

        return list;
    }
}
