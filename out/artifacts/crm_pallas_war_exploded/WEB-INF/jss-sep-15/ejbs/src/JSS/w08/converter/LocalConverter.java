package JSS.w08.converter;

import javax.ejb.EJBLocalObject;
import java.math.BigDecimal;

/**
 * @author Cyril Kadomsky
 */
public interface LocalConverter extends EJBLocalObject {
    public BigDecimal dollarToYen(BigDecimal dollars);
    public BigDecimal yenToEuro(BigDecimal yen);
}
