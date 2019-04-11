package velasco.v;

import java.sql.Connection;
import java.sql.DriverManager;

public class NamesMain 
{

	public static void main(String[] args) throws Exception
	{
		System.out.println("Welcome to Names Database!\n");
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		String connectionUrl
		    = "jdbc:derby:NAMES;user=;password=;create=true";

		System.out.println("\nConnecting to (and creating) the database\n");
		
		Connection conn
		    = DriverManager.getConnection(connectionUrl);
		
		System.out.println("\nGood Bye!");
	}

}
