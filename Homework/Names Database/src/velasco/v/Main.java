package velasco.v;

import java.util.List;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        System.out.printf("Welcome to Names Database!%n");
        Scanner input = new Scanner(System.in);
        
        DatabasePath    dbPath = new DatabasePath();
        DatabaseHandler dbHandler = new DatabaseHandler(dbPath);
        DatabasePrinter dbPrinter = new DatabasePrinter();

        // Print Table
        List<Database> people = dbHandler.findPerson();
        dbPrinter.print(people);

        /*
         *  Get user input of names to add to database
         */
     	System.out.print("Enter first and last name (\".\" when done): ");
     	String userInput = input.nextLine().trim();
     	
     	while (!userInput.equals("."))
     	{
     		long inserted = dbHandler.insert(enterName(userInput));
     		
     		if (inserted != 0)
     		{
     			System.out.printf("> Inserted! ID = %d%n", inserted );
     		}
     		
     		System.out.print("Enter first and last name (\".\" when done): ");
     		userInput = input.nextLine().trim();
     	}
     	
        // Prints the table
        dbPrinter.print(dbHandler.findPerson());
     	
        /*
     	 *  Delete by ID
     	 */
     	System.out.print("Enter ID to delete (\".\" when done): ");
     	userInput = input.nextLine().trim();
     	
     	while (!userInput.equals("."))
     	{
     		try 
     		{
     			long id = Long.parseLong(userInput);
     		
     			int deleteCount = dbHandler.delete(id);
     		
     			if (deleteCount > 0)
     			{
     				System.out.printf("> Deleted!%n");
     			}
     			else
     			{
     				System.out.printf("> FAIL! ID = %d not found%n", id);
     			}
     		}
     		
     		catch (NumberFormatException e) { /* Eclipse requires catch to run */ }
     	     		
     		System.out.print("Enter ID to delete (\".\" when done): ");
     		userInput = input.nextLine().trim();
     		       
     	}
     
     	// Prints the table
        dbPrinter.print(dbHandler.findPerson());
        
        
        /*
         *  Update by ID
         */
        System.out.print("Enter ID to update (\".\" when done): ");
 		userInput = input.nextLine().trim();
 		
 		while (!userInput.equals("."))
     	{
    		try 
     		{
     			long id = Long.parseLong(userInput);
     			
     			System.out.print("Enter first and last name (\".\" when done): ");
     			String newName = input.nextLine().trim();
     			
     			int updateCount = dbHandler.updateName(id, newName);
     			
     			if (updateCount > 0)
     			{
     				System.out.printf("> Updated! ID = %d%n", id);
     			}
     			else
     			{
     				System.out.printf("> FAIL! ID = %d not found%n", id);
     			}     		}
     		
     		catch (NumberFormatException e) { /* Eclipse requires catch to run */ }
     		
     		System.out.print("Enter ID to update (\".\" when done): ");
     		userInput = input.nextLine().trim();
     	}
 		
 		// Prints the table
        dbPrinter.print(dbHandler.findPerson());

 		input.close();
 		
        // Done
        System.out.printf("Good bye!%n");
    }

    public static Database enterName(String userInput) throws Exception
	{		 
		Database newPerson = new Database();

		if (!userInput.equals(""))
		{
			// Get first and last name from String, if possible
			String[] names = userInput.split(" ");
			
	        newPerson.setId(System.currentTimeMillis());
	        newPerson.setFirstName(names[0]);
	        newPerson.setLastName(names.length == 2 ? names[1] : "");
		}
		
        return newPerson;
	}
}
