package velasco.v;

import java.util.Scanner;

public class ExceptionHandlingMain 
{
	private static boolean parsed = false;
	
	public static void main(String[] args)
	{
		// Variables
		Scanner input = new Scanner(System.in);
		double parsedNum = 0.0, parsedDen = 0.0;
		
		// Prints welcome message.
		System.out.println("Welcome to: Division!"); 
		
		do { // Get numerator from user
			System.out.print("\nPlease enter a numerator: ");
			parsedNum = getNumerator(input.nextLine());
			} while (!parsed);
		
		parsed = false; // Reset boolean
				
		do { // Get denominator from user
			System.out.print("Please enter a denominator: ");
			parsedDen = getDenominator(input.nextLine());
			} while (!parsed);
	
		// Math
		double result = parsedNum / parsedDen;
		
		// Output and exit
		System.out.printf("\n\tResult: %f / %f = %f\n", parsedNum, parsedDen, result);
		System.out.print("\nGoodbye!");
		input.close();
	}
	
	public static double getNumerator(String userNum)
	{
		double parsedNum = 0.0;
		
		try 
			{
				parsedNum = Double.parseDouble(userNum);
				parsed = true;
				
				// Check for zero
				System.out.println();
			} 
			catch (Exception e)
			{
				System.out.printf("\n\tThe numerator value \"%s\" is not numeric. Please try again.\n", userNum);
			}
		
			return parsedNum;
	}
	
	public static double getDenominator(String userNum)
	{
		double parsedNum = 0;
		
		try 
			{
				parsedNum = Double.parseDouble(userNum);
				parsed = true;
				
				// Check for zero
				if (parsedNum == 0)
				{
				System.out.println("\n\tThe denominator cannot be zero. Please try again.\n");
				parsed = false; // Loop again
				}
			} 
			catch (Exception e)
			{
				System.out.printf("\n\tThe denominator value \"%s\" is not numeric. Please try again.\n\n", userNum);
			}
		
			return parsedNum;
	}
}