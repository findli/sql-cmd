package ya.sqlcmd.model;

import java.sql.*;
import java.util.*;

public class JDBCDatabaseManager implements DatabaseManager {

    private Connection connection;

    @Override
    public ArrayList<HashMap<String, String>> getTableData(String tableName) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM public." + tableName);
            ResultSetMetaData rsmd = rs.getMetaData();
            ArrayList<HashMap<String, String>> dataSet = new ArrayList<>();
            while (rs.next()) {
                LinkedHashMap<String, String> row = new LinkedHashMap();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.put(rsmd.getColumnName(i), rs.getObject(i).toString());
                }
                dataSet.add(row);
            }
            rs.close();
            stmt.close();
            return dataSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private int getSize(String tableName) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rsCount = stmt.executeQuery("SELECT COUNT(*) FROM public." + tableName);
        rsCount.next();
        int size = rsCount.getInt(1);
        rsCount.close();
        return size;
    }

    @Override
    public LinkedHashSet<String> getTableNames() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'");
            LinkedHashSet<String> tables = new LinkedHashSet<String>();
            while (rs.next()) {
                tables.add(rs.getString("table_name"));
            }
            rs.close();
            stmt.close();
            return tables;
        } catch (SQLException e) {
            e.printStackTrace();
            return new LinkedHashSet<>();
        }
    }

    @Override
    public void connect(String database, String userName, String password) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Please add jdbc jar to project.", e);
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/" + database, userName,
                    password);
        } catch (SQLException e) {
            connection = null;
            throw new RuntimeException(
                    String.format("Can't get connection for model:%s user:%s",
                            database, userName),
                    e);
        }
    }

    @Override
    public void insertData(String tableName, HashMap<String, String> rows) {
        try {
            Statement stmt = connection.createStatement();

            String tableNames = getNameFormatted(rows, "%s,");
            String values = getValuesFormatted(rows, "'%s',");

            stmt.executeUpdate("INSERT INTO public." + tableName + " (" + tableNames + ")" +
                    "VALUES (" + values + ")");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear(String tableName) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("TRUNCATE TABLE public." + tableName);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String tableName) {
        try {
            Statement stmt = connection.createStatement();
            String sql = "DROP TABLE public." + tableName;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(String tableName, LinkedList<String> input) throws Exception {
        try {
            Statement stmt = connection.createStatement();
            String fields = getInsertFormatted(input, "%s varchar(255),");
            String sql = "CREATE TABLE \"" + tableName + "\" (" + fields + ");";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            throw new Exception("Table " + tableName + " already is set!");
        }
    }

    @Override
    public void update(String tableName, String id, HashMap<String, String> newValue) {
        try {
            String tableNames = getNameFormatted(newValue, "%s = ?,");

            String sql = "UPDATE public." + tableName + " SET " + tableNames + " WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            int index = 1;
            for (Object value : newValue.values()) {
                ps.setObject(index, value);
                index++;
            }
            ps.setObject(index, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String[] getTableColumns(String tableName) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM information_schema.columns WHERE table_schema = 'public' AND table_name = '" + tableName + "'");
            String[] tables = new String[100];
            int index = 0;
            while (rs.next()) {
                tables[index++] = rs.getString("column_name");
            }
            tables = Arrays.copyOf(tables, index, String[].class);
            rs.close();
            stmt.close();
            return tables;
        } catch (SQLException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    @Override
    public boolean isConnected() {
        return connection != null;
    }

    @Override
    public void deleteAllTables() {
        LinkedHashSet<String> tables = getTableNames();
        for (String table :
                tables) {
            delete(table);
        }
    }

    private String getInsertFormatted(LinkedList<String> fields, String format) {
        String string = "";
        for (String key : fields) {
            string += String.format(format, key);
        }
        string = string.substring(0, string.length() - 1);
        return string;
    }

    private String getNameFormatted(HashMap<String, String> newValue, String format) {
        String string = "";
        for (String key : newValue.keySet()) {
            string += String.format(format, key);
        }
        string = string.substring(0, string.length() - 1);
        return string;
    }

    private String getValuesFormatted(HashMap<String, String> input, String format) {
        String values = "";
        for (Object value : input.values()) {
            values += String.format(format, value);
        }
        values = values.substring(0, values.length() - 1);
        return values;
    }
}
