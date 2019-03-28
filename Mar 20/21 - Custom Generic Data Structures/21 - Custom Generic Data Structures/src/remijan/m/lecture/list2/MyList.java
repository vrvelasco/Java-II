package remijan.m.lecture.list2;

import java.util.Iterator;
import java.util.StringJoiner;

public class MyList<T> {

    private MyListNode<T> first;
    private MyListNode<T> last;

    public MyList() {
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void add(T data) {
        MyListNode<T> node = new MyListNode<>(data);

        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        MyListNode<T> n = first;
        while (n != null) {
            sj.add(String.valueOf(n.getData()));
            n = n.getNext();
        }
        return sj.toString();
    }

    public Iterator<T> iterator() {
        return new ForwardIterator<>(first);
    }

}
