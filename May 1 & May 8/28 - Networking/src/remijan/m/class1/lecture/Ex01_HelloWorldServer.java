package remijan.m.class1.lecture;

import java.net.ServerSocket;
import java.net.Socket;

public class Ex01_HelloWorldServer {

    public static void main(String[] args) throws Exception {
        System.out.printf("SERVER: HelloWorldServer started%n");

        // User a ServerSocket to start a server application.
        // A server application can accept network connections
        // from client applications and respond to the client 
        // based an any criteria you need for your application
        int port = 12727;
        System.out.printf("SERVER: Creating ServerSocket on port %d%n", port);
        // Typically define a port for your server application
        ServerSocket server = new ServerSocket(port);

        System.out.printf("SERVER: Waiting for client connection...%n");
        // Calling #accept() blocks the current Thread until a network
        // connection is established by a client to this server's port
        Socket socket = server.accept();

        // Once the #accept() method unblocks, that typically means a 
        // client has established a connection.  The server is now 
        // free to handle the connection in aany way it sees fit.
        System.out.printf("SERVER: Got client connection!%n");
        System.out.printf("SERVER: Address: %s %n", socket.getRemoteSocketAddress().toString());
        System.out.printf("SERVER: Hello Server!%n");

        System.out.printf("SERVER: Exit!%n");
    }
}
