package remijan.m.class1.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ex06_filter {
    public static void main(String[] args) {
      
      // Create a List of integers
      ArrayList<Integer>
          ints = new ArrayList<>();      
      Collections.addAll(ints,3,10,6,1,4,8,2,5,9,7);
      
      // The filter operation take a stream of size N and type A
      // and turns it into a new stream of size K and type A. In
      // other words, the size of the new stream may be smaller
      // and the type remains the same.
      
      // Evens
      {
        List<Integer> filtered = ints.stream()
            .filter (a -> a % 2 == 0)
            .collect(Collectors.toList());
        
        System.out.printf("Evens: %s%n", filtered);
      }
      
      // Odds
      {
        List<Integer> filtered = ints.stream()
            .filter (a -> a % 2 != 0)
            .collect(Collectors.toList());
        
        System.out.printf("Odds: %s%n", filtered);
      }
      
      // Values over 1000
      {
        List<Integer> filtered = ints.stream()
            .filter (a -> a > 1000)
            .collect(Collectors.toList());
        
        System.out.printf("Values over 1000: %s%n", filtered);
      }
      
      // Identity
      {
        List<Integer> filtered = ints.stream()
            .filter (a -> true)
            .collect(Collectors.toList());
        
        System.out.printf("Identity: %s%n", filtered);
      }
    }
}
