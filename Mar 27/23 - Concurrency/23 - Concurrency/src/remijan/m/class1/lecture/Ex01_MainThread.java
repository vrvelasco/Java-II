package remijan.m.class1.lecture;

public class Ex01_MainThread {

    public static void main(String[] args) {

        // By default the JVM creates a starting 'main' thread for you.
        // So you have been using threads all along and you didn't even know it.
        // The 'main' thread is created to run the Java application's
        // main(String[] args) method. This is the only thread created for you.
        // You are responsible for creating any other threads you may need.
        // Use the #getName() method to get a thread's name.
        String name
            = Thread.currentThread().getName();
        System.out.printf("Main thread name = \"%s\"%n", name);
        System.out.printf("Good bye!%n");
    }
}
