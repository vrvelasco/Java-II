package remijan.m.lecture;

/**
 * Finally.
 * 
 * Clean up resources
 */
public class Ex07_MultiCatch {

  public static void main(String[] args) {
    try {
      PromptForRange p 
          = new PromptForRange();
      System.out.printf("Integer value = %d%n", p.forRange());
    } catch (LessThanException | GreaterThanException e) {
      System.out.printf("Value not in range.%n");
    }
    finally {}
  }
}
