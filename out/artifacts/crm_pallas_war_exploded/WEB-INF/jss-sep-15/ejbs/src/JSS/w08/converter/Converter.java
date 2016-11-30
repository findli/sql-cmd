package JSS.w08.converter;

import javax.ejb.EJBObject;
import java.math.BigDecimal;
import java.rmi.RemoteException;

/**
 * @author Cyril Kadomsky
 */
public interface Converter extends EJBObject {
    public BigDecimal dollarToYen(BigDecimal dollars) throws RemoteException;
    public BigDecimal yenToEuro(BigDecimal yen) throws RemoteException;
}
