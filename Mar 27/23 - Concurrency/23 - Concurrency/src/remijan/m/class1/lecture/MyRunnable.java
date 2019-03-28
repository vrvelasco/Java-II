package remijan.m.class1.lecture;

// This class implements java.lang.Runnable.  Therefore, it passes
// the "is a" test and it is correct to say that MyRunnable is a Runnable
public class MyRunnable implements Runnable {

    // The Runnable interface only has 1 method you must
    // implement, which is the #run() method.
    // This is where you put your code that you want to execute in
    // an asynchronous manner in its own thread.  You must override
    // the #run() method an put your code here.  However, remember,
    // you do NOT directly call the #run() method.  After an instance
    // of MyThread is created, you call the #start() method to start
    // a new asynchronous thread.  #start() will automatically call
    // the #run() method for you.
    @Override
    public void run() {
        for (long counter = 1; true; counter++) {
            System.out.printf("[%s] Running %d%n", Thread.currentThread().getName(), counter);
            try {
                Thread.sleep(1000 * 3);
            } catch (InterruptedException ignore) {
            }
        }
    }

}
