package net.javajoy.jss.w13_2.annotated;

/**
 * @author Cyril Kadomsky
 */

//@Component("emailService")
public class EmailService implements MessagingService {

    private static int count;
    private int id;

    public EmailService() {
        id = count++;
    }

    public boolean sendMessage(String receiver, String message) {
        System.out.println("Email message to " + receiver + " : " + message);
        return true;
    }

    @Override
    public String toString() {
        return "EmailService{ "+ id +" }";
    }
}
