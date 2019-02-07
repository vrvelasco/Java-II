package remijan.m.lecture;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ex07_Map {

    public static void main(String[] args) {

        // A map is a data structure that stores values based on key value.  
        // It has these basic operations
        //   put   (put object into the map based on a key value)
        //   get   (get object from map by key value)
        
        // Simple map
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "red");
        map.put(2, "orange");
        map.put(3, "yellow");

        System.out.printf("%s%n", String.valueOf(map));

        // Replace value of key
        {
            System.out.printf("%n");

            map.put(1, "green");
            System.out.printf("%s%n", String.valueOf(map));
        }

        // Find by key
        {
            System.out.printf("%n");
            int key = 1;
            if (map.containsKey(key)) {
                String val = map.get(key);
                System.out.printf("Key %d, Value %s%n", key, val);
            }
        }

        // Loop by key
        {
            System.out.printf("%n");
            for (int key : map.keySet()) {
                String val = map.get(key);
                System.out.printf("Key %d, Value %s%n", key, val);
            }
        }

        // value is list.
        {
            System.out.printf("%n");
            Map<String, List<Integer>> data = new HashMap<>();

            data.put("monday", Arrays.asList(10,4,5,88,56));
            data.put("tuesday", Arrays.asList(9,84,10,7363,3));
            data.put("wednesday", Arrays.asList(0,0,0,6));
            data.put("thursday", Arrays.asList(2,90,912,35,6,8247,485,716));

            System.out.printf("%s%n", String.valueOf(data));

        }
    }
}
