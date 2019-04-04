package remijan.m.class1.lecture;

public class IntegerConsumer implements Runnable {

    protected IntegerStore store;

    /**
     * Consumer is created with a synchronized store
     */
    public IntegerConsumer(IntegerStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        // Consumer runs forever. This means it will attempt to consume
        // values from the store forever.
        while (true) {
            try {
                // Call the consumeValue() method of the store.
                // Remember the consumeValue() method is synchronized.
                // Therefore, the thread executing this method will
                // wait() and stop running until the store has a value
                // which this consumer may consume. If there are multiple
                // threads running consumers, it may take a while before
                // being able to consume a value since the multiple consumers
                // are all trying to consume the same value
                Integer consumed = store.consumeValue();
                SystemTool.printf("Consumer consumed %d%n", consumed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
