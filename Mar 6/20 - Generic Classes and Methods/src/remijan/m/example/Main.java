package remijan.m.example;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    
    public void run() {
        System.out.printf("Welcome to PriorityQueue%n%n");
        
        // Create reader object to get correct user input
        IntegerReader reader
            = new IntegerReader();
        
        // Create queue to hold user input
        PriorityQueue<Integer> queue
            = new PriorityQueue<>();
        
        // Read user input until the user indicates they want
        // to stop.  Each time the user enters input correctly
        // enqueue that input (integer) onto the queue.
        for (Integer i=reader.nextInteger(); i!=null; i=reader.nextInteger()) {
            queue.enqueue(i);
        }
        
        // Print the size of the queue
        System.out.printf("%nSize of queue = %d%n", queue.size());     
        
        // Print the contents of the queue by dequeue'ing all the values
        // They should be in priority order when dequeue'ed.
        while (!queue.isEmpty()) {
            System.out.printf("  %d%n", queue.dequeue());
        }
        
        System.out.printf("%nGood-bye!%n");
    }
}
