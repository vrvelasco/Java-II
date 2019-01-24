package remijan.m.lecture;

public class Ex07_SplittingStrings {
  public static void main(String[] args) {
    // split
    {
      String s1 = "some, delimited,  string,   of,data";
      String [] tokens = s1.split(",");
      for (String token : tokens) {
        System.out.printf("\"%s\"%n",token);
      }
    }
  }
}

