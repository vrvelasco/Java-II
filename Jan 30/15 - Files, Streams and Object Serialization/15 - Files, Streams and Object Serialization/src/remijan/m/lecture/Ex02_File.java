package remijan.m.lecture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex02_File {

  public static void main(String[] args) throws IOException {

    // The Files object works with the Path object to tell you 
    // more about the existance and attributes of a file
    // on the file system
    {
      Path path = Paths.get("WOW.txt");
      System.out.printf("exists = %b%n", Files.exists(path));
      System.out.printf("isDirectory = %b%n", Files.isDirectory(path));
      System.out.printf("isRegularFile = %b%n", Files.isRegularFile(path));
      System.out.printf("isReadable = %b%n", Files.isReadable(path));

      // This blows up because the file doesn't exist
      // System.out.printf("size = %d%n", Files.size(path));
    }

    // A file named `newfile.txt` exists in the root of the project directory
    // 
    // The root of the project directory is 
    // the starting point for relative file paths
    {
      System.out.printf("%n");
      Path path = Paths.get("newfile.txt");
      System.out.printf("exists = %b%n", Files.exists(path));
      System.out.printf("isDirectory = %b%n", Files.isDirectory(path));
      System.out.printf("isRegularFile = %b%n", Files.isRegularFile(path));
      System.out.printf("isReadable = %b%n", Files.isReadable(path));
      System.out.printf("size = %d%n", Files.size(path));
      System.out.printf("lastModifiedTime = %s%n", Files.getLastModifiedTime(path));      
    }
  }
}
