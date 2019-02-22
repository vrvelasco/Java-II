package remijan.m.class2.example;

import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Mp3SalesMain {
    public static void main(String[] args) throws Exception {
        ////// Print welcome message
        System.out.printf("Welcome to MP3 Sales%n%n");
        
        ////// Read the data file and save data to a list
        System.out.printf("Reading sales data...%n%n");
        // Create list to hold the data
        List<Sales> salesList = new LinkedList<>();
        // Create reader to read the data from the data file
        try (Scanner reader = new Scanner(Paths.get("mp3.txt")))
        {
            // Loop while there is data to be read from the data file
            while (reader.hasNext()) {
                // Read a line of data from the data file
                String lineOfData = reader.nextLine();
                
                // Split the line of data
                String[] tokens = lineOfData.split(",");
                
                // Get ID
                Integer id = Integer.parseInt(tokens[0].trim());
                
                // Get Genre
                String genre = tokens[1].trim();
                
                // Get Artist
                String artist = tokens[2].trim();
                
                // Get download count
                int downloadCount = Integer.parseInt(tokens[3].trim());
                
                // Get pricePerDownload
                double pricePerDownload = Double.parseDouble(tokens[4].trim());
                
                // Create Sales object to store the data
                Sales sales = new Sales(
                    id, genre, artist, downloadCount, pricePerDownload
                );
                  
                // Store sales in sales list
                salesList.add(sales);
            }
        }
        
        
        ////// Print all of the sales
        System.out.printf("All the sales...%n");
        System.out.printf("%-3s%-10s%-30s%6s%6s%n"
            ,"ID", "Genre", "Artist", "Count", "Price");
        salesList.forEach(s ->
            System.out.printf("%-3s%-10s%-30s%6s%6s%n"
            ,s.getId().toString() // ID
            ,s.getGenre() // Genre
            ,s.getArtist() // Artist
            ,s.getDownloadCount().toString() // Count
            ,s.getPricePerDownload().toString() // Price
            )
        );
        System.out.printf("%n");
            
        
        ////// Print Genre summary
        System.out.printf("Sales by Genre summary...%n");
         Map<String, List<Sales>> byGenre
            = salesList
                .stream()
                .collect(Collectors.groupingBy(i -> i.getGenre()));

        byGenre.forEach(
            (genre, sales) -> {
                System.out.printf("%s%n", genre);
                System.out.printf(
                      "  Downloaded: %4d  Total price: %8s%n"
                      // Reduce downloadCount to a single value: SUM!
                    , sales.stream().mapToInt(s -> s.getDownloadCount()).sum()
                      
                      // Total price is downloadCount * pricePerDownload, so reduce to a sum of this product.
                    //, sales.stream().mapToDouble(s -> s.getDownloadCount() * s.getPricePerDownload()).sum()
                    
                      // Wrap with NumberFormat to get nice currency value
                    , NumberFormat.getCurrencyInstance().format(
                        sales.stream().mapToDouble(s -> s.getDownloadCount() * s.getPricePerDownload()).sum()
                    )
                );                
            }
        );
        
        
        ////// Print good bye message
        System.out.printf("%nGood bye!%n");
    }
}
