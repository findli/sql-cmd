package JSS.w02;

import java.sql.*;

public class JDBCMetaData {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Personnel";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    private static Connection conn = null;


    public static void main(String[] args) {
        Statement stmt = null;
        try {
            // 1. Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // 2. Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 3. Execute a query
            System.out.println("Creating statement...");
            try {
                try {
                    stmt = conn.createStatement();
                    DatabaseMetaData metadata = conn.getMetaData();

                    // Show all tables
                    ResultSet rsTables = metadata.getTables(null, null, null, null);
                    while(rsTables.next()) {
                        System.out.println(rsTables.getString("TABLE_NAME"));
                    }

                    rsTables.close();

                    printTableData("Employees");
                    System.out.println();
                    printTableData("positions");

/*                    // Ensure table existence
                    rsTables = metadata.getTables(null, null, "employees", null);
                    if( !rsTables.next() ) {
                        stmt.executeUpdate("CREATE TABLE employees (" +
                                "  id INT UNSIGNED NOT NULL AUTO_INCREMENT," +
                                "  name VARCHAR(45) NOT NULL," +
                                "  age INT NOT NULL," +
                                "  salary FLOAT NOT NULL," +
                                "  PRIMARY KEY (id))" +
                                "ENGINE = InnoDB;");
                        stmt.executeUpdate("INSERT INTO Employees (name, age, salary) VALUES " +
                                "('Ann', 22, 2356.50), " +
                                "('Barbara', 33, 3345), " +
                                "('Clara', 44, 2234.50)");
                    }
                    rsTables.close();

*/

                } catch( SQLException e) {
                    e.printStackTrace();
                } finally {
                    if(stmt!=null) stmt.close();
                }


            } catch( SQLException e) {
                e.printStackTrace();
            } finally {
                if(stmt!=null) stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }


    private static void printTableData(String tableName) throws  SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
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
        rs.close();
        stmt.close();

    }

}
