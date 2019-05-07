package remijan.m.class1.lecture;

import java.net.Socket;

public class Ex01_HelloWorldClient {

  public static void main(String[] args) throws Exception {
    System.out.printf("CLIENT: HelloWorldClient started%n");

    // A client application uses a Socket to connect to 
    // another machine.  The client must provide the Socket
    // The IP/Name of the machine and the port number of the
    // server application.  
    System.out.printf("CLIENT: Creating socket%n");
    // A connection to the server is established as soon
    // as the object is created.
    Socket socket = new Socket("localhost", 12727);

    System.out.printf("CLIENT: Exit%n");
  }
}
