package remijan.m.class2.lecture;

import java.util.List;

public class DataPrinter {

    public void print(List<Names> names) {
        System.out.printf("\nNames\n");
        System.out.printf("=====\n");
        books.forEach(b
            -> System.out.printf(
                "%d\t %s\t %s\t", // %b\t %f\t %s\n",
                b.getId(),
                b.getAuthor(),
                b.getTitle(),
                //b.getBestSeller(),
                //b.getPrice().doubleValue(),
               // b.getPublicationDate()
            )
        );
        System.out.printf("=====\n");
    }
}
