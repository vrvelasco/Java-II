package remijan.m.lecture;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ex02_Collections {

    public static void main(String[] args) {
        // sort
        {
            // The Collections utility class has a method to: sort
            //
            List<Integer> ints = new LinkedList<>();
            ints.add(10);
            ints.add(5);
            ints.add(1);
            ints.add(4);

            System.out.printf("BEFORE%n");
            for (Integer i : ints) {
                System.out.printf("%d%n", i);
            }

            Collections.sort(ints);

            System.out.printf("AFTER%n");
            for (Integer i : ints) {
                System.out.printf("%d%n", i);
            }
        }
        // min
        {
            // The Collections utility class has a method to: Find minimum
            //
            System.out.printf("%n");

            List<Integer> ints = new LinkedList<>();
            ints.add(10);
            ints.add(5);
            ints.add(1);
            ints.add(4);

            int min = Collections.min(ints);
            System.out.printf("MIN %d%n", min);
        }
        // max
        {
            // The Collections utility class has a method to: Find maximum
            //
            System.out.printf("%n");

            List<Integer> ints = new LinkedList<>();
            ints.add(10);
            ints.add(5);
            ints.add(1);
            ints.add(4);

            int max = Collections.max(ints);
            System.out.printf("MAX %d%n", max);
        }

        // frequency
        {
            // The Collections utility class has a method to: Find frequency of a value
            //
            System.out.printf("%n");

            List<Integer> ints = new LinkedList<>();
            ints.add(4);
            ints.add(10);
            ints.add(3);
            ints.add(1);
            ints.add(4);
            ints.add(10);
            ints.add(4);

            System.out.printf("Frequency 10: %d%n", Collections.frequency(ints, 10));
            System.out.printf("Frequency  4: %d%n", Collections.frequency(ints, 4));
            System.out.printf("Frequency  1: %d%n", Collections.frequency(ints, 1));
        }

        // reverse
        {
        // The Collections utility class has a method to: reverse
            //
            System.out.printf("%n");

            List<Integer> ints = new LinkedList<>();
            ints.add(1);
            ints.add(2);
            ints.add(3);
            ints.add(4);
            ints.add(5);

            System.out.printf("BEFORE%n");
            for (Integer i : ints) {
                System.out.printf("%d%n", i);
            }

            Collections.reverse(ints);

            System.out.printf("AFTER%n");
            for (Integer i : ints) {
                System.out.printf("%d%n", i);
            }
        }
    }
}
