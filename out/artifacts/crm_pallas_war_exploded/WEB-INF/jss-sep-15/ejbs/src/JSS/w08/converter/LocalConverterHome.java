package JSS.w08.converter;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 * @author Cyril Kadomsky
 */
public interface LocalConverterHome extends EJBLocalHome {
    JSS.w08.converter.LocalConverter create() throws CreateException;
}
