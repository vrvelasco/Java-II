package velasco.v;

import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception 
	{
		Scanner input = new Scanner(System.in);
	
		System.out.printf("Welcome to Client!%n");

        Socket socket = new Socket("localhost", 12727);
  
        Formatter toServer = new Formatter(socket.getOutputStream());
        Scanner fromServer = new Scanner(socket.getInputStream());
        
        // Connected?
        String statusMsg = fromServer.nextLine();

        // Got the "connected" message from the server
        if (statusMsg.equals("-start-")) {
        System.out.printf("%nConnected!%n");
        }
        
        String userStr = ""; // Holds input
        
        while (!userStr.equals(".")) 
        {
        	System.out.printf("%nWhat do you want echoed (\".\" to exit)? ");
        	
        	userStr = input.nextLine();
        	toServer.format("%s%n", userStr);
        	
        	toServer.flush();

        	String pong = fromServer.nextLine();
        
        	// Got the "stop" message from the server
        	if (pong.equals("-end-")) 
        	{
        		System.out.printf("%nClosing Connection to server%n");
        		socket.close();
        	}
        	else
        		System.out.printf("%n  %s%n", pong);
        }
        
        System.out.printf("%nGood bye!");
	}
}
