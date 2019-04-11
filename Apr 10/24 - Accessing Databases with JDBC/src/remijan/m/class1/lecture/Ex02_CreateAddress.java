package remijan.m.class1.lecture;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex02_CreateAddress {

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


        // Use the StringBuilder class to create an SQL statement
        // that can be executed to create a table named 'address'
        StringBuilder sp = new StringBuilder();
        sp.append(" create table address ( ");
        sp.append("      id                   bigint ");
        sp.append("     ,address1             varchar(50) ");
        sp.append("     ,address2             varchar(50) ");
        sp.append("     ,city                 varchar(20) ");
        sp.append("     ,state                varchar(2) ");
        sp.append("     ,zip_code			  integer ");
        sp.append("     ,created_on           timestamp ");
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
            // Execute statement to create table
            stmt.execute();
        }

        // You are done with the application so close
        // your database connection
        conn.close();

        System.out.printf("%nGood-bye!%n");
    }
}
