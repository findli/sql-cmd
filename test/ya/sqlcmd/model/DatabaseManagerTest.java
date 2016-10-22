package ya.sqlcmd.model;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public abstract class DatabaseManagerTest {

    //    private DatabaseManager manager;
    protected DatabaseManager manager;

    @Before
    public void setup() {
        manager = getDatabaseManager();
        manager.connect("sqlcmd", "postgres", "postgres");
    }

    public abstract DatabaseManager getDatabaseManager();

    @Test
    public void createTable() throws Exception {
        manager.deleteAllTables();
        LinkedList<String> fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("email");
        try {
            manager.create("user", fields);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<String> tableNames = manager.getTableNames();

        assertEquals(Arrays.toString(tableNames.toArray(new String[tableNames.size()])), "[user]");
    }

    @Test(expected = Exception.class)
    public void testCantAddSameTableName() throws Exception {
        //given
        manager.deleteAllTables();
        //when
        LinkedList<String> fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("email");
        try {
            manager.create("user", fields);
        } catch (Exception e) {
        }
        fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("email");

        manager.create("user", fields);
        //then
    }

    @Test
    public void testGetAllTableNames() {
        LinkedList<String> fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("email");
        try {
            manager.create("user", fields);
        } catch (Exception e) {
            System.out.println(e);
        }
        fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("ts");
        try {
            manager.create("task", fields);
        } catch (Exception e) {
            System.out.println(e);
        }

        Set<String> tableNames = manager.getTableNames();
        assertEquals("[user, task]", Arrays.toString(tableNames.toArray(new String[tableNames.size()])));
    }

    @Test
    public void testClearTable() throws Exception {
        LinkedList<String> fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("email");
        try {
            manager.create("user", fields);
        } catch (Exception e) {
            e.printStackTrace();
        }

        manager.clear("user");


    }

    @Test
    public void testGetTableData() {
        // given
        manager.deleteAllTables();
        // manager
        LinkedList<String> fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("password");
        try {
            manager.create("user", fields);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // when
        HashMap<String, String> rows = new HashMap<String, String>();
        rows.put("name", "Ivan");
        rows.put("password", "ivanPassword");
        rows.put("id", "1");
        manager.insertData("user", rows);
        // then
        ArrayList users = manager.getTableData("user");
        System.out.println(users);
        assertEquals(1, users.size());

        Map<String, String> user = (Map<String, String>) users.iterator().next();
        assertEquals(user.get("name"), "Ivan");
        assertEquals(user.get("password"), "ivanPassword");
        assertEquals(user.get("id"), "1");
    }

    @Test
    public void testUpdateTableData() {
        // given
        manager.deleteAllTables();

        LinkedList<String> input = new LinkedList<String>();
        input.add("name");
        input.add("password");
        input.add("id");
        try {
            manager.create("user", input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, String> rows = new HashMap<String, String>();
        rows.put("name", "Ivan");
        rows.put("password", "ivanPassword");
        rows.put("id", "1");
        manager.insertData("user", rows);

        // when
        rows = new HashMap<String, String>();
        rows.put("name", "Ivan2");
        rows.put("password", "ivanPassword2");
        manager.update("user", "1", rows);

        // then
        ArrayList users = manager.getTableData("user");
        assertEquals(1, users.size());

        Map<String, String> user = (Map<String, String>) users.iterator().next();
        assertEquals(user.get("name"), "Ivan2");
        assertEquals(user.get("password"), "ivanPassword2");
        assertEquals(user.get("id"), "1");
    }

    @Test
    public void testGetColumnNames() {
        // given
        manager.deleteAllTables();

        LinkedList<String> input = new LinkedList<String>();
        input.add("name");
        input.add("password");
        input.add("id");
        try {
            manager.create("user", input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // when
        String[] columnNames = manager.getTableColumns("user");

        // then
        assertEquals("[name, password, id]", Arrays.toString(columnNames));
    }

    @Test
    public void testisConnected() {
        // given
        // when
        // then
        assertTrue(manager.isConnected());
    }
}
