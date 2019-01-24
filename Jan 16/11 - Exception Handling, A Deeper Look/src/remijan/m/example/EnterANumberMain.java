package remijan.m.example;

import java.util.Scanner;

public class EnterANumberMain {

  public static void main(String[] args) {
    System.out.printf("Welcome to pick a number%n");

    Scanner scanner
        = new Scanner(System.in);

    boolean validUserInput
        = false;

    while (!validUserInput) {
      System.out.printf("Pick a number between 1-10 (inclusive): ");

      Integer pickedNumber = null;

      try {
        String input = scanner.nextLine();
        pickedNumber = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.printf("%n\tERROR: You did not enter a number. Try again!%n%n");
      }

      if (pickedNumber != null) {
        
        if (pickedNumber < 1) {
          System.out.printf("%n\tERROR: Number must be greater than or equal to 1. Try again!%n%n");
        } else if (pickedNumber > 10) {
          System.out.printf("%n\tERROR: Number must be less than or equal to 10. Try again!%n%n");
        } else {          
          validUserInput = true;
          System.out.printf("%n\tSUCCESS: You entered %d!%n%n", pickedNumber);
        }
      }
    }

    System.out.printf("Good bye!%n");
  }
}
