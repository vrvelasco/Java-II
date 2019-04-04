package remijan.m.class1.lecture;

public class Ex02_MyThread {

    public static void main(String[] args) {
        // Welcome
        System.out.printf("[%s] Welcome to my thread example!%n", Thread.currentThread().getName());

        // Create a new instance of your own thread, giving
        // it a unique name when you create it.
        MyThread t = new MyThread("Cool thread");

        // Use the #start() method to "start" the thread.  Calling
        // the #start() method will cause the JVM to create and
        // execute the code of the thread in an asynchronous manner,
        // completely seperate from the default main thread. A common
        // mistake is to call the #run() method.  This is WRONG.
        // Calling #run() is s simple method call within the
        // default main thread.  Calling #run() will NOT result in a
        // new asynchronous thread of execution.
        t.start();

        // Good bye
        System.out.printf("[%s] Good bye!%n", Thread.currentThread().getName());
    }
}
