package JSS.w08.account;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

/**
 * @author Cyril Kadomsky
 */
public interface Account extends EJBObject {

    boolean withdraw(int amount) throws RemoteException;

    void deposit(int amount) throws RemoteException;

    int getBalance() throws RemoteException;

}
