package ya.sqlcmd.model;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public abstract class DatabaseManagerTest {
    protected DatabaseManager manager;

    @Before
    public void setup() throws Exception {
        manager = getDatabaseManager();
        manager.connect("sqlcmd", "postgres", "postgres");
    }

    public abstract DatabaseManager getDatabaseManager();

    @Test
    public void createTable() throws Exception {
        // given
        manager.deleteAllTables();

        LinkedList<String> fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("email");
        manager.create("user", fields);

        // when
        Set<String> tableNames = manager.getTableNames();

        // then
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
        manager.create("user", fields);

        fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("email");
        manager.create("user", fields);

        //then
        // TODO: 30.12.16 assertion
    }

    @Test
    public void testGetAllTableNames() throws Exception {
        //given
        manager.deleteAllTables();

        // when
        LinkedList<String> fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("email");
        manager.create("user", fields);

        fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("ts");
        manager.create("task", fields);

        // then
        Set<String> tableNames = manager.getTableNames();
        assertEquals("[user, task]", Arrays.toString(tableNames.toArray(new String[tableNames.size()])));
    }

    @Test
    public void testClearTable() throws Exception {
        // given
        manager.deleteAllTables();

        LinkedList<String> fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("email");
        manager.create("user", fields);

        // when
        manager.clear("user");

        // then
        // TODO: 30.12.16 write assertion
    }

    @Test
    public void testGetTableData() throws Exception {
        // given
        manager.deleteAllTables();
        LinkedList<String> fields = new LinkedList<>();
        fields.add("id");
        fields.add("name");
        fields.add("password");
        manager.create("user", fields);

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
    public void testUpdateTableData() throws Exception {
        // given
        manager.deleteAllTables();

        LinkedList<String> input = new LinkedList<String>();
        input.add("name");
        input.add("password");
        input.add("id");
        manager.create("user", input);

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
    public void testGetColumnNames() throws Exception {
        // given
        manager.deleteAllTables();

        LinkedList<String> input = new LinkedList<String>();
        input.add("name");
        input.add("password");
        input.add("id");
        manager.create("user", input);

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
