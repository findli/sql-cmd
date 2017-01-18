package ya.sqlcmd.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class InMemoryDatabaseManagerTest extends DatabaseManagerTest {

    @Override
    public DatabaseManager getDatabaseManager() {
        return new InMemoryDatabaseManager();
    }

    @Test
    public void testDeleteAllTables() throws Exception {
        //given
        LinkedList<String> fields = new LinkedList<String>() {
        };
        manager.create("user", fields);
        manager.create("task", fields);

        // when
        manager.deleteAllTables();

        //then
        assertEquals(manager.getTableNames().size(), 0);
    }

    @Test
    public void testRemoveTable() throws Exception {
        //given - инициализация зависимостей
        manager.deleteAllTables();
        LinkedList<String> fields = new LinkedList<String>() {
        };
        manager.create("user", fields);

        //when - проверяемая логика

        manager.delete("user");

        //then - проверка правильного выполнения логики
        Set<String> tableNames = manager.getTableNames();
        assertEquals("[]", Arrays.toString(tableNames.toArray(new String[tableNames.size()])));
    }
}
