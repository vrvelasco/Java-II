package remijan.m.class3.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex04_SelectSong {

    public static void main(String[] args) throws Exception {
        // Get connection to the database.
        ConnectionHandler connectionHandler
            = new ConnectionHandler();
        Connection conn
            = connectionHandler.getConnection();


        // NOTE
        // Do the query 1st in SquirrelSQL, then copy & paste it into your code.
        StringBuilder sp = new StringBuilder();
        sp.append(" select ");
        sp.append("      id ");
        sp.append("     ,artist ");
        sp.append("     ,title ");
        sp.append("     ,minutes ");
        sp.append(" from  ");
        sp.append("     song ");


        boolean keepSelecting = true;
        do {
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
                System.out.printf("=====%n");
                System.out.printf("SONGS%n");
                System.out.printf("=====%n");
                while (rs.next()) {
                    // id
                    Long id = rs.getLong("id");
                    // artist
                    String artist = rs.getString("artist");
                    // title
                    String title = rs.getString("title");
                    // minutes
                    Double minutes = rs.getDouble("minutes");

                    System.out.printf(
                        "%-14d|%-20s|%-30s|%.2f%n"
                        , id
                        , artist
                        , title
                        , minutes
                    );
                }
            }

            Thread.sleep(1000 * 3);
        } while (keepSelecting);

        // You are done with the application so close
        // your database connection
        conn.close();

        System.out.printf("%nGood-bye!%n");
    }
}
