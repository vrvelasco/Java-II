package remijan.m.class1.lecture;

import java.util.Optional;

public class IntegerStore {

    // This store has the ability to store only a single
    // value. At any given time, the store may be storing
    // a value or it may not. Therefore use Optional to be
    // able to tell if the store has a value or not.
    protected Optional<Integer> value;

    /**
     * Constructor, create the store with the store not
     * storing any value
     */
    public IntegerStore() {
        value = Optional.empty();
    }

    /**
     * This is a synchronized method to consume the value
     * the store is currently storing. Being synchronized
     * means that Java guarantees only 1 thread is executing
     * synchronized code in this class no matter how many threads
     * want to be executing synchronized code.
     *
     * When THREAD-A calls this method, the first thing this method
     * does is checks to see if the store is currently
     * storing a value. If it is **NOT** storing a value, the
     * THREAD-A gives up it's lock by calling the wait() method.
     * THREAD-A will stop executing. When another thread calls the
     * notify() or notifyAll() methods, that will wake up THREAD-A
     * and THREAD-A will be able to execute again. It will again
     * check to see if the store is currently storing a value. If
     * not, THREAD-A will wait() again.
     *
     * If the store **IS** currently storing a value, THREAD-A will
     * consume it by doing the following:
     *  1. Store the value in a local variable
     *  2. Empty the value the store is storing (remember it's consuming the value)
     *  3. Calls notifyAll() to let all other threads know it's done.
     *  4. Return the locally stored value.
     */
    public synchronized Integer consumeValue() throws InterruptedException {
        while (!value.isPresent()) {
            SystemTool.printf("Consumer waiting to consume a value%n");
            wait();
        }

        Integer retval
            = value.get();

        value = Optional.empty();
        notifyAll();
        return retval;
    }

    /**
     * This is a synchronized method to store a value in the store.
     * Being synchronized means that Java guarantees only 1 thread
     * is executing synchronized code in this class no matter how
     * many threads want to be executing synchronized code.
     *
     * When THREAD-B calls this method, the first thing this method
     * does is checks to see if the store is currently
     * storing a value. If it **IS** storing a value, the
     * THREAD-B gives up it's lock by calling the wait() method.
     * THREAD-B will stop executing. When another thread calls the
     * notify() or notifyAll() methods, that will wake up THREAD-B
     * and THREAD-B will be able to execute again. It will again
     * check to see if the store is currently storing a value. If
     * it **IS**, THREAD-B will wait() again.
     *
     * If the store is **NOT** currently storing a value, THREAD-B is
     * then able to continue running. The new value to store is
     * passed in as a method parameter. The new value is stored
     * by doing the following:
     *  1. Set this value as the value the store is storing
     *  2. Calls notifyAll() to let all other threads know it's done.
     */
    public synchronized void storeValue(Integer newValue) throws InterruptedException {
        while (value.isPresent()) {
            SystemTool.printf("Producer waiting to store new value %d%n", newValue);
            wait();
        }

        SystemTool.printf("Producer storing new value %d%n", newValue);
        value = Optional.of(newValue);
        notifyAll();
    }
}
