package remijan.m.class2.lecture;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.printf("Welcome to Names database\n\n");
        
        Scanner scanner 
            = new Scanner(System.in);
        
        DataPath    dataPath = new DataPath();
        DataHandler dataHandler = new DataHandler(DataPath);
        DataPrinter dataPrinter = new DataPrinter();

        
        //
        // Print the book table
        //
        List<Names> names
            = dataHandler.findNames();
        dataPrinter.print(names);

        //
        // Enter data for a new book
        //
        System.out.printf("\nENTER DATA FOR NEW BOOK\n");
        System.out.printf("ID: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.printf("AUTHOR: ");
        String author = scanner.nextLine();
        System.out.printf("TITLE: ");
        String title = scanner.nextLine();
        System.out.printf("PRICE: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.printf("BESTSELLER (y/n): ");
        Boolean bestSeller = "y".equals(scanner.nextLine());
        System.out.printf("PUBLICATION DATE (MM/dd/yyyy): ");
        String pdStr = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date pd = sdf.parse(pdStr);

        Book newBook = new Book();
        newBook.setAuthor(author);
        newBook.setBestSeller(bestSeller);
        newBook.setId(id);
        newBook.setPrice(price);
        newBook.setPublicationDate(pd);
        newBook.setTitle(title);

        int insertCount = bookHandler.insert(newBook);
        System.out.printf("%nInsert count: %d%n", insertCount);
        
        
        //
        // Print the book table
        //
        bookPrinter.print(
            bookHandler.findBooks()
        );

        
        //
        // Update the price of a book
        //
        System.out.printf("\nUPDATE PRICE OF BOOK\n");
        System.out.printf("ID: ");
        id = Integer.parseInt(scanner.nextLine());
        System.out.printf("PRICE: ");
        price = new BigDecimal(scanner.nextLine());

        int updateCount = bookHandler.updatePrice(id, price);
        System.out.printf("%nUpdate count: %d%n", updateCount);
        
        
        //
        // Print the book table
        //
        bookPrinter.print(
            bookHandler.findBooks()
        );

        
        //
        // Delete a book
        //
        System.out.printf("\nDELETE A BOOK\n");
        System.out.printf("ID: ");
        id = Integer.parseInt(scanner.nextLine());
        int deleteCount = bookHandler.delete(id);
        System.out.printf("%nDelete count: %d%n", deleteCount);
        
        
        //
        // Print the book table
        //
        bookPrinter.print(
            bookHandler.findBooks()
        );

        
        // Done
        System.out.printf("\nGood bye!\n");
    }

}
