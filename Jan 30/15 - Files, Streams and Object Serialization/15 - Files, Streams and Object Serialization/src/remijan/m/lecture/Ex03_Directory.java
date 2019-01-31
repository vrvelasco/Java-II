package remijan.m.lecture;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Ex03_Directory {

  public static void main(String[] args) throws Exception {

    // The Files object works with the Path object to tell you 
    // more about the existance and attributes of a directory
    // on the file system
    Path projectDir = Paths.get(".").toAbsolutePath(); // '.' = Yourself; ".." = Parent
    System.out.printf("projectDir = %s%n", projectDir);
    System.out.printf("isDirectory = %b%n", Files.isDirectory(projectDir));

    // List directory contents
    {
      System.out.printf("%n");
      DirectoryStream<Path> children
          = Files.newDirectoryStream(projectDir);
      for (Path p : children) { // Loop through contents
        System.out.printf("Child: %s%n", p.getFileName());
      }
    }

    // Filter with simple OS glob filtering
    {
      System.out.printf("%n");
      DirectoryStream<Path> children
          = Files.newDirectoryStream(projectDir, "*.txt");
      for (Path p : children) {
        System.out.printf("GLOB: %s%n", p.getFileName());
      }
    }

    // Filter with DirectoryStream.Filter
    {
      System.out.printf("%n");
      
      // Created filter
      class RegularFileFilter implements DirectoryStream.Filter<Path> {
        @Override
        public boolean accept(Path entry) throws IOException {
          return Files.isRegularFile(entry);
        }
      }

      DirectoryStream<Path> children             // Filter from above
          = Files.newDirectoryStream(projectDir, new RegularFileFilter());
      for (Path p : children) {
        System.out.printf("FILTER: %s%n", p.getFileName());
      }
    }

    // Walk tree
    {
      System.out.printf("%n");
      class MyVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
          System.out.printf("WALK: %s%n", file.toAbsolutePath());
          return java.nio.file.FileVisitResult.CONTINUE;
        }
      }

      Files.walkFileTree(projectDir, new MyVisitor());
    }
  }
}
