package ya.sqlcmd.model;

import java.util.*;

public class InMemoryDatabaseManager implements DatabaseManager {

    public static final String TABLE_NAME = "user"; // TODO implement multitables
    private DataSet[] data = new DataSet[1000];
    private int freeIndex = 0;
    private InMemoryDatabaseManager.DataBase dataBase = this.new DataBase();

    @Override
    public DataSet[] getTableData(String tableName) {
        validateTable(tableName);

        return Arrays.copyOf(data, freeIndex);
    }

    private void validateTable(String tableName) {
        LinkedList<String> fiedls = new LinkedList<>();
        fiedls.add(0, "id");
        fiedls.add(0, "name");
        fiedls.add(0, "password");
        dataBase.createTable("user", fiedls);

//        if (!"user".equals(tableName)) {
//        if (tableName != "user") {
//            throw new UnsupportedOperationException("Only for 'user' table, but you try to work with: " + tableName);
//        }
    }

    @Override
    public String[] getTableNames() {
        return new String[]{TABLE_NAME, "test"};
    } // TODO to remove test

    @Override
    public void connect(String database, String userName, String password) {
        // do nothing
    }

    @Override
    public void clear(String tableName) {
//        validateTable(tableName);

        data = new DataSet[1000];
        freeIndex = 0;
    }

    @Override
    public void delete(String tableName) {
        System.out.println(freeIndex);
        for (int index = 0; index < freeIndex; index++) {
            System.out.println(data[index]);
        }
    }

    @Override
    public void create(String tableName, DataSet input) {
        insertData(tableName, input);

        validateTable(tableName);

        data[freeIndex] = input;
        freeIndex++;
    }

    public void insertData(String tableName, DataSet rows) {
//        Array rows = Arrays.asList(rows);
//        this.dataBase.insert(tableName, rows);
    }

    @Override
    public void update(String tableName, int id, DataSet newValue) {
        validateTable(tableName);

        for (int index = 0; index < freeIndex; index++) {
//            if (data[index].get("id").equals((Object) id)/* == id*/) {// not correct!!!
            if ((int) data[index].get("id") == id) {
                data[index].updateFrom(newValue);
            }
        }
    }

    @Override
    public String[] getTableColumns(String tableName) {
        return new String[]{"name", "password", "id"};
    }

    @Override
    public boolean isConnected() {
        return true;
    }

    final class DataBase {
        private HashSet<Table> tables;

        public void createTable(String tableName, LinkedList<String> fields) {
            Table table = new Table(tableName, fields);
            if (this.tables.contains(table)) {
                this.tables.remove(table);
            }
            this.tables.add(table);
        }

        public void deleteTable(String tableName) throws IllegalAccessException {
            this.tables.remove(this.getTable(tableName));
        }

        public void insert(String tableName, HashMap<String, String> row) throws IllegalAccessException {
            this.getTable(tableName).insert(row);
        }

        public void update(String tableName, HashMap<String, String> newValues, int rowId) throws IllegalAccessException {
            this.getTable(tableName).update(newValues, rowId);
        }

        private Table getTable(String tableName) throws IllegalAccessException {
            for (Table table : this.tables) {
                if (table.getName() == tableName) {
                    return table;
                }
            }
            throw new IllegalAccessException("There is no table named: " + tableName);
        }

        final class Table {
            protected String name;
            protected LinkedList<String> fields;
            protected Map<String, String>[] rows = new HashMap[]{};

            public Table(final String tableName, final LinkedList<String> fields) {
                this.name = tableName;
                this.fields = fields;
            }

            public void clear(String tableName) {
                this.rows = new HashMap[]{};
                for (Map<String, String> row : this.rows) {
                    row = null;
                }
            }

            public String getName() {
                return name;
            }

            public void insert(HashMap<String, String> row) {
                this.rows[this.rows.length] = row;
            }

            public void update(HashMap<String, String> newValues, int rowId) throws IllegalAccessException {
                HashMap<String, String> row = getRow(rowId);

                for (String fieldName : newValues.keySet()) {
                    String fieldValue = newValues.get(fieldName);

                    row.remove(fieldName);
                    row.put(fieldName, fieldValue);
                }
            }

            private HashMap<String, String> getRow(int rowId) throws IllegalAccessException {
                for (HashMap<String, String> row : rows) {
                    if (row.get("id") == Integer.toString(rowId)) {
                        return row;
                    }
                }
                throw new IllegalAccessException("There is no row with id equals to " + rowId);
            }
        }
    }

}
