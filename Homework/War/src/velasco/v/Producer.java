package velasco.v;

// Fig. 23.10: Producer.java
// Producer with a run method that inserts the values 1 to 10 in buffer.

import java.security.SecureRandom;

public class Producer implements Runnable
{
	private static final SecureRandom generator = new SecureRandom();
	private final SynchronizedBuffer sharedLocation; // reference to shared object
	
	// constructor
	public Producer(SynchronizedBuffer sharedLocation) 
	{
		this.sharedLocation = sharedLocation;
	}
	
	// store values from 1 to 10 in sharedLocation
	@Override
	public void run() 
	{
		int sum = 0;
	
	    for (int count = 1; count <= 10; count++) 
	    {
	    	try { // sleep 1 to 4 seconds, then place value in Buffer
	    		Thread.sleep(1000 * (generator.nextInt(3) + 1)); // random sleep
	    		sharedLocation.blockingPut(count); // set value in buffer
	    		sum += count; // increment sum of values
	    		System.out.printf("\t%2d%n", sum);
	    		} catch (InterruptedException exception) 
	    		{
	    		Thread.currentThread().interrupt();
	    		}
	    }
	
	    System.out.printf("Producer done producing%nTerminating Producer%n");
	}
}
