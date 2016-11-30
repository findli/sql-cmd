package ru.javajoy.jps.w6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Вектор строк с методами добавить, удалить, поиск по значению и индексу.
 * <p/>
 * Данный класс  реализует следующие методы: добавить, удалить, поиск по значению и индексу. Массив является строчным,
 * длина массива по умолчанию - 10 элементов.
 *
 * @author Артем
 */
public class Vector implements SequenceLines, Iterable {

    private int capacity;
    private int size;
    private String[] array;

    public Vector() {
        this(10);
    }

    public Vector(int capacity) {
        this.capacity = capacity;
        this.array = new String[this.capacity];
    }

    public int size() {
        return size;
    }

    //AZ Добавление элемента в конец массива
    @Override
    public void add(String value) {
        array[size] = value;
        size++;
    }

    //AZ Добавление элемента в середину массива
    @Override
    public void add(int index, String value) {

        System.arraycopy(array, 0, array, 0, index);
        System.arraycopy(array, index, array, index + 1, array.length - (index + 1));
        array[index] = value;

    }

    //AZ Поиск элемента
    @Override
    public String findByValue(String value) {

        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return array[i];
            }
        }
        return null;
    }

    //AZ Поиск элемента по индексу
    @Override
    public String findByIndex(int index) {
        return array[index];
    }

    //AZ Удаление элементов
    @Override
    public void remove(String value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                System.arraycopy(array, 0, array, 0, i);
                System.arraycopy(array, i + 1, array, i, array.length - (i + 1));
                size--;
            }
        }
    }

    public String toString() {
        return Arrays.toString(array);
    }

    public String get(int index) {
        return array[index];
    }

    @Override
    public Iterator iterator() {
        return new VectorIterator();
    }

    /**
     * Iterator
     * <p/>
     * В данном классе реализован метод Iterator для наполнения массива
     */
    class VectorIterator implements Iterator {

        private int position;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return array[position++];
            } else {
                throw new NoSuchElementException(String.format("Нет элемента по индексу", position));
            }
        }

        @Override
        public void remove() {
        }
    }

}
