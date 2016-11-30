package JSS.w03_pract.model;

import java.sql.*;

public final class DatabaseConnection {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    private static DatabaseConnection instance = null;

    private Connection conn = null;

    private DatabaseConnection(String dbName) {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL + dbName + "?useUnicode=true&characterEncoding=utf8", USER, PASS);
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
        if (instance == null) {
            instance = new DatabaseConnection(dbName);
        }
        return instance.conn;
    }

    public static void printTableData(String tableName) throws  SQLException {
        Statement stmt = instance.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
        printResultSet(rs);
        rs.close();
        stmt.close();

    }

    public static void printResultSet(ResultSet rs) throws  SQLException {
        ResultSetMetaData meta  = rs.getMetaData();

        int cnt = meta.getColumnCount();
        for(int i=1; i<=cnt; i++) {
            System.out.print(meta.getColumnName(i) + " (" + meta.getColumnType(i) + ") \t");
        }
        System.out.println();

        while (rs.next()) {
            for (int i=1; i<=cnt; i++) {
                System.out.print(rs.getString(i) + " \t");
            }
            System.out.println();
        }
    }


}


