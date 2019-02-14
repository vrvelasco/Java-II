package remijan.m.class1.lecture;

import java.util.ArrayList;
import java.util.Collections;

public class Ex02_min_max {
    public static void main(String[] args) {
        
      // Create a List of integers
      ArrayList<Integer>
          ints = new ArrayList<>();      
      Collections.addAll(ints,3,10,6,1,4,8,2,5,9,7);
      
      // Generic stream using lambda expression
      {
        int min = ints.stream()
            .min((a,b) -> Integer.compare(a, b))
            .get();
        System.out.printf("Min A: %d%n", min);
      }
      
      // Generic stream using Method Reference Operator. 
      // This is even shorter than a lambda expression.
      {
        int min = ints.stream()
            .min(Integer::compare)
            .get();
        System.out.printf("Min B: %d%n", min);
      }
      
      // Generic stream to an IntStream which has a more specialized
      // min() method which doesn't require a lambda expression.
      {
        int min = ints.stream()
            .mapToInt(a -> a)
            .min().getAsInt();
        System.out.printf("Min C: %d%n", min);
      }
    }
}
