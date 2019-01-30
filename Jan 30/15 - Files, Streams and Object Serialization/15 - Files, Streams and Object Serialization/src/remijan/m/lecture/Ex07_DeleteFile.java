package remijan.m.lecture;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex07_DeleteFile {

  public static void main(String[] args) throws Exception {
    // Files object makes deleting files trival
    Path deleteMe = Paths.get("newfile-copy.txt");
    Files.delete(deleteMe);
    System.out.printf("DONE%n");
  }
}
