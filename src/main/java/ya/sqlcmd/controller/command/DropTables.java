package ya.sqlcmd.controller.command;

import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.ui.View;

public class DropTables implements Command {

    private DatabaseManager manager;
    private View view;

    public DropTables(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("drop tables");
    }

    @Override
    public void process(String command) {
        try {
            manager.deleteAllTables();
            view.write("Все таблица были успешно удалены.");
        } catch (Exception e) {
            view.write("Все таблица не были успешно удалены.");
            e.printStackTrace();
        }

    }
}
