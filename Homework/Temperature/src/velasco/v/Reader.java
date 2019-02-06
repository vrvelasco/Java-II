package velasco.v;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Reader
{
	private int lines = 0;
	private int coldest = 0;
	private int warmest = 0;
	private double average = 0.0;
	private int smallest = 0;
	private int largest = 0;
	
	public int getLines()
	{
		return lines;
	}
	
	public int getColdest()
	{
		return coldest;
	}
	
	public int getWarmest()
	{
		return warmest;
	}
	
	public double getAverage()
	{
		return average;
	}
	
	public int getSmallest()
	{
		return smallest;
	}
	
	public int getLargest()
	{
		return largest;
	}
	
	public void processData() throws Exception
	{
		Path tempFile = Paths.get("temperatures.dat");
		
		try (Scanner fileReader = new Scanner(tempFile))
		{
			while (fileReader.hasNext())
			{
				lines++;
				System.out.println(fileReader.nextLine());
			}
		}
	}
}