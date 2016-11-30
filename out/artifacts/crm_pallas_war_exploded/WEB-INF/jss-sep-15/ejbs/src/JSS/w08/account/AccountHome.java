package JSS.w08.account;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;

/**
 * @author Cyril Kadomsky
 */

public interface AccountHome extends EJBHome {
    Account create() throws RemoteException, CreateException;
}