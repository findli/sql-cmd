package ya.sqlcmd.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by indigo on 25.08.2015.
 */
public interface DatabaseManager {

    HashMap<String, String>[] getTableData(String tableName);

    String[] getTableNames();

    void connect(String database, String userName, String password);

    void insertData(String tableName, HashMap<String, String> rows);

    void clear(String tableName);

    void delete(String tableName);

    void create(String tableName, LinkedList<String> input);

    void update(String tableName, String id, HashMap<String, String> newValue);

    String[] getTableColumns(String tableName);

    boolean isConnected();
}
