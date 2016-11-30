package JSS.w09_p01;

import JSS.w09_p01.validator.CardValidator;
import JSS.w09_p01.validator.CreditCard;
import JSS.w09_p01.validator.ICardValidator;

/**
 * @author Cyril Kadomsky
 */
public class CVClient {
  public static void main(String[] argv) {
      CreditCard card = new CreditCard();
      card.setNumber("356363638");

      ICardValidator validator = new CardValidator().getValidatorPort();
      boolean result = validator.validateCard(card);
      System.out.println("Card validation result = " + result);
  }
}
