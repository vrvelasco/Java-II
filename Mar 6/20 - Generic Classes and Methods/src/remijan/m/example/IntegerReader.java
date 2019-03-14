package remijan.m.example;

import java.util.Scanner;

public class IntegerReader {
    
    protected Scanner scanner;
    
    public IntegerReader() {
        scanner = new Scanner(System.in);
    }
    
    public Integer nextInteger() {
        // loop forever asking for user input
        Integer returnValue = null;
        while (true) {            
            System.out.printf("Enter an integer (\".\" when done): ");
            String userInput = scanner.nextLine();
            if (".".equals(userInput)) {
                returnValue = null;
                break;
            }
            try {
                returnValue = new Integer(userInput);
                break;
            } catch (NumberFormatException e) {
                System.out.printf("%n  \"%s\" is not an integer. Try again.%n%n", userInput);
            }
        }
        return returnValue;
    }
}
