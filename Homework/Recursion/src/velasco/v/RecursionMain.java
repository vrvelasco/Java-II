package velasco.v;

import java.util.Scanner;

public class RecursionMain 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Anagram myAnagram = new Anagram();
		
		// Welcome message and get first word
		System.out.println("Welcome to anagram!");
		String userStr = displayMenu(input);
		
		// Loop until "-1" is entered
		while (!userStr.equals("-1"))
		{
			myAnagram.renameMethod(userStr);
			
			// Loop again?
			userStr = displayMenu(input);
		}
		
		// Good bye message
		System.out.print("\nGood bye!");

	}
	
	public static String displayMenu(Scanner input)
	{
		System.out.print("\nEnter word to anagram (-1 to exit): ");
				
		return input.nextLine();
	}

}
