package remijan.m.class1.example;

import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LambdasMain {

    public static void main(String[] args) throws Exception {
        System.out.printf("Welcome to names!%n%n");

        System.out.printf("Creating List to store the data...%n%n");
        List<Name> list
            = new LinkedList<>();

        System.out.printf("Reading and storing data file data...%n%n");
        try (
            // Create Scanner to read the data file
            Scanner scanner = new Scanner(Paths.get("names.txt"))) {
            // Loop while there is more data to read in the data file
            while (scanner.hasNext()) {
                // Get a line of data from the data file
                String line = scanner.nextLine();

                // Trim the line of data, make sure there is actually data
                line = line.trim();

                // If there is data, parse the data.  You 
                // know the data is comma-separated values.
                if (!line.isEmpty()) {
                    // Split the line of data by the comma character ,
                    String[] tokens = line.split(",");

                    // Get ID value
                    Integer id = Integer.parseInt(tokens[0]);

                    // Get First name
                    String firstName = tokens[1];

                    // Get Last name
                    String lastName = tokens[2];

                    // Create Name object to hold data
                    Name name = new Name(id, firstName, lastName);

                    // Store Name object in list
                    list.add(name);
                }
            }
        }
        
        ////// Loop and print
        System.out.printf("Name list:%n");
        list.stream()
            .forEach(n -> System.out.printf(
                  "\tID=%d, First Name=\"%s\", Last Name=\"%s\"%n"
                , n.getId(), n.getFirstName(), n.getLastName())
        );
        System.out.printf("%n");
        
        
        ////// Filter by last name size
        System.out.printf("Last Name greater than 4 characters:%n");
        list.stream()
            .filter(n -> n.getLastName().length() > 4)
            .forEach(n -> System.out.printf(
                  "\tID=%d, First Name=\"%s\", Last Name=\"%s\"%n"
                , n.getId(), n.getFirstName(), n.getLastName())
        );
        System.out.printf("%n");
        

        ////// User search by ID:
        // Create scanner to read user input.
        Scanner input
            = new Scanner(System.in);

        // Loop until user decides to stop
        while (true) {
            // Prompt user to enter and ID value
            System.out.printf("Find name by ID (-1 to exit): ");
            String userInput = input.nextLine();

            if ("-1".equals(userInput)) {
                break;
            }

            Integer id = Integer.parseInt(userInput);
            Optional<Name> optional = list.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
            ;
            
            if (optional.isPresent()) {
                Name name = optional.get();
                System.out.printf("\tID: %d%n", name.getId());
                System.out.printf("\tFirst Name: %s%n", name.getFirstName());
                System.out.printf("\tLast Name: %s%n", name.getLastName());
                System.out.printf("%n");
            } else {
                System.out.printf("\tID %d not found!%n%n", id);
            }
        }
        System.out.printf("%n");

        

        System.out.printf("%nGood bye!%n");
    }
}
