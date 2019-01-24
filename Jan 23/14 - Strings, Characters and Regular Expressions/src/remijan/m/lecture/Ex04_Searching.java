package remijan.m.lecture;

public class Ex04_Searching {
  public static void main(String[] args) {
    // charAt()
    {
      String s1 = "hello world";
      for (int i=0; i<s1.length(); i++) {
        char c = s1.charAt(i);
        System.out.printf("%d: %s = %d%n", i, c, (int)c);
        System.out.printf("%n");
      }
    }
    // indexOf()
    {
      String s1 = "hello world";
      
      int idx = s1.indexOf("hello");
      System.out.printf("hello = %d%n", idx);
      
      idx = s1.indexOf("world");
      System.out.printf("world = %d%n", idx);     
      System.out.printf("%n");
    }
    // indexOf()
    {
      String s1 = "abc abc abc";
      
      int idx = s1.indexOf("abc");
      System.out.printf("1st abc = %d%n", idx);
      
      idx = s1.indexOf("abc", idx + 1);
      System.out.printf("2nd abc = %d%n", idx);   
      
      idx = s1.indexOf("abc", idx + 1);
      System.out.printf("3rd abc = %d%n", idx);
      System.out.printf("%n");
    }
    // contains()
    {
      String s1 = "hello world";
      System.out.printf("hello = %b%n", s1.contains("hello"));
      System.out.printf("world = %b%n", s1.contains("world"));
      System.out.printf("o w = %b%n", s1.contains("o w"));
      System.out.printf("%n");
    }
    // matches()
    {
      String s1 = "hello world";
      System.out.printf("hello = %b%n", s1.matches("hello"));
      System.out.printf("hello = %b%n", s1.matches("hello.*"));
    }
  }
}
