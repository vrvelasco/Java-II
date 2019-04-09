package velasco.v;

import java.util.Optional;


public class Deck 
{
	protected Optional<Integer> value;

    public Deck() 
    {
        value = Optional.empty();
    }

    public synchronized Integer consumeValue() throws InterruptedException 
    {
        while (!value.isPresent()) 
        {
            System.out.printf("Buffer empty. Consumer waits...%n");
            wait();
        }

        Integer retval = value.get();

        value = Optional.empty();
        notifyAll();
        
        return retval;
    }

    public synchronized void storeValue(Integer newValue) throws InterruptedException 
    {
        while (value.isPresent()) 
        {
            wait();
        }

        value = Optional.of(newValue);
        notifyAll();
    }
}
