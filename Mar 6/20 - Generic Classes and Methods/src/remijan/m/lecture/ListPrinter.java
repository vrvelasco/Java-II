package remijan.m.lecture;

import java.util.List;
import java.util.StringJoiner;

public class ListPrinter {

    ////// This is an example of a generic method.
    ////// These methods are defined using the following format:
    //////
    ////// public static <T> void methodName(T p1, T p2) { ... }
    //////
    ////// Where:
    //////    `public` is the visibility of the method: public, private, protected, none
    //////    `static` is optional.
    //////    `<T>` is the type-parameter section.  There can be more than 1 parameter separated by commas
    //////    `void` is the return type...can be anything, including T or any other type-parameter.
    //////    `T` can be used in parameter lists and in the body of the method.
    //////
    public <T> void prettyPrint(List<T> list) {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        list.forEach(x -> sj.add(String.valueOf(x)));
        System.out.printf("%s%n", sj.toString());
    }
}
