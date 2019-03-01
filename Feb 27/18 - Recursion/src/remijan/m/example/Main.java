package remijan.m.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner 
            = new Scanner(System.in);
        
        System.out.printf("Welcome to Palindrome%n%n");
        
        System.out.printf("Enter a string to check: ");
        String userInput = scanner.nextLine();
        Palindrome p = new Palindrome(userInput);
        System.out.printf("%b%n", p.check());
        
        
        System.out.printf("%nGood bye!%n");
    }
}
