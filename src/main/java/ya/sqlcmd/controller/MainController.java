package ya.sqlcmd.controller;

import ya.sqlcmd.controller.command.*;
import ya.sqlcmd.model.DatabaseManager;
import ya.sqlcmd.ui.View;

public class MainController {

    private Command[] commands;
    private View view;

    public MainController(View view, DatabaseManager manager) {
        this.view = view;
        this.commands = new Command[] {
                new Connect(manager, view),
                new Help(view),
                new Exit(view),
                new IsConnected(manager, view),
                new List(manager, view),
                new DropTables(manager, view),
                new Insert(manager, view),
                new Clear(manager, view),
                new CreateTable(manager, view),
                new Find(manager, view),
                new Unsupported(view)
        };
    }

    public void run() {
        try {
            doWork();
        } catch (ExitException e) {
            // system.exit() breaks tests
            // do nothing
        }
    }

    private void doWork() throws ExitException {
        view.write("Привет юзер!");
        view.write("Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password");

        while (true) {
            String input = view.read();

            for (Command command : commands) {
                try {
                    if (command.canProcess(input)) {
                        command.process(input);
                        break;
                    }
                } catch (Exception e) {
                    if (e instanceof ExitException) {
                        throw new ExitException();
                    }
                    printError(e);
                    break;
                }
            }
            view.write("Введи команду (или help для помощи):");
        }
    }

    private void printError(Exception e) {
        String message = e.getMessage();
        Throwable cause = e.getCause();
        if (cause != null && cause.getMessage().length() != 0) {
            message = String.format(message + "%n" + cause.getMessage());
        }
        view.write(String.format("Неудача!%n%s", message));
        view.write("Повтори попытку.");
    }

}
