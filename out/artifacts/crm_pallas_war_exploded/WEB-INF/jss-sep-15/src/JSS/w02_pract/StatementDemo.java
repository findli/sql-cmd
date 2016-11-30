package JSS.w02_pract;

import java.sql.*;

public class StatementDemo {

    static Connection conn = DatabaseConnection.getConnection("Personnel");

    public static void main(String[] args) {

        try {

            // usePreparedStatement();
            useCallableStatement();

        } catch( SQLException e) {
            e.printStackTrace();
        }

    }

    static void useCallableStatement() throws SQLException {

        CallableStatement cst = conn.prepareCall("{call personnel.getEmployee(?, ?, ?)}");
        cst.setString(1, "Dora");
        cst.registerOutParameter(2, Types.INTEGER);
        cst.registerOutParameter(3, Types.INTEGER);

        cst.execute();

        int id = cst.getInt(2);
        int age = cst.getInt(3);

        System.out.println("id = " + id + ", age = " + age);
    }


    static void usePreparedStatement() throws SQLException {

            java.sql.PreparedStatement stmt = conn.prepareStatement("select * from employees where name = ? and age = ?");

            stmt.setString(1,"Fred");
            stmt.setInt(2,6);

            ResultSet rs = stmt.executeQuery();

            DatabaseConnection.printResultSet(rs);

    }

}
