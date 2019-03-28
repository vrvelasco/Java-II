package remijan.m.lecture.list4;

public class Ex04_ListIterable {

    public static void main(String[] args) {
        MyList<String> strings
            = new MyList<>();

        strings.add("hello");
        strings.add("doctor");
        strings.add("name");
        strings.add("continue");
        strings.add("yesterday");
        strings.add("tomorrow");

        System.out.printf("%nIterable%n");;
        for (String s : strings) {
            System.out.printf(" %s%n", s);
        }

        System.out.printf("%nDONE%n");
    }
}
