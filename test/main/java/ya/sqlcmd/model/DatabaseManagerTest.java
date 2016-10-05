package ya.sqlcmd.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by indigo on 21.08.2015.
 */
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
    public void testGetAllTableNames() {
        String[] tableNames = manager.getTableNames();
        assertEquals("[user, test]", Arrays.toString(tableNames));
    }

    @Test
    public void testGetTableData() {
        // given
        manager.clear("user");

        // when
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
        // then
        Map<String, String>[] users = manager.getTableData("user");
        assertEquals(1, users.length);

        Map<String, String> user = users[0];
        assertEquals(user.get("name"), "Ivan");
        assertEquals(user.get("password"), "ivanPassword");
        assertEquals(user.get("id"), "1");
    }

    @Test
    public void testUpdateTableData() {
        // given
        manager.clear("user");

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
        manager.insertData("user", rows);
        manager.update("user", "1", rows);

        // then
        Map<String, String>[] users = manager.getTableData("user");
        assertEquals(1, users.length);

        Map<String, String> user = users[0];
        assertEquals(user.get("name"), "Ivan2");
        assertEquals(user.get("password"), "ivanPassword2");
        assertEquals(user.get("id"), "1");
    }

    @Test
    public void testGetColumnNames() {
        // given
        manager.clear("user");

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
