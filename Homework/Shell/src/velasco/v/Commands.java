package velasco.v;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
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
	
	public void listDir() throws Exception
	{
		Path path = Paths.get(".").toAbsolutePath();
		System.out.printf("Directory of \"%s\"%n", path);
		
		if (Files.isDirectory(path)) 
		{
            DirectoryStream<Path> children = Files.newDirectoryStream(path);
           
            for (Path p : children)
            {
            	if (Files.isRegularFile(p))
            		System.out.printf("%-5s%,15d %-20s%n", Files.isDirectory(p) ? "d" : " ", Files.size(p), p.getFileName());
            	else
            		System.out.printf("%-20s %-20s%n", Files.isDirectory(p) ? "d" : " ", p.getFileName());
            }
            System.out.printf("%n");
        } 
		else
			System.out.println("ERROR: Path is not a directory!!!!!!!!!!");

	}
	
	public void listDirPath(String userInput) throws Exception
	{
		// Convert userInput to charArray
		char[] pathArray = userInput.toCharArray();
				
		// Get path from the user's input after removing "dir "
		Path path = Paths.get(String.valueOf(pathArray, 4, (pathArray.length - 4)));
		
		System.out.printf("Directory of \"%s\"%n", path);
		
		if (Files.isDirectory(path)) 
		{
            DirectoryStream<Path> children = Files.newDirectoryStream(path);
           
            for (Path p : children)
            {
            	if (Files.isRegularFile(p))
            		System.out.printf("%-5s%,15d %-20s%n", Files.isDirectory(p) ? "d" : " ", Files.size(p), p.getFileName());
            	else
            		System.out.printf("%-20s %-20s%n", Files.isDirectory(p) ? "d" : " ", p.getFileName());
            }
            System.out.printf("%n");
        } 

	}
	
	public void showFile(String userInput) throws Exception
	{
		// Convert userInput to charArray
		char[] pathArray = userInput.toCharArray();
		
		// Get path from the user's input after removing "show "
		Path path = Paths.get(String.valueOf(pathArray, 5, (pathArray.length - 5)));
		
		// Exists?
		if (!Files.exists(path)) 
		{
            System.out.printf("ERROR: Path does not exit: \"%s\"", path);
		}
		else
		{
			// File?
			if (Files.isRegularFile(path))
			{
				System.out.printf("Contents of \"%s\"%n", path);
				
				try (Scanner fileReader = new Scanner(path))
				{
					while (fileReader.hasNext()) 
					{
						String line = fileReader.nextLine();
						System.out.println(line);
					}
				
					System.out.println();
				}
			}
		
			else
				System.out.printf("ERROR: Path is not a file: \"%s\"", path);
		}
	}
}