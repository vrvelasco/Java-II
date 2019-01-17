package remijan.m.lecture;

import java.util.Scanner;

/**
 * Finally.
 * 
 * Clean up resources
 */
public class Ex06_AutoClosable {

  public static void main(String[] args) {
    try (
        Prompt p = new Prompt();
    ) {
      System.out.printf("Integer value = %d%n", p.forInt());
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }    
  }
}
