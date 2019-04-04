package remijan.m.class2.lecture;

import remijan.m.class1.lecture.SystemTool;

public class DeadlockResource {

    String str1 = "Hello";
    String str2 = "Java";

    public void oneTwo(long l) {
        SystemTool.printf("Get lock on str1. . .%n");
        synchronized (str1) {
            SystemTool.printf("Get lock on str2. . .%n");
            synchronized (str2) {
                SystemTool.printf("Got both locks: %s %s %d %n", str1, str2, l);
            }
        }
    }

    public void twoOne(long l) {
       SystemTool.printf("Get lock on str2. . .%n");
        synchronized (str2) {
            SystemTool.printf("Get lock on str1. . .%n");
            synchronized (str1) {
                SystemTool.printf("Got both locks: %s %s %d %n", str2, str1, l);
            }
        }
    }
}
