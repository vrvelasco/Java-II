package remijan.m.lecture;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex01_Path {

  public static void main(String[] args) throws IOException {
    
    // A Path object represents a file or directory on the file system.
    // The file or directory doesn't need to exist!
    Path path = Paths.get("WOW.txt"); // Directory or file
    System.out.printf("FileName = %s%n", path.getFileName()); // Guesses file name
    System.out.printf("isAbsolute = %b%n", path.isAbsolute()); // Guess if fully qualified path (root)
    System.out.printf("toAbsolute = %s%n", path.toAbsolutePath()); // Guesses where the project directory is
    System.out.printf("toUri = %s%n", path.toUri()); // URL for browser

    Path absolute = Paths.get(path.toUri());
    System.out.printf("isAbsolute = %b%n", absolute.isAbsolute());
  }
}
