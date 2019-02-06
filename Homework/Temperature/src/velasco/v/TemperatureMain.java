package velasco.v;

public class TemperatureMain 
{
	public static void main(String[] args) throws Exception 
	{
		Reader myReader = new Reader();
		
		// Introduction
		System.out.printf("Welcome to Temperature Analysis!%n%n"
				         + "There are %d total temperature data values.%n%n"
				         + "The coldest temperature is %d.%n%n"
				         + "The warmest temperature is %d.%n%n"
				         + "The average temperature is %s.%n%n"
				         + "Frequency of each temperature:%n%n"
				         + "%s%n%s", myReader.getLines(), myReader.getColdest(), myReader.getWarmest(), myReader.getAverage(), "TEMP COUNT", "==== =====");
		
		// Temperatures from file
		myReader.processData();
		
		// Exit
		System.out.printf("%nThe smallest, least frequent temperature is %d.%n"
				        + "The largest, most frequent temperature is %d.%n%n%s", myReader.getSmallest(), myReader.getLargest(), "Good bye!");
		}
}
