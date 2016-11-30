package net.javajoy.jss.w13_2.aop;

/**
 * @author Cyril Kadomsky
 */
public interface CustomerDAO {

    void setTableName(String tableName);

    Customer get(long id);

    int size();
}
