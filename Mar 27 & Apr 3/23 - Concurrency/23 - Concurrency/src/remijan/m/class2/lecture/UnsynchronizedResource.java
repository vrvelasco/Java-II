package remijan.m.class2.lecture;

import remijan.m.class1.lecture.SystemTool;

public class UnsynchronizedResource {

    public
    //synchronized
    void print() {
        for (int i=0; i<5; i++) {
            try {
                SystemTool.printf("Prints iteration %02d%n", i);
                Thread.sleep(1000 * 2);
            } catch (InterruptedException ex) {
            }
        }
    }
}
