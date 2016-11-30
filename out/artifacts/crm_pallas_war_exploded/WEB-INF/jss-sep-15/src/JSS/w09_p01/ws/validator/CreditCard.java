package JSS.w09_p01.ws.validator;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Cyril Kadomsky
 */
@XmlRootElement
public class CreditCard {

    private String number;
    private Integer controlNumber;
    private String expiryDate;
    private String type;

    public CreditCard() {
        this.number = "0000 0000 0000 0000";
        controlNumber = 0;
        expiryDate = "";
        type = "Visa";
    }

    public CreditCard(String number, Integer controlNumber, String expiryDate, String type) {
        this.number = number;
        this.controlNumber = controlNumber;
        this.expiryDate = expiryDate;
        this.type = type;
    }

    @XmlAttribute(required = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlAttribute(required = false)
    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    @XmlAttribute(required = false)
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @XmlAttribute(required = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
