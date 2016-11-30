package JSS.w08.converter;

import javax.ejb.CreateException;
import javax.ejb.Stateless;
import java.math.BigDecimal;

/**
 * @author Cyril Kadomsky
 */
@Stateless(name="ConverterBean")
public class ConverterBean {

    BigDecimal yenRate = new BigDecimal("121.6000");
    BigDecimal euroRate = new BigDecimal("0.0077");

    public void setYenRate(BigDecimal yenRate) {
        this.yenRate = yenRate;
    }

    public void setEuroRate(BigDecimal euroRate) {
        this.euroRate = euroRate;
    }

    public ConverterBean() {}

    public BigDecimal dollarToYen(BigDecimal dollars) {
        BigDecimal result = dollars.multiply(yenRate);
        return result.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal yenToEuro(BigDecimal yen) {
        BigDecimal result = yen.multiply(euroRate);
        return result.setScale(2, BigDecimal.ROUND_UP);
    }

    public void ejbCreate() throws CreateException {

    }

}
