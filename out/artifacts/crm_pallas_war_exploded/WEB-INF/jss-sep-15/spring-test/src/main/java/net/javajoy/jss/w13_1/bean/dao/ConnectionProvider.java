package net.javajoy.jss.w13_1.bean.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cyril Kadomsky
 */
public class ConnectionProvider {

    private String connectionString;
    private List<Connection> pool;

    public ConnectionProvider() {

    }

    public ConnectionProvider(String connectionString) {
        this.connectionString = connectionString;
    }

    void init() {
        pool = new ArrayList<Connection>(10);
    }

    // factory method
    public Connection getConnection() {
        System.out.println("getConnection() invoked");
        // ...
        Connection con = new Connection(this,pool.size()+1);
        pool.add(con);
        return con;
    }

    public void closeConnection(Connection conn) {
        // ...
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

}
