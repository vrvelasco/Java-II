package remijan.m.class1.lecture;

/**
 * The LongRunningJob class implements the Runnable interface.
 * Therefore the LongRunningJob class passes the is-a test such
 * that LongRunningJob is a Runnable
 */
public class LongRunningJob implements Runnable {

    // Class-level variable to store the job number
    protected int jobNumber;

    // Constructor with 1 argument. The argument is the
    // job number which is stored in the class-level variable
    public LongRunningJob(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    /**
     * Overridden run() method. This is the code that the
     * ExecutorService will eventually run. Put whatever
     * code you want to run here.
     */
    @Override
    public void run() {
        SystemTool.printf("Running job %d%n", jobNumber);
        ThreadTool.sleep(1000 * 5);
    }
}
