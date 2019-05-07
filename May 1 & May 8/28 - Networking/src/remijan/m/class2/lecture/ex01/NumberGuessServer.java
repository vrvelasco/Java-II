package remijan.m.class2.lecture.ex01;

import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberGuessServer {

    public static void main(String[] args) throws Exception {
        System.out.printf("SERVER: %s: NumberGuessServer has started%n", Thread.currentThread().getName());

        System.out.printf("SERVER: %s: Creating pool of threads%n", Thread.currentThread().getName());
        ExecutorService pool = Executors.newFixedThreadPool(3);

        String address = Inet4Address.getLocalHost().getHostAddress();
        int port = 12727;
        System.out.printf("SERVER: %s: Creating ServerSocket for %s/%d%n",
             Thread.currentThread().getName(), address, port);
        ServerSocket server = new ServerSocket(port);

        while (true) {
            System.out.printf("SERVER: %s: Waiting to accept next client connection....%n", Thread.currentThread().getName());
            Socket socket = server.accept();
            System.out.printf("SERVER: %s: Got client connection from %s%n",
                 Thread.currentThread().getName(), socket.getRemoteSocketAddress());
            pool.execute(new NumberGuessRunnable(socket));
        }
    }
}
