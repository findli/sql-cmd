package net.javajoy.jss.w13_1.bean.dao;


import java.util.List;
import java.util.Map;

/**
 * @author Cyril Kadomsky
 */
public class CustomerDAO {

    String tableName;
    Connection connection;
    List<Ordering> order;

    Map<String,SimpleFilter> filter;

    public CustomerDAO() {
    }

    public CustomerDAO(String tableName, Connection connection, List<Ordering> order) {
        this.tableName = tableName;
        this.connection = connection;
        this.order = order;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Ordering> getOrder() {
        return order;
    }

    public void setOrder(List<Ordering> order) {
        this.order = order;
    }

    public Map<String, SimpleFilter> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, SimpleFilter> filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "CustomerDAO{" +
                "tableName='" + tableName + '\'' +
                ", connection=" + connection +
                ", order=" + order +
                ", filter=" + filter +
                '}';
    }
}
