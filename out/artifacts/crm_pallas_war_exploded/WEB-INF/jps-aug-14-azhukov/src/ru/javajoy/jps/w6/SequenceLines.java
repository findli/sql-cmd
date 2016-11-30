package ru.javajoy.jps.w6;

public interface SequenceLines {

    void add(String value);

    void add(int index, String value);

    String findByValue(String value);

    String findByIndex(int index);

    void remove(String value);


}
