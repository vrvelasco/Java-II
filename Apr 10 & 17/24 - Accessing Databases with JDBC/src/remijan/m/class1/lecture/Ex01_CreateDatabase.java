package remijan.m.class1.lecture;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01_CreateDatabase {

    public static void main(String[] args) throws Exception {
        // Check to make sure you have a driver that is
        // able to connect to a Derby database
        String driver
            = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver);

        // Define a folder on your file system where Derby
        // will write all of its database files
        String location
            = Paths.get("./db").toAbsolutePath().toString();
        System.out.printf("Database Path: \"%s\"%n", location);
        
        
        // Generate a connection URL string to connect to the
        // Derby database
        //
        // NOTE:  The `create=true` means Derby will create the 
        //        database if it doesn't already exist.
        String connectionUrl
            = "jdbc:derby:" + location + ";user=;password=;create=true";

        
        // Connect to the database.  This will cause the database
        // to be created if it doesn't already exist.
        System.out.printf("JDBC Url: %s%n", connectionUrl);
        Connection conn
            = DriverManager.getConnection(connectionUrl);
        
        
        // Close connection to the database
        conn.close();

        // Done
        System.out.printf("DONE!%n%nCheck the \"%s\" folder%n", location);
    }
}
