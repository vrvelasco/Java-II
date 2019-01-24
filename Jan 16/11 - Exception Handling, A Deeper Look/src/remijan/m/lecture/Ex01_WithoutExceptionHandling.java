package remijan.m.lecture;

import java.util.Scanner;

/**
 * Without exception handling.
 * 
 * In this example, there is not exception handling.
 * 
 * Any exceptions that occur are handled in the default
 * way by the JDK, which is to dump the stack trace.
 * 
 */
public class Ex01_WithoutExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a integer value: ");
        String userInput 
                = scanner.nextLine();

        int intInput
                = Integer.parseInt(userInput);

        System.out.printf("Integer value = %d%n", intInput);
    }
}
/* Lecture Notes:
 * 
 * Checked Exception - Won't compile
 * Runtime Exception - No compile error (Error at Runtime)
 * 
 */