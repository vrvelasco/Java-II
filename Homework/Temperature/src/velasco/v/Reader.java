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
	List<Integer> tempList;
	Set<Integer> setList;
	
	public Reader() // Constructor
	{
		tempList = new LinkedList<>(); // List that holds temperatures from file
	}
	
	public int getLines() // How many entries?
	{
		return tempList.size();
	}
	
	public int getColdest() // Lowest temperature?
	{
		return Collections.min(tempList);
	}
	
	public int getWarmest() // Highest temperature?
	{
		return Collections.max(tempList);
	}
	
	public int getAverage() // Average temperature?
	{
		int sum =0;
		
		for (int temp : tempList)
		{
			sum += temp;
		}
		
		return sum / tempList.size();
	}
	
	public int getSmallest() // Smallest, least frequent
	{
		return smallest;
	}
	
	public int getLargest() // Largest, most frequent
	{
		return largest;
	}
	
	public void processData() throws Exception
	{
		Path tempFile = Paths.get("temperatures.dat"); // Get path to file
		
		try (Scanner fileReader = new Scanner(tempFile))
		{
			while (fileReader.hasNext()) //  Loop while file contains data
			{
				tempList.add(Integer.parseInt(fileReader.nextLine())); // Add the line to the List
			}
		}
		
		//Collections.sort(tempList);
		setList = new TreeSet<>(tempList); // Duplicate entries not allowed.
	}
	
	public void printData()
	{
		for (int temp : setList)
		{
			System.out.printf("%4s%6s%n", temp, Collections.frequency(tempList, temp));
		}
	}
}