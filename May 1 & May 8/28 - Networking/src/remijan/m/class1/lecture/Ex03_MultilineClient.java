package remijan.m.class1.lecture;

import java.net.Socket;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ex03_MultilineClient {

    public static void main(String[] args) throws Exception {
        System.out.printf("CLIENT: MultiLineClient started%n");

        System.out.printf("CLIENT: Creating socket%n");
        Socket socket = new Socket("localhost", 12727);

        Formatter toServer = new Formatter(socket.getOutputStream());
        Scanner fromServer = new Scanner(socket.getInputStream());

        // The Protocol for multiline states that the client will
        // send data to the server first.  So, following that protocol
        // after a connection is established the server is waiting for
        // the client to send data.  Let's send the server multiple
        // lines of data.
        send(toServer, "hello");
        send(toServer, "doctor");
        send(toServer, "name");
        send(toServer, "continue");
        send(toServer, "yesterday");
        send(toServer, "tomorrow");
        send(toServer, "-end-");

        // After the client sends data, the protocol now states
        // the server will send the thank you response.  So the
        // Client must now read that response from the server
        System.out.printf("CLIENT: Reading response from server%n");
        // Create a list to store all the lines of
        // data sent by the client to the server
        List<String> linesFromServer = new LinkedList<>();
        // Client will continue to read lines of data from the server
        // until the client recieves "-end-" from the server.
        // The call to #readLine() will block the current thread
        // until the server sends a line of data.
        for (String line = fromServer.nextLine(); !line.equals("-end-"); line = fromServer.nextLine()) {
             System.out.printf("CLIENT: Got line from server: \"%s\". Store and wait for next line%n", line);
            linesFromServer.add(line);
        }
        System.out.printf("CLIENT: Got from server \"%s\"%n", linesFromServer.toString());

        System.out.printf("CLIENT: exit%n");
    }

    private static void send(Formatter toServer, String message) throws Exception {
        System.out.printf("CLIENT: Sending server %s%n", message);
        toServer.format("%s%n", message);
        toServer.flush();
        Thread.sleep(1000 * (1 + new SecureRandom().nextInt(5)));
    }
}
