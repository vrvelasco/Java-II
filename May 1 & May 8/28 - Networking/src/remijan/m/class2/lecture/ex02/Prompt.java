package remijan.m.class2.lecture.ex02;

import java.util.Scanner;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Prompt {

    protected Scanner scanner;

    public Prompt() {
        scanner = new Scanner(System.in);
    }

    public String getCommand() {
        String s = null;
        do {
            System.out.printf("CLIENT: prompt> ");
            s = scanner.nextLine().trim();
            if (s.isEmpty()) {
                System.out.printf("%nCLIENT:     No command entered. Try again.%n%n");
            }
        } while (s.isEmpty());
        return s;
    }
}
