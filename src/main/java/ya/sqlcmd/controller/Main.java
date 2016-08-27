package ya.sqlcmd.controller;

import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.model.JDBCDatabaseManager;
import ya.sqlcmd.view.View;
import ya.sqlcmd.view.Console;

/**
 * Created by indigo on 25.08.2015.
 */
public class Main {

    public static void main(String[] args) {
        View view = new Console();
        DatabaseManager manager = new JDBCDatabaseManager();

        MainController controller = new MainController(view, manager);
        controller.run();


    }
}
