package remijan.m.example;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NameMain {

    public static void main(String[] args) throws Exception {
        System.out.printf("Welcome to names!%n%n");

        System.out.printf("Creating map to store the data...%n%n");
        Map<Integer, Name> map
            = new HashMap<>();

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

                    // Store Name object in map
                    map.put(name.getId(), name);
                }
            }
        }

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
            if (!map.containsKey(id)) {
                System.out.printf("\tID %d not found!%n%n", id);
            } else {
                Name name = map.get(id);
                System.out.printf("\tID: %d%n", name.getId());
                System.out.printf("\tFirst Name: %s%n", name.getFirstName());
                System.out.printf("\tLast Name: %s%n", name.getLastName());
                System.out.printf("%n");
            }
        }
        System.out.printf("%n");

        ////// Sort by last Name
        // Create list to hold Name objects
        List<Name> list
            = new ArrayList<>(map.size());

        // Add all name objects to the list
        list.addAll(map.values());
        
        // Use collections to sort Name objects by last name value
        Collections.sort(list, new LastNameComparator());
        
        // Print sorted list
        System.out.printf("Sorted by last name:%n");
        for (Name n : list) {
            System.out.printf("\t%s%n", n.getLastName());
        }
        System.out.printf("%n");

        System.out.printf("%nGood bye!%n");
    }
}
