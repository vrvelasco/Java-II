package remijan.m.class2.lecture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import remijan.m.class1.lecture.SystemTool;

public class Ex01_UnsynchronizedResource {

    public static void main(String[] args) {
        // ExecutorService is a built-in thread pool you can
        // use to execute many threads at a time without
        // exhausting system resources
        SystemTool.printf("Create thread pool%n");
        ExecutorService pool
            = Executors.newFixedThreadPool(6);

        // Create a shared resource has unsynchronized access
        // This threads my access the unsynchronized resource
        // whenever they want and are free to change the state
        // of any data regardless of what other threads are doing.
        UnsynchronizedResource r = new UnsynchronizedResource();

        SystemTool.printf("Add jobs to pool%n");
        pool.execute(() -> r.print());
        pool.execute(() -> r.print());
        pool.execute(() -> r.print());
        pool.execute(() -> r.print());

        SystemTool.printf("Shutdown thread pool%n");
        pool.shutdown();;

        SystemTool.printf("Good bye!%n");
    }
}
