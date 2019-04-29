package remijan.m.class3.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ex02_CreateSong {

    public static void main(String[] args) throws Exception {
        // Get connection to the database.
        ConnectionHandler connectionHandler
            = new ConnectionHandler();
        Connection conn
            = connectionHandler.getConnection();

        // Use the StringBuilder class to create an SQL statement
        // that can be executed to create a table named 'song'
        StringBuilder sp = new StringBuilder();
        sp.append(" create table song ( ");
        sp.append("      id                bigint ");
        sp.append("     ,artist            varchar(20) ");
        sp.append("     ,title             varchar(30) ");
        sp.append("     ,minutes           double ");
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
            System.out.printf("Creating table...");
            stmt.execute();
            System.out.printf("[DONE]%n");
        }

        // You are done with the application so close
        // your database connection
        conn.close();

        System.out.printf("%nGood-bye!%n");
    }
}
