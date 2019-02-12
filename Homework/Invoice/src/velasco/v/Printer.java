package velasco.v;

import java.util.Scanner;

public class Printer 
{
	
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
}