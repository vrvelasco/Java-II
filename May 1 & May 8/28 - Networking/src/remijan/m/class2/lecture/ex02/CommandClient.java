package remijan.m.class2.lecture.ex02;

import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class CommandClient {

    public static void main(String[] args) throws Exception {
        System.out.printf("CLIENT: CommandClient I've started%n");

        System.out.printf("CLIENT: Creating my socket%n");
        Socket socket = new Socket("10.30.11.3", 12727);

        // Create Reader and Writer
        Scanner fromServer = new Scanner(socket.getInputStream());
        Formatter toServer = new Formatter(socket.getOutputStream());

        // Read user input
        Prompt prompt = new Prompt();

        try {
            for (String command = ""; !"exit".equals(command);) {
                // prompt user for command
                command = prompt.getCommand();

                // send command to server
                toServer.format("%s%n", command);
                toServer.flush();

                // read response from server
                for (String line = fromServer.nextLine(); !("-end-".equals(line)); line = fromServer.nextLine()) {
                    System.out.printf("CLIENT-SERVER: %s%n", line);
                }
            }
        } catch (Exception e) {}

        System.out.printf("CLIENT: I'm done%n");
    }
}
