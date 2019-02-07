package remijan.m.lecture;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex06_Set {

    public static void main(String[] args) {
        
        // A set is a special list data structure which does not allow duplicate
        // values.  
        // It has these basic operations
        //   add   (add object to the set)
        {
            // A HashSet uses the Object#equals() method to compare objects to
            // determine if they are equal. You must override the Object#equals()
            // method if you want to change the default equals() behavior.
            Set<String> set = new HashSet<>();
                       
            set.add("a");
            set.add("a");
            set.add("A"); // upper and lower case are lexographically different
            set.add("B"); 
            set.add("b");
            set.add("b");
            set.add("c");
            set.add("d");
            set.add("e");
            set.add("e");
            set.add("f");

            System.out.printf("HashSet default%n");
            for (String s : set) {
                System.out.printf("%s%n", s);
            }
            System.out.printf("%n");
        }
        
        {
            // A HashSet uses the Object#equals() method to compare objects to
            // determine if they are equal. You must override the Object#equals()
            // method if you want to change the default equals() behavior.
            class CaseInsensitiveComparator implements Comparator<String> {
                @Override
                public int compare(String o1, String o2) {
                    return o1.toUpperCase().compareTo(o2.toUpperCase());
                }
            }
            Set<String> set = new TreeSet<>(new CaseInsensitiveComparator());

            set.add("a");
            set.add("a");
            set.add("A"); // CaseInsensitiveComparator treats upper and lower case the same
            set.add("B");
            set.add("b");
            set.add("b");            
            set.add("c");
            set.add("d");
            set.add("e");
            set.add("e");
            set.add("f");

            System.out.printf("TreeSet CaseInsensitiveComparator%n");
            for (String s : set) {
                System.out.printf("%s%n", s);
            }
            System.out.printf("%n");
        }
    }
}
