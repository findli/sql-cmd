package JSS.w08.converter;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;

/**
 * @author Cyril Kadomsky
 */
public interface ConverterHome extends EJBHome {
    JSS.w08.converter.Converter create() throws RemoteException, CreateException;
}
