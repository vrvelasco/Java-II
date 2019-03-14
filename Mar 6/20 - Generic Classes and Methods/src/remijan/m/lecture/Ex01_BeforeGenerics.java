package remijan.m.lecture;

import java.nio.file.Paths;
import java.util.LinkedList;

public class Ex01_BeforeGenerics {

    public static void main(String[] args) {
        // Before Generics
        LinkedList objectList = new LinkedList();
        objectList.add(1);
        objectList.add("hello");
        objectList.add(Paths.get("doctor.txt"));

        Integer intval = (Integer) objectList.get(0);
        System.out.printf("intval = %d%n", intval);

        // After Generics
        LinkedList<Integer> integerList
            = new LinkedList<>();
        integerList.add(1);
        //integerList.add("name");
        intval = integerList.get(0);

        // Generics 
        LinkedList<String> stringList
            = new LinkedList<>();
        stringList.add("continue");
        //stringList.add(Paths.get("yesterday.mp3"));
    }
}
