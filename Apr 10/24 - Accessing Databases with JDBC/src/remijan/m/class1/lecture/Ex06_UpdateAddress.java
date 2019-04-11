package remijan.m.class1.lecture;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex06_UpdateAddress {

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
        sp.append(" update address ");
        sp.append(" set ");
        sp.append("      address1=?   ");        
        sp.append("     ,city=?       ");
        sp.append("     ,state=?      ");
        sp.append("     ,zip_code=?   ");
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
                System.out.printf("Update data for Route 2%n");
                // address1
                stmt.setString(1, "6784 Poplar Ct.");
                // city
                stmt.setString(2, "Emerald City");
                // state
                stmt.setString(3, "CT");
                // zip_code
                stmt.setInt(4, 67458);
                // id
                stmt.setLong(5, 1111111111111L);
                // If you uncomment the line below and run with 
                // this ID, the application will run without any
                // errors, but, you'll notice the output about
                // how many records are updated will be 0 because
                // the where clause of the query will not match
                // any ID values in the database
                //stmt.setLong(5, 5555555555555L);
                
                // execute
                int count
                    = stmt.executeUpdate();
                
                System.out.printf(" +- Updated %d record%n", count);
            }
        }
        
        // You are done with the application so close
        // your database connection
        conn.close();
        
        System.out.printf("%nGood-bye!%n");
    }
}
