package ya.sqlcmd.controller;

import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.model.JDBCDatabaseManager;
import ya.sqlcmd.ui.View;
import ya.sqlcmd.ui.Console;

public class Main {
    public static void main(String[] args) {
        View view = new Console();
        // TODO: 22.10.16 implement strategy
        DatabaseManager manager = new JDBCDatabaseManager();

        MainController controller = new MainController(view, manager);
        controller.run();
    }
}
