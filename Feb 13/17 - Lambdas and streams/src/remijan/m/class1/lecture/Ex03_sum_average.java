package remijan.m.class1.lecture;

import java.util.ArrayList;
import java.util.Collections;

public class Ex03_sum_average {
    public static void main(String[] args) {
        
      // Create a List of integers
      ArrayList<Integer>
          ints = new ArrayList<>();      
      Collections.addAll(ints,3,10,6,1,4,8,2,5,9,7);
      
      // Generic stream to "reduce" a list of values down to
      // a single value...more on the reduce() method later....
      {
        int sum = ints.stream()
            .reduce((a,b) -> a + b)
            .get();
        System.out.printf("Sum A: %d%n", sum);
      }
      
      // Generic stream to an IntStream which has a 
      // specialed sum() method to get the sum.
      {
        int sum = ints.stream()
            .mapToInt(a -> a)
            .sum();        
        System.out.printf("Sum B: %d%n", sum);
      }
      
      // Generic stream to an IntStream which has a
      // specialized average() method to get the sum.
      // average is sum / count....can't do this all 
      // in 1 expression without IntStream
      {
        double average = ints.stream()
            .mapToInt(a -> a)
            .average()
            .getAsDouble();
        System.out.printf("Average: %f%n", average);
      }
    }
}
