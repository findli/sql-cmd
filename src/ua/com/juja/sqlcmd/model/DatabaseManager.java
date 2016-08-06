package ua.com.juja.sqlcmd.model;

/**
 * Created by indigo on 25.08.2015.
 */
public interface DatabaseManager {

    DataSet[] getTableData(String tableName);

    String[] getTableNames();

    void connect(String database, String userName, String password);

    public void insertData(String tableName, DataSet rows);

    void clear(String tableName);

    void delete(String tableName);

    void create(String tableName, DataSet input);

    void update(String tableName, int id, DataSet newValue);

    String[] getTableColumns(String tableName);

    boolean isConnected();
}
