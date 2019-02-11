package velasco.v;

public class TemperatureMain 
{
	public static void main(String[] args) throws Exception 
	{
		Reader myReader = new Reader();
		
		// Temperatures from file
		myReader.processData();
				
		// Introduction
		System.out.printf("Welcome to Temperature Analysis!%n%n"
				         + "There are %d total temperature data values.%n%n"
				         + "The coldest temperature is %d.%n%n"
				         + "The warmest temperature is %d.%n%n"
				         + "The average temperature is %.2f.%n%n"
				         + "Frequency of each temperature:%n%n"
				         + "%s%n%s%n", myReader.getLines(), myReader.getColdest(), myReader.getWarmest(), myReader.getAverage(), "TEMP COUNT", "==== =====");
		
		// Least and Most
		myReader.findMostFrequent();
		myReader.findLeastFrequent();
		
		// Print contents
		myReader.printData();
		
		// Exit
		System.out.printf("%nThe smallest, least frequent temperature is %d.%n"
				        + "The largest, most frequent temperature is %d.%n%n%s", myReader.getSmallest(), myReader.getLargest(), "Good bye!");
		}
}
