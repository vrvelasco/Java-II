package remijan.m.lecture;

import java.util.StringJoiner;

public class Ex06_JoiningStrings {
  public static void main(String[] args) {
    // +
    {
      String description = "";
      description = description + "hello" + " " + "doctor";
      description += "name" + " " + "continue" + " " + "yesterday" + " " + "tomorrow";
      System.out.printf("Description=%s%n%n", description);
    }
    
    // StringBuilder
    {
      StringBuilder sp = new StringBuilder();
      
      sp.append("I am a string");
      sp.append(100);
      sp.append(56.34);
      sp.append(false);      
      
      System.out.printf("%s%n%n", sp.toString());
    
      sp.setLength(0);
      sp.append("I am a string");
      sp.append("\n");
      sp.append(100);
      sp.append("\n");
      sp.append(56.34);
      sp.append("\n");
      sp.append(false);
      System.out.printf("%s%n%n", sp.toString());
      
      System.out.printf("%s%n%n", sp.reverse().toString());      
    }
    
    // StringJoiner
    {
      StringJoiner sj = new StringJoiner(",", "[", "]");
      sj.add(String.valueOf(1));
      sj.add(String.valueOf(2));
      sj.add(String.valueOf(3));
      System.out.printf("%s%n%n",sj.toString());
    }
    {
      StringJoiner sj = new StringJoiner(",", "select ", " from TABLE");
      sj.add("ID");
      sj.add("FIRST_NAME");
      sj.add("LAST_NAME");
      System.out.printf("%s%n%n",sj.toString());      
    }
    
  }
}

