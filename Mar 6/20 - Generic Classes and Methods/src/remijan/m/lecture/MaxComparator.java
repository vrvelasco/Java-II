package remijan.m.lecture;

public class MaxComparator {

    ////// This is an example of a generic method that restricts T
    ////// to a value which is assignable to SOMETHING.
    //////
    ////// These methods are defined using the following format:
    //////
    ////// public static <T extends SOMETHING> void methodName(T p1, T p2) { ... }
    //////
    ////// Where:
    //////    `public` is the visibility of the method: public, private, protected, none
    //////    `static` is optional.
    //////    `<T extends SOMETHING>` is the type-parameter section.  There can be more
    //////                            than 1 parameter separated by commas. By specifying
    //////                            "exends SOMETHING" you restrict the type of Java
    //////                            objects passed to this method to either be SOMETHING
    //////                            or a sub-class of SOMETHING
    //////    `void` is the return type...can be anything, including T or any other type-parameter.
    //////    `T` can be used in parameter lists and in the body of the method.
    //////
    public <T extends Comparable> T max(T t1, T t2) {
        T max = null;
        if (t1.compareTo(t2) > 0) {
            max = t1;
        } else if (t2.compareTo(t1) > 0) {
            max = t2;
        } else {
            max = t1;
        }
        return max;
    }
}
