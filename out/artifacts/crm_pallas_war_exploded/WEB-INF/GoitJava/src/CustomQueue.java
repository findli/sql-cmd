import java.util.*;

public class CustomQueue<E> implements Queue<E> {

    private int length = 2;
    private int size = 0;
    private LinkedList<E> someQueue;

    public CustomQueue(int length) {
        this.length = length;
        someQueue = new LinkedList<>();
    }

    public CustomQueue() {
        someQueue = new LinkedList<>();
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static void main(String[] args) {

        CustomQueue<String> customQueue = new CustomQueue<>(2);
        customQueue.offer("One");
        customQueue.offer("Two");
        customQueue.offer("Three");
        System.out.println(customQueue.toString());

    }

    private static void testApp() {
        CustomQueue<Integer> customQueue = new CustomQueue<>(2);
        customQueue.offer(1);
        System.out.println(customQueue);
        customQueue.offer(2);
        customQueue.offer(3);
        customQueue.offer(4);
        System.out.println(customQueue);

        System.out.println(customQueue.element());
        customQueue.clear();
        System.out.println(customQueue.element());
    }


    @Override
    public boolean offer(E addLastElement) {
        if (size < length ) {
            size++;
        } else {
            someQueue.removeFirst();
        }
        someQueue.addLast(addLastElement);
        return true;
    }


    //Retrieves and removes the head of this queue, or returns null if this queue is empty.
    @Override
    public E poll() {
        if (size == 0) {
            return null;
        } else {
            E result = someQueue.getFirst();
            someQueue.removeFirst();
            return result;
        }
    }

    @Override
    public void clear() {
        someQueue.clear();
        size = 0;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        } else {
            return someQueue.getFirst();
        }
    }


    @Override
    public E element() {
        if (size == 0) {
            System.err.println("\t There is no element in the queue");
            throw new NoSuchElementException();
        } else {
            return someQueue.getFirst();
        }
    }

    public String toString() {
        return someQueue.toString();
    }


/*========elements not to be implemented===============*/

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

}
