package remijan.m.lecture;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex08_RegularExpression {

  public static void main(String[] args) {

    String s;
    Pattern p;
    Matcher m;

    // . Any character
    {
      s = "hat, cat, coat, bat";
      p = Pattern.compile(".at");
      m = p.matcher(s);
      while (m.find()) {
        System.out.printf("Matched '%s' at index %d\n", m.group(), m.start());
      }
    }

    // \s  Whitespace
    System.out.printf("%n");
    {
      s = "Greetings, Rita Red. It is good to meet you";
      p = Pattern.compile("Rita\\sRed");
      m = p.matcher(s);
      while (m.find()) {
        System.out.printf("Matched '%s' at index %d\n", m.group(), m.start());
      }
    }
    {
      s = "Greetings, Rita\tRed. It is good to meet you";
      p = Pattern.compile("Rita\\sRed");
      m = p.matcher(s);
      while (m.find()) {
        System.out.printf("Matched '%s' at index %d\n", m.group(), m.start());
      }
    }

    // * one or more
    System.out.printf("%n");
    {
      s = "Greetings, Rita    Red. It is good to meet you";
      p = Pattern.compile("Rita\\s*Red");
      m = p.matcher(s);
      while (m.find()) {
        System.out.printf("Matched '%s' at index %d\n", m.group(), m.start());
      }
    }

    // * one or more
    System.out.printf("%n");
    {
      s = "Greetings, Rita  \t\t  \t\t   Red. It is good to meet you";
      p = Pattern.compile("Rita\\s*Red");
      m = p.matcher(s);
      while (m.find()) {
        System.out.printf("Matched '%s' at index %d\n", m.group(), m.start());
      }
    }

    // \d  Digits        
    System.out.printf("%n");
    {
      s = "123-555-1212";
      p = Pattern.compile("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d");
      m = p.matcher(s);
      System.out.printf("Phone matches %b\n", m.matches());
    }

    // {} ranges
    System.out.printf("%n");
    {
      s = "123-555-1212";
      p = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
      m = p.matcher(s);
      System.out.printf("Phone matches %b\n", m.matches());
    }

    // [] custom character classes
    System.out.printf("%n");
    {
      s = "123-555-1212";
      p = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{4}");
      m = p.matcher(s);
      System.out.printf("Phone matches %b\n", m.matches());
    }
    {
      s = "123.555.1212";
      p = Pattern.compile("[0-9]{3}[.-][0-9]{3}[.-][0-9]{4}");
      m = p.matcher(s);
      System.out.printf("Phone matches %b\n", m.matches());
    }
    {
      s = "123-555-1212";
      p = Pattern.compile("[0-9]{3}[.-][0-9]{3}[.-][0-9]{4}");
      m = p.matcher(s);
      System.out.printf("Phone matches %b\n", m.matches());
    }
    {
      s = "123-555.1212";
      p = Pattern.compile("[0-9]{3}[.-][0-9]{3}[.-][0-9]{4}");
      m = p.matcher(s);
      System.out.printf("Phone matches %b\n", m.matches());
    }

    // ? Zero or 1
    System.out.printf("%n");
    {
      s = "09/2014";
      p = Pattern.compile("\\d{2}/\\d{4}");
      m = p.matcher(s);
      System.out.printf("Date matches %b\n", m.matches());
    }
    {
      s = "092014";
      p = Pattern.compile("\\d{2}/?\\d{4}");
      m = p.matcher(s);
      System.out.printf("Date matches %b\n", m.matches());
    }

    // Groupings
    System.out.printf("%n");
    {
      s = "123-555-8978";
      p = Pattern.compile("[0-9]{3}[.-][0-9]{3}[.-][0-9]{4}");
      m = p.matcher(s);
      System.out.printf("Phone matches %b\n", m.matches());
    }
    {
      s = "555-8978";
      p = Pattern.compile("([0-9]{3}[.-])?[0-9]{3}[.-][0-9]{4}");
      m = p.matcher(s);
      System.out.printf("Phone matches %b\n", m.matches());
    }
  }
}
