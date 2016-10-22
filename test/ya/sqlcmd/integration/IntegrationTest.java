package ya.sqlcmd.integration;

import org.junit.Before;
import org.junit.Test;
import ya.sqlcmd.controller.Main;
import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.model.JDBCDatabaseManager;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    private ConfigurableInputStream in;
    private ByteArrayOutputStream out;
    private DatabaseManager databaseManager;

    @Before
    public void setup() {
        databaseManager = new JDBCDatabaseManager();
        out = new ByteArrayOutputStream();
        in = new ConfigurableInputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testHelp() {
        // given
        in.add("help");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // help
                "Существующие команды:\n" +
                "\tconnect|databaseName|userName|password\n" +
                "\t\tдля подключения к базе данных, с которой будем работать\n" +
                "\tlist\n" +
                "\t\tдля получения списка всех таблиц базы, к которой подключились\n" +
                "\tdrop tables\n" +
                "\t\tдля удаления всех таблиц.\n" +
                "\tclear|tableName\n" +
                "\t\tдля очистки всей таблицы\n" +
                "\tcreate|tableName|column1|value1|column2|value2|...|columnN|valueN\n" +
                "\t\tдля создания записи в таблице\n" +
                "\tinsert|tableName|column1|value1|column2|value2|...|columnN|valueN\n" +
                "\t\tдля создания записи в таблице\n" +
                "\tfind|tableName\n" +
                "\t\tдля получения содержимого таблицы 'tableName'\n" +
                "\thelp\n" +
                "\t\tдля вывода этого списка на экран\n" +
                "\texit\n" +
                "\t\tдля выхода из программы\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    public String getData() {
        try {
            String result = new String(out.toByteArray(), "UTF-8");
            out.reset();
            return result;
        } catch (UnsupportedEncodingException e) {
            return e.getMessage();
        }
    }

    @Test
    public void testExit() {
        // given
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testListWithoutConnect() {
        // given
        in.add("show tables");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // show tables
                "Вы не можете пользоваться командой 'show tables' пока не подключитесь с помощью комманды connect|databaseName|userName|password\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testFindWithoutConnect() {
        // given
        in.add("find|user");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // find|user
                "Вы не можете пользоваться командой 'find|user' пока не подключитесь с помощью комманды connect|databaseName|userName|password\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testUnsupported() {
        // given
        in.add("unsupported");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // unsupported
                "Вы не можете пользоваться командой 'unsupported' пока не подключитесь с помощью комманды connect|databaseName|userName|password\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testUnsupportedAfterConnect() {
        // given
        in.add("connect|sqlcmd|postgres|postgres");
        in.add("unsupported");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // connect
                "Успех!\n" +
                "Введи команду (или help для помощи):\n" +
                // unsupported
                "Несуществующая команда: unsupported\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testListAfterConnect() {
        // given
        in.add("connect|sqlcmd|postgres|postgres");
        in.add("drop tables");
        in.add("create|user|id|name|password");
        in.add("list");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // connect
                "Успех!\n" +
                "Введи команду (или help для помощи):\n" +
                "Все таблица были успешно удалены.\n" +
                "Введи команду (или help для помощи):\n" +
                "Таблица user была успешно создана с полями: '[id, name, password]'.\n" +
                "Введи команду (или help для помощи):\n" +
                // show tables
                "[user]\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testFindAfterConnect() {
        // given
        in.add("connect|sqlcmd|postgres|postgres");
        in.add("drop tables");
        in.add("create|user|id|name|password");
        in.add("find|user");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // connect
                "Успех!\n" +
                "Введи команду (или help для помощи):\n" +
                "Все таблица были успешно удалены.\n" +
                "Введи команду (или help для помощи):\n" +
                "Таблица user была успешно создана с полями: '[id, name, password]'.\n" +
                "Введи команду (или help для помощи):\n" +
                // find|user
                "--------------------\n" +
                "|id|name|password|\n" +
                "--------------------\n" +
                "--------------------\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testConnectAfterConnect() {
        // given
        in.add("connect|sqlcmd|postgres|postgres");
        in.add("drop tables");
        in.add("list");
        in.add("connect|sqlcmd|postgres|postgres");
        in.add("list");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // connect sqlcmd
                "Успех!\n" +
                "Введи команду (или help для помощи):\n" +
                "Все таблица были успешно удалены.\n" +
                "Введи команду (или help для помощи):\n" +
                // show tables
                "[]\n" +
                "Введи команду (или help для помощи):\n" +
                // connect test
                "Успех!\n" +
                "Введи команду (или help для помощи):\n" +
                // show tables
                "[]\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testConnectWithError() {
        // given
        in.add("connect|sqlcmd");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // connect sqlcmd
                "Неудача! по причине: Неверно количество параметров разделенных знаком '|', ожидается 4, но есть: 2\n" +
                "Повтори попытку.\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testFindAfterConnect_withData() {
        // given
//        databaseManager.connect("sqlcmd", "postgres", "postgres");
//
//        databaseManager.clear("user");
//
//        DataSet user1 = new DataSet();
//        user1.put("id", 13);
//        user1.put("name", "Stiven");
//        user1.put("password", "*****");
//        databaseManager.create("user", user1);
//
//        DataSet user2 = new DataSet();
//        user2.put("id", 14);
//        user2.put("name", "Eva");
//        user2.put("password", "+++++");
//        databaseManager.create("user", user2);

        in.add("connect|sqlcmd|postgres|postgres");
        in.add("drop tables");
        in.add("create|user|id|name|password");
        in.add("clear|user");
        in.add("insert|user|id|13|name|Stiven|password|*****");
        in.add("insert|user|id|14|name|Eva|password|+++++");
        in.add("find|user");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // connect
                "Успех!\n" +
                "Введи команду (или help для помощи):\n" +
                "Все таблица были успешно удалены.\n" +
                "Введи команду (или help для помощи):\n" +
                "Таблица user была успешно создана с полями: '[id, name, password]'.\n" +
                "Введи команду (или help для помощи):\n" +
                // clear|user
                "Таблица user была успешно очищена.\n" +
                "Введи команду (или help для помощи):\n" +
                // create|user|id|13|name|Stiven|password|*****
                "Запись {id=13, name=Stiven, password=*****} была успешно создана в таблице 'user'.\n" +
                "Введи команду (или help для помощи):\n" +
                // create|user|id|14|name|Eva|password|+++++
                "Запись {id=14, name=Eva, password=+++++} была успешно создана в таблице 'user'.\n" +
                "Введи команду (или help для помощи):\n" +
                // find|user
                "--------------------\n" +
                "|id|name|password|\n" +
                "--------------------\n" +
                "|13|Stiven|*****|\n" +
                "|14|Eva|+++++|\n" +
                "--------------------\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testClearWithError() {
        // given
        in.add("connect|sqlcmd|postgres|postgres");
        in.add("clear|sadfasd|fsf|fdsf");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // connect
                "Успех!\n" +
                "Введи команду (или help для помощи):\n" +
                // clear|sadfasd|fsf|fdsf
                "Неудача! по причине: Формат команды 'clear|tableName', а ты ввел: clear|sadfasd|fsf|fdsf\n" +
                "Повтори попытку.\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }

    @Test
    public void testCreateWithErrors() {
        // given
        in.add("connect|sqlcmd|postgres|postgres");
        in.add("drop tables");
        in.add("create|user|");
        in.add("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                // connect
                "Успех!\n" +
                "Введи команду (или help для помощи):\n" +
                "Все таблица были успешно удалены.\n" +
                "Введи команду (или help для помощи):\n" +
                // create|user|error
                "Неудача! по причине: В таблице должно бытьхотя бы одно поле. 'insert|tableName|column1|column2|...|columnN', а ты прислал: 'create|user|'\n" +
                "Повтори попытку.\n" +
                "Введи команду (или help для помощи):\n" +
                // exit
                "До скорой встречи!\n", getData());
    }
}
