package ru.javajoy.jss.db;

/**
 * Connect with DataBase
 */
import java.sql.*;

public final class DBConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String PASSWORD = "2926101";
    private static DBConnection dbConnection = null;
    private Connection conn = null;

    private DBConnection(String dbName){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL + dbName + "?useUnicode=true&characterEncoding=utf8", USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static Connection getConnection(String dbName) {
        if (dbConnection == null) {
            dbConnection = new DBConnection(dbName);
        }
        return dbConnection.conn;
    }


}
