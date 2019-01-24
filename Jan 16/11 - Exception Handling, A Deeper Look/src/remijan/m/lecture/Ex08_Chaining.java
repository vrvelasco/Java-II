package remijan.m.lecture;

/**
 * Finally.
 * 
 * Clean up resources
 */
public class Ex08_Chaining {

  public static void main(String[] args) {
    try {
      PromptForRange p 
          = new PromptForRange();
      System.out.printf("Integer value = %d%n", p.forRange());
    } catch (LessThanException | GreaterThanException e) {
      RuntimeException re
          = new RuntimeException(e);
      throw re;
    }
    finally {}
  }
}
