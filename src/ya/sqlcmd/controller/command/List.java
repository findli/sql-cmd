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
        Set<String> tableNames = manager.getTableNames();

        String message = Arrays.toString(tableNames.toArray(new String[tableNames.size()]));

        view.write(message);
    }
}
