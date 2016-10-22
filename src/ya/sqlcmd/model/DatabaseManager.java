package ya.sqlcmd.model;

import java.util.*;

public interface DatabaseManager {

    ArrayList<HashMap<String, String>> getTableData(String tableName);

    LinkedHashSet<String> getTableNames();

    void connect(String database, String userName, String password);

    void insertData(String tableName, HashMap<String, String> rows);

    void clear(String tableName);

    void delete(String tableName);

    void create(String tableName, LinkedList<String> input) throws Exception;

    void update(String tableName, String id, HashMap<String, String> newValue);

    String[] getTableColumns(String tableName);

    boolean isConnected();

    void deleteAllTables();
}
