package net.javajoy.jss.w13_2.annotated;

/**
 * @author Cyril Kadomsky
 */
public interface MessagingService {

    boolean sendMessage(String receiver, String message);
}
