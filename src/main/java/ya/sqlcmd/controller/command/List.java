package ya.sqlcmd.controller.command;

import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.ui.View;

import java.util.Arrays;
import java.util.Set;

public class List implements Command {

    private DatabaseManager manager;
    private View view;

    public List(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.equals("list");
    }

    @Override
    public void process(String command) {
        Set<String> tableNames = null;
        try {
            tableNames = manager.getTableNames();
            view.write(format(tableNames));
        } catch (Exception e) {
            view.write("Ошибка при отображении списка таблиц.");
            e.printStackTrace();
        }

    }

    private String format(Set<String> tableNames) {
        return Arrays.toString(tableNames.toArray(new String[tableNames.size()]));
    }
}
