package velasco.v;

import java.util.Scanner;
import java.util.StringJoiner;

public class GenericsMain 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to Priority Stack!\n");
        
        menu();
        int choice = selection(input);
        
        while (choice != 4)
        {
			// within range?
			if (choice >= 1 && choice <= 3)
			{
				switch (choice)
				{
                case 1:               	
                	System.out.println("\nIntegers\n"); // Integers was selected
                    
                    // New Integer PriorityStack
                    PriorityStack intStack = new PriorityStack<Integer>();
                    
                    // Get Integers
                    System.out.print("Enter integer (\".\" when done): ");
                    String userInt = input.nextLine();
                    
                    // Start a loop
                    while (!userInt.equals("."))
                    {
                    	try // Valid?
                    	{ 
                    		intStack.push(Integer.parseInt(userInt)); // Add value
                    	}
                    	catch (NumberFormatException e)
                    	{
                    		System.out.println("\nNot an integer, try again.\n");
                    	}
                    	
                    	 // Loop again?
                        System.out.print("Enter integer (\".\" when done): ");
                    	userInt = input.nextLine();
                    }
                    
                    // Print contents
                    StringJoiner printInt = new StringJoiner(", ", "","");
                    
                    while (!intStack.isEmpty())
                    {
                    	printInt.add(intStack.pop().toString());
                    }
                    	System.out.printf("\n%s\n\n", printInt);
                    	
                    menu(); // Display menu
                    break;
                case 2:
                    System.out.println("\nDoubles\n"); // Doubles was selected
                    
                    // New Double PriorityStack
                    PriorityStack dblStack = new PriorityStack<Double>();
                    
                    // Get Doubles
                    System.out.print("Enter double (\".\" when done): ");
                    String userDbl = input.nextLine();
                    
                    // Start a loop
                    while (!userDbl.equals("."))
                    {
                    	try
                    	{
                    	dblStack.push(Double.parseDouble(userDbl)); // Add value
                    	}
                    	catch (NumberFormatException e)
                    	{
                    		System.out.println("\nNot a double, try again.\n");
                    	}
                    	
                    	// Loop again?
                        System.out.print("Enter double (\".\" when done): ");
                    	userDbl = input.nextLine(); 
                    }
                    
                    // Print contents
                    StringJoiner printDbl = new StringJoiner(", ", "","");
                    
                    while (!dblStack.isEmpty())
                    {
                    	printDbl.add(dblStack.pop().toString());
                    }
                    	System.out.printf("\n%s\n\n", printDbl);
                    
                    menu(); // Display menu
                    break;
                case 3:
                    System.out.println("\nStrings\n"); // Strings was selected
                    
                    // New Integer PriorityStack
                    PriorityStack strStack = new PriorityStack<String>();
                    
                    // Get String
                    System.out.print("Enter string (\".\" when done): ");
                    String userStr = input.nextLine();
                    
                    // Start a loop
                    while (!userStr.equals("."))
                    {
                    	strStack.push(userStr); // Add value
                    	
                    	// Loop again?
                        System.out.print("Enter string (\".\" when done): ");
                    	userStr = input.nextLine(); 
                    }
                    
                    // Print contents
                    StringJoiner printStr = new StringJoiner(", ", "","");
                    
                    while (!strStack.isEmpty())
                    {
                    	printStr.add(strStack.pop().toString());
                    }
                    	System.out.printf("\n%s\n\n", printStr);
                    	
                   	menu(); // Display menu
                    break;
				}
			}
			else
				System.out.println("\nOops, try again.\n");
						
			// Get choice again
			choice = selection(input);
		}
        // Exit message
        System.out.print("\nGood bye!");
    
        input.close();
	}
	
	public static void menu()
	{
		System.out.println("Main Menu\n"
				         + "  1. Integers\n"
				         + "  2. Doubles\n"
				         + "  3. Strings\n"
				         + "  4. EXIT\n");
	}
    
    public static int selection(Scanner input)
    {
        int selection;
        
        System.out.print("Selection: ");
        
        try // Number?
		{
			selection = Integer.parseInt(input.nextLine());	
		}
		catch (NumberFormatException e)
		{
			selection = -1; // Error
		}

		return selection;
	}
}