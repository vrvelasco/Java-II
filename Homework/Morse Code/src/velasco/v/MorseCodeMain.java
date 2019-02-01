package velasco.v;

import java.util.Scanner;

public class MorseCodeMain 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Converter myConverter = new Converter();
		
		// Welcome message
		System.out.print("Welcome to translator!\n\nEnter text to translate (-1 to exit): ");
		String userStr = input.nextLine();
	
		do 
		{
			// Empty string?
			while (userStr.equals(""))
			{
				System.out.print("\nPlease enter at least one character: ");
				userStr = input.nextLine();
			}
			
			// Output
			System.out.println(myConverter.determineLanguage(userStr));
			
			// Get user input again
			System.out.print("\nEnter text to translate (-1 to exit): ");
			userStr = input.nextLine();
		
		} while(!userStr.equals("-1"));

		// Exit message
		System.out.println("\nGood Bye!");
		
		input.close();
	}
}
