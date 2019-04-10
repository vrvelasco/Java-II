package velasco.v;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WarMain 
{
    public static void main(String[] args) 
    {
        System.out.printf("Welcome to WAR!%n%n");
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // Create a shared resource which need synchronized access
        Deck deck = new Deck();

        // Add consumer and producer jobs to the pool
        System.out.printf("Producer has started running%n");
        pool.execute(new Producer(deck)); // Producer will put into store
        
        System.out.printf("Consumer has started running%n%n");
        pool.execute(new Consumer(deck)); // Consumer will get from store
    }
}
