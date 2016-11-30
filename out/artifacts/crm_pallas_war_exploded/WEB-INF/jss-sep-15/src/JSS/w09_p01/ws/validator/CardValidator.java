package JSS.w09_p01.ws.validator;
import javax.jws.WebService;

/**
 * @author Cyril Kadomsky
 */

@WebService(endpointInterface = "JSS.w09_p01.ws.validator.ICardValidator", serviceName = "CardValidator", portName = "ValidatorPort")
public class CardValidator implements ICardValidator {

    public boolean validate(CreditCard card) {
        log("validate(CreditCard card)");
        Character lastChar  = card.getNumber().charAt(card.getNumber().length()-1);
        return Integer.parseInt(lastChar.toString()) % 2 == 0;
    }

    public boolean validate(String cardNumber) {
        log("validate(String cardNumber)");
        return cardNumber.matches("(\\d{4}\\s*){4}");
    }

    private void log(String message) {
        System.out.println("CardValidator : " + message);
    }
}
