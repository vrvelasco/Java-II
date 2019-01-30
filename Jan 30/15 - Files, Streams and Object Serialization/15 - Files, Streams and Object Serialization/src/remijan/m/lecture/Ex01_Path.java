package remijan.m.lecture;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex01_Path {

  public static void main(String[] args) throws IOException {
    
    // A Path object represents a file or directory on the file system.
    // The file or directory doesn't need to exist!
    Path path = Paths.get("WOW.txt");
    System.out.printf("FileName = %s%n", path.getFileName());
    System.out.printf("isAbsolute = %b%n", path.isAbsolute());
    System.out.printf("toAbsolute = %s%n", path.toAbsolutePath());
    System.out.printf("toUri = %s%n", path.toUri());

    Path absolute = Paths.get(path.toUri());
    System.out.printf("isAbsolute = %b%n", absolute.isAbsolute());
  }
}
