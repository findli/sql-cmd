package JSS.w02;

import java.sql.*;

public class JDBCEmployees {
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
            //Class.forName(JDBC_DRIVER);
            // 2. Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 3. Execute a query
            System.out.println("Creating statement...");
            try {
                stmt = conn.createStatement();
                DatabaseMetaData metadata = conn.getMetaData();
                ResultSet rsTables = metadata.getTables(null, null, "employees", null);
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



                //insertEmployeeSQL("dddd",1,111);
                //insertEmployee("inserted!!!!",1000,21);
                insertEmployeePosition("new employee", 20, 3883, "Manager");
                insertEmployeePosition("another new employee", 20, 3883, "Top Manager");
                printEmployees();



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

    static void printEmployees() throws SQLException {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");
        // 4. Extract data from result set
        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("name");
            float salary = rs.getFloat("salary");
            System.out.println("ID: " + id +", First: " + first +", Age: " + age + ", Salary: " + salary);
        }
        rs.close();
    }


    static void insertEmployeeSQL( String name, int age, float salary) throws SQLException {
        Statement stmt = conn.createStatement();
        int key = stmt.executeUpdate("INSERT INTO Employees (name, age, salary) VALUES ('" + name + "', 75, 10000)",
                Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        System.out.print("Inserted keys : ");
        while (rs.next()) System.out.print(rs.getString(1) + " ");
        rs.close();
        stmt.close();
    }


    static void insertEmployee( String name, int age, float salary) throws SQLException {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String sql = "SELECT * FROM Employees";
        ResultSet rs = stmt.executeQuery(sql);
        rs.moveToInsertRow();
        rs.updateString("name", name);
        rs.updateFloat("salary", salary);
        rs.updateInt("age", age);
        rs.insertRow();
        rs.close();
        stmt.close();
    }


    static void insertEmployeePosition( String name, int age, float salary, String position) throws SQLException {
        Statement stmt = conn.createStatement();
        int positionID = -1;

        // 0. Check if such eployee exists

        // 1. get position id
        String sql = "select id from positions where name = '" + position + "'";
        System.out.println(sql);
        ResultSet rsPos =  stmt.executeQuery("select id from positions where name = '" + position + "'");
        if (rsPos.next()) {  // position exists?
            positionID = rsPos.getInt("id");
        } else {
            stmt.executeUpdate("INSERT into positions (name) values ('" + position +"')",Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKeys  = stmt.getGeneratedKeys();
            if (rsKeys.next()) {
                positionID = rsKeys.getInt(1);
            }
        }

        // 2. update employee
        if (positionID > 0) {
            String sql1 = "INSERT INTO Employees (name, age, salary, fkPosition) VALUES ('" + name + "', '" + age + "', '" + salary + "', '" + positionID + "')";
            System.out.println(sql1);
            int key = stmt.executeUpdate(sql1,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            System.out.print("Inserted keys : ");
            while (rs.next()) System.out.print(rs.getString(1) + " ");
            rs.close();

        }


        stmt.close();
    }


    static void updateEmployee( int n, String name, int age, float salary) throws SQLException {
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String sql = "SELECT * FROM Employees";
        ResultSet rs = stmt.executeQuery(sql);
        rs.absolute(n);
        rs.updateString("name", name);
        rs.updateInt("age", age);
        rs.updateFloat("salary", salary);
        rs.updateRow();
        rs.close();
        stmt.close();
    }

}

