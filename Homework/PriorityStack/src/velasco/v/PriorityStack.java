package velasco.v;

import java.util.*;
	
public class PriorityStack<T extends Comparable<T>> 
{ 
	private final ArrayList<T> elements; // Used to store elements
	
	public PriorityStack()
	{
		elements = new ArrayList<T>(); // Create List
	}
	
	public void push(T value)
	{ 
		elements.add(value); // Place value on Stack
	}
	
	public T pop() 
	{ 		
		// Prioritize
		Collections.sort(elements);
		Collections.reverse(elements);
		
		return elements.remove(elements.size() - 1);
	}
	
	public boolean isEmpty()
	{
		return elements.size() == 0 ? true : false;
	}
}