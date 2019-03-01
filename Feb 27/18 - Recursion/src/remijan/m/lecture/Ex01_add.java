package remijan.m.lecture;

/**
 * @author Michael
 */
public class Ex01_add {
    public static void main(String[] args) {
      
      ////// You can use a loop to add up the numbers from 1-10
      long sum = 0;
      for (int i=1; i<=10; i++) {
        System.out.printf("Loop: %d%n", i);
        sum += i;
      }
      System.out.printf("Result: %d%n", sum);
      
      
      ////// You can also do the same thing with recursion.
      ////// The add() method is a recursive function.  This
      ////// means it will continue to call itself in order
      ////// to add up the numbers from 1-10
      long result = add(10);
      System.out.printf("Result: %d%n", result);
      
      System.out.printf("Done!%n");
    }
    
    // 1 + 2 + 3 + 4 + ...
    public static long add(long number) {
      System.out.printf("add(%d)%n", number);
      
      // base case test.  All recursion needs a base case becase
      // the base case defines when to stop the recursion
      if (number == 0) {  
        return 0;
      }
      else {
        return number + add(number - 1);
      }
    }
}
