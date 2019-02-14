package velasco.v;

public class InvoiceMain 
{

	public static void main(String[] args) throws Exception
	{
		Printer myPrinter = new Printer();
		myPrinter.getData(); // Fill List
		
		// Welcome message
		System.out.println("Welcome to Invoice!\n");

		int choice = myPrinter.printMenu(); // Display message and get selection
		
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
				System.out.println("\nOops, try again.\n");
				break;
			}
			
			choice = myPrinter.printMenu(); // Show menu again and get selection
		}
		
		// Exit message
		System.out.println("\nGood bye!");
	}
}
