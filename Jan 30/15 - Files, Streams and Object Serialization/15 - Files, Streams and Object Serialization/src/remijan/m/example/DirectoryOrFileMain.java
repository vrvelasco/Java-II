package remijan.m.example;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DirectoryOrFileMain {

    public static void main(String[] args) throws Exception {
        System.out.printf("Welcome to Directory or File%n%n");

        Scanner input
            = new Scanner(System.in);

        while (true) {
            System.out.printf("Enter directory or file (-1 to exit): ");
            String userInput
                = input.nextLine();

            // If the user wants to exit, break out of the loop
            if ("-1".equals(userInput)) {
                break;
            }

            Path userPath
                = Paths.get(userInput);

            // If path does not exist, inform the user. 
            if (!Files.exists(userPath)) {
                System.out.printf("Directory or file does not exist!%n%n");
            } 
            // If the path is a directory, get a directory listing
            else if (Files.isDirectory(userPath)) {
                DirectoryStream<Path> children
                    = Files.newDirectoryStream(userPath);
                for (Path p : children) {
                    System.out.printf("\t%s (%d bytes)%n", p.getFileName(), Files.size(p));
                }
                System.out.printf("%n");
            } 
            // Otherwise, assume it's a file and read the contents
            else {
                // Create a scanner within the try statement
                // Java will auto-close the Scanner
                try (Scanner scanner = new Scanner(userPath) )
                {
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                }
                System.out.printf("%n");
            }
        }
        System.out.printf("%nGood bye!%n");
    }
}
