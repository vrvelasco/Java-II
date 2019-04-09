package velasco.v;

import java.security.SecureRandom;

public class Producer implements Runnable 
{
    protected Deck deck;

    public Producer(Deck deck) 
    {
        this.deck = deck;
    }

    @Override
    public void run() 
    {
        SecureRandom random = new SecureRandom();

        while (true) 
        {
            try 
            {
            	// Create random card
                int produced = random.nextInt(12);
                System.out.printf("Producer produced %s%n", Consumer.value[produced]);

                deck.storeValue(produced);
                Thread.sleep(1000 * (random.nextInt(4) + 1));
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
