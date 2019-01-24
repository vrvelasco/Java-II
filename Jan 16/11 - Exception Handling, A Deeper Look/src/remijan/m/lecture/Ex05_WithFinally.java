package remijan.m.lecture;

import java.util.Scanner;

/**
 * Finally.
 * 
 * Clean up resources
 */
public class Ex05_WithFinally {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("Enter a integer value: ");
    String userInput
        = scanner.nextLine();

    try {
      int intInput
        = Integer.parseInt(userInput);
      System.out.printf("Integer value = %d%n", intInput);
    } catch (NumberFormatException e) {
      System.out.printf("Opps, not an integer!%n");
    } finally {
      /**
       * Finally is always run, no matter what
       */
      System.out.printf("Finally is always run no matter what.%n");
    }

  }
}
