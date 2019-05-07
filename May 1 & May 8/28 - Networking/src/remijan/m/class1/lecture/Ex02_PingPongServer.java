package remijan.m.class1.lecture;

import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Ex02_PingPongServer {

    public static void main(String[] args) throws Exception {
        System.out.printf("SERVER: PingPongServer started%n");

        String address = Inet4Address.getLocalHost().getHostAddress();
        int port = 12727;
        System.out.printf("SERVER: Creating ServerSocket for %s/%d%n", address, port);
        ServerSocket server = new ServerSocket(port);

        System.out.printf("SERVER: Waiting for client connection...%n");
        Socket socket = server.accept();
        System.out.printf("SERVER: Address: %s %n", socket.getRemoteSocketAddress().toString());

        // Now that the #accept() method has unblocked and a connection
        // between the server and the client has been established, get the
        // InputStream and OutputStream for communication.  Always look at
        // these streams from the point of view of the running application.
        //
        // If I am the SERVER
        //   OutputStream -> write to client
        //   InputStream  <- read from client
        //
        // Wrap OutputSream for easier use.
        Formatter toClient = new Formatter(socket.getOutputStream());
        //
        // Wrap InputStream for easier use.
        Scanner fromClient = new Scanner(socket.getInputStream());

        // Server is now waiting for the client to send some data.
        // The #readLine() method call will block the current thread
        // until data is sent to the server.
        //
        // This is the start of the "protocol", which is the language
        // the client & server applications understand.  The protocol
        // for this application is that the CLIENT will send data first
        // So the SERVER must wait for it.
        System.out.printf("SERVER: Waiting for line of data from client...%n");
        // Use the InputStream to read data from the client.
        String ping = fromClient.nextLine();

        // Now that the #readLine() method has unblocked, that means
        // the client has sent the server a complete line of data.
        // Let's see what the server received:
        System.out.printf("SERVER: Got from client \"%s\"%n", ping);

        // The server is now free to respond to the client in the
        // way defined by the protocol.
        //
        // In this case, the protocol states that after receiving
        // any line of data from the client, the server should
        // respond with "pong"
        System.out.printf("SERVER: Sending \"pong\" to client%n");
        // Use OutputStream to send data back to the client.
        toClient.format("pong%n");
        // Always remember to #flush()!
        toClient.flush();

        System.out.printf("SERVER: exit%n");
    }
}
