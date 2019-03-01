package remijan.m.lecture;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Michael
 */
public class Ex04_printDirectory {

    public static void main(String[] args) throws Exception {
        
        ////// Navigating trees, such as a file system,
        ////// is another great example of using recursion
        Path p = Paths.get("").toAbsolutePath();
        System.out.printf("Path: %s%n", p);
        print(1, p);
    }

    public static void print(int depth, Path parent) {
        System.out.printf("%" + depth + "s", "");
        System.out.printf("%s%n", parent.getFileName());
        try {
            Files.newDirectoryStream(parent, c -> Files.isDirectory(c))
                .forEach(c -> print(depth + 4, c));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
