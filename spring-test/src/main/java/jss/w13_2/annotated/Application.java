package jss.w13_2.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("application")
@Scope("singleton")
public class Application {
    // рельно инициализация будет через сеттер
    @Autowired
    @Qualifier("smsService")
    @Resource(name = "smsService") // если name не указать то автоматом имя переменной
    private MessagingService messagingService;
    /**
     * [EmailService{id=0}, SmsService{id=0}] - добавятся только бины без инициализации
     */
    @Autowired // Inject all instances of MessagingService interface
//    @Qualifier("smsService")
    private List<MessagingService> messagingServiceAutowired;

    /**
     * свяжется с бином по имени
     * потом если не найдено найдет по типу все совпадающие - как @Autowired
     */
    @Resource // First try to inject list by the field name - DIConfig.messagingServiceResource()
    private List<MessagingService> messagingServiceResource;

    public Application() {
    }

    //    @Autowired
//    public Application(EmailService svc) {
//        this.messagingService = svc;
//    }
    public Application(MessagingService svc) {
        this.messagingService = svc;
    }

    public List<MessagingService> getMessagingServiceResource() {
        return messagingServiceResource;
    }

    public List<MessagingService> getMessagingServiceAutowired() {
        return messagingServiceAutowired;
    }

//    @Autowired
//    @Required
//    @Qualifier("smsService")
/*
    public void setService(MessagingService svc){
        this.messagingService = svc;}
*/

    public boolean processMessage(String msg, String rec) {
        return messagingService.sendMessage(rec, msg);
    }
}
