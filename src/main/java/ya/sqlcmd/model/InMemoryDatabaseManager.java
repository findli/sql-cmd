package ya.sqlcmd.model;

import java.util.*;

public class InMemoryDatabaseManager implements DatabaseManager {

    public static final String TABLE_NAME = "user"; // TODO implement multitables
    private DataSet[] data = new DataSet[1000];
    private int freeIndex = 0;
    private InMemoryDatabaseManager.DataBase dataBase = this.new DataBase();

    @Override
    public HashMap<String, String>[] getTableData(String tableName) {
        DataBase.Table table = null;
        try {
            table = this.dataBase.getTable(tableName);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return table.getRows();
    }

    private void validateTable(String tableName) {
        // @todo implement
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
        // @todo implement
        this.dataBase.clear(tableName);
//        validateTable(tableName);

//        data = new DataSet[1000];
//        freeIndex = 0;
    }

    @Override
    public void delete(String tableName) {
        System.out.println(freeIndex);
        for (int index = 0; index < freeIndex; index++) {
            System.out.println(data[index]);
        }
    }

    @Override
    public void create(String tableName, LinkedList<String> fields) {
        this.dataBase.createTable(tableName, fields);

//        insertData(tableName, fields);

//        validateTable(tableName);

//        data[freeIndex] = input;
//        freeIndex++;
    }

    public void insertData(String tableName, HashMap<String, String> row) {
        try {
            this.dataBase.insert(tableName, row);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String tableName, String id, HashMap<String, String> newValue) {
        try {
            this.dataBase.update(tableName, newValue, id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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

        public void update(String tableName, HashMap<String, String> newValues, String rowId) throws IllegalAccessException {
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

        public void clear(String tableName) {
            try {
                Table table = this.getTable(tableName);
                table.clear();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        final class Table {
            protected String name;
            protected LinkedList<String> fields;
            protected HashMap<String, String>[] rows = new HashMap[]{};

            public Table(final String tableName, final LinkedList<String> fields) {
                this.name = tableName;
                this.fields = fields;
            }

            public void clear() {
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

            public void update(HashMap<String, String> newValues, String rowId) throws IllegalAccessException {
                Map<String, String> row = getRow(rowId);

                for (String fieldName : newValues.keySet()) {
                    String fieldValue = newValues.get(fieldName);

                    row.remove(fieldName);
                    row.put(fieldName, fieldValue);
                }
            }

            public HashMap<String, String>[] getRows() {
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
