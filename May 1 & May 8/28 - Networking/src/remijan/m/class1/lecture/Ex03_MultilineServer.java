package remijan.m.class1.lecture;

import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ex03_MultilineServer {

    public static void main(String[] args) throws Exception {
        System.out.printf("SERVER: MultiLineServer started%n");

        String address = Inet4Address.getLocalHost().getHostAddress();
        int port = 12727;
        System.out.printf("SERVER: Creating ServerSocket for %s/%d%n", address, port);
        ServerSocket server = new ServerSocket(port);

        System.out.printf("SERVER: Waiting for client connection...%n");
        Socket socket = server.accept();
        System.out.printf("SERVER: Address: %s %n", socket.getRemoteSocketAddress().toString());

        Formatter toClient = new Formatter(socket.getOutputStream());
        Scanner fromClient = new Scanner(socket.getInputStream());

        // The protocol for multiline is that both the client and the
        // server may send multiple lines of data to each other.  The
        // protocol states that "-end-" should be used by both the
        // client and the server to indicate they are done sending data.
        // The protocol also states that the client will send data to
        // the server first.  So, the server will attempt to read
        // lines of data from the client until it recieves "-end-".
        System.out.printf("SERVER: Waiting line of data from client...%n");
        // Create a list to store all the lines of
        // data sent by the client to the server
        List<String> linesFromClient = new LinkedList<>();
        // Server will continue to read lines of data from the client
        // until the server recieves "-end-" from the client.
        // The call to #readLine() will block the current thread
        // until the client sends a line of data.
        for (String line = fromClient.nextLine(); !line.equals("-end-"); line = fromClient.nextLine()) {
            System.out.printf("SERVER: Got line from client: \"%s\". Store and wait for next line%n", line);
            linesFromClient.add(line);
        }

        // Once the server has finished reading all the lines of data
        // from the client, the server simply prints what the client sent
        System.out.printf("SERVER: Client sent \"-end-\", so client is finished%n");

        // The protocol now states that the server will send the client
        // a thank you message.  Server will send multiple lines.  And
        // of course use "-end-" to indicate to the client that the
        // server is done sending data.
        System.out.printf("SERVER: Sending \"thank you\" to client%n");
        toClient.format("thank%n");
        toClient.format("you,%n");
        toClient.format("  client,%n");
        toClient.format(" for sending me%n");
        toClient.format("a message!%n");
        toClient.format("-end-%n");
        toClient.flush();
        Thread.sleep(3000);

        System.out.printf("SERVER: exit%n");
    }
}
