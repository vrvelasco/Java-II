package remijan.m.class2.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ex07_sorted {
    public static void main(String[] args) {
      ArrayList<Integer>
          ints = new ArrayList<>();      
      Collections.addAll(ints,3,10,6,1,4,8,2,5,9,7);
      
      // Low to high
      {
        List<Integer> sorted = ints.stream()
            .sorted()
            .collect(Collectors.toList());
        
        System.out.printf("Low to high: %s%n", sorted);
      }
      
      // high to low
      {
        List<Integer> sorted = ints.stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
        
        System.out.printf("High to low: %s%n", sorted);
      }
      
      
      // Between 4-8 inclusive, sorted reverse order.
      {
        List<Integer> sorted = ints.stream()
            .filter(a -> (a >= 4 && a<=8))
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
        
        System.out.printf("Filtered & sorted: %s%n", sorted);
      }
      
    }
}
