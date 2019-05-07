package remijan.m.class1.lecture;

import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex04_LoopServer {

    public static void main(String[] args) throws Exception {
        System.out.printf("SERVER: LoopServer started%n");

        String address = Inet4Address.getLocalHost().getHostAddress();
        int port = 12727;
        System.out.printf("SERVER: Creating ServerSocket for %s/%d%n", address, port);
        ServerSocket server = new ServerSocket(port);

        // Loop forever.  This will allow the server application
        // to always be up-and-running so clients can connect to it
        // at any time.
        for (;;) {
            System.out.printf("SERVER: Waiting for next client connection...%n");
            Socket socket = server.accept();
            System.out.printf("SERVER: Got client connection from address %s%n", socket.getRemoteSocketAddress().toString());
        }
    }
}
