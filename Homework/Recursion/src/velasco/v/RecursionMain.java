package velasco.v;

import java.util.*;

public class RecursionMain 
{	
	static int counter = 1; // For the line count
	static List<String> anagrams; // Holds the anagrams

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		// Welcome message and get first word
		System.out.println("Welcome to anagram!");
		String userStr = displayMenu(input);
		
		// Loop until "-1" is entered
		while (!userStr.equals("-1"))
		{	
			// Instantiate list
			anagrams = new LinkedList<>();
			
			// Start recursion
			anagram("", userStr, anagrams);
			
			// Lambda and Stream
			anagrams.stream().forEach(x -> System.out.printf("%d\t%s%n", counter++, x));
			
			// Loop again?
			userStr = displayMenu(input);
			
			// Reset line counter
			counter = 1;
		}
		
		// Good bye message
		System.out.print("\nGood bye!");
	}
	
	public static String displayMenu(Scanner input)
	{
		System.out.print("\nEnter word to anagram (-1 to exit): ");
				
		return input.nextLine();
	}
	
	public static void anagram(String prefix, String userStr, List<String> list)
	{		
		String x = "", y = "", z = "";
		
		if (userStr.length() <= 1) // Base case
		{ 
			list.add(prefix + userStr);
		}
		else
		{			
			for (int i = 0; i < userStr.length(); i++)
			{
				x = userStr.substring(0, i);
				y = userStr.substring(i, i + 1);
				z = userStr.substring(i + 1);
								
				// Recursion
				anagram(prefix + y, x + z, list);
			}
		}
	}
}
