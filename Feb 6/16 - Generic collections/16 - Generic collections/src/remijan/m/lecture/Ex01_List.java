package remijan.m.lecture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex01_List {

    public static void main(String[] args) {

        // ArrayList
        {
            // This is the way to create a new instance of an ArrayList object
            // That holds String objects
            List<String> strings
                = new ArrayList<>();

            // This is how to add items to the list.
            strings.add("hello");
            strings.add("world");
            // This will not work because it's not a String
            //strings.add(1);

            // This is how to use a for loop to loop over the elements of the list
            for (String s : strings) {
                System.out.printf("%s%n", s);
            }

            strings.add("world");
            strings.add("world");
            strings.add("world");
            strings.add("world");

            for (String s : strings) {
                System.out.printf("%s%n", s);
            }
            
            // index
            System.out.printf("%nloop by index%n");
            for (int i = 0; i < strings.size(); i++)
            {
                System.out.printf("%s%n", strings.get(i));
            }
            
        }
        // LinkedList
        {
            System.out.printf("%n");

            // This is the way to create a new instance of a LinkedList object
            // That holds Integer objects
            List<Integer> ints
                = new LinkedList<>();

            // This is how to add items to the list.
            ints.add(1);                // auto boxing
            ints.add(new Integer(2));   // new Integer object
            // This will not work because it is not an integer
            //ints.add("foo");

            
            // This is how to use a for loop to loop over the elements of the list
            for (Integer i : ints) {
                System.out.printf("%d%n", i);
            }
        }

        // Copying  (CONSTRUCTOR)
        {
            System.out.printf("%ncopy (constructor)%n");

            // Source list
            List<Integer> src
                = new LinkedList<>();
            // Fill list with values
            src.add(1);
            src.add(2);
            src.add(3);

            // Destination list. Copy the contents of the source list 
            // into this list by passing the source list to the constructor
            // of the destination list.
            List<Integer> dst
                = new LinkedList<>(src);

            // Loop and show destination list
            for (Integer i : dst) {
                System.out.printf("%d%n", i);
            }
        }

        // Copying  (ADD ALL)
        {
            System.out.printf("%ncopy (add all)%n");

            // Source list
            List<Integer> src
                = new LinkedList<>();
            // Fill list with values
            src.add(1);
            src.add(2);
            src.add(3);

            // Destination list. Create new destination list. Then use the
            // addAll(src) method to copy the values from the source list
            // into the destination list.
            List<Integer> dst = new LinkedList<>();
            dst.addAll(src);

            // Loop and show destination list
            for (Integer i : dst) {
                System.out.printf("%d%n", i);
            }
        }
    }
}
