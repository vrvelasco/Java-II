package remijan.m.class1.lecture;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Michael
 */
public class Ex01_forEach {
    public static void main(String[] args) {
        
      // Create a List of integers
      ArrayList<Integer>
          ints = new ArrayList<>();      
      Collections.addAll(ints,3,10,6,1,4,8,2,5,9,7);
      
      // Traditional iterator pattern, which loops, retrieves an item
      // from the list, and then processing is done with that item
      for (Integer i : ints) {
        System.out.printf("%d, ", i);
      }
      System.out.printf("%n");
      
      // New stream-lambda expression. A lambda - effectively a method -- is
      // passed to the list. The List then loops internally applying the 
      // method to each item. How the list loops is up to the list.
      ints.stream()
        .forEach(x -> System.out.printf("%d, ", x));
    }
}
