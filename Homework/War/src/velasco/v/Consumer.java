package velasco.v;

// Fig. 23.11: Consumer.java
// Consumer with a run method that loops, reading 10 values from buffer.

import java.security.SecureRandom;

public class Consumer implements Runnable 
{
	private static final SecureRandom generator = new SecureRandom();
	private final SynchronizedBuffer sharedLocation; // reference to shared object

	// constructor
	public Consumer(SynchronizedBuffer sharedLocation) 
	{
		this.sharedLocation = sharedLocation;
	}

	// read sharedLocation's value 10 times and sum the values
	@Override
	public void run() 
	{
		int sum = 0;

		for (int count = 1; count <= 10; count++) 
		{
			// sleep 1 to 4 seconds, read value from buffer and add to sum
			try 
			{
				Thread.sleep(1000 * (generator.nextInt(3) + 1));
				sum += sharedLocation.blockingGet();
				System.out.printf("\t\t\t%2d%n", sum);
			}
			catch (InterruptedException exception) 
			{
				Thread.currentThread().interrupt();
			}
		}

		System.out.printf("%n%s %d%n%s%n", "Consumer read values totaling", sum, "Terminating Consumer");
	}
}
