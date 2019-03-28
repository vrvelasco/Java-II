package remijan.m.class1.lecture;

public class Ex03_MyRunnable {

    public static void main(String[] args) {
        // Welcome
        System.out.printf("[%s] Welcome to my runnable example!%n", Thread.currentThread().getName());

        // Create a new instance of your own thread, giving
        // it a unique name when you create it.
        Thread t = new Thread(new MyRunnable(), "Cool runnable!");

        // Use the #start() method to "start" the thread.  Calling
        // the #start() method will cause the JVM to create and
        // execute the code of the thread in an asynchronous manner,
        // completely seperate from the default main thread. A common
        // mistake is to call the #run() method.  This is WRONG.
        // Calling #run() is s simple method call within the
        // default main thread.  Calling #run() will NOT result in a
        // new asynchronous thread of execution.
        t.start();

        // Main thread loops forever
        for (long counter = 1; true; counter++) {
            System.out.printf("[%s] Running %d%n", Thread.currentThread().getName(), counter);
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException ignore) {
            }
        }
    }
}
