package remijan.m.lecture.list2;

import java.util.Iterator;

public class Ex02_ListIterator {

    public static void main(String[] args) {
        MyList<String> strings
            = new MyList<>();

        strings.add("hello");
        strings.add("doctor");
        strings.add("name");
        strings.add("continue");
        strings.add("yesterday");
        strings.add("tomorrow");

        System.out.printf("%nIterator%n");;
        for (Iterator<String> itr = strings.iterator(); itr.hasNext();) {
            String next = itr.next();
            System.out.printf(" > %s%n", next);
        }

        System.out.printf("%nDONE%n");
    }
}
