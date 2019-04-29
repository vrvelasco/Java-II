package remijan.m.class3.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex08_SelectArtist {

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
        sp.append("      a.id       artist_id");
        sp.append("     ,a.artist   artist_name");
        sp.append("     ,r.id       album_id ");
        sp.append("     ,r.title    album_title ");
        sp.append(" from  ");
        sp.append("      artist a ");
        sp.append("     ,album  r ");
        sp.append(" where ");
        sp.append("     r.artist_ptr = a.id ");



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
                System.out.printf("=======%n");
                System.out.printf("ARTISTS%n");
                System.out.printf("=======%n");
                while (rs.next()) {
                    // artist_id
                    Long artistId = rs.getLong("artist_id");
                    // artist_name
                    String artistName = rs.getString("artist_name");
                    // album_id
                    Long albumId = rs.getLong("album_id");
                    // album_title
                    String albumTitle = rs.getString("album_title");

                    System.out.printf(
                        "%-14d|%-20s|%-14d|%-30s%n"
                        , artistId
                        , artistName
                        , albumId
                        , albumTitle
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
