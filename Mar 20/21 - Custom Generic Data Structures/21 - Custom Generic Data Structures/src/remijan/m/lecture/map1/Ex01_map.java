package remijan.m.lecture.map1;

import java.util.HashMap;
import java.util.Map;

public class Ex01_map {
    public static void main(String[] args) {
        Map<Integer, String> map
            = new HashMap<>();
        
        map.put(100, "Rita Red");
        map.put(200, "Oscar Orange");
        map.put(300, "Yet Yellow");
        map.put(400, "Gary Green");
        map.put(500, "Betty Blue");
        map.put(600, null);
        
        // Find a value by looking up by key
        String rita
            = map.get(100);
        System.out.printf("100 is \"%s\"%n%n", rita);
        
        // If a key isn't present, it will return null for the value
        String missing
            = map.get(7977);
        System.out.printf("7977 is \"%s\"%n%n", missing);
        
        // Use containsKey to determine if a key exists
        // This is the reliable way to determine if
        // data exists for a key.  Data in the map can be null.
        boolean contains
            = map.containsKey(7977);
        System.out.printf("Contains 7977 is %b%n%n", contains);
        
        // Get all the keys
        System.out.printf("-- All the keys --%n");
        map.keySet().forEach(System.out::println);
        System.out.printf("%n");
        
        // Get all the keys
        System.out.printf("-- All the values --%n");
        map.values().forEach(System.out::println);
        System.out.printf("%n");
        
        // Internal object that holds both keys and values
        System.out.printf("-- Both keys and values --%n");
        map.entrySet().forEach(
            t -> System.out.printf("key=%d value=\"%s\"%n",t.getKey(),t.getValue()));
        System.out.printf("%n");
        
    }
}
