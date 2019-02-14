package velasco.v;

import java.nio.file.Paths;
import java.util.*;

public class Printer
{
	Scanner input = new Scanner(System.in);
	List<Invoice> invoiceList = new LinkedList<>();

	public void rawData() throws Exception
	{
		System.out.println("\nRaw Data\n");
		
		invoiceList.stream()
				   .forEach(e -> System.out.printf("%d\t%s\t%s\t%d\t%.2f%n", e.getId(), e.getDept(), e.getDescription(), e.getQty(), e.getPrice()));
	}
	
	public void invoices()
	{
		System.out.println("\nInvoices by Default\n");
		
		// Columns
		System.out.printf("%-4s %-15s %-30s %4s %8s%n%s %s %s %s %s%n",
						  "ID", "DEPARTMENT", "DESCRIPTION", "QTY", "PRICE",
						  "====","===============", "==============================", "====", "========");
		
		// Output
		invoiceList.stream()
				   .forEach(e -> System.out.printf("%-4d %-15s %-30s %4d %8.2f%n",
						    e.getId(), e.getDept(), e.getDescription(), e.getQty(), e.getPrice()));
	}
	
	public void deptInvoices()
	{
		System.out.println("\nInvoices by Department\n");
		
		// Columns
		System.out.printf("%-4s %-15s %-30s %4s %8s%n%s %s %s %s %s%n",
						  "ID", "DEPARTMENT", "DESCRIPTION", "QTY", "PRICE",
						  "====","===============", "==============================", "====", "========");
		
		// Sort by Department
		invoiceList.sort((a,b) -> a.getDept().compareTo(b.getDept()));
		
		// Output
		invoiceList.stream()
				   .forEach(e -> System.out.printf("%-4d %-15s %-30s %4d %8.2f%n",
						    e.getId(), e.getDept(), e.getDescription(), e.getQty(), e.getPrice()));
	}
	
	public void qtyInvoices()
	{
		System.out.println("\nInvoices by Quantity\n");
		
		// Columns
		System.out.printf("%-4s %-15s %-30s %4s %8s%n%s %s %s %s %s%n",
						  "ID", "DEPARTMENT", "DESCRIPTION", "QTY", "PRICE",
						  "====","===============", "==============================", "====", "========");
		
		// Sort by QTY
		invoiceList.sort((a,b) -> a.getQty().compareTo(b.getQty()));
		
		// Output
		invoiceList.stream()
				   .forEach(e -> System.out.printf("%-4d %-15s %-30s %4d %8.2f%n",
						    e.getId(), e.getDept(), e.getDescription(), e.getQty(), e.getPrice()));
	}
	
	public void summary()
	{
		System.out.println("\n*** SUMMARY ***\n\n// TODO");
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
		 try (
		            // Create Scanner to read the data file
		            Scanner fileReader = new Scanner(Paths.get("invoices.dat"))
		     ) 
		 {
		            // Loop while there is more data to read in the data file
		            while (fileReader.hasNext()) 
		            {
		                // Get a line of data from the data file
		                String line = fileReader.nextLine();

		                // Trim the line of data, make sure there is actually data
		                line = line.trim();

		                // If there is data, parse the data.  You 
		                // know the data is comma-separated values.
		                if (!line.isEmpty()) 
		                {
		                    // Split the line of data by tabs
		                    String[] tokens = line.split("\t");

		                    // Get ID value
		                    Integer id = Integer.parseInt(tokens[0]);

		                    // Get Department
		                    String department = tokens[1];

		                    // Get Description
		                    String description = tokens[2];
		                    
		                    // Get Quantity
		                    Integer qty = Integer.parseInt(tokens[3]);
		                    
		                    // Get Price
		                    Double price = Double.parseDouble(tokens[4]);

		                    // Create Invoice object to hold data
		                    Invoice invoice = new Invoice(id, department, description, qty, price);

		                    // Store Invoice object in list
		                    invoiceList.add(invoice);
		                }
		            }
		 }
	}
}