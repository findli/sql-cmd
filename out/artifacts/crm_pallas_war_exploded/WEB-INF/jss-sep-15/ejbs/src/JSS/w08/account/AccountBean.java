package JSS.w08.account;

import javax.ejb.CreateException;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * @author Cyril Kadomsky
 */
@Stateful(name = "AccountEJB")
public class AccountBean {

    public AccountBean() {}

    private int amount = 0;

    public boolean withdraw(int amount) {
        if (amount <= this.amount) {
            this.amount -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void deposit(int amount) {
        this.amount += amount;
    }

    public int getBalance() {
        return amount;
    }

    public void ejbCreate() throws CreateException {}

    @Remove
    public void remove() {}
}
