package remijan.m.class2.lecture;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.printf("Welcome to Book database%n%n");
        
        Scanner scanner 
            = new Scanner(System.in);
        
        BookPath    bookPath = new BookPath();
        BookHandler bookHandler = new BookHandler(bookPath);
        BookPrinter bookPrinter = new BookPrinter();

        
        //
        // Print the book table
        //
        List<Book> books
            = bookHandler.findBooks();
        bookPrinter.print(books);

        //
        // Enter data for a new book
        //
        boolean keepAsking = true;
        while (keepAsking) {
	        System.out.printf("%nENTER DATA FOR NEW BOOK%n");
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
	        
	        System.out.printf("%nDo you want to add another book (y/n)? ");
	        String yon = scanner.nextLine().toUpperCase();
	        if (yon.startsWith("N")) {
	        	keepAsking = false;
	        }
        }
        
        
        //
        // Print the book table
        //
        bookPrinter.print(
            bookHandler.findBooks()
        );

        
        //
        // Update the price of a book
        //
        System.out.printf("%nUPDATE PRICE OF BOOK%n");
        System.out.printf("ID: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.printf("PRICE: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

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
        System.out.printf("%nDELETE A BOOK%n");
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
        
        
        //
        // Search for a book by title
        //
        System.out.printf("%nSEARCH BOOKS BY TITLE%n");
        System.out.printf("TITLE: ");
        String searchTitle = scanner.nextLine();
        List<Book> matchTitle = bookHandler.findBooksByTitle(searchTitle);
        //
        // Print the search results
        //
        bookPrinter.print(
        		matchTitle
        );
        

        
        // Done
        System.out.printf("%nGood bye!%n");
    }

}
