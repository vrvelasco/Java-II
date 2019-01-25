package velasco.v;

public class Converter 
{
	// Constants
	private static final String UNKNOWN = "?";
	private static final String SPACE = "   ";
	
	// Array that hold values
	String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--."};
	char[] english = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                        '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

	public String determineLanguage(String userStr)
	{
		String translation = "";
		int dotsAndDashes = 0;
		
		char[] userChar = userStr.toUpperCase().trim().toCharArray();
		
		for (char c : userChar )
		{
			if (c == '.' || c == '-')
				dotsAndDashes++;			
		}
		
		// Language?
		if (dotsAndDashes < userChar.length) // How many dots and dashes?
			translation = convertToMorse(userChar);
		else
			translation = convertToEnglish(userStr.toUpperCase().trim().split(" "));
		
		return translation;
	}
	
	
	private String convertToMorse(char[] userTokens)
	{
		String morseTranslation = "Morse:";
		
		for (char c : userTokens)
		{
			for (int i = 0; i < english.length; i++)
			{
				if (c == english[i])
					morseTranslation += morse[i];
				else if (c == ' ')
					morseTranslation += SPACE;
				else
					morseTranslation += UNKNOWN;
			}
		}
		
		return morseTranslation;
	}
	
	private String convertToEnglish(String[] userTokens)
	{
		String englishTranslation = "English:";
		
		for (String token : userTokens)
		{
			
		}
		
		return englishTranslation;
	}
}
