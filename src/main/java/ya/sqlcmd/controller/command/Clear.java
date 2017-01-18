package ya.sqlcmd.controller.command;

import ya.sqlcmd.controller.command.helper.StringCommandParser;
import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.ui.View;

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
    public void process(String command) throws Exception {
        String[] data;
        try {
            data = StringCommandParser.parse(command, StringCommandParser.NOT_EQUAL_TWO);
        } catch (IllegalArgumentException e) {
            throw new Exception("Ожидался следующий формат команды: 'clear|tableName'.", e);
        }
        String tableName = data[1];
        try {
            manager.clear(tableName);
            view.write(String.format("Таблица %s была успешно очищена.", tableName));
        } catch (Exception e) {
            view.write(String.format("Таблица %s не была успешно очищена.", tableName));
        }

    }
}
