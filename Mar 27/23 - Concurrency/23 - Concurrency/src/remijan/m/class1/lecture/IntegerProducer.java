package remijan.m.class1.lecture;

import java.security.SecureRandom;

public class IntegerProducer implements Runnable {

    protected IntegerStore store;

    /**
     * Producer is created with a synchronized store
     */
    public IntegerProducer(IntegerStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        // Create a SecureRandom to produce random values for the store
        SecureRandom random = new SecureRandom();

        // Producer runs forever. This means it will attempt to produce
        // values for the store forever.
        while (true) {
            try {
                // Generate a random value between 1 and 10,000 inclusive
                int produced = random.nextInt(10000) + 1;

                // Call the storeValue() method of the store.
                // Remember the storeValue() method is synchronized.
                // Therefore, the thread executing this method will
                // wait() and stop running until the store no longer
                // storing a value and hence is able to store a new
                // value. If there are multiple threads running producers,
                // it may take a while before being able to store the value
                // this producer produced
                store.storeValue(produced);
                SystemTool.printf("Producer sleeping...%n");
                ThreadTool.sleep(1000 * 3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
