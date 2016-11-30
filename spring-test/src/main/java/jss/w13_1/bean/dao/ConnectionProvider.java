package jss.w13_1.bean.dao;

import java.util.ArrayList;
import java.util.List;

public class ConnectionProvider {
    private String connectionString;
    private List<Connection> pool;

    public ConnectionProvider() {
//        this.connectionString = connectionString;
    }

    public ConnectionProvider(String connectionString) {
        pool = new ArrayList<Connection>(10);
//        this.connectionString = connectionString;
    }

    void init() {
        pool = new ArrayList<Connection>(10);
    }
    public Connection getConnection() {
        System.out.println("getConnection() invoked");
        Connection connection = new Connection(this, pool.size() + 1);
        pool.add(connection);

        return connection;
    }

    public void closeConnection(Connection connection) {

    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public List<Connection> getPool() {
        return pool;
    }

    public void setPool(List<Connection> pool) {
        this.pool = pool;
    }
}
