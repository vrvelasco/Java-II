package remijan.m.class1.lecture;

import java.util.ArrayList;
import java.util.Collections;

public class Ex05_reduce {
    public static void main(String[] args) {
        
      // Create a List of integers
      ArrayList<Integer>
          ints = new ArrayList<>();      
      Collections.addAll(ints,3,10,6,1,4,8,2,5,9,7);
      
      // The reduce() operation takes a stream of size N of type A
      // and reduces to a single value of type B. In other words, when
      // you reduce(), the result is a single value and the type of
      // object may change.
      
      // Product of numbers
      {
        int product = ints.stream()
            .reduce((a,b) -> a * b)
            .get();
        System.out.printf("Product: %d%n", product);
      }
      
      // Sum of squares
      {
        int sum = ints.stream()
            .reduce((a,b) -> a + (b * b))
            .get();
        System.out.printf("Sum of squares (wrong): %d%n", sum);
      }
      
      // Sum of squares
      {
        int sum = ints.stream()
            .reduce(0, (a,b) -> a + (b * b))
            .intValue();
        System.out.printf("Sum of squares (right): %d%n", sum);
      }
      
      // CSV
      {
        String csv = ints.stream()
            .map(a -> String.valueOf(a))
            .reduce((a,b) -> a + ", " + b)
            .get();
            
        System.out.printf("CSV: %s%n", csv);
      }
    }
}
