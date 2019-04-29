package remijan.m.class1.lecture;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex07_DeleteAddress {

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

        
        // NOTE
        // Do the query 1st in SquirrelSQL, then copy & paste it into your code.
        StringBuilder sp = new StringBuilder();
        sp.append(" delete from address ");
        sp.append(" where ");
        sp.append("      id=?");

        
        // Use a try-with-resources statement so that
        // the PreparedStatement and the ResultSet
        // objects are closed automatically for you so
        // your application does not have a resource leak
        try (
            // A PreparedStatement is the object used
            // which represents the database SQL statement
            PreparedStatement stmt
                = conn.prepareStatement(sp.toString());
        ) {
            // Main Street
            {
                System.out.printf("Delete data for Route 2%n");
                // id
                // Run this 1 time and the output should say 1 record
                // was deleted.  Run it again, the output should say 
                // 0 records deleted.  If the where clause of the 
                // query does not match any ID values in the database
                // nothing will be deleted.
                stmt.setLong(1, 1111111111111L);
                
                // execute
                int count
                    = stmt.executeUpdate();
                
                System.out.printf(" +- Deleted %d record%n", count);
            }
        }
        
        // You are done with the application so close
        // your database connection
        conn.close();
        
        System.out.printf("%nGood-bye!%n");
    }
}
