package remijan.m.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class PriorityQueue<T extends Comparable<T>> {

    private List<T> q;

    public PriorityQueue() {
        q = new LinkedList<>();
    }

    public void enqueue(T t) {
        q.add(t);
        Collections.sort(q);
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
