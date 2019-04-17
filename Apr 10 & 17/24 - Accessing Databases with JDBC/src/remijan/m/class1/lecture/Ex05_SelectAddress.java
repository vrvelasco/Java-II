package remijan.m.class1.lecture;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class Ex05_SelectAddress {

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
        sp.append(" select ");
        sp.append("      id ");
        sp.append("     ,address1 ");
        sp.append("     ,address2 ");
        sp.append("     ,city ");
        sp.append("     ,state ");
        sp.append("     ,zip_code ");
        sp.append("     ,created_on ");
        sp.append(" from  ");
        sp.append("     address ");

        
        // Use a try-with-resources statement so that
        // the PreparedStatement and the ResultSet
        // objects are closed automatically for you so
        // your application does not have a resource leak
        try (
            // A PreparedStatement is the object used
            // which represents the database SQL statement
            PreparedStatement stmt
                = conn.prepareStatement(sp.toString());

            // A ResultSet represents the data from the 
            // database after the SQL statement is executed.
            ResultSet rs
                = stmt.executeQuery();
        ) {
            // Loop over the ResultSet to get all the data.
            System.out.printf("ADDRESS TABLE%n");
            System.out.printf("============%n");
            while (rs.next()) {
                // id
                Long id = rs.getLong("id");
                // address1
                String address1 = rs.getString("address1");
                // address2
                String address2 = rs.getString("address2");
                // city
                String city = rs.getString("city");
                // state
                String state = rs.getString("state");
                // zip_code
                Integer zipCode = rs.getInt("zip_code");
                // created_on
                Timestamp ts = rs.getTimestamp("created_on");

                System.out.printf(
                    "%d : %s %n \t %s, %s, %s, %s %d%n"
                    , id
                    , ts.toString()
                    , address1
                    , address2
                    , city
                    , state
                    , zipCode
                );
            }
        }
        
        // You are done with the application so close
        // your database connection
        conn.close();
        
        System.out.printf("%nGood-bye!%n");
    }
}
