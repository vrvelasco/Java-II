package remijan.m.lecture.list1;

public class Ex01_ListAdd {

    public static void main(String[] args) {
        MyList<String> strings
            = new MyList<>();

        strings.add("hello");
        strings.add("doctor");
        strings.add("name");
        strings.add("continue");
        strings.add("yesterday");
        strings.add("tomorrow");

        System.out.printf("%nTo String%n");
        System.out.printf("%s%n", strings.toString());

        System.out.printf("%nDONE%n");
    }
}
