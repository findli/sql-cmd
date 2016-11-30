package ru.javajoy.jps.w9;

public class Dialog {

    private static final String ERROR_INPUT = "Error input";
    private static final String RECORD_COMPLETE = "Record complete";
    private static final String REMOVE_COMPLETE = "Remove complete";
    private static final String INPUT_NOTE = "Input note";
    private static final String GET_COMPLETE = "Complete";
    private Diary diary;

    public Dialog(Diary dia) {
        this.diary = dia;
    }

    public void onNewCommand(String cmd) throws ArrayIndexOutOfBoundsException {
        Time time;
        String[] command = cmd.split(" ");
        try {
            String[] timeString = command[1].split(":");
            cmd = command[0];
            time = Diary.CheckInput.readTime(timeString);
            if (time == null) {
                Demo.statusString(ERROR_INPUT);
            } else {
                switch (cmd) {
                    case Diary.ADD:
                        Demo.statusString(INPUT_NOTE);
                        diary.command(Demo.getInputLine(), time, cmd);
                        switch (diary.getStatus()) {
                            case Diary.STATUS_OK:
                                Demo.statusString(RECORD_COMPLETE);
                                break;
                            case Diary.STATUS_ERROR:
                                Demo.statusString(ERROR_INPUT);
                                break;
                        }
                        break;
                    case Diary.GET:
                        Record record = diary.command(null, time, cmd);
                        Demo.statusString(String.valueOf(record));
                        switch (diary.getStatus()) {
                            case Diary.STATUS_GET_INPUT:
                                Demo.statusString(GET_COMPLETE);
                                break;
                            case Diary.STATUS_ERROR:
                                Demo.statusString(ERROR_INPUT);
                                break;
                        }
                        break;
                    case Diary.REMOVE:
                        diary.command(null, time, cmd);
                        switch (diary.getStatus()) {
                            case Diary.STATUS_REMOVE_COMPLETE:
                                Demo.statusString(REMOVE_COMPLETE);
                                break;
                            case Diary.STATUS_ERROR:
                                Demo.statusString(ERROR_INPUT);
                                break;
                        }
                        break;
                    default:
                        Demo.statusString(ERROR_INPUT);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Demo.statusString(ERROR_INPUT);
        }
    }
}
