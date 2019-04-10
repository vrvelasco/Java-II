package velasco.v;

import java.security.SecureRandom;

public class Consumer implements Runnable 
{
    protected Deck deck;
	Integer[] cards = { -1, -1 }; // Holds the two cards
	public static String[] value = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" }; // Possible card Values
	String winner = ""; // For displaying the winner
	

    public Consumer(Deck deck) 
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
            		Integer consumed = deck.consumeValue();
            		playGame(consumed);
            	
                Thread.sleep(1000 * (random.nextInt(4) + 1));
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
    private void playGame(int consumed)
    {
    	if (cards[0] == -1) // First card empty?
        {
        	cards[0] = consumed;
        }
        else 
        	if (cards[1] == -1) // Second card empty?
        	{
        		cards[1] = consumed;
        	}

    	if (cards[0] != -1 && cards[1] != -1)
    	{
        	if (cards[0] > cards[1]) // First card is higher
        	{
        		winner = "Winner is Card 1.";
        	}
        	else if (cards[0] < cards[1]) // Second card is higher
        	{
        		winner = "Winner is Card 2.";
        	}
        	else // Card values are the same
        	{
        		winner = "Cards tie!";
        	}
        	
        	// Print outcome of game played
        	System.out.printf("%n\tPLAY GAME%n "
        			+ "\tCard 1 is \"%s\", Card 2 is \"%s\". %s %n%n", value[cards[0]], value[cards[1]], winner);
        	
        	// Reset placeholder
        	cards[0] = -1;
        	cards[1] = -1;
        }
    }
}