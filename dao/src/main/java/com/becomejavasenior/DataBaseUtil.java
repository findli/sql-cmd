package com.becomejavasenior;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseUtil {

    public static Connection getConnection() {
        Properties props = new Properties();
        FileInputStream fileInputStream;
        Connection con = null;
        try {
            fileInputStream = new FileInputStream("db.properties");
            props.load(fileInputStream);

            Class.forName(props.getProperty("org.postgresql.Driver"));

            con = DriverManager.getConnection(props.getProperty("url"),
                    props.getProperty("username"),
                    props.getProperty("password"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static String getQuery(String name) {
        return name;
    }
}
