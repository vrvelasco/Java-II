package remijan.m.class1.lecture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex06_Synchronization {

    public static void main(String[] args) {
        // ExecutorService is a built-in thread pool you can
        // use to execute many threads at the same time without
        // exhausting system resources
        SystemTool.printf("Create thread pool%n");
        ExecutorService pool
            = Executors.newFixedThreadPool(6);

        // Create a shared resource which need synchronized access
        IntegerStore store = new IntegerStore();


        // Add consumer and producer jobs to the pool
        SystemTool.printf("Add jobs to pool%n");
        pool.execute(new IntegerConsumer(store)); // Consumer will get from store
        pool.execute(new IntegerConsumer(store)); // Consumer will get from store
        pool.execute(new IntegerProducer(store)); // Producer will put into store

        SystemTool.printf("Good bye!%n");
    }
}
