package ru.javajoy.jps.w9;

import java.util.Map;
import java.util.TreeMap;

public final class Diary {

    public static final String ADD = "add";
    public static final String GET = "get";
    public static final String REMOVE = "remove";

    private final Map<Time, Record> diary = new TreeMap<>();
    private int status = 0;

    public static final int STATUS_OK = 0;
    public static  final int STATUS_ERROR = 1;
    public static final int STATUS_GET_INPUT = 2;
    public static final int STATUS_REMOVE_COMPLETE = 3;

    public Diary(Demo demo) {
        new CheckInput(demo);
    }

    public Record command(String note, Time time, String cmd) {
        changeStatus(cmd);changeStatus(cmd);
        switch (cmd) {
            case Diary.GET:
                return diary.get(time);
            case Diary.REMOVE:
                diary.remove(time);
                break;
            default:
                diary.put(time, new Record(note));
        }

        return null;
    }

    private int changeStatus(String cmd) {
        switch (cmd) {
            case Diary.ADD:
                setStatus(STATUS_OK);
                break;
            case Diary.GET:
                setStatus(STATUS_GET_INPUT);
                break;
            case Diary.REMOVE:
                setStatus(STATUS_REMOVE_COMPLETE);
                break;
        }
        return getStatus();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class CheckInput {

        private static final int HOUR = 23;
        private static final int SECOND_MINUTE = 60;
        private static final int ZERO = 0;
        private final Demo demo;

        public CheckInput(Demo demo) {
            this.demo = demo;
        }

        //Распределение введеного времени в формате ЧЧ:ММ:СС
        public static Time readTime(String str2[]) {
            Time time;
            int hour = 0;
            int minute = 0;
            int second = 0;
            for (int count = 0; count < 3; count++) {
                if (isNumber(str2[count])) {
                    if (count == 0) {
                        hour = Integer.parseInt(str2[count]);
                        if (hour > HOUR) {
                            return null;
                        }
                    }
                    if (count == 1) {
                        minute = Integer.parseInt(str2[count]);
                    } else if (count == 2) {
                        second = Integer.parseInt(str2[count]);
                    }
                } else {
                    return null;
                }
            }
            time = new Time(hour, minute, second);
            return time;
        }

        //Проверка на ввод числа
        public static boolean isNumber(String str) throws NumberFormatException {
            int inputTime = -1;
            try {
                inputTime = Integer.parseInt(str);
            } catch (NumberFormatException ignored) {

            } finally {
                if (inputTime < ZERO || inputTime > SECOND_MINUTE) {
                    return false;
                }
            }
            return true;
        }
    }
}
