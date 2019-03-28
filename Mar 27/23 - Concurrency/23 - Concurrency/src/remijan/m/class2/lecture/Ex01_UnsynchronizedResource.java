package remijan.m.class2.lecture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex01_UnsynchronizedResource {

    public static void main(String[] args) {
        // ExecutorService is a built-in thread pool you can
        // use to execute many threads at a time without
        // exhausting system resources
        System.out.printf("Create thread pool%n");
        ExecutorService pool
            = Executors.newFixedThreadPool(6);
        
        // Create a shared resource which need synchronized access
        UnsynchronizedResource r = new UnsynchronizedResource();
        
        System.out.printf("Add jobs to pool%n");
        
        pool.execute(() -> r.print());
        pool.execute(() -> r.print());
        pool.execute(() -> r.print());
        pool.execute(() -> r.print());
    }
}
