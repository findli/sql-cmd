package ru.javajoy.jps.w6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Список строк с методами добавить, удалить, поиск по значению и индексу.
 * <p/>
 * Данный класс  реализует следующие методы: добавить, удалить, поиск по значению и индексу. Массив является строчным.
 *
 * @author Артем
 */
public class ListInt implements SequenceLines, Iterable {

    protected Node head;
    private Node node = head;
    private int size;

    @Override
    public void add(String value) {

        if (head == null) {
            head = new Node(value, null);
            size++;
            return;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(value, null);

    }

    /**
     * @param index
     * @param value
     * @throws java.lang.NullPointerException - возможен если cur == null
     */
    @Override
    public void add(int index, String value) {

        Node node = get(index);

        if (head != null) {
            if (size == index) {
                while (node.next != null) {
                    node = node.next;
                }
            }

            Node cur = head;
            Node prev = null;
            size = 0;

            while (cur != null && size != index) {
                prev = cur;
                cur = cur.next;
                size++;
            }
            if (cur != null) {
                prev.next = new Node(value, cur);
            }
        }
    }

    @Override
    public String findByValue(String value) {

        Node node = head;
        int i = 1;

        while (node != null && node.value != value) {
            node = node.next;
            i++;
        }
        return node == null ? null : node.value;

    }

    @Override
    public String findByIndex(int index) {

        Node node;
        int i = 0;

        for (node = head; node != null && i != index; node = node.next) {
            i++;
        }
        return node == null ? null : node.value;
    }

    @Override
    public void remove(String value) {

        Node node = head;
        int i = 1;

        while (node != null && node.value != value) {
            node = node.next;
            i++;

        }
        node = get(i);

        if (node != null) {
            if (node.equals(head)) {
                if (head.next != null) {
                    head.next = null;
                    node.next = null;
                    size--;
                } else {
                    head = null;
                    size = 0;
                }
            } else {
                Node nodeBefore = get(i - 1);
                nodeBefore.next = node.next;
                node.next = null;
                size--;
            }
        }
    }

    public Node get(int index) {

        size = 1;

        if (index < 0) {
            throw new IndexOutOfBoundsException("Недействительный индекс" + index);
        }
        if (!isEmpty()) {
            Node current = head;
            int i = index;
            while (current.next != null && i != 0) {
                current = current.next;
                i--;
                size++;
            }
            if (i != 0) {
                throw new IndexOutOfBoundsException("Нет элемента по индексу " + index);
            } else {
                return current;
            }
        } else {
            throw new IndexOutOfBoundsException("Нет элемента по индексу " + index);
        }
    }

    public boolean isEmpty() {
        return size == 0 || head == null;
    }

    public void revomeNode(int index) {

        final Node node = get(index);

        if (node != null) {
            if (node.equals(head)) {
                if (head.next != null) {
                    head = head.next;
                    node.next = null;
                    size--;
                } else {
                    head = null;
                    size = 1;
                }
            } else {
                Node nodeBefore = get(index - 1);
                nodeBefore.next = node.next;
                node.next = null;
                size--;
            }

        }
    }

    public Iterator iterator() {
        return new ListIterator();
    }

    public static class Node {

        protected Node next = null;
        private String value = null;

        Node(String index, Node next) {
            this.value = index;
            this.next = next;
        }

        public Node(Node next, String value) {
            this.next = next;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    /**
     * Iterator
     * <p/>
     * В данном классе реализован метод Iterator для наполнения списка
     */
    public class ListIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return head != null;

        }

        @Override
        public Object next() {

            if (hasNext()) {
                String headTemp = head.value;
                head = head.next;
                return headTemp;
            }
            throw new NoSuchElementException("Элементы отсутствуют");
        }

        @Override
        public void remove() {

        }
    }

}





