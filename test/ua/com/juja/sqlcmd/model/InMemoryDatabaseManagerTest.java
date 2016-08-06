package ua.com.juja.sqlcmd.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by indigo on 25.08.2015.
 */
public class InMemoryDatabaseManagerTest extends DatabaseManagerTest {

    @Override
    public DatabaseManager getDatabaseManager() {
        return new InMemoryDatabaseManager();
    }

    @Test
    public void testRemove() {
        //given - инициализация зависимостей

//        DataSet fields = new DataSet();
//        fields.put("id", "");
//manager.create("user",  );
        String[] tableNames = manager.getTableNames();
        assertEquals("[user, test]", Arrays.toString(tableNames));
        //when - проверяемая логика

        DataSet row = new DataSet();
        row.put("name", "Stiven");
        row.put("password", "pass");
        row.put("id", 13);

        manager.insertData("user", row);
        manager.delete("user");
        //then - проверка правильного выполнения логики
    }
}
