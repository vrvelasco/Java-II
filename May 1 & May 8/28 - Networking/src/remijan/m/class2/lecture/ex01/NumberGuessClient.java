package remijan.m.class2.lecture.ex01;

import java.net.Socket;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.Scanner;

public class NumberGuessClient {

    public static void main(String[] args) throws Exception {
        System.out.printf("CLIENT: NumberGuessClient I've started%n");

        System.out.printf("CLIENT: Creating my socket%n");
        Socket socket = new Socket("localhost", 12727);

        // Create Reader and Writer
        Scanner fromServer = new Scanner(socket.getInputStream());
        Formatter toServer = new Formatter(socket.getOutputStream());

        // Scanner
        Scanner scanner = new Scanner(System.in);

        boolean keepPrompting = true;
        while (keepPrompting) {
            // prompt user for guess
            System.out.print("CLIENT: Guess number [1-100]: ");
            String userGuessStr = scanner.nextLine();
            int userGuess = Integer.parseInt(userGuessStr);

            // send guess to server
            toServer.format("%d%n",userGuess);
            toServer.format("-end-%n");
            toServer.flush();

            // read response from server
            LinkedList<String> lines = new LinkedList<>();
            for (String line = fromServer.nextLine(); !("-end-".equals(line)); line = fromServer.nextLine()) {
                lines.add(line);
            }
            String response = lines.get(0);

            // if too high, or too low, prompt user again
            // if equal, exit
            if ("too high".equals(response)) {
                System.out.printf("CLIENT: You guessed to high.%n");
            } else {
                if ("too low".equals(response)) {
                    System.out.printf("CLIENT: You guessed to low.%n");
                } else {
                    System.out.printf("CLIENT: CORRECT!!%n");
                    keepPrompting = false;
                }
            }
        }

        System.out.printf("CLIENT: I'm done%n");
    }
}
