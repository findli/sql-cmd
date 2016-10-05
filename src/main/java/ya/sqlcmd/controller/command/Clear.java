package ya.sqlcmd.controller.command;

import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.view.View;

public class Clear implements Command {

    private DatabaseManager manager;
    private View view;

    public Clear(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("clear|");
    }

    @Override
    public void process(String command) {
        String[] data = command.split("\\|");
        if (data.length != 2) {
            throw new IllegalArgumentException("Формат команды 'clear|tableName', а ты ввел: " + command);
        }
        manager.clear(data[1]);

        view.write(String.format("Таблица %s была успешно очищена.", data[1]));
    }
}
