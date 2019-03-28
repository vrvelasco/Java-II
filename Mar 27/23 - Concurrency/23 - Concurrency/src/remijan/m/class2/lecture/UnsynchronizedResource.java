package remijan.m.class2.lecture;

public class UnsynchronizedResource {

    public void print() {
        for (int i=0; i<10; i++) {
            try {
                System.out.printf("Thread \"%s\" Prints %02d%n"
                    ,Thread.currentThread().getName(), i);
                Thread.sleep(1000 * 2);
            } catch (InterruptedException ex) {
            }
        }
    }
}
