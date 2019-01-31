package velasco.v;

import java.util.Scanner;

public class ShellMain {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Commands myCommands = new Commands();
		String userInput = "";
		
		// Welcome message
		System.out.println("Welcome to Shell!\n");
		
		// Display prompt
		userInput = myCommands.displayPrompt(input);
		
		while (!userInput.equalsIgnoreCase("exit"))
		{
			if (userInput.equals(""))
				userInput = myCommands.displayPrompt(input);
			// Help?
			else if (userInput.equalsIgnoreCase("help"))
				myCommands.helpMenu();
			// List directory?
			else if (userInput.equalsIgnoreCase("dir"))
				myCommands.listDir();
			// List directory from path?
			else if (userInput.contains("dir"))
				myCommands.listDirPath(userInput);
			// Show command missing parameter?
			else if (userInput.equalsIgnoreCase("show"))
				System.out.println("ERROR: The [file] parameter is missing. Execute 'help' for more information\n");
			// Show contents of file
			else if (userInput.contains("show"))
				myCommands.showFile();
			//Unknown command?
			else 
			{
				System.out.printf("Unknown command \"%s\"%n",userInput );
				myCommands.helpMenu();
			}
			
			// Display prompt again
			userInput = myCommands.displayPrompt(input);
		}
		
		System.out.println("\nGood bye!");
	}

}
