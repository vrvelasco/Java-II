package velasco.v;

public class Converter 
{
	// Constants
	private static final String UNKNOWN = "?";
	private static final String TRIPLE_SPACE = "   ";
	private static final String SPACE = " ";
	
	// String and char array that hold values
	String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--","-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
			          ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};
	char[] english = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                      '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

	public String determineLanguage(String userStr)
	{
		String translation = ""; // Will return to Main
		int dotsAndDashes = 0, other = 0; // Counters
		
		char[] userChar = userStr.toUpperCase().trim().toCharArray(); // Convert to char[] for enhanced For Loop
		
		for (char c : userChar ) // Loop through the elements
		{
			if (c == '.' || c == '-') // Dot or dash?
				dotsAndDashes++; // True? Increment		
			else
				other++; // Otherwise, it's something else				
		}
		
		// Language?
		if (dotsAndDashes < other) // Mostly dots and dashes?
			translation = convertToMorse(userChar);
		else
			translation = convertToEnglish(userStr); // Split into tokens using the delimiter
		
		return translation;
	}
	
	
	private String convertToMorse(char[] userTokens)
	{
		String morseTranslation = "\nDetected language: English\n\n";
		boolean found = false; // Was there a match?
		
		for (char c : userTokens) // Get single character from user's string
		{
				for (int i = 0; i < english.length; i++) // Go through array
				{
					if (c == english[i]) // Matched an English element?
					{
						morseTranslation += morse[i];
						found = true;
						break;
					}
					
					if (c == ' ') // Matched a space?
					{	morseTranslation += SPACE;
						found = true;
						break;
					}
				}
								
				if (!found) // Nothing matched?
					morseTranslation += UNKNOWN;
				
				found = false; // Reset boolean

				morseTranslation += SPACE; // Add space after For loop
				}
		
		return morseTranslation;
		}
	
	private String convertToEnglish(String userStr)
	{
		String[] tripleToken = userStr.trim().split(TRIPLE_SPACE); // Array of tokens in String separated by TRIPLE_SPACE
		String englishTranslation = "\nDetected language: Morse code\n\n";
		boolean found = false;
		
		for (String tokens : tripleToken) // Go through tokens in String separated by TRIPLE_SPACE
		{
			String[] singleToken = tokens.split(SPACE); // Array of tokens in String separated by SPACE
			
			for (String token : singleToken) // Go through tokens in String separated by SPACE
			{
				for (int i = 0; i < morse.length; i++) // Loop until there is a match
				{
					if (token.equals(morse[i])) // Matched a Morse Code element?
					{
						englishTranslation += english[i];
						found = true;
						break;
					}	
				}
				
				if (!found) // Nothing matched?
					englishTranslation += UNKNOWN;
				
				found = false; // Reset boolean
			}
			
			englishTranslation += SPACE; // SPACE after loop, because it is the end of the word
		}
		
		return englishTranslation;
	}
}
