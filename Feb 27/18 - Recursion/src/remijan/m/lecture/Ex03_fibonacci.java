package remijan.m.lecture;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Michael
 */
public class Ex03_fibonacci {
    public static void main(String[] args) {
      
      ////// Generating a fibonacci sequence of
      ////// numbers is another classic recursion
      ////// example.  A fibanacci number sequence
      ////// is generated by starting with the numbers
      ////// 0 and 1.  Then all following numbers are
      ////// determined recursively by adding the
      ////// previous two numbers together.
      List<Long> numbers = new LinkedList<>();
      for (int i=0; i<=20; i++) {
        numbers.add(fibonacci(i));
      }
      
      System.out.printf("Result: %s%n", numbers);
      System.out.printf("Done!%n");
    }
    
    // Index:  0  1  2  3  4  5  6  7   8   9   10  11  12   13   14   15   16   17    18    19
    // Value: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, ...]
    public static long fibonacci(long number) {
      System.out.printf("fibonacci(%d)%n", number);
      
      // base case test.  All recursion needs a base case becase
      // the base case defines when to stop the recursion
      if (number == 0 || number == 1) {  
        return number;
      }
      else {
        return fibonacci(number - 1) + fibonacci(number - 2);
      }
    }
}