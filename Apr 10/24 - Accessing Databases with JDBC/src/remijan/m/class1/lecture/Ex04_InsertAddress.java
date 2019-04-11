package remijan.m.class1.lecture;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Types;

public class Ex04_InsertAddress {

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
        sp.append(" insert into address ( ");
        sp.append("      id         ");
        sp.append("     ,address1   ");
        sp.append("     ,address2   ");
        sp.append("     ,city       ");
        sp.append("     ,state      ");
        sp.append("     ,zip_code   ");
        sp.append("     ,created_on ");
        sp.append(" ) values ( ");
        sp.append("      ?");
        sp.append("     ,?");
        sp.append("     ,?");
        sp.append("     ,?");
        sp.append("     ,?");
        sp.append("     ,?");
        sp.append("     ,?");
        sp.append(" ) ");

        
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
                System.out.printf("Insert data for Main Street%n");
                // id
                stmt.setLong(1, System.currentTimeMillis());
                // address1
                stmt.setString(2, "123 Main Street");
                // address2
                stmt.setNull(3, Types.VARCHAR);
                // city
                stmt.setString(4, "Smallville");
                // state
                stmt.setString(5, "IL");
                // zip_code
                stmt.setInt(6, 12345);
                // created_on
                stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                
                // execute
                int count
                    = stmt.executeUpdate();
                
                System.out.printf(" +- Inserted %d record%n", count);
            }
            
            // Broadway Ave.
            {
                System.out.printf("Insert data for Broadway Ave.%n");
                // id
                stmt.setLong(1, System.currentTimeMillis());
                // address1
                stmt.setString(2, "874 Broadway Ave.");
                // address2
                stmt.setString(3, "Unit #45c");
                // city
                stmt.setString(4, "Metropolis");
                // state
                stmt.setString(5, "IL");
                // zip_code
                stmt.setInt(6, 56854);
                // created_on
                stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
                
                // execute
                int count
                    = stmt.executeUpdate();
                
                System.out.printf(" +- Inserted %d record%n", count);
            }
            
            // Route 2.
            {
                System.out.printf("Insert data for Route 2.%n");
                // id
                stmt.setLong(1, 1111111111111L);
                // address1
                stmt.setString(2, "896547 Rural Route 2.");
                // address2
                stmt.setNull(3, Types.VARCHAR);
                // city
                stmt.setString(4, "Cornville");
                // state
                stmt.setString(5, "MO");
                // zip_code
                stmt.setInt(6, 66325);
                // created_on
               stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
    
                // execute
                int count
                    = stmt.executeUpdate();
                
                System.out.printf(" +- Inserted %d record%n", count);
            }
        }
        
        // You are done with the application so close
        // your database connection
        conn.close();
        
        System.out.printf("%nGood-bye!%n");
    }
}
