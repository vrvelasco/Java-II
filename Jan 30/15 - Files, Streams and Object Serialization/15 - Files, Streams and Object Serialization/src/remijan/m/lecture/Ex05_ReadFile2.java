package remijan.m.lecture;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ex05_ReadFile2 {

    public static void main(String[] args) throws Exception {

        // Path defines the file you want to read
        Path colors
            = Paths.get("colors.txt");

        // Let's get a little more complicated than just echoing the data
        try (
            // You already know an object that is able to read data!
            Scanner scanner
            = new Scanner(colors);
        ) {
            while (scanner.hasNext()) {
                // Process each line of data by splitting it into parts
                String line = scanner.nextLine();
                String[] tokens = line.split("\t");
                int index = Integer.parseInt(tokens[0]);
                String color = tokens[1];
                System.out.printf("Index: %d, Color: \"%s\"%n", index, color);
            }
        }
    }
}
