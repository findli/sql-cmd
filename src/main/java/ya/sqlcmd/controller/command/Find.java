package ya.sqlcmd.controller.command;

import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.ui.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Find implements Command {

    private DatabaseManager manager;
    private View view;

    public Find(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.startsWith("find|");
    }

    @Override
    public void process(String command) {
        String[] data = command.split("\\|");
        String tableName = data[1];

        String[] tableColumns = new String[0];
        try {
            tableColumns = manager.getTableColumns(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        printHeader(tableColumns);

        ArrayList tableData = null;
        try {
            tableData = manager.getTableData(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        printTable(tableData);
    }

    private void printTable(ArrayList<HashMap<String, String>> tableData) {
        for (HashMap<String, String> row : tableData) {
            printRow(row);
        }
        view.write("--------------------");
    }

    private void printRow(HashMap<String, String> row) {
        Collection<String> values = row.values();
        String result = "|";
        for (String value : values) {
            result += value + "|";
        }
        view.write(result);
    }

    private void printHeader(String[] tableColumns) {
        String result = "|";
        for (String name : tableColumns) {
            result += name + "|";
        }
        view.write("--------------------");
        view.write(result);
        view.write("--------------------");
    }
}
