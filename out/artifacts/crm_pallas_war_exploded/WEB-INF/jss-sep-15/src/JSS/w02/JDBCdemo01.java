package JSS.w02;

import java.sql.*;

public class JDBCdemo01 {
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
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Employees where sss='1'");
                // 4. Extract data from result set
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int age = rs.getInt("age");
                    String first = rs.getString("name");
                    float salary = rs.getFloat("salary");
                    System.out.println("ID: " + id + ", First: " + first + ", Age: " + age + ", Salary: " + salary);
                }
                rs.close();


                stmt.close();
                conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }

}
