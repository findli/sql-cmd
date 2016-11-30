package net.javajoy.jss.w13_2.annotated;

import org.springframework.stereotype.Component;

/**
 * @author Cyril Kadomsky
 */

@Component("smsService")
public class SmsService implements MessagingService {

    private static int count;
    private int id;

    public SmsService() {
        id = count++;
    }

    public boolean sendMessage(String receiver, String message) {
        System.out.println("SMS message to " + receiver + " : " + message);
        return true;
    }

    @Override
    public String toString() {
        return "SmsService{" + id+ "}";
    }
}
