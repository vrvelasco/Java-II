package velasco.v;

import java.util.Scanner;

public class InvoiceMain 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Printer myPrinter = new Printer();
		
		// Welcome message
		System.out.println("Welcome to Invoice!\n");

		int choice = printMenu(input); // Display message and get selection
		
		while (choice != 6) // Loop until EXIT is selected
		{
			switch (choice) // Menu selection
			{
			case 1: // Show raw data
				myPrinter.rawData();
				break;
			case 2: // Show invoices
				myPrinter.invoices();
				break;
			case 3: // Show invoices by DEPT
				myPrinter.deptInvoices();
				break;
			case 4: // Show invoices by QTY
				myPrinter.qtyInvoices();
				break;
			case 5: // Show department summary
				myPrinter.summary();
				break;
			default: // Something else
				System.out.println("\nInvalid choice: Please try again.\n");
				break;
			}
			
			choice = printMenu(input); // Show menu again
		}
		
		// Exit message
		System.out.println("\nGood bye!");
	}

	public static int printMenu(Scanner input)
	{
		int selection = -1;
		
		// Menu
		System.out.print("MAIN MENU\n"
			           + "  1. Show raw data\n"
				       + "  2. Show invoices\n"
				       + "  3. Show invoices by DEPT\n"
				       + "  4. Show invoices by QTY\n"
				       + "  5. Show department summary\n"
				       + "  6. EXIT\n\nSelection: ");
		// Number?
		try
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
