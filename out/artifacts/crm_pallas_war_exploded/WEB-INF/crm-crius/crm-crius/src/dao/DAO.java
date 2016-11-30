package dao;


import java.util.List;

public interface DAO<T> extends Iterable<T> {

    /**
     * get all data from table for list
     */
    void refresh();

    List<T> getAsList(); //get all items from table into list
    void setFilter(String filter); //Where...
    void setOrdering ( String ordering); //Order by..
    boolean update(int id,String columnName, String item); //Update item
    void add(T item); //Add item
    boolean deleteItem(int id); //Delete item

}
