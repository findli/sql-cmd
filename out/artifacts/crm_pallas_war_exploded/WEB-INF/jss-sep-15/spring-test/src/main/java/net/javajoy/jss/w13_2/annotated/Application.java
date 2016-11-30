package net.javajoy.jss.w13_2.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Cyril Kadomsky
 */


@Component
@Scope("singleton")
public class Application {

    //field-based dependency injection

    @Autowired
    @Qualifier("smsService")
    @Resource(name="smsService")
    private MessagingService messagingService;

    @Autowired   // Inject all instances of MessagingService interface
    private List<MessagingService> msgServicesAutowired;

    @Resource   // First try to inject list by the field name
    private List<MessagingService> msgServiceResource;


    public Application() {
    }

    // constructor-based dependency injection

    // @Autowired
    public Application(MessagingService svc) {
        this.messagingService = svc;
    }

    // setter-based dependency injection

//    @Autowired
//    @Required
//    @Qualifier("smsService")
    public void setService(MessagingService svc) {
        this.messagingService = svc;
    }

    @Autowired
    public List<MessagingService> getMsgServicesAutowired() {
        return msgServicesAutowired;
    }

    public List<MessagingService> getMsgServiceResource() {
        return msgServiceResource;
    }

    public boolean processMessage(String msg, String rec){
        // ...
        return messagingService.sendMessage(rec, msg);
    }

}
