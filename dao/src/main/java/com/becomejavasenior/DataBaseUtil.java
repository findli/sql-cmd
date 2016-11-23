package com.becomejavasenior;

import com.becomejavasenior.DAO.DatabaseException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class DataBaseUtil {
/*
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
    */

    private static BasicDataSource dataSource;
    private static final String PROPERTIES_FILE = "database.properties";

    static {
        if(Objects.equals(System.getenv("DEPLOYMENT_ENVIRONMENT"),"production")) {
            URI dbUri = null;
            try {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            } catch (URISyntaxException e) {
                throw new DatabaseException("DATABASE_URL can't be loaded.", e);
            }
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            dataSource = new BasicDataSource();
            dataSource.setUrl(dbUrl);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
        } else {
            Properties properties = new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

            if (propertiesFile == null) {
                throw new DatabaseException("Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");
            }

            try {
                properties.load(propertiesFile);
            } catch (IOException e) {
                throw new DatabaseException("Properties file '" + PROPERTIES_FILE + "' can't be loaded.", e);
            }

            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(properties.getProperty("db.driver"));
            dataSource.setUrl(properties.getProperty("db.url"));
            dataSource.setUsername(properties.getProperty("db.user"));
            dataSource.setPassword(properties.getProperty("db.password"));
            dataSource.setInitialSize(Integer.parseInt(properties.getProperty("db.initsize")));
            dataSource.setMaxTotal(Integer.parseInt(properties.getProperty("db.maxtotal")));
            dataSource.setMaxWaitMillis(Long.parseLong(properties.getProperty("db.maxwait")));
            dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("db.maxidle")));
            dataSource.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            dataSource.setDefaultAutoCommit(true);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static String getQuery(String name) {
        return name;
    }
}
