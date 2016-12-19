package jss.w13_2.aop;

public interface CustomerDAO {
    void setTableName(String tableName);

    Customer get(long id);

    int size();
}
