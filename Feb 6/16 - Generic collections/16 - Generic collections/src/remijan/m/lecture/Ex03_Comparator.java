package remijan.m.lecture;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ex03_Comparator {

    public static void main(String[] args) {
        // sort by name (default)
        {
            // By default, sorting uses the Object.equals() method
            // to compare objects. This gives you default sorting
            // behavior which may not be desirable.
            List<String> strs = new LinkedList<>();
            strs.add("hello");
            strs.add("doctor");
            strs.add("name");
            strs.add("continue");
            strs.add("yesterday");
            strs.add("tomorrow");

            System.out.printf("BEFORE%n");
            for (String s : strs) {
                System.out.printf("%s%n", s);
            }

            Collections.sort(strs);

            System.out.printf("AFTER%n");
            for (String s : strs) {
                System.out.printf("%s%n", s);
            }
        }
        // sort by length
        {
            // A Comparator can be used to customize how the objects are
            // compared while sorting. This examples how to create your
            // own Comparator<String> to sort by string length.
            System.out.printf("%n");

            List<String> strs = new LinkedList<>();
            strs.add("hello");
            strs.add("doctor");
            strs.add("name");
            strs.add("continue");
            strs.add("yesterday");
            strs.add("tomorrow");

            System.out.printf("BEFORE%n");
            for (String s : strs) {
                System.out.printf("%s%n", s);
            }

            Collections.sort(strs, new StringLengthComparator());

            System.out.printf("AFTER%n");
            for (String s : strs) {
                System.out.printf("%s%n", s);
            }
        }
    }
}
