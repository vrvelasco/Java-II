package remijan.m.lecture.list3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReverseIterator<T> implements Iterator<T> {

    MyListNode<T> previous;

    public ReverseIterator(MyListNode<T> last) {
        previous = last;
    }

    @Override
    public boolean hasNext() {
        boolean retval = previous != null;
        return retval;
    }

    @Override
    public T next() {
        if (previous == null) {
            throw new NoSuchElementException();
        } else {
            T retval = previous.getData();
            previous = previous.getPrevious();
            return retval;
        }
    }
}
