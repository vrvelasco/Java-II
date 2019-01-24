package remijan.m.lecture;

public class Ex01_ConstructingStrings {
  public static void main(String[] args) {
    /**
     * Almost never need to use the string constructor
     * 
     * Just use the "" characters to make a String
     */
    System.out.println("this is a string");
   
    
    /**
     * Constructor with byte[] is most useful
     * 
     * A=65
     */
    byte [] bytes = {65, 66};
    String strFromBytes = new String(bytes);
    System.out.printf("%s%n", strFromBytes);
   
    
    /**
     * Unicode characters
     * 
     * http://unicode-table.com/en/#01A9
     * 
     * A=\u0041
     */
    String unicodeAB = "\u0041 \u0042";
    System.out.printf("%s%n", unicodeAB);
    
    
    /**
     * Unicode characters
     * 
     * http://unicode-table.com/en/#01A9
     * 
     * Sigma=\u01A9
     * Omega=\u03A9
     * Pi=\u03A0
     */
    String unicodeStr = "\u01A9 \u03A9 \u03A0";
    System.out.printf("%s%n", unicodeStr);
  }
}
