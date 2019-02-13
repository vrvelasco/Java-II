package velasco.v;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Printer
{
	Scanner input = new Scanner(System.in);
	List<String> dataList;
	
	public Printer()
	{
		dataList = new LinkedList<>();
	}
	
	public void rawData() throws Exception
	{
		System.out.println("\nRAW DATA\n");
		
		for (String entry : dataList)
		{
			System.out.println(entry);
		}
	}
	
	public void invoices()
	{
		System.out.println("\nINVOICES");
	}
	
	public void deptInvoices()
	{
		System.out.println("\nINVOICES BY DEPT");
	}
	
	public void qtyInvoices()
	{
		System.out.println("\nINVOICES BY QTY");
	}
	
	public void summary()
	{
		System.out.println("\nSUMMARY");
	}
	
	public int printMenu() // Displays menu
	{
		int selection;
		
		// Menu
		System.out.print("\nMAIN MENU\n"
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
	
	public void getData() throws Exception
	{
		Path dataFile = Paths.get("invoices.dat"); // Get path to file
		
		try (Scanner fileReader = new Scanner(dataFile)) // Auto close
		{
			while (fileReader.hasNext()) //  Loop while file contains data
			{
				dataList.add(fileReader.nextLine());
			}
		}
	}
}
