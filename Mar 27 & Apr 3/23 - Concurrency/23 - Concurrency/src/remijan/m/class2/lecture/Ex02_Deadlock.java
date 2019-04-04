package remijan.m.class2.lecture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import remijan.m.class1.lecture.SystemTool;

public class Ex02_Deadlock {

    public static void main(String[] args) {

        // ExecutorService is a built-in thread pool you can
        // use to execute many threads at a time without
        // exhausting system resources
        SystemTool.printf("Create thread pool%n");
        ExecutorService pool
            = Executors.newFixedThreadPool(6);

        SystemTool.printf("Create DeadlockResource%n");
        DeadlockResource r = new DeadlockResource();

        SystemTool.printf("Add jobs to pool%n");
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

        SystemTool.printf("Shutdown thread pool%n");
        pool.shutdown();;

        SystemTool.printf("Good bye!%n");
    }
}
