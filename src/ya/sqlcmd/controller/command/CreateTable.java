package ya.sqlcmd.controller.command;

import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.ui.View;

import java.util.HashMap;
import java.util.LinkedList;

public class CreateTable implements Command {

    private final DatabaseManager manager;
    private final View view;

    public CreateTable(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("create|");
    }

    @Override
    public void process(String command) {
        String[] data = command.split("\\|");

        String tableName = data[1];

        if (data.length < 3 ) {
            throw new IllegalArgumentException(String.format("В таблице должно быть" +
                    "хотя бы одно поле. " +
                    "'insert|tableName|column1|column2|...|columnN', " +
                    "а ты прислал: '%s'", command));
        }
        LinkedList<String> fieldsOfNewTable = new LinkedList<String>();
        for (int index = 2; index < data.length; index++) {
            fieldsOfNewTable.add(data[index]);
        }
        try {
            manager.create(tableName, fieldsOfNewTable);
        } catch (Exception e) {
            e.printStackTrace();
        }

        view.write(String.format("Таблица %s была успешно создана с полями: '%s'.", tableName, fieldsOfNewTable.toString()));
    }
}
