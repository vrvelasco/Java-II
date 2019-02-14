package remijan.m.class1.lecture;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04_map {
    public static void main(String[] args) {
     
      // Create a List of integers
      ArrayList<Integer>
          ints = new ArrayList<>();      
      Collections.addAll(ints,3,10,6,1,4,8,2,5,9,7);
      
      // A stream map() operation takes a stream of size N of type A
      // and turns it into a new stream of size N of type B. In other
      // words, when you map(), the size remains the same but the
      // type of objects in the stream may change. 
      
      // Map to identity
      {
        List<Integer> mapped = ints
            .stream()
            .map(a -> a)
            .collect(Collectors.toList());
            
        System.out.printf("Idenity: %s%n", mapped);
      }
      
      // Map to squares
      {
        List<Integer> mapped = ints
            .stream()
            .map(a -> a * a)
            .collect(Collectors.toList());
            
        System.out.printf("Squares: %s%n", mapped);
      }
      
      // Map to halves
      {
        List<Double> mapped = ints
            .stream()
            .map(a ->  a / 2.0)
            .collect(Collectors.toList());
            
        System.out.printf("Halves: %s%n", mapped);
      }
      
      // Map to strings
      {
        List<String> mapped = ints
            .stream()
            .map(a ->  "INC-" + a)
            .collect(Collectors.toList());
            
        System.out.printf("Strings: %s%n", mapped);
      }
      
      // Map to BigDecimal
      {
        List<BigDecimal> mapped = ints
            .stream()
            .map(a ->  new BigDecimal(a).negate())
            .collect(Collectors.toList());
          
        System.out.printf("BigDecimal: %s%n", mapped);
      }
    
    //In class example
    class Age{
        private int age;
        public Age (int x) {
            age = x;
        }
        
        @Override
        public String toString() {
            return "age: " + age;
        }
    }
        List<Age> mapped = ints
            .stream()
            .map(a ->  new Age(a))
            .collect(Collectors.toList());
          
        System.out.printf("Ages: %s%n", mapped);
    }
}
