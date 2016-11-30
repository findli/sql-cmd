package task.abstractCollection;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Rustam on 27.10.2016.
 */
abstract class MyAbstractCollection<E> implements Collection<E> {

    private int size;
    private E[] data;

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++){
                if (iterator().next() == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++){
                if (iterator().next().equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E[] toArray() {
        return data;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            return (E[]) Arrays.copyOf(data, size(), a.getClass());
        }
        System.arraycopy(data, 0, a, 0, data.length);
        if (a.length > size()) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean modified = false;
        E[] newData = (E[]) new Object[c.size()];
        int newSize = 0;
        if (!(c.size() == this.size && containsAll(c))) {
            for (E e : data) {
                if (c.contains(e)) {
                    newData[newSize] = e;
                    newSize++;
                }
            }
            if (newSize > 0) {
                data = newData;
                size = newSize;
                modified = true;
            }
        }
        return modified;
    }

}