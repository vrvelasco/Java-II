package remijan.m.lecture;

import java.util.Scanner;

public class PromptForRange {
  private Scanner scanner;
  
  public PromptForRange() {
    scanner = new Scanner(System.in);
  }
  
  public int forRange() throws LessThanException, GreaterThanException
  {
    System.out.printf("Enter a integer between 10-20: ");
    String userInput
        = scanner.nextLine();
    
    int intVal 
        = Integer.parseInt(userInput); 
    if (intVal < 10) {
      throw new LessThanException();
    } else 
      if (intVal > 20) {
        throw new GreaterThanException();
      }
    
    return intVal;
  }
}
