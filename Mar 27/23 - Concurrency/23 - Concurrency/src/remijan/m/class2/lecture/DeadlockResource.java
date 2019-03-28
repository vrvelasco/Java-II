package remijan.m.class2.lecture;

public class DeadlockResource {

    String str1 = "Hello";
    String str2 = "Java";

    public void oneTwo(long l) {
        synchronized (str1) {
            synchronized (str2) {
                System.out.printf("%s %s %d %n", str1, str2, l);
            }
        }
    }
    
    public void twoOne(long l) {
        synchronized (str2) {
            synchronized (str1) {
                System.out.printf("%s %s %d %n", str2, str1, l);
            }
        }
    }
}
