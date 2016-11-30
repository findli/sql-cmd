package JSS.w02_pract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by Cyrill on 20.09.2015.
 */
public class TransactionsDemo {

    private static Connection conn = null;

    public static void main(String[] args) {
        conn = DatabaseConnection.getConnection("Personnel");
        try {
            //doTransaction();
            doTransaction1();
            DatabaseConnection.printTableData("employees");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Must not change the DB
    static void doTransaction() throws SQLException {

        conn.setAutoCommit(false);

        int insertedKey = 0;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO Employees (name, age, salary, fkPosition) VALUES ('Temp', 0, 0, 1) ",
                Statement.RETURN_GENERATED_KEYS);
        ResultSet rsgc = stmt.getGeneratedKeys();
        if (rsgc.next()) {
            insertedKey = rsgc.getInt(1);
        }
        rsgc.close();
        System.out.println("Temp data inserted, id = " + insertedKey + ". Press enter...");
        DatabaseConnection.printTableData("employees");


        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        if (insertedKey!=0) {
            stmt.executeUpdate("DELETE FROM Employees WHERE id=" + insertedKey);
        }
        conn.commit();
        stmt.executeUpdate("DELETE FROM Employees");
        System.out.println("All data deleted, but not commited.");
        DatabaseConnection.printTableData("employees");

        System.out.println("Press enter...");
        sc.nextLine();
        conn.rollback();
        conn.setAutoCommit(true);
    }

    // Must not change the DB
    static void doTransaction1() throws SQLException {
        Statement stmt = null;
        conn.setAutoCommit(false);
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Employees (name, age, salary) VALUES ('Temp', 0, 0) ",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate("INSERT FROM Employees (name, age, salary) VALUES ('Temp', 1, 1) ",   // invalid sql
                    Statement.RETURN_GENERATED_KEYS);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            if (stmt!=null) {
                stmt.close();
            }
            conn.setAutoCommit(true);
        }
    }

}
