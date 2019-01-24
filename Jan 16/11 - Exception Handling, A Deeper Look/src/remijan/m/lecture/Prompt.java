package remijan.m.lecture;

import java.util.Scanner;

public class Prompt implements AutoCloseable {
  private Scanner scanner;
  
  public Prompt() {
    scanner = new Scanner(System.in);
  }
  
  public int forInt() {
    System.out.printf("Enter a integer value: ");
    String userInput
        = scanner.nextLine();
    
    return Integer.parseInt(userInput);    
  }

  @Override
  public void close() throws Exception {
    /**
     * Close is run no matter what
     */
    System.out.printf("Close is run no mattter what%n");
    scanner.close();
  }
}
