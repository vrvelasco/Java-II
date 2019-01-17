package remijan.m.lecture;

import java.util.Scanner;

/**
 * StackTrace.
 * 
 * If we handle the exception gracefully, we lose the 
 * StackTrace information so we don't know where there
 * exception exactly happened in our code.
 * 
 * Use getStackTrace() to figure it out.
 */
public class Ex04_StackTrace {

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
      
      /**
       * printStackTrace()           -- Async, defaults to System.err
       * printStackTrace(System.out) -- Sync
       */
      e.printStackTrace(System.out);
      
      /**
       * Get the array of StackTraceElement
       * 
       * Loop and see what's in them
       */
      StackTraceElement[] elements = e.getStackTrace();

      for (StackTraceElement ste : elements) {
        System.out.printf("%nSTACK TRACE ELEMENT%n");
        System.out.printf("ClassName = %s%n", ste.getClassName());
        System.out.printf("FileName = %s%n", ste.getFileName());
        System.out.printf("LineNuber = %d%n", ste.getLineNumber());
        System.out.printf("MethodName = %s%n", ste.getMethodName());
      }
    }
  }
}
