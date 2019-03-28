package remijan.m.lecture.list3;

import java.util.Iterator;

public class Ex03_ListReverseIterator {

    public static void main(String[] args) {
        MyList<String> strings
            = new MyList<>();

        strings.add("hello");
        strings.add("doctor");
        strings.add("name");
        strings.add("continue");
        strings.add("yesterday");
        strings.add("tomorrow");

        System.out.printf("%nReverse Iterator%n");;
        for (Iterator<String> itr = strings.iteratorReverse(); itr.hasNext();) {
            String next = itr.next();
            System.out.printf(" < %s%n", next);
        }

        System.out.printf("%nDONE%n");
    }
}
