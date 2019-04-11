package remijan.m.class2.lecture;

import java.util.List;

public class BookPrinter {

    public void print(List<Book> books) {
        System.out.printf("\nBOOKS\n");
        System.out.printf("=====\n");
        books.forEach(b
            -> System.out.printf(
                "%d\t %s\t %s\t %b\t %f\t %s\n",
                b.getId(),
                b.getAuthor(),
                b.getTitle(),
                b.getBestSeller(),
                b.getPrice().doubleValue(),
                b.getPublicationDate()
            )
        );
        System.out.printf("=====\n");
    }
}
