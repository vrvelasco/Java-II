package remijan.m.class1.lecture;

import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Ex02_PingPongClient {

    public static void main(String[] args) throws Exception {
        System.out.printf("CLIENT: PingPongClient started%n");

        System.out.printf("CLIENT: Creating socket%n");
        Socket socket = new Socket("localhost", 12727);

        // Now that the Socket object is created, a connection
        // between the server and the client has been established. Get the
        // InputStream and OutputStream for communication.  Always look at
        // these streams from the point of view of the running application.
        //
        // If I am the CLIENT
        //   OutputStream -> write to server
        //   InputStream  <- read from server
        //
        // Wrap OutputStream for convenience
        Formatter toServer = new Formatter(socket.getOutputStream());
        //
        // Wrap InputStream for convenience
        Scanner fromServer = new Scanner(socket.getInputStream());

        // The protocol for the ping/pong application is that
        // The client will write data to the server first.  So
        // after a connection is established, the server is
        // following this protocol and is waiting for the client
        // to send it a line of data.
        System.out.printf("CLIENT: Writing \"ping\" to server%n");
        // Use OutputStream to send data to the server
        toServer.format("ping%n");
        // Always remember to #flush!
        toServer.flush();

        // The protocol for the ping/pong application now says
        // that after the client writes a line of data to the
        // server, the client should wait for a response from
        // the server.
        System.out.printf("CLIENT: Reading response from server%n");
        // Use InputStream to read data from the server
        String pong = fromServer.nextLine();
        // Let's see what the server sent
        System.out.printf("CLIENT: Got from server \"%s\"%n", pong);
    }
}
