package remijan.m.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParserMain {

  public static void main(String[] args) {
    System.out.printf("Welcome to Sentence Parser!%n");

    Scanner scanner
        = new Scanner(System.in);

    boolean keepAsking = true;
    while (keepAsking) {
      System.out.printf("Enter a sentence to parse (-1 to exit): ");
      String userInput
          = scanner.nextLine().trim();

      // Check if user wants to exit
      if ("-1".equals(userInput)) {
        keepAsking = false;
        continue;
      }
      
      
      // Get number of words
      int numberOfWords 
          = userInput.split(" ").length;      
      System.out.printf("Number of words: %d%n", numberOfWords);
      
      
      // Get number of non-whitespace characters
      int nonWhitespaceCount = 0;
      char[] chars = userInput.toCharArray();
      for (int i=0; i<chars.length; i++) {
        if (chars[i] != ' ') {
          nonWhitespaceCount++;
        }
      }
      System.out.printf("Number of non-whitespace characters: %d%n", nonWhitespaceCount);
      
      
      // Get number of vowels
      int vowelCount = 0;
      Pattern p = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);
      Matcher m = p.matcher(userInput);
      while (m.find()) {
        vowelCount++;
      }
      System.out.printf("Number of vowels: %d%n", vowelCount);
      
      
      // Get number of characters in each word
      List<String> words
          = Arrays.asList(userInput.split(" "));      
      for (String word : words) {    
        System.out.printf("%s (%d)%n",word, word.length());
      }
      
    }

    System.out.printf("Good bye!%n");
  }
}