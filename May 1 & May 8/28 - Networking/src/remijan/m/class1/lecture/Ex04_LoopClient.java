package remijan.m.class1.lecture;

import java.net.Socket;

public class Ex04_LoopClient {

    public static void main(String[] args) throws Exception {
        System.out.printf("CLIENT: LoopClient started%n");

        for (long l = 0; true; l++) {
            System.out.printf("CLIENT: Creating socket %d%n", l);
            Socket socket = new Socket("localhost", 12727);
            socket.close();
            Thread.sleep(1000 * 5);
        }
    }
}
