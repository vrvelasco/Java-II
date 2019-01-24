package remijan.m.lecture;

public class Ex05_OperationsReturningAlteredStrings {
  public static void main(String[] args) {
    // trim()
    {
      String s1 = "  hello world   ";
      System.out.printf("\"%s\"%n", s1);
      
      String trimmed = s1.trim();
      System.out.printf("\"%s\"%n", trimmed);
      System.out.printf("%n");
    }
    // substring()
    {
      String s1 = "hello world";  
      
      String substring5 = s1.substring(5);
      System.out.printf("substring = \"%s\"%n", substring5);
      
      String substring37 = s1.substring(3,7);
      System.out.printf("substring = \"%s\"%n", substring37);
      System.out.printf("%n");
    }
    // toUpperCase()
    {
      String s1 = "hello world";
      
      String asUpper = s1.toUpperCase();
      System.out.printf("toUpperCase = %s%n", asUpper);
      System.out.printf("%n");
    }
    // toLowerCase()
    {
      String s1 = "Hello WORLD";
      
      String asLower = s1.toLowerCase();
      System.out.printf("toLowerCase = %s%n", asLower);
      System.out.printf("%n");
    }
    // replace()
    {
      String s1 = "hello world";
      
      String replaced = s1.replace("ll", "LL");
      System.out.printf("replace = %s%n", replaced);
      System.out.printf("%n");
    }
  }
}
