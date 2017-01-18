package ya.sqlcmd.controller.command;

import ya.sqlcmd.controller.command.helper.StringCommandParser;
import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.ui.View;

public class Connect implements Command {

    private static String COMMAND_SAMPLE = "connect|sqlcmd|postgres|postgres";

    private DatabaseManager manager;
    private View view;

    public Connect(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("connect|");
    }

    @Override
    public void process(String command) {
        String[] data = new String[0];
        try {
            data = StringCommandParser.parse(command, StringCommandParser.NOT_EQUAL, 4);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("Ожидается, например: '%s'.", COMMAND_SAMPLE), e);
        }
        String databaseName = data[1];
        String userName = data[2];
        String password = data[3];

        try {
            manager.connect(databaseName, userName, password);
            view.write("Успех!");
        } catch (Exception e) {
            view.write("Не удалось установить коннект к базе!");
            e.printStackTrace();
        }

    }
}
