package velasco.v;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Server 
{

	public static void main(String[] args) throws Exception 
	{
		System.out.printf("Welcome to Server!%n%n");

        int port = 12727;
        ServerSocket server = new ServerSocket(port);

        System.out.printf("Waiting to accept connection...%n");
        Socket socket = server.accept();
        
        String address = socket.getRemoteSocketAddress().toString();
        System.out.printf("Handling connection from %s %n", address);
         
        Formatter toClient = new Formatter(socket.getOutputStream());
        Scanner fromClient = new Scanner(socket.getInputStream());
        
        System.out.println("Sending client the \"connected\" message");
        toClient.format("-start-%n");
        toClient.flush();

        String ping = fromClient.nextLine();

        while (!ping.equals(".")) 
        {
        	System.out.printf("Server received \"%s\" from client%n", ping);

        	System.out.printf("Sending client \"ECHO: %s\"%n", ping);
        
        	toClient.format("ECHO: %s%n", ping);
        	toClient.flush();

        	ping = fromClient.nextLine();
        }

        System.out.println("Server recceived \"null\" from client");
        toClient.format("-end-");
        toClient.flush();
        System.out.printf("Lost connection from %s", address);
      }
}
