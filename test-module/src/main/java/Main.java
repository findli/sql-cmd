import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");

        mysqlJdbc();
    }

    private static void mysqlJdbc() {
        //        try {
//            Class.forName("org.mysql.jdbc.Driver");
//            Class.forName("org.mysql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Please add jdbc jar to project.", e);
//        }
        try {
            // http://nixmash.com/java/classnotfoundexception-com-mysql-jdbc-driver-fix-in-intellij-idea/
            // http://stackoverflow.com/questions/34189756/warning-about-ssl-connection-when-connecting-to-mysql-database
            // http://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue

//            Connection connection = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1:3306/java_jss_salesdept?verifyServerCertificate=false&useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root",
//                    "123");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/java_jss_salesdept?verifyServerCertificate=false&useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "123");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
