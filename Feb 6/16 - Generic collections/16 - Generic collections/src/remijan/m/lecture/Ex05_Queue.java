package remijan.m.lecture;

import java.util.LinkedList;
import java.util.Queue;

public class Ex05_Queue {

    public static void main(String[] args) {
        
        // A queue is a First In First Out (FIFO) data structure. If you've ever
        // waited in line, then you know what a queue is.
        // It has these basic operations
        //   offer (aka enqueue, add object to the end of the line)
        //   peek  (get object at the front of the line but don't remove it)
        //   poll  (aka dequeue, get object at the front of th eline and remove it)
        Queue<String> queue = new LinkedList<>();

        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");

        System.out.printf("Size: %d%n", queue.size());

        String peek = queue.peek();
        System.out.printf("peek: %s%n", peek);
        System.out.printf("Size: %d%n", queue.size());

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            System.out.printf("POLL: %s  %d%n", poll, queue.size());
        }

    }
}
