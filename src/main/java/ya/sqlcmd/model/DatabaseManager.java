package ya.sqlcmd.model;

import java.util.*;

public interface DatabaseManager {

    ArrayList<HashMap<String, String>> getTableData(String tableName) throws Exception;

    LinkedHashSet<String> getTableNames() throws Exception;

    void connect(String database, String userName, String password) throws Exception;

    void insertData(String tableName, HashMap<String, String> rows) throws Exception;

    void clear(String tableName) throws Exception;

    void delete(String tableName) throws Exception;

    void create(String tableName, LinkedList<String> input) throws Exception;

    void update(String tableName, String id, HashMap<String, String> newValue) throws Exception;

    String[] getTableColumns(String tableName) throws Exception;

    boolean isConnected();

    void deleteAllTables() throws Exception;
}
