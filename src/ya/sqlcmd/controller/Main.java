package ya.sqlcmd.controller;

import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.model.JDBCDatabaseManager;
import ya.sqlcmd.ui.View;
import ya.sqlcmd.ui.Console;

public class Main {
    // TODO: 24.10.16 other in memory db like sql lite and H2
    public static void main(String[] args) {
        View view = new Console();
        // TODO: 22.10.16 implement strategy
        DatabaseManager manager = new JDBCDatabaseManager();

        MainController controller = new MainController(view, manager);
        controller.run();
    }
}
