package remijan.m.lecture;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Without exception handling.
 *
 * In this example, there is not exception handling.
 *
 * Any exceptions that occur are handled in the default way by the JDK, which is
 * to dump the stack trace.
 *
 */
public class Ex02_TwoTypes {

  public static void main(String[] args) throws Exception { 
    unchecked();
    checked();
  }

  private static void checked() throws Exception { // Checked exception: without "throws"
    /**
     * This is a checked exception
     * 
     * It must be caught
     * OR
     * It must be throwed
     */
    new FileInputStream("some/file.txt");
  }

  private static void unchecked() { // Runtime: No handling needed right now.
    /**
     * This is an unchecked exception
     * 
     * Not caught
     * Not throwed
     */
    Integer.parseInt("abcd");
  }
}
