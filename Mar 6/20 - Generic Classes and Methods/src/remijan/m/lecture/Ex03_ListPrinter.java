package remijan.m.lecture;

import java.util.ArrayList;
import java.util.Collections;

public class Ex03_ListPrinter {

    public static void main(String[] args) {

        ListPrinter printer
            = new ListPrinter();

        ArrayList<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 3, 10, 6, 1, 4, 8, 2, 5, 9, 7);
        printer.prettyPrint(ints);

        ArrayList<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 3.5, 10.6, 6.3, 1.6, 4.4, 8.9, 2.1, 5.5, 9.7, 7.5);
        printer.prettyPrint(doubles);

        ArrayList<Name> names = new ArrayList<>();
        Collections.addAll(names, new Name("Rita Red"), new Name("Oscar Orange"));
        printer.prettyPrint(names);
    }
}