package remijan.m.class1.lecture;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class SystemTool {

    /**
     * A convenience method which will print whatever message is passed to it along with the name of the thread that is currently executing this code
     */
    public static void printf(String format, Object... params) {
        // Create a new list to hold the thread name.
        List<Object> list = new LinkedList<>();
        list.add(Thread.currentThread().getName());

        // Add all of the 'params' vararg array into a List
        list.addAll(
            Arrays.stream(params).collect(Collectors.toList())
        );

        // Print out
        System.out.printf("[%s] " + format, list.toArray());
    }
}
