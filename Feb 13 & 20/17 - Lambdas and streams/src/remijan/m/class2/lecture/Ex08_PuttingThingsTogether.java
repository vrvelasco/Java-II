package remijan.m.class2.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Ex08_PuttingThingsTogether {
    public static void main(String[] args) {
      ArrayList<Integer>
          ints = new ArrayList<>();      
      Collections.addAll(ints,3,10,6,1,4,8,2,5,9,7);
      
      // Odd values
      // Square
      // Sorted
      {
        List<Integer> list = ints.stream()
            .filter(a -> (a % 2 != 0))
            .map(a -> a * a)
            .sorted()
            .collect(Collectors.toList());
        
        System.out.printf("Ex A: %s%n", list);
      }
      
      // Odd values
      // Original & doubled value
      // sorted by double value (reversed)
      {
        class Touple implements Comparable<Touple> {
          Integer orginal;
          Integer doubled;

          @Override
          public int compareTo(Touple t) {
            return t.doubled.compareTo(this.doubled);
          }
          
          @Override
          public String toString() {
            return new StringJoiner(",", "[", "]")
              .add(String.valueOf(this.orginal))
              .add(String.valueOf(this.doubled))
              .toString();
          }
        }
        List<Touple> list = ints.stream()
            .filter(a -> (a % 2 != 0))
            .map(a -> {
              Touple t = new Touple();
              t.orginal = a;
              t.doubled = a * 2;
              return t;
            })
            .sorted()
            .collect(Collectors.toList());
        
        System.out.printf("Ex B: %s%n", list);
      }
    }
}
