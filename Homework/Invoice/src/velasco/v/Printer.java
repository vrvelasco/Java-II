package velasco.v;

import java.util.Scanner;

public class Printer 
{
	Scanner input = new Scanner(System.in);
	Scanner fileReader = new Scanner(System.in);
	
	public void rawData()
	{
		System.out.println("\nRAW DATA\n");
	}
	
	public void invoices()
	{
		System.out.println("\nINVOICES\n");
	}
	
	public void deptInvoices()
	{
		System.out.println("\nINVOICES BY DEPT\n");
	}
	
	public void qtyInvoices()
	{
		System.out.println("\nINVOICES BY QTY\n");
	}
	
	public void summary()
	{
		System.out.println("\nSUMMARY\n");
	}
	
	public int printMenu() // Displays menu
	{
		int selection;
		
		// Menu
		System.out.print("MAIN MENU\n"
			       + "  1. Show raw data\n"
			       + "  2. Show invoices\n"
			       + "  3. Show invoices by DEPT\n"
			       + "  4. Show invoices by QTY\n"
			       + "  5. Show department summary\n"
			       + "  6. EXIT\n\nSelection: ");
		
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
