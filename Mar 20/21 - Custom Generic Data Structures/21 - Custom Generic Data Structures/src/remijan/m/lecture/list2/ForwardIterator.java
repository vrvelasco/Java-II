package remijan.m.lecture.list2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardIterator<T> implements Iterator<T> {

    MyListNode<T> next;

    public ForwardIterator(MyListNode<T> first) {
        next = first;
    }

    @Override
    public boolean hasNext() {
        boolean retval = next != null;
        return retval;
    }

    @Override
    public T next() {
        if (next == null) {
            throw new NoSuchElementException();
        } else {
            T retval = next.getData();
            next = next.getNext();
            return retval;
        }
    }
}
