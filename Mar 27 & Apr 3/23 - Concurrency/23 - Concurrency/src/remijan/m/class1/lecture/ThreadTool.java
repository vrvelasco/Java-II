package remijan.m.class1.lecture;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class ThreadTool {

    /**
     * Convenience method to sleep a thread
     * without calling having to handle the
     * InterruptedException
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignore) {}
    }
}
