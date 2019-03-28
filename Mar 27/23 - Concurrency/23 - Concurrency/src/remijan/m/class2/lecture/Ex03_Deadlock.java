package remijan.m.class2.lecture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex03_Deadlock {

    public static void main(String[] args) {
        
        // ExecutorService is a built-in thread pool you can
        // use to execute many threads at a time without
        // exhausting system resources
        System.out.printf("Create thread pool%n");
        ExecutorService pool
            = Executors.newFixedThreadPool(6);
        
        DeadlockResource r = new DeadlockResource();
        
        pool.execute(() -> {
            long l = 0;
            while (true) {
                r.oneTwo(++l);
            }
        });
        pool.execute(() -> {
            long l = 0;
            while (true) {
                r.twoOne(++l);
            }
        });
    }
}
