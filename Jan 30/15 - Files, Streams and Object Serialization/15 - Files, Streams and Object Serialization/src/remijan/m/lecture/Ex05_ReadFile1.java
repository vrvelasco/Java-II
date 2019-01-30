package remijan.m.lecture;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ex05_ReadFile1 {

    public static void main(String[] args) throws Exception {

        // Path defines the file you want to read
        Path colors
            = Paths.get("colors.txt");

        try (
            // You already know an object that is able to read data!       
            Scanner scanner
                = new Scanner(colors);
        ){
            // Loop and echo the contents of the file
            while (scanner.hasNext()) {
                System.out.printf("LINE: \"%s\"%n", scanner.nextLine());
            }
        }
    }
}
