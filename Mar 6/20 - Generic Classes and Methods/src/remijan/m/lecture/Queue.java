package remijan.m.lecture;

import java.util.LinkedList;
import java.util.List;

////// This is an example of a generic class
////// Generic classes are defined following a pattern that looks like this:
//////
////// public class MyClassName<T> {...}
//////
////// Where:
//////    `<T>` is the type-parameter section.  There can be more than parameter separated by commas
//////    `T` can be used wherever it needs to be used in the class.
public class Queue<T> {

    private List<T> q;

    public Queue() {
        q = new LinkedList<>();
    }

    public void enqueue(T t) {
        q.add(t);
    }

    public T peek() {
        if (q.isEmpty()) {
            return null;
        } else {
            return q.get(0);
        }
    }

    public T dequeue() {
        T retval = peek();
        q.remove(0);
        return retval;
    }
    
    public boolean isEmpty() {
        return q.isEmpty();
    }

    public int size() {
        return q.size();
    }
}
