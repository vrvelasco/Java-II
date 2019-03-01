package remijan.m.lecture;

/**
 * @author Michael
 */
public class Ex02_factorial {
    public static void main(String[] args) {
        
      ////// Factorial is another classic example of 
      ////// recursion.  Instead of adding numbers
      ////// together, factorial multiplies them.
      long result = factorial(5);
      System.out.printf("Result: %d%n", result);
      System.out.printf("Done!%n");
    }
    
    // 1 * 2 * 3 * 4 * 5...
    public static long factorial(long number) {
      System.out.printf("factorial(%d)%n", number);
      
      // base case test.  All recursion needs a base case becase
      // the base case defines when to stop the recursion
      if (number <= 1) {  
        return 1; // 0! == 1 and 1! == 1
      }
      else {
        return number * factorial(number - 1);
      }
    }
}
