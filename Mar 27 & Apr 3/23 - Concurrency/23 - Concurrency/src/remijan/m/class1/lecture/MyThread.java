package remijan.m.class1.lecture;

// This class extends java.lang.Thread.  Therefore, it passes
// the "is a" test and it is correct to say that MyThread is a Thread
public class MyThread extends Thread {

    // Call the Thread class's constructor passing the name parameter value
    public MyThread(String name) {
        super(name);
    }

    // This is where you put your code that you want to execute in
    // an asynchronous manner in its own thread.  You must override
    // the #run() method an put your code here.  However, remember,
    // you do NOT directly call the #run() method.  After an instance
    // of MyThread is created, you call the #start() method to star
    // a new asynchronous thread.  #start() will automatically call
    // the #run() method for you.
    @Override
    public void run() {
        long counter = 0;
        while (true) {
            System.out.printf("[%s] Running %d%n", Thread.currentThread().getName(), ++counter);
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException ignore) {
            }
        }
    }
}
