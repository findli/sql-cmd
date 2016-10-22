package ya.sqlcmd.controller.command;

import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.ui.View;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Insert implements Command {

    private final DatabaseManager manager;
    private final View view;

    public Insert(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("insert|");
    }

    @Override
    public void process(String command) {
        String[] data = command.split("\\|");
        if (data.length % 2 != 0) {
            throw new IllegalArgumentException(String.format("Должно быть четное " +
                    "количество параметров в формате " +
                    "'insert|tableName|column1|column2|...|columnN', " +
                    "а ты прислал: '%s'", command));
        }

        String tableName = data[1];

        LinkedHashMap<String, String> fieldsWithValues = new LinkedHashMap<>();
        for (int index = 1; index < (data.length / 2); index++) {
            String columnName = data[index * 2];
            String value = data[index * 2 + 1];

            fieldsWithValues.put(columnName, value);
        }
        manager.insertData(tableName, fieldsWithValues);
        view.write(String.format("Запись %s была успешно создана в таблице '%s'.", fieldsWithValues, tableName));
    }
}
