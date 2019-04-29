package remijan.m.class3.lecture;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01_CreateDatabase {

    public static void main(String[] args) throws Exception {
        // Check to make sure you have a driver that is
        // able to connect to a REMOTE Derby database
        String driver
            = "org.apache.derby.jdbc.ClientDriver";
        Class.forName(driver);

        // Define the host and port location of the database
        String location
            = "10.30.11.3:1527";
        System.out.printf("Database location: \"%s\"%n", location);

        // Define the name of the database
        String name = "JavaII";
        System.out.printf("Database name: \"%s\"%n", name);

        // Generate a connection URL string to connect to the
        // Derby database
        //
        // NOTE:  The `create=true` means Derby will create the
        //        database if it doesn't already exist.
        String connectionUrl
            = "jdbc:derby://" + location + "/" + name + ";user=sa;password=sa;create=true";

        // Connect to the database.  This will cause the database
        // to be created if it doesn't already exist.
        System.out.printf("JDBC Url: %s%n", connectionUrl);
        Connection conn
            = DriverManager.getConnection(connectionUrl);

        // Close connection to the database
        conn.close();

        // Done
        System.out.printf("DONE!%nCheck server for \"%s\"%n", name);
    }
}
