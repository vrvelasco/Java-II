package remijan.m.lecture;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex06_CopyFiles {

  public static void main(String[] args) throws Exception {
    // Files object makes copying files trivial
    Path newFileOrig = Paths.get("newfile.txt");
    Path newFileCopy = Paths.get("newfile-copy.txt");
    Files.copy(newFileOrig, newFileCopy);
    System.out.printf("DONE%n");
  }
}
