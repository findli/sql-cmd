package task.abstractCollection;

/**
 * Created by Artem on 08.11.2016.
 */
import java.util.*;

public class MyQueue<E> extends MyAbstractCollection<E> implements Queue<E> {

    private final int CAPACITY;
    private E[] data;
    private int size;

    public MyQueue(int capacity) {
        this.CAPACITY = capacity;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean offer(E e) {
        if (size < CAPACITY) {
            data[size] = e;
            size++;
            return true;
        }
        if (size == CAPACITY) {
            System.arraycopy(data, 1, data, 0, size - 1);
            data[size - 1] = e;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        if (isEmpty()) {
            noElement();
        }
        for (int i = 0; i < size && !removed; i++) {
            if (o == null && data[i] == null || data[i].equals(o)) {
                System.arraycopy(data, i + 1, data, i, size - 1);
                size--;
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            noElement();
        }
        return poll();
    }

    @Override
    public E poll() {
        E removedElement;
        if (isEmpty()) {
            return null;
        } else {
            removedElement = data[0];
            System.arraycopy(data, 1, data, 0, size - 1);
            size--;
        }
        return removedElement;
    }

    @Override
    public E element() {
        if (isEmpty()) {
            noElement();
        }
        return data[0];
    }

    @Override
    public E peek() {
        E element;
        if (isEmpty()) {
            element = null;
        } else {
            element = data[0];
        }
        return element;
    }

    @Override
    public boolean add(Object o) {
        return offer((E) o);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public boolean addAll(Collection c) {
        E changedData[] = Arrays.copyOf(data, data.length);
        int newSize = size;
        if (c.size() > (CAPACITY - size - 1)) {
            return false;
        } else {
            try {
                for (Object elem : c) {
                    changedData[newSize++] = (E) elem;
                }
            } catch (ClassCastException e) {
                throw new IllegalArgumentException("Illegal type of elements!");
            }
            data = changedData;
            size = newSize;
            return true;
        }
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean modified = false;
        for (Object elem : c) {
            if (this.remove(elem) ) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < size; i++) {
            b.append(data[i].toString());
            if (i != size - 1) {
                b.append(", ");
            }
        }
        b.append(']');
        return b.toString();
    }

    @Override
    public void clear() {
        this.data = (E[]) new Object[data.length];
        size = 0;
    }

    private void noElement() {
        throw new NoSuchElementException("The Queue is empty!");
    }

    private class Itr<E> implements Iterator<E> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor + 1 <= size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                noElement();
            }
            return (E) data[cursor++];
        }

        @Override
        public void remove() {
            E[] newData = (E[]) Arrays.copyOf(data, data.length);
            cursor--;
            System.arraycopy(data, cursor + 1, data, cursor, data.length - cursor - 1);
            size--;
        }
    }
}