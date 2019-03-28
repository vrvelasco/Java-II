package remijan.m.class1.lecture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex05_ExecutorService {

    public static void main(String[] args) {
        // ExecutorService is a built-in thread pool you can
        // use to execute many threads at the same time without
        // exhausting system resources
        SystemTool.printf("Create thread pool%n");
        ExecutorService pool
            = Executors.newFixedThreadPool(3);

        // Add Runnable objects to the pool to execute. Remember
        // The Runnable interface? There is only 1 method in the
        // Runnable interface: run(). Create a class (or lambda)
        // that implements this method and the ExecutorService
        // will eventually run it for you.
        SystemTool.printf("Add Runnable objects (jobs) to the thread pool%n");
        for (int i=1; i<=10; i++) {
            SystemTool.printf("Submit job #%d to the pool%n", i);
            pool.execute(new LongRunningJob((i)));
        }

        // Shutdown the pool. This means to finish running whatever
        // is currently in the pool and when finished to stop all
        // the threads.
        SystemTool.printf("Shutdown pool%n");
        pool.shutdown();

        // Good bye
        SystemTool.printf("Good bye!%n");
    }
}
