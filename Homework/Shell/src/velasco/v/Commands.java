package velasco.v;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Commands 
{
	public String displayPrompt(Scanner input)
	{
		System.out.print("prompt> ");
		return input.nextLine().trim();
	}
	
	public void helpMenu()
	{
		System.out.printf("%nCOMMANDS:%n"
				       + "  help%30s%n  dir  [path]%28s%n  show file%25s%n  exit%23s%n%n",
				       "Show list of commands","List contents of directory", "Show contents of file", "Exit the shell");
	}
	
	public void listDir()
	{
		Path p = Paths.get(".").toAbsolutePath();
		System.out.printf("%nDirectory of \"%s\"%n", p);
		//DirectoryStream<p> = ;
		
		/*for (Path d : dir)
		{
			System.out.printf("%b %d %s %n", p.isDirectory() ? 'd' : ' ', // GET FILE SIZE, // GET NAME);
		} */
	}
	
	public void listDirPath(String userInput)
	{
		/*
		// Get path from the user's input
		String[] dirPath = userInput.split(" ");
		
		// Element 1 is the path from user (element 0 should contain "dir")
		Path p = dirPath[1];
		*/
	}
	
	public void showFile()
	{
		/*
		Scanner file = new Scanner(filePath[1]);
		
		// Get path from the user's input
		String[] filePath = userInput.split(" ");
		
		// Element 1 is the path from user (element 0 should contain "show")
		Path p = filePath[1];
		
		// Show contents of file
		System.out.printf("SHOW: \"%s\"%n", //PATH);
		
		while (file.hasNext())
		{
			String line = file.nextLine(); 
			System.out.println(line\n);
		}
		*/
	}
}
