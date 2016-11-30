package JSS.w03_pract.model.dao;


import java.util.List;
import java.util.function.Predicate;

public interface DAO<T> extends Iterable<T> {


    interface Filter {
        String getSQLCondition();  // Where ...
    }

    interface Ordering {
        String getSQLOrdering(); // Order by...
    }

    void setFilter( Filter filter );
    void setOrdering ( Ordering ordering);


    T getByID(long id);
    T getByPosition(int pos);

    List<T> getAsList();
    List<T> getAsList( Predicate<T> predicate );


    long add(T customer);
    boolean update(T customer);
    boolean delete(T customer);
    boolean delete(long id);

    void refresh();

}
