package remijan.m.class2.lecture.ex01;

import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessRunnable implements Runnable {

    private Socket socket;
    private int numberToGuess;

    public NumberGuessRunnable(Socket socket) {
        this.socket = socket;
        this.numberToGuess = new Random().nextInt(100) + 1;
    }

    @Override
    public void run() {

        System.out.printf("SERVER: %s: %s: Handling client%n",
             Thread.currentThread().getName(), socket.getRemoteSocketAddress());

        try {
            // Create Reader and Writer
            Scanner fromClient = new Scanner(socket.getInputStream());
            Formatter toClient = new Formatter(socket.getOutputStream());

            while (true) {
                // accept a guess
                LinkedList<String> lines = new LinkedList<>();
                for (String line = fromClient.nextLine(); !("-end-".equals(line)); line = fromClient.nextLine()) {
                    lines.add(line);
                }
                System.out.printf("SERVER: %s: %s: From client \"%s\"%n",
                     Thread.currentThread().getName(), socket.getRemoteSocketAddress(), lines);

                int userGuess = Integer.parseInt(lines.get(0));

                // determine if too high, too low, or equal
                String result = "";
                if (userGuess > numberToGuess) {
                    result = "too high";
                } else if (userGuess < numberToGuess) {
                    result = "too low";
                } else {
                    result = "equal";
                }

                // return response
                toClient.format("%s%n",result);
                toClient.format("-end-%n");
                toClient.flush();
            }

        } catch (IOException e) {
        }
    }
}
