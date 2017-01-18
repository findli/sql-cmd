package ya.sqlcmd.model;

import java.util.*;

public class InMemoryDatabaseManager implements DatabaseManager {

    public static final String TABLE_NAME = "user"; // TODO implement multitables
    private int freeIndex = 0;
    private InMemoryDatabaseManager.DataBase dataBase = this.new DataBase();

    @Override
    public ArrayList<HashMap<String, String>> getTableData(String tableName) throws IllegalAccessException {
        DataBase.Table table = null;
        table = this.dataBase.getTable(tableName);
        return table.getRows();
    }

    @Override
    public LinkedHashSet<String> getTableNames() {
        return dataBase.getTableNames();
    } // TODO to remove test

    @Override
    public void connect(String database, String userName, String password) {
        // do nothing
    }

    @Override
    public void clear(String tableName) throws IllegalAccessException {
        this.dataBase.clear(tableName);
//        validateTable(tableName);

//        data = new DataSet[1000];
//        freeIndex = 0;
    }

    @Override
    public void delete(String tableName) throws IllegalAccessException {
        dataBase.deleteTable(tableName);
    }

    @Override
    public void create(String tableName, LinkedList<String> fields) throws Exception {
        this.dataBase.createTable(tableName, fields);

//        insertData(tableName, fields);

//        validateTable(tableName);

//        data[freeIndex] = input;
//        freeIndex++;
    }

    public void insertData(String tableName, HashMap<String, String> row) throws IllegalAccessException {
        this.dataBase.insert(tableName, row);
    }

    @Override
    public void update(String tableName, String id, HashMap<String, String> newValue) throws IllegalAccessException {
        this.dataBase.update(tableName, newValue, id);
    }

    @Override
    public String[] getTableColumns(String tableName) {
        return new String[]{"name", "password", "id"};
    }

    @Override
    public boolean isConnected() {
        return true;
    }

    @Override
    public void deleteAllTables() throws IllegalAccessException {
        for (String tableName : dataBase.getTableNames()) {
            delete(tableName);
        }
    }

    final class DataBase {
        private HashSet<Table> tables = new LinkedHashSet<>();
        private HashSet<String> tableNames = new HashSet<>();

        public void createTable(String tableName, LinkedList<String> fields) throws Exception {
            Table table = new Table(tableName, fields);
            if (this.issetTable(tableName)) {
                throw new Exception("Table " + tableName + " already is set!");
            }
            this.tables.add(table);
        }

        private boolean issetTable(String tableName) {
            for (Table table : tables) {
                if (table.getName() == tableName) {
                    return true;
                }
            }
            return false;
        }

        public void deleteTable(String tableName) throws IllegalAccessException {
            this.tables.remove(this.getTable(tableName));
        }

        public void insert(String tableName, HashMap<String, String> row) throws IllegalAccessException {
            this.getTable(tableName).insert(row);
        }

        public void update(String tableName, HashMap<String, String> newValues, String rowId) throws IllegalAccessException {
            this.getTable(tableName).update(newValues, rowId);
        }

        private Table getTable(String tableName) throws IllegalAccessException {
            for (Table table : this.tables) {
                if (table.getName().equals(tableName)) {
                    return table;
                }
            }
            throw new IllegalAccessException("There is no table named: " + tableName);
        }

        public void clear(String tableName) throws IllegalAccessException {
            Table table = this.getTable(tableName);
            table.clear();
        }

        public LinkedHashSet<String> getTableNames() {
            LinkedHashSet<String> tableNames = new LinkedHashSet<>();
            for (Table table : tables) {
                tableNames.add(table.getName());
            }
            return tableNames;
        }

        final class Table {
            protected String name;
            protected LinkedList<String> fields;
            protected ArrayList<HashMap<String, String>> rows = new ArrayList<>();

            public Table(final String tableName, final LinkedList<String> fields) {
                this.name = tableName;
                this.fields = fields;
            }

            public void clear() {
                this.rows.clear();
            }

            public String getName() {
                return name;
            }

            public void insert(HashMap<String, String> row) {
                this.rows.add(row);
            }

            public void update(HashMap<String, String> newValues, String rowId) throws IllegalAccessException {
                Map<String, String> row = getRow(rowId);

                for (String fieldName : newValues.keySet()) {
                    String fieldValue = newValues.get(fieldName);

                    row.remove(fieldName);
                    row.put(fieldName, fieldValue);
                }
            }

            public ArrayList<HashMap<String, String>> getRows() {
                return rows;
            }

            public Map<String, String> getRow(String rowId) throws IllegalAccessException {
                for (Map<String, String> row : rows) {
                    if (row.get("id") == rowId) {
                        return row;
                    }
                }
                throw new IllegalAccessException("There is no row with id equals to " + rowId);
            }
        }
    }
}
