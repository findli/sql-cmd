
package JSS.w09_p01.validator;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the JSS.w09_p01.validator package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreditCard_QNAME = new QName("http://JSS.javajoy.net", "creditCard");
    private final static QName _ValidateCard_QNAME = new QName("http://JSS.javajoy.net", "validateCard");
    private final static QName _ValidateCardNumber_QNAME = new QName("http://JSS.javajoy.net", "validateCardNumber");
    private final static QName _ValidateCardNumberResponse_QNAME = new QName("http://JSS.javajoy.net", "validateCardNumberResponse");
    private final static QName _ValidateCardResponse_QNAME = new QName("http://JSS.javajoy.net", "validateCardResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: JSS.w09_p01.validator
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link ValidateCard }
     * 
     */
    public ValidateCard createValidateCard() {
        return new ValidateCard();
    }

    /**
     * Create an instance of {@link ValidateCardNumber }
     * 
     */
    public ValidateCardNumber createValidateCardNumber() {
        return new ValidateCardNumber();
    }

    /**
     * Create an instance of {@link ValidateCardNumberResponse }
     * 
     */
    public ValidateCardNumberResponse createValidateCardNumberResponse() {
        return new ValidateCardNumberResponse();
    }

    /**
     * Create an instance of {@link ValidateCardResponse }
     * 
     */
    public ValidateCardResponse createValidateCardResponse() {
        return new ValidateCardResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://JSS.javajoy.net", name = "creditCard")
    public JAXBElement<CreditCard> createCreditCard(CreditCard value) {
        return new JAXBElement<CreditCard>(_CreditCard_QNAME, CreditCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://JSS.javajoy.net", name = "validateCard")
    public JAXBElement<ValidateCard> createValidateCard(ValidateCard value) {
        return new JAXBElement<ValidateCard>(_ValidateCard_QNAME, ValidateCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCardNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://JSS.javajoy.net", name = "validateCardNumber")
    public JAXBElement<ValidateCardNumber> createValidateCardNumber(ValidateCardNumber value) {
        return new JAXBElement<ValidateCardNumber>(_ValidateCardNumber_QNAME, ValidateCardNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCardNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://JSS.javajoy.net", name = "validateCardNumberResponse")
    public JAXBElement<ValidateCardNumberResponse> createValidateCardNumberResponse(ValidateCardNumberResponse value) {
        return new JAXBElement<ValidateCardNumberResponse>(_ValidateCardNumberResponse_QNAME, ValidateCardNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://JSS.javajoy.net", name = "validateCardResponse")
    public JAXBElement<ValidateCardResponse> createValidateCardResponse(ValidateCardResponse value) {
        return new JAXBElement<ValidateCardResponse>(_ValidateCardResponse_QNAME, ValidateCardResponse.class, null, value);
    }

}
