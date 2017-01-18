package ya.sqlcmd.controller.command;

import ya.sqlcmd.ui.View;

public class Exit implements Command {

    private View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return command.equals("exit");
    }

    @Override
    public void process(String command) {
        view.write("До скорой встречи!");
        // system.exit() breaks tests
        throw new ExitException();
    }
}
