package remijan.m.lecture;

import java.util.Scanner;

/**
 * With exception handling.
 *
 * In this example, there is basic exception handling.
 */
public class Ex03_WithExceptionHandling {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("Enter a integer value: ");
    String userInput
        = scanner.nextLine();

    try {
      int intInput
          = Integer.parseInt(userInput);

      /*
      * No problem? Print the integer value
       */
      System.out.printf("Integer value = %d%n", intInput);
    } catch (NumberFormatException e) {
      /*
      * Problem? Handle it gracefully
       */
      System.out.printf("Opps, not an integer!%n");
    }
  }
}
