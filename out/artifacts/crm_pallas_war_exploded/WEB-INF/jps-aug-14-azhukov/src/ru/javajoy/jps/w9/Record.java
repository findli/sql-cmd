package ru.javajoy.jps.w9;

public final class Record {

    private static String note;

    public Record(String note) {
        Record.note = note;
    }

    @Override
    public String toString() {
        return "Note='" + note + '\'';
    }

}
