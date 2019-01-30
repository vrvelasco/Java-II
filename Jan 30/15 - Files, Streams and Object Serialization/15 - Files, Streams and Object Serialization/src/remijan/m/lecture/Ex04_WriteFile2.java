package remijan.m.lecture;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;

public class Ex04_WriteFile2 {

    public static void main(String[] args) throws Exception {

        // Path defines the file you want to create/write
        Path colors = Paths.get("colors.txt").toAbsolutePath();
        System.out.printf("Write to: %s%n", colors.toString());

        try (
            // OutputStream is a low-level API for writing bytes somewhere
            OutputStream os
                = Files.newOutputStream(colors);
                //= Files.newOutputStream(colors, StandardOpenOption.APPEND);

            // Formatter is a decorator over OutputStream and makes
            // writing bytes a lot easier.
            Formatter formatter
                = new Formatter(os);
        ) {
            // Write to the file
            int i = 0;
            formatter.format("%d\t%s%n", ++i, "red");
            formatter.format("%d\t%s%n", ++i, "orange");
            formatter.format("%d\t%s%n", ++i, "yellow");
            formatter.format("%d\t%s%n", ++i, "green");
            formatter.format("%d\t%s%n", ++i, "blue");
            formatter.format("%d\t%s%n", ++i, "indigo");
            formatter.format("%d\t%s%n", ++i, "violet");

            // Whenever you are WRITING, you must **ALWAYS** remember to flush
            formatter.flush();
            
            // No need to close...JAVA does it for you.
            // formatter.close();
        }

        System.out.printf("DONE%n");
    }
}
