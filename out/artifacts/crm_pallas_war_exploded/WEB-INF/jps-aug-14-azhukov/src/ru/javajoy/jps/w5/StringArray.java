package ru.javajoy.jps.w5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArray {

    private String[] stringArray;
    private int size;
    private Condition condition;

    public StringArray(int capacity) {
        int capacity1 = capacity;
        this.stringArray = new String[capacity1];
    }

    //AZ добавление элементов
    public void add(String word) throws Exception {

        if (size >= stringArray.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс за пределами массива");
        }

        if (word.length() < 3) {
            throw new Exception("Минимум должно быть 3 символа в слове " + '"' + word + "'");

        }
        stringArray[size] = word;
        size++;
    }

    //AZ удаление элементов
    public String remove(int index) {

        for (int i = 0; i < size; i++) {
            if (i == index) {
                System.arraycopy(stringArray, 0, stringArray, 0, i);
                System.arraycopy(stringArray, i + 1, stringArray, i, stringArray.length - (i + 1));
                size--;
                return stringArray[i];
            }
        }
        return null;
    }

    //AZ изменение элементов по индексу
    public void change(int index, String newWord) {

        if ((index < 0) || (index > stringArray.length)) {
            throw new ArrayIndexOutOfBoundsException("Выход за рамки маасива");
        }
        stringArray[index] = newWord;
    }

    //AZ поиск по элементу
    public String find(String word) throws ExceptionCheckCondition {

        if (word.equals("")) {
            throw new ExceptionCheckCondition("Условие невозможно проверить");
        }
        for (int i = 0; i < size; i++) {
            if (stringArray[i].equals(word)) {
                return stringArray[i];
            }
        }
        return null;
    }

    //AZ  итератор
    public Iterator<String> iterator() {
        return new MyIterator();
    }

    public void setCondition(Condition condition) {
        this.condition = condition;

    }

    public int getSize() {
        return size;
    }

    public String get(int index) {
        return stringArray[index];
    }

    public class MyIterator implements Iterator<String> {
        private int cursor = -1;

        @Override
        public boolean hasNext() {

            if (cursor == size - 1) {
                return false;
            } else {
                cursor++;
                while (condition.check(stringArray[cursor])) {
                    return true;

                }
            }
            return hasNext();

        }

        @Override
        public String next() {

            if (cursor < size) {
                return stringArray[cursor];
            } else {
                throw new NoSuchElementException("Нет больше элементов. И такое бывает.");
            }

        }

        @Override
        public void remove() {

        }
    }

}
