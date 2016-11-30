package JSS.w09_p01.ws.validator;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @author Cyril Kadomsky
 */

@WebService( targetNamespace = "http://JSS.javajoy.net", name = "ICardValidator" )
public interface ICardValidator {

    @WebResult(name= "isValid")
    @WebMethod(operationName = "validateCard")
    boolean validate(@WebParam(name="credit-card") CreditCard card);

    @WebResult(name= "isValid")
    @WebMethod(operationName = "validateCardNumber")
    boolean validate(@WebParam(name="card-number") String cardNumber);

}
