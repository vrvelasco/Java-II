package remijan.m.class1.lecture;

public class Ex04_MyRunnableLambda {

    public static void main(String[] args) {
         // Welcome
        System.out.printf("[%s] Welcome to my runnable lambda example!%n", Thread.currentThread().getName());


        // If your runnable is simple enough, consider using
        // a lambda expression instead of a seperate class.
        Thread t = new Thread(
              () -> {
                  for (long counter = 1; true; counter++) {
                    System.out.printf("[%s] Running %d%n", Thread.currentThread().getName(), counter);
                    try {
                        Thread.sleep(1000 * 3);
                    } catch (InterruptedException ignore) {}
                }
              }
            , "Cool -> lambda"
        );

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
