package remijan.m.lecture;

public class Ex03_Comparing {

  public static void main(String[] args) {
    // ==
    {
      String s1 = new String("hello");
      String s2 = new String("hello");
      System.out.printf("== %b%n", s1 == s2);
    }
    // equals()
    {
      String s1 = new String("hello");
      String s2 = new String("hello");
      System.out.printf("equals() %b%n", s1.equals(s2));
    }
    // equalsIgnoreCase()
    {
      String s1 = new String("hello");
      String s2 = new String("HeLLo");
      System.out.printf("equalsIgnoreCase() %b%n", s1.equalsIgnoreCase(s2));
    }
    // compareTo()
    {
      System.out.printf("compareTo a,a = %d%n", "a".compareTo("a"));
      System.out.printf("compareTo a,b = %d%n", "a".compareTo("b"));
      System.out.printf("compareTo b,a = %d%n", "b".compareTo("a"));
      System.out.printf("compareTo a,A = %d%n", "a".compareTo("A"));
    }
    // startsWith()
    {
      String description = "PX188 is the best widget ever.";
      System.out.printf("startsWith() = %b%n", description.startsWith("PX188"));
      System.out.printf("startsWith() = %b%n", description.startsWith("px188"));
    }
    // endsWith()
    {
      String location = "We all met at the IHOP";
      System.out.printf("endsWith() = %b%n", location.endsWith("IHOP"));
    }

  }
}
