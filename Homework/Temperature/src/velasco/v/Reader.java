package velasco.v;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Reader
{
	// Variables
	private int coldest = 0;
	private int warmest = 0;
	private int smallest = 0;
	private int largest = 0;
	private int lines = 0;
	private int frequency = 0;
	List<Integer> tempList;
	Set<Integer> setList;
	
	public Reader() // Constructor
	{
		tempList = new LinkedList<>(); // List that holds temperatures from file
	}
	
	public int getLines() // How many entries?
	{
		lines = tempList.size();
		return lines;
	}
	
	public int getColdest() // Lowest temperature?
	{
		coldest = Collections.min(tempList);
		return coldest;
	}
	
	public int getWarmest() // Highest temperature?
	{
		warmest = Collections.max(tempList);
		return warmest;
	}
	
	public double getAverage() // Average temperature?
	{
		double sum = 0;
		
		for (int temp : tempList)
			sum += temp;
		
		return sum / lines;
	}
	
	public int getSmallest() // Smallest, least frequent
	{
		return smallest;
	}
	
	public int getLargest() // Largest, most frequent
	{
		return largest;
	}
	
	public void processData() throws Exception // Gets temperature values from file and adds to List
	{
		Path tempFile = Paths.get("temperatures.dat"); // Get path to file
		
		try (Scanner fileReader = new Scanner(tempFile)) // Auto close
		{
			while (fileReader.hasNext()) //  Loop while file contains data
			{
				tempList.add(Integer.parseInt(fileReader.nextLine())); // Add the line to the List
			}
		}
		
		setList = new TreeSet<>(tempList); // Duplicate entries not allowed.
	}
	
	public void printData() // Prints unique values and their frequency
	{
		for (int temp : setList)
			System.out.printf("%4d %5d%n", temp, Collections.frequency(tempList, temp));
	}
	
	public void findLeastFrequent()
	{
		boolean found = false;
		
		for (int temp : setList)
		{
			if (!found)
			{
				int count = Collections.frequency(tempList, temp);
				
				if (count <= frequency && temp < getWarmest())
				{
					smallest = temp;
					frequency = count;
					
					if (frequency == 1)
						found = true;
				}
			}
			/*if (frequency == 1) // Found the temperature. No need to check the rest
				break;*/
		}
	}
	
	public void findMostFrequent()
	{
		frequency = 0;
		
		for (int temp : setList)
		{
			int count = Collections.frequency(tempList, temp);
			
			if (count > frequency && temp > getColdest())
			{
				largest = temp;
				frequency = count;
			}
		}
	}
}